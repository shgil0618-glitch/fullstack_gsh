package com.thejoa703.service;

import com.thejoa703.dto.request.RecipeRequest4;
import com.thejoa703.dto.request.SearchRequest4;
import com.thejoa703.dto.response.*;
import com.thejoa703.entity.*;
import com.thejoa703.service.AiTextService;
import com.thejoa703.service.ApiModeration;
import com.thejoa703.service.OpenAIEmbeddingService;
import com.thejoa703.repository.*;
import com.thejoa703.util.FileStorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class RecipeService4 {

    private final RecipeRepository4 recipeRepository;
    private final CategoryRepository4 categoryRepository;
    private final AppUserRepository userRepository;
    private final RecipeLikeRepository4 likeRepository;
    private final SearchHistoryRepository4 searchHistoryRepository;
    
    private final FileStorageService fileStorageService;
    private final ApiModeration apiModeration;
    private final AiTextService aiTextService; // 추가
    private final OpenAIEmbeddingService embeddingService; // 추가

    /**
     * 1. 레시피 등록 및 수정 (기존 saveRecipe)
     */
    public RecipeResponse4 saveRecipe(RecipeRequest4 request, MultipartFile mainImage, List<MultipartFile> stepImages) {
        if (apiModeration.detectBadWords(request.getTitle() + " " + request.getDescription())) {
            throw new IllegalArgumentException("부적절한 내용이 포함되어 있습니다.");
        }

        AppUser user = userRepository.findById(request.getAppUserId()).orElseThrow();
        Category4 category = categoryRepository.findById(request.getCategoryId()).orElseThrow();

        String mainPath = (mainImage != null && !mainImage.isEmpty()) 
                          ? fileStorageService.upload(mainImage) : request.getImage();

        Recipe4 recipe = Recipe4.builder()
                .id(request.getRecipeId())
                .user(user)
                .category(category)
                .title(request.getTitle())
                .description(request.getDescription())
                .image(mainPath)
                .cookTime(request.getCookTime())
                .difficulty(request.getDifficulty())
                .servings(request.getServings())
                .status(request.getStatus())
                .build();

        // [보완] 기존 리스트 초기화 후 재등록 (JPA OrphanRemoval 활용)
        recipe.getIngredients().clear();
        if (request.getIngredients() != null) {
            request.getIngredients().forEach(i -> recipe.addIngredient(
                RecipeIngredient4.builder().ingreName(i.getIngreName()).ingreNum(i.getIngreNum()).build()
            ));
        }

        recipe.getSteps().clear();
        if (request.getSteps() != null) {
            for (int i = 0; i < request.getSteps().size(); i++) {
                String sImg = (stepImages != null && i < stepImages.size() && !stepImages.get(i).isEmpty()) 
                              ? fileStorageService.upload(stepImages.get(i)) : null;
                recipe.addStep(RecipeStep4.builder()
                        .stepDesc(request.getSteps().get(i).getStepDesc()).stepImage(sImg).build());
            }
        }

        return RecipeResponse4.fromEntity(recipeRepository.save(recipe));
    }

    /**
     * 2. [추가] AI 레시피 자동 생성 기능
     */
    public String generateAiDescription(RecipeRequest4 request) {
        List<String> ingredients = request.getIngredients().stream().map(i -> i.getIngreName()).collect(Collectors.toList());
        List<String> steps = request.getSteps().stream().map(s -> s.getStepDesc()).collect(Collectors.toList());
        return aiTextService.generateDescription(request.getTitle(), ingredients, steps);
    }

    /**
     * 3. [추가] AI 검색어 추천 기능
     */
    public String getAiRecommendedKeyword(String input) {
        // 모든 검색 히스토리에서 고유 키워드 추출
        List<String> allKeywords = searchHistoryRepository.findAll().stream()
                .map(SearchHistory4::getKeyword).distinct().collect(Collectors.toList());
        return embeddingService.recommendKeyword(input, allKeywords);
    }

    /**
     * 4. [추가] 마이페이지: 내가 쓴 레시피 & 좋아요 목록
     */
    @Transactional(readOnly = true)
    public List<RecipeResponse4> getMyRecipes(Long userId) {
        return recipeRepository.findByUserIdOrderByCreatedAtDesc(userId).stream()
                .map(RecipeResponse4::fromEntity).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<RecipeResponse4> getLikedRecipes(Long userId) {
        return likeRepository.findLikedRecipesByUserId(userId).stream()
                .map(RecipeResponse4::fromEntity).collect(Collectors.toList());
    }

    /**
     * 5. [보완] 검색 및 페이징 (기존 검색 히스토리 저장 로직 포함)
     */
    public PageResponseDto<RecipeResponse4> searchRecipes(SearchRequest4 searchRequest) {
        if (searchRequest.getKeyword() != null && !searchRequest.getKeyword().trim().isEmpty()) {
            AppUser user = searchRequest.getAppUserId() != null ? userRepository.findById(searchRequest.getAppUserId()).orElse(null) : null;
            searchHistoryRepository.save(SearchHistory4.builder().user(user).keyword(searchRequest.getKeyword()).build());
        }

        List<Recipe4> content = recipeRepository.searchRecipesPaged(
                searchRequest.getKeyword(), searchRequest.getSearchField(),
                searchRequest.getCategoryId() != null ? searchRequest.getCategoryId().intValue() : null,
                searchRequest.getSort(), searchRequest.getRStart(), searchRequest.getREnd()
        );

        long total = recipeRepository.countRecipes(searchRequest.getKeyword(), 
                searchRequest.getCategoryId() != null ? searchRequest.getCategoryId().intValue() : null);

        List<RecipeResponse4> dtos = content.stream().map(RecipeResponse4::fromEntity).collect(Collectors.toList());
        int totalPages = (int) Math.ceil((double) total / searchRequest.getPageSize());

        return new PageResponseDto<>(dtos, searchRequest.getCurrentPage(), total, totalPages, searchRequest.getCurrentPage() >= totalPages);
    }

    /**
     * 6. [추가] 관리자용: 전체 레시피 관리
     */
    @Transactional(readOnly = true)
    public List<RecipeResponse4> getAllRecipesForAdmin() {
        return recipeRepository.findAll().stream().map(RecipeResponse4::fromEntity).collect(Collectors.toList());
    }

    public void adminDeleteRecipe(Long recipeId) {
        // 관리자는 사용자 검증 없이 삭제 가능
        recipeRepository.deleteById(recipeId);
    }

    /**
     * 좋아요 토글 및 상세조회 등 기존 메서드 유지...
     */
    public RecipeResponse4 getRecipeDetail(Long recipeId) {
        Recipe4 recipe = recipeRepository.findById(recipeId).orElseThrow();
        recipe.setViews(recipe.getViews() + 1);
        return RecipeResponse4.fromEntity(recipe);
    }

    public boolean toggleLike(Long recipeId, Long userId) {
        Optional<RecipeLike4> like = likeRepository.findByUserIdAndRecipeId(userId, recipeId);
        if (like.isPresent()) {
            likeRepository.delete(like.get());
            return false;
        } else {
            likeRepository.save(RecipeLike4.builder()
                    .recipe(recipeRepository.getReferenceById(recipeId))
                    .user(userRepository.getReferenceById(userId)).build());
            return true;
        }
    }
}