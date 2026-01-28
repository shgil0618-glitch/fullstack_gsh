package com.thejoa703.controller;

import com.thejoa703.dto.request.RecipeRequest4;
import com.thejoa703.dto.request.SearchRequest4;
import com.thejoa703.dto.response.PageResponseDto;
import com.thejoa703.dto.response.RecipeResponse4;
import com.thejoa703.service.RecipeService4;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Tag(name = "Recipe V4 API", description = "AI 연동 및 JPA 기반 레시피 서비스")
@RestController
@RequestMapping("/api/v4/recipes")
@RequiredArgsConstructor
public class RecipeController4 {

    private final RecipeService4 recipeService;

    @Operation(summary = "1. 레시피 등록 및 수정", description = "이미지 파일들과 레시피 데이터를 함께 전송합니다.")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<RecipeResponse4> saveRecipe(
            @RequestPart("recipe") RecipeRequest4 request,
            @RequestPart(value = "mainImage", required = false) MultipartFile mainImage,
            @RequestPart(value = "stepImages", required = false) List<MultipartFile> stepImages) {
        
        return ResponseEntity.ok(recipeService.saveRecipe(request, mainImage, stepImages));
    }

    @Operation(summary = "2. AI 레시피 설명 자동 생성", description = "입력된 제목, 재료를 바탕으로 AI가 설명을 생성합니다.")
    @PostMapping("/ai/description")
    public ResponseEntity<Map<String, String>> generateAiDescription(@RequestBody RecipeRequest4 request) {
        String description = recipeService.generateAiDescription(request);
        return ResponseEntity.ok(Map.of("description", description));
    }

    @Operation(summary = "3. AI 검색어 추천", description = "사용자 입력값과 유사한 인기 검색어를 추천합니다.")
    @GetMapping("/ai/recommend")
    public ResponseEntity<Map<String, String>> getAiRecommend(@RequestParam("input") String input) {
        String recommended = recipeService.getAiRecommendedKeyword(input);
        return ResponseEntity.ok(Map.of("keyword", recommended));
    }

    @Operation(summary = "4-1. 마이페이지: 내가 쓴 레시피")
    @GetMapping("/my/written")
    public ResponseEntity<List<RecipeResponse4>> getMyRecipes(@RequestParam("userId") Long userId) {
        return ResponseEntity.ok(recipeService.getMyRecipes(userId));
    }

    @Operation(summary = "4-2. 마이페이지: 좋아요한 레시피")
    @GetMapping("/my/liked")
    public ResponseEntity<List<RecipeResponse4>> getLikedRecipes(@RequestParam("userId") Long userId) {
        return ResponseEntity.ok(recipeService.getLikedRecipes(userId));
    }

    @Operation(summary = "5. 레시피 검색 및 페이징", description = "검색 조건에 따른 페이징 결과를 반환합니다.")
    @GetMapping("/search")
    public ResponseEntity<PageResponseDto<RecipeResponse4>> searchRecipes(@ModelAttribute SearchRequest4 searchRequest) {
        return ResponseEntity.ok(recipeService.searchRecipes(searchRequest));
    }

    @Operation(summary = "6. 상세 조회", description = "레시피 상세 정보 및 조회수를 증가시킵니다.")
    @GetMapping("/{recipeId}")
    public ResponseEntity<RecipeResponse4> getRecipeDetail(@PathVariable("recipeId") Long recipeId) {
        return ResponseEntity.ok(recipeService.getRecipeDetail(recipeId));
    }

    @Operation(summary = "7. 좋아요 토글", description = "좋아요가 없으면 생성, 있으면 삭제합니다.")
    @PostMapping("/{recipeId}/like")
    public ResponseEntity<Map<String, Boolean>> toggleLike(
            @PathVariable("recipeId") Long recipeId, 
            @RequestParam("userId") Long userId) {
        boolean liked = recipeService.toggleLike(recipeId, userId);
        return ResponseEntity.ok(Map.of("liked", liked));
    }

    // --- 관리자 전용 영역 ---

    @Operation(summary = "[관리자] 전체 레시피 목록 조회")
    @GetMapping("/admin/all")
    public ResponseEntity<List<RecipeResponse4>> getAllRecipesForAdmin() {
        return ResponseEntity.ok(recipeService.getAllRecipesForAdmin());
    }

    @Operation(summary = "[관리자] 레시피 강제 삭제")
    @DeleteMapping("/admin/{recipeId}")
    public ResponseEntity<Void> adminDeleteRecipe(@PathVariable("recipeId") Long recipeId) {
        recipeService.adminDeleteRecipe(recipeId);
        return ResponseEntity.noContent().build();
    }
}