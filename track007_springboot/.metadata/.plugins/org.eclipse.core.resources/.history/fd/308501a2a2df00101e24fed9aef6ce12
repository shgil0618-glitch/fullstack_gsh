package com.thejoa703.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thejoa703.dao.Recipes3Dao;
import com.thejoa703.dto.AiUsageHistory3;
import com.thejoa703.dto.BadWords3;
import com.thejoa703.dto.RecipeLikes3;
import com.thejoa703.dto.Recipes3Dto;
import com.thejoa703.dto.RecipesIngre3;
import com.thejoa703.dto.RecipesStep3;
import com.thejoa703.dto.SearchHistory3;
import com.thejoa703.service.RecipeService;

@Service
@Transactional
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private Recipes3Dao recipes3Dao;

    /* ==================================================
     * 1️⃣ RECIPE
     * ================================================== */
    @Override
    public int insertRecipe(Recipes3Dto recipe, List<RecipesIngre3> ingredients, List<RecipesStep3> steps) {
        int result = recipes3Dao.insertRecipe(recipe);

        if (ingredients != null) {
            for (RecipesIngre3 ingre : ingredients) {
                ingre.setRecipeId(recipe.getRecipeId());
                recipes3Dao.insertIngredient(ingre);
            }
        }

        if (steps != null) {
            for (RecipesStep3 step : steps) {
                step.setRecipeId(recipe.getRecipeId());
                recipes3Dao.insertStep(step);
            }
        }
        return result;
    }

    @Override
    public Recipes3Dto selectRecipe(int recipeId) {
        Recipes3Dto recipe = recipes3Dao.selectRecipe(recipeId);
        if (recipe != null) {
            recipe.setIngredients(recipes3Dao.selectRecipeIngredients(recipeId));
            recipe.setSteps(recipes3Dao.selectRecipeSteps(recipeId));
        }
        return recipe;
    }

    @Override
    public List<Recipes3Dto> selectRecipeListPaging(Map<String, Object> param) {
        return recipes3Dao.selectRecipeListPaging(param);
    }

    @Override
    public List<Recipes3Dto> selectMyRecipes(int appUserId) {
        return recipes3Dao.selectMyRecipes(appUserId);
    }

    @Override
    public int incrementRecipeViews(int recipeId) {
        return recipes3Dao.incrementRecipeViews(recipeId);
    }

    @Override
    public int updateRecipe(Recipes3Dto recipe, List<RecipesIngre3> ingredients, List<RecipesStep3> steps) {
        // 레시피 수정
        int result = recipes3Dao.updateRecipe(recipe);

        // 재료/단계 삭제 후 재등록
        recipes3Dao.deleteIngredients(recipe.getRecipeId());
        recipes3Dao.deleteSteps(recipe.getRecipeId());

        if (ingredients != null) {
            for (RecipesIngre3 ingre : ingredients) {
                ingre.setRecipeId(recipe.getRecipeId());
                recipes3Dao.insertIngredient(ingre);
            }
        }

        if (steps != null) {
            for (RecipesStep3 step : steps) {
                step.setRecipeId(recipe.getRecipeId());
                recipes3Dao.insertStep(step);
            }
        }
        return result;
    }

    @Override
    public int deleteRecipe(int recipeId) {
        return recipes3Dao.deleteRecipe(recipeId);
    }

    /* ==================================================
     * 2️⃣ INGREDIENT / STEP
     * ================================================== */
    @Override
    public List<RecipesIngre3> selectRecipeIngredients(int recipeId) {
        return recipes3Dao.selectRecipeIngredients(recipeId);
    }

    @Override
    public List<RecipesStep3> selectRecipeSteps(int recipeId) {
        return recipes3Dao.selectRecipeSteps(recipeId);
    }

    /* ==================================================
     * 3️⃣ SEARCH
     * ================================================== */
    @Override
    public int searchBothCount(Map<String, Object> param) {
        return recipes3Dao.searchBothCount(param);
    }

    @Override
    public List<Recipes3Dto> searchBothPaging(Map<String, Object> param) {
        return recipes3Dao.searchBothPaging(param);
    }

    @Override
    public int insertSearchHistory(SearchHistory3 history) {
        return recipes3Dao.insertSearchHistory(history);
    }

    @Override
    public List<SearchHistory3> selectMySearchHistory(int appUserId) {
        return recipes3Dao.selectMySearchHistory(appUserId);
    }

    @Override
    public int deleteExcessSearchHistory(Map<String, Object> param) {
        return recipes3Dao.deleteExcessSearchHistory(param);
    }

    /* ==================================================
     * 4️⃣ LIKE
     * ================================================== */
    @Override
    public int insertRecipeLike(RecipeLikes3 like) {
        return recipes3Dao.insertRecipeLike(like);
    }

    @Override
    public int deleteRecipeLike(int appUserId, int recipeId) {
        return recipes3Dao.deleteRecipeLike(Map.of("appUserId", appUserId, "recipeId", recipeId));
    }

    @Override
    public boolean existsRecipeLike(int appUserId, int recipeId) {
        return recipes3Dao.existsRecipeLike(Map.of("appUserId", appUserId, "recipeId", recipeId)) > 0;
    }

    @Override
    public int countRecipeLikes(int recipeId) {
        return recipes3Dao.countRecipeLikes(recipeId);
    }

    @Override
    public List<Recipes3Dto> selectMyLikedRecipes(int appUserId) {
        return recipes3Dao.selectMyLikedRecipes(appUserId);
    }

    /* ==================================================
     * 5️⃣ AI USAGE
     * ================================================== */
    @Override
    public int insertAiUsageHistory(AiUsageHistory3 history) {
        return recipes3Dao.insertAiUsageHistory(history);
    }

    @Override
    public List<AiUsageHistory3> selectAiUsageByUser(int appUserId) {
        return recipes3Dao.selectAiUsageByUser(appUserId);
    }

    @Override
    public List<AiUsageHistory3> selectAllAiUsage() {
        return recipes3Dao.selectAllAiUsage();
    }

    /* ==================================================
     * 6️⃣ BAD WORD
     * ================================================== */
    @Override
    public List<BadWords3> selectBadWords() {
        return recipes3Dao.selectBadWords();
    }

    @Override
    public int insertBadWord(BadWords3 word) {
        return recipes3Dao.insertBadWord(word);
    }

    @Override
    public int deleteBadWord(int wordId) {
        return recipes3Dao.deleteBadWord(wordId);
    }
}
