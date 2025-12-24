package com.thejoa703.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dao.Recipes3Dao;
import com.thejoa703.dto.Recipes3Dto;
import com.thejoa703.dto.RecipesIngre3;
import com.thejoa703.dto.RecipesStep3;
import com.thejoa703.util.UtilUpload;


@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private Recipes3Dao recipeDao;

	@Autowired
	private UtilUpload utilUpload; // 파일 업로드 유틸

	// 공통 파일 업로드 처리
	private String uploadFile(MultipartFile file, String existingFile) {
		if (file != null && !file.isEmpty()) {
			try {
				return utilUpload.fileUpload(file);
			} catch (IOException e) {
				throw new RuntimeException("파일 업로드 실패", e);
			}
		}
		return existingFile; // 새 파일 없으면 기존 값 유지
	}

	// 📌 레시피 등록 (대표 이미지 + 재료 + 단계 + 단계 이미지)
	@Transactional
	@Override
	public int createRecipe(MultipartFile imageFile, Recipes3Dto dto, List<MultipartFile> stepImages) {
		int result = 0;

		// 1) 대표 이미지 업로드
		dto.setImage(uploadFile(imageFile, dto.getImage()));

		// 2) 레시피 기본 정보 저장 (selectKey로 recipeId 채워짐)
		result += recipeDao.insertRecipe(dto);
		int recipeId = dto.getRecipeId();

		// 3) 재료 저장
		List<RecipesIngre3> ingredients = dto.getIngredients();
		if (ingredients != null && !ingredients.isEmpty()) {
			for (RecipesIngre3 ingre : ingredients) {
				ingre.setRecipeId(recipeId);
				result += recipeDao.insertIngre(ingre);
			}
		}

		// 4) 단계 저장 + 단계 이미지 업로드
		List<RecipesStep3> steps = dto.getSteps();
		if (steps != null && !steps.isEmpty()) {
			for (int i = 0; i < steps.size(); i++) {
				RecipesStep3 step = steps.get(i);
				step.setRecipeId(recipeId);

				MultipartFile stepFile = (stepImages != null && stepImages.size() > i) ? stepImages.get(i) : null;
				step.setStepImage(uploadFile(stepFile, step.getStepImage()));

				result += recipeDao.insertStep(step);
			}
		}

		return result;
	}

	@Transactional
	@Override
	public int updateRecipe(MultipartFile imageFile, Recipes3Dto dto, List<MultipartFile> stepImages) {
		int result = 0;
		int recipeId = dto.getRecipeId();

		// 1) 대표 이미지 교체
		dto.setImage(uploadFile(imageFile, dto.getImage()));
		result += recipeDao.updateRecipe(dto);

		// 2) 기존 재료 삭제 후 재삽입
		recipeDao.deleteIngreByRecipeId(recipeId);
		List<RecipesIngre3> ingredients = dto.getIngredients();
		if (ingredients != null && !ingredients.isEmpty()) {
			for (RecipesIngre3 ingre : ingredients) {
				ingre.setRecipeId(recipeId);
				result += recipeDao.insertIngre(ingre);
			}
		}

		// 3) 기존 단계 삭제 후 재삽입
		recipeDao.deleteStepByRecipeId(recipeId);
		List<RecipesStep3> steps = dto.getSteps();
		if (steps != null && !steps.isEmpty()) {
			for (int i = 0; i < steps.size(); i++) {
				RecipesStep3 step = steps.get(i);
				step.setRecipeId(recipeId);

				MultipartFile stepFile = (stepImages != null && stepImages.size() > i) ? stepImages.get(i) : null;
				step.setStepImage(uploadFile(stepFile, step.getStepImage()));

				result += recipeDao.insertStep(step);
			}
		}

		return result;
	}

	@Transactional
	@Override
	public int deleteRecipe(int recipeId) {
		int result = 0;

		// 1) 재료 삭제
		recipeDao.deleteIngreByRecipeId(recipeId);

		// 2) 단계 삭제
		recipeDao.deleteStepByRecipeId(recipeId);

		// 3) 레시피 삭제
		result += recipeDao.deleteRecipe(recipeId);

		return result;
	}

	@Override
	public Recipes3Dto getRecipeById(int recipeId) {
		return recipeDao.selectRecipeById(recipeId);
	}

	@Override
	public List<Recipes3Dto> selectRecipeAllPaged(Map<String, Object> params) {
		return recipeDao.selectRecipeAllPaged(params);
	}

	@Override
	public int countAll(Integer category) {
	    Map<String, Object> params = new HashMap<>();
	    params.put("category", category);
	    params.put("searchField", "ALL");
	    // keyword는 아예 넣지 않거나 빈 문자열로 처리
	    return recipeDao.countSearchRecipes(params);

	}

	@Override
	public int countSearchRecipes(Map<String, Object> params) {
		return recipeDao.countSearchRecipes(params);
	}

	@Override
	public List<Recipes3Dto> searchRecipesPaged(Map<String, Object> params) {
		return recipeDao.searchRecipesPaged(params);
	}

	@Transactional
	@Override
	public int incrementViews(int recipeId) {
		return recipeDao.incrementViews(recipeId);
	}

	@Override
	public List<RecipesIngre3> getIngredients(int recipeId) {
		return recipeDao.selectIngreByRecipeId(recipeId);
	}

	@Override
	public List<RecipesStep3> getSteps(int recipeId) {
		return recipeDao.selectStepByRecipeId(recipeId);
	}

	// ---------------------------
	// 좋아요 기능
	// ---------------------------
	@Transactional
	@Override
	public void likeRecipe(int appUserId, int recipeId) {
		Map<String, Object> params = Map.of("appUserId", appUserId, "recipeId", recipeId);
		// 중복 좋아요 방지
		if (recipeDao.existsLike(params) == 0) {
			recipeDao.insertLike(params);
		}
	}

	@Transactional
	@Override
	public void unlikeRecipe(int appUserId, int recipeId) {
		Map<String, Object> params = Map.of("appUserId", appUserId, "recipeId", recipeId);
		recipeDao.deleteLike(params);
	}

	@Override
	public int countLikesByRecipe(int recipeId) {
		return recipeDao.countLikesByRecipe(recipeId);
	}

	// ---------------------------
	// 검색 기록
	// ---------------------------
	@Transactional
	@Override
	public void saveSearchHistory(Integer appUserId, String keyword) {
		if (keyword == null || keyword.isBlank())
			return;
		recipeDao.insertSearchHistory(Map.of("appUserId", appUserId, "keyword", keyword));
	}

	@Override
	public List<Map<String, Object>> topKeywords(int limit) {
		return recipeDao.topKeywords(limit);
	}

	// ---------------------------
	// 비속어 관리
	// ---------------------------
	@Override
	public List<Map<String, Object>> getAllBadWords() {
		return recipeDao.selectAllBadWords();
	}

	@Transactional
	@Override
	public void addBadWord(String word) {
		if (word == null || word.isBlank())
			return;
		if (recipeDao.existsBadWord(word) == 0) {
			recipeDao.insertBadWord(Map.of("word", word));
		}
	}

	@Transactional
	@Override
	public void deleteBadWordById(int wordId) {
		recipeDao.deleteBadWordById(wordId);
	}

	// ---------------------------
	// AI 사용 기록 관리
	// ---------------------------
	@Override
	public List<Map<String, Object>> getAllAiUsage() {
		return recipeDao.selectAllAiUsage();
	}

	@Transactional
	@Override
	public void deleteAiUsageById(int aiHistId) {
		recipeDao.deleteAiUsageById(aiHistId);
	}

	// ---------------------------
	// 카테고리
	// ---------------------------
	@Override
	public List<Map<String, Object>> getAllCategories() {
		return recipeDao.selectAllCategories();
	}

	@Override
	public String getCategoryName(int category) {
		return recipeDao.selectCategoryName(category);
	}

	// ---------------------------
	// 내 레시피 / 좋아요 레시피 조회
	// ---------------------------
	@Override
	public List<Recipes3Dto> selectMyRecipes(int appUserId) {
		return recipeDao.selectMyRecipes(appUserId);
	}

	@Override
	public List<Recipes3Dto> selectLikedRecipes(int appUserId) {
		return recipeDao.selectLikedRecipes(appUserId);
	}

}