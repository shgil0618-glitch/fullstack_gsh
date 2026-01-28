package com.thejoa703;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.thejoa703.dto.request.RecipeRequest4;
import com.thejoa703.dto.request.SearchRequest4;
import com.thejoa703.dto.response.RecipeResponse4;
import com.thejoa703.entity.AppUser;
import com.thejoa703.entity.Category4;
import com.thejoa703.entity.Recipe4;
import com.thejoa703.repository.AppUserRepository;
import com.thejoa703.repository.CategoryRepository4;
import com.thejoa703.repository.RecipeRepository4;
import com.thejoa703.service.RecipeService4;

@SpringBootTest
@Transactional
class RecipeServiceTests {

    @Autowired private RecipeService4 recipeService;
    @Autowired private RecipeRepository4 recipeRepository;
    @Autowired private AppUserRepository userRepository;
    @Autowired private CategoryRepository4 categoryRepository;

    private AppUser user;
    private Category4 category;

    @BeforeEach
    void setup() {
        // 사용자 생성
        user = new AppUser();
        user.setEmail("user_" + UUID.randomUUID() + "@test.com");
        user.setPassword("pass123");
        user.setNickname("tester");
        user.setProvider("local");
        user.setDeleted(false);
        userRepository.save(user);

        // 카테고리 생성
        category = new Category4();
        category.setCategoryName("한식");
        categoryRepository.save(category);
    }

    // ---------------------------------------------------------------------
    // 레시피 저장 및 조회
    // ---------------------------------------------------------------------
    @Test
    @DisplayName("■ RecipeRepository-CRUD")
    void testRecipeRepository() {
        Recipe4 recipe = new Recipe4();
        recipe.setUser(user);
        recipe.setCategory(category);
        recipe.setTitle("김치찌개");
        recipe.setDescription("맛있는 김치찌개 레시피");
        recipe.setStatus("PUBLIC"); // 혹은 "DELETED"

        recipeRepository.save(recipe);

        // 단건조회
        Recipe4 found = recipeRepository.findById(recipe.getId()).orElseThrow();
        assertThat(found.getTitle()).isEqualTo("김치찌개");

        // 수정
        found.setTitle("된장찌개");
        recipeRepository.save(found);
        assertThat(recipeRepository.findById(found.getId()).get().getTitle()).isEqualTo("된장찌개");

        // 삭제
        recipeRepository.delete(found);
        assertThat(recipeRepository.findById(found.getId())).isEmpty();
    }

    // ---------------------------------------------------------------------
    // 서비스 계층 테스트: AI 설명 생성, 검색, 좋아요 토글
    // ---------------------------------------------------------------------
    @Test
    @DisplayName("■ RecipeService-saveRecipe & getRecipeDetail")
    void testSaveAndDetail() {
        RecipeRequest4 request = new RecipeRequest4();
        request.setAppUserId(user.getId());
        request.setCategoryId(category.getId());
        request.setTitle("비빔밥");
        request.setDescription("다양한 나물과 고추장을 넣은 비빔밥");
        request.setCookTime(20);
        request.setDifficulty("중간");
        request.setServings(2);
        request.setStatus("PUBLIC");

        RecipeResponse4 saved = recipeService.saveRecipe(request, null, null);
        assertThat(saved.getTitle()).isEqualTo("비빔밥");

        RecipeResponse4 detail = recipeService.getRecipeDetail(saved.getId());
        assertThat(detail.getViews()).isGreaterThan(0);
    }

    @Test
    @DisplayName("■ RecipeService-searchRecipes")
    void testSearchRecipes() {
        // 검색 요청
        SearchRequest4 searchRequest = new SearchRequest4();
        searchRequest.setKeyword("비빔밥");
        searchRequest.setCurrentPage(1);
        searchRequest.setPageSize(10);

        var pageResult = recipeService.searchRecipes(searchRequest);
        assertThat(pageResult.getContent()).isNotNull();
    }

    @Test
    @DisplayName("■ RecipeService-toggleLike")
    void testToggleLike() {
        Recipe4 recipe = new Recipe4();
        recipe.setUser(user);
        recipe.setCategory(category);
        recipe.setTitle("불고기");
        recipe.setDescription("달콤짭짤한 불고기");
        recipeRepository.save(recipe);

        boolean liked = recipeService.toggleLike(recipe.getId(), user.getId());
        assertThat(liked).isTrue();

        boolean unliked = recipeService.toggleLike(recipe.getId(), user.getId());
        assertThat(unliked).isFalse();
    }
}