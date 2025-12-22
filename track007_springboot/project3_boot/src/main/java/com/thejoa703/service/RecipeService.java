package com.thejoa703.service;

import java.util.List;
import java.util.Map;

import com.thejoa703.dto.AiUsageHistory3;
import com.thejoa703.dto.BadWords3;
import com.thejoa703.dto.RecipeLikes3;
import com.thejoa703.dto.Recipes3Dto;
import com.thejoa703.dto.RecipesIngre3;
import com.thejoa703.dto.RecipesStep3;
import com.thejoa703.dto.SearchHistory3;

public interface RecipeService {

    /* ==================================================
     * 1️ RECIPE
     * ================================================== */
    int insertRecipe(Recipes3Dto recipe, List<RecipesIngre3> ingredients, List<RecipesStep3> steps);
    Recipes3Dto selectRecipe(int recipeId);
    List<Recipes3Dto> selectRecipeListPaging(Map<String, Object> param);
    List<Recipes3Dto> selectMyRecipes(int appUserId);
    int incrementRecipeViews(int recipeId);
    int updateRecipe(Recipes3Dto recipe, List<RecipesIngre3> ingredients, List<RecipesStep3> steps);
    int deleteRecipe(int recipeId);

    /* ==================================================
     * 2️ INGREDIENT / STEP
     * ================================================== */
    List<RecipesIngre3> selectRecipeIngredients(int recipeId);
    List<RecipesStep3> selectRecipeSteps(int recipeId);

    /* ==================================================
     * 3️ SEARCH
     * ================================================== */
    int searchBothCount(Map<String, Object> param);
    List<Recipes3Dto> searchBothPaging(Map<String, Object> param);
    int insertSearchHistory(SearchHistory3 history);
    List<SearchHistory3> selectMySearchHistory(int appUserId);
    int deleteExcessSearchHistory(Map<String, Object> param);

    /* ==================================================
     * 4️ LIKE
     * ================================================== */
    int insertRecipeLike(RecipeLikes3 like);
    int deleteRecipeLike(int appUserId, int recipeId);
    boolean existsRecipeLike(int appUserId, int recipeId);
    int countRecipeLikes(int recipeId);
    List<Recipes3Dto> selectMyLikedRecipes(int appUserId);

    /* ==================================================
     * 5️ AI USAGE
     * ================================================== */
    int insertAiUsageHistory(AiUsageHistory3 history);
    List<AiUsageHistory3> selectAiUsageByUser(int appUserId);
    List<AiUsageHistory3> selectAllAiUsage();

    /* ==================================================
     * 6️ BAD WORD
     * ================================================== */
    List<BadWords3> selectBadWords();
    int insertBadWord(BadWords3 word);
    int deleteBadWord(int wordId);
}
