package com.thejoa703.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.thejoa703.dto.AiUsageHistory3;
import com.thejoa703.dto.BadWords3;
import com.thejoa703.dto.RecipeLikes3;
import com.thejoa703.dto.Recipes3Dto;
import com.thejoa703.dto.RecipesIngre3;
import com.thejoa703.dto.RecipesStep3;
import com.thejoa703.dto.SearchHistory3;

@Mapper
public interface Recipes3Dao {

    /* ==================================================
     * 1️⃣ RECIPE (레시피 기본)
     * ================================================== */

    // 레시피 기본 정보 등록
    int insertRecipe(Recipes3Dto dto);

    // 레시피 단건 조회
    Recipes3Dto selectRecipe(int recipeId);

    // 레시피 목록 페이징
    List<Recipes3Dto> selectRecipeListPaging(Map<String, Object> param);

    // 내 레시피 목록 조회 (마이페이지)
    List<Recipes3Dto> selectMyRecipes(int appUserId);

    // 조회수 증가
    int incrementRecipeViews(int recipeId);

    // 레시피 수정
    int updateRecipe(Recipes3Dto dto);

    // 레시피 삭제
    int deleteRecipe(int recipeId);

    /* ==================================================
     * 2️⃣ INGREDIENT / STEP (재료 및 단계)
     * ================================================== */

    // 재료 등록
    int insertIngredient(RecipesIngre3 ingre);

    // 재료 조회
    List<RecipesIngre3> selectRecipeIngredients(int recipeId);

    // 재료 전체 삭제 (수정 시)
    int deleteIngredients(int recipeId);

    // 단계 등록
    int insertStep(RecipesStep3 step);

    // 단계 조회
    List<RecipesStep3> selectRecipeSteps(int recipeId);

    // 단계 전체 삭제 (수정 시)
    int deleteSteps(int recipeId);

    /* ==================================================
     * 3️⃣ SEARCH (검색)
     * ================================================== */

    // 검색 결과 개수
    int searchBothCount(Map<String, Object> param);

    // 검색 결과 페이징
    List<Recipes3Dto> searchBothPaging(Map<String, Object> param);

    // 검색 기록 저장
    int insertSearchHistory(SearchHistory3 history);

    // 내 검색 기록 조회
    List<SearchHistory3> selectMySearchHistory(int appUserId);

    // 검색 기록 개수 초과분 삭제
    int deleteExcessSearchHistory(Map<String, Object> param);

    /* ==================================================
     * 4️⃣ LIKE (좋아요)
     * ================================================== */

    // 좋아요 등록
    int insertRecipeLike(RecipeLikes3 like);

    // 좋아요 취소
    int deleteRecipeLike(Map<String, Integer> param);

    // 좋아요 여부 확인
    int existsRecipeLike(Map<String, Integer> param);

    // 레시피 좋아요 수 조회
    int countRecipeLikes(int recipeId);

    // 내가 좋아요한 레시피 목록
    List<Recipes3Dto> selectMyLikedRecipes(int appUserId);

    /* ==================================================
     * 5️⃣ AI USAGE (간소화)
     * ================================================== */

    // AI 사용 기록 저장
    int insertAiUsageHistory(AiUsageHistory3 history);

    // 사용자별 AI 사용 기록 조회
    List<AiUsageHistory3> selectAiUsageByUser(int appUserId);

    // 관리자용 전체 AI 사용 기록
    List<AiUsageHistory3> selectAllAiUsage();

    /* ==================================================
     * 6️⃣ BAD WORD (비속어)
     * ================================================== */

    // 비속어 목록 조회
    List<BadWords3> selectBadWords();

    // 비속어 추가
    int insertBadWord(BadWords3 word);

    // 비속어 삭제
    int deleteBadWord(int wordId);
}
