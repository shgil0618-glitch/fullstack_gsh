package com.thejoa703.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dto.Recipes3Dto;
import com.thejoa703.dto.RecipesIngre3;
import com.thejoa703.dto.RecipesStep3;

public interface RecipeService {

    // 레시피 CRUD
    public int createRecipe(MultipartFile imageFile, Recipes3Dto dto, List<MultipartFile> stepImages);
    public int updateRecipe(MultipartFile imageFile, Recipes3Dto dto, List<MultipartFile> stepImages);
    public int deleteRecipe(int recipeId);
    public Recipes3Dto getRecipeById(int recipeId);

    // 목록 / 검색 / 페이징
    public List<Recipes3Dto> selectRecipeAllPaged(Map<String, Object> params);
    public int countAll(Integer category);
    public int countSearchRecipes(Map<String, Object> params);
    public List<Recipes3Dto> searchRecipesPaged(Map<String, Object> params);

    // 조회수
    public int incrementViews(int recipeId);

    // 재료 / 단계
    public List<RecipesIngre3> getIngredients(int recipeId);
    public List<RecipesStep3> getSteps(int recipeId);

    // 좋아요
    public void likeRecipe(int appUserId, int recipeId);
    public void unlikeRecipe(int appUserId, int recipeId);
    public int countLikesByRecipe(int recipeId);

    // 검색 기록
    public void saveSearchHistory(Integer appUserId, String keyword);
    public List<Map<String, Object>> topKeywords(int limit);

    // 비속어 관리
    public List<Map<String, Object>> getAllBadWords();
    public void addBadWord(String word);
    public void deleteBadWordById(int wordId);

    // AI 사용 기록 관리
    public List<Map<String, Object>> getAllAiUsage();
    public void deleteAiUsageById(int aiHistId);

    // 카테고리
    public List<Map<String, Object>> getAllCategories();
    public String getCategoryName(int category);

    // 내가 작성한 레시피 목록
    public List<Recipes3Dto> selectMyRecipes(int appUserId);

    // 내가 좋아요 표시한 레시피 목록
    public List<Recipes3Dto> selectLikedRecipes(int appUserId);
}