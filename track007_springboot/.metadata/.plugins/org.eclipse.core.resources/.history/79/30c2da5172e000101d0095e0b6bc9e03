package com.thejoa703.service;

import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dao.Recipes3Dao;
import com.thejoa703.dto.Recipes3Dto;
import com.thejoa703.dto.RecipesIngre3;
import com.thejoa703.dto.RecipesStep3;
import com.thejoa703.service.RecipeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final Recipes3Dao recipes3Dao;

    // application.properties에서 업로드 루트 경로 주입 (예: C:/upload)
    @Value("${resource.path}")
    private String uploadRoot;

    // 업로드 URL 패턴(필요 시 사용)
    @Value("${upload.path:/upload/**}")
    private String uploadPathPattern;

    // -------------------------
    // 파일 저장 유틸
    // - 업로드 루트(uploadRoot) 아래에 recipes/ 디렉터리 생성 후 저장
    // - 반환값: 저장된 파일명 (DB에 저장할 값). 필요하면 경로를 포함해서 저장하도록 변경 가능.
    // -------------------------
    private String saveImageFile(MultipartFile imageFile) {
        if (imageFile == null || imageFile.isEmpty()) return null;

        try {
            // 저장 디렉터리: uploadRoot + /recipes/
            Path root = Paths.get(uploadRoot);
            Path recipesDir = root.resolve("recipes");
            if (Files.notExists(recipesDir)) {
                Files.createDirectories(recipesDir);
            }

            // 고유 파일명 생성 (UUID + 원래 확장자)
            String original = imageFile.getOriginalFilename();
            String ext = "";
            if (original != null && original.contains(".")) {
                ext = original.substring(original.lastIndexOf('.'));
            }
            String filename = UUID.randomUUID().toString() + ext;

            Path target = recipesDir.resolve(filename);

            // 파일 저장
            Files.copy(imageFile.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);

            // DB에는 상대 경로 또는 파일명만 저장 (프론트에서 resourcePath + "/recipes/" + filename 로 접근)
            return filename;
        } catch (IOException e) {
            throw new RuntimeException("이미지 저장 실패", e);
        }
    }

    // -------------------------
    // 레시피 등록
    // -------------------------
    @Override
    @Transactional
    public int createRecipe(MultipartFile imageFile, Recipes3Dto dto) {
        try {
            String savedFileName = saveImageFile(imageFile);
            if (savedFileName != null) {
                // DB에 저장할 값: recipes/<filename> 또는 filename만 저장
                dto.setImage("recipes/" + savedFileName);
            }

            int inserted = recipes3Dao.insertRecipe(dto);
            if (inserted <= 0) throw new RuntimeException("레시피 등록 실패");

            // insertRecipe가 selectKey로 recipeId를 채워준다고 가정
            List<RecipesIngre3> ingreList = dto.getIngredients();
            if (ingreList != null) {
                for (RecipesIngre3 ing : ingreList) {
                    ing.setRecipeId(dto.getRecipeId());
                    recipes3Dao.insertIngre(ing);
                }
            }

            List<RecipesStep3> stepList = dto.getSteps();
            if (stepList != null) {
                for (RecipesStep3 step : stepList) {
                    step.setRecipeId(dto.getRecipeId());
                    recipes3Dao.insertStep(step);
                }
            }

            return 1;
        } catch (Exception e) {
            throw e;
        }
    }

    // -------------------------
    // 레시피 수정
    // -------------------------
    @Override
    @Transactional
    public int updateRecipe(MultipartFile imageFile, Recipes3Dto dto) {
        try {
            String savedFileName = saveImageFile(imageFile);
            if (savedFileName != null) {
                dto.setImage("recipes/" + savedFileName);
            }

            int updated = recipes3Dao.updateRecipe(dto);
            if (updated <= 0) throw new RuntimeException("레시피 수정 실패");

            int recipeId = dto.getRecipeId();

            // 기존 재료/단계 삭제 후 재삽입
            recipes3Dao.deleteIngreByRecipeId(recipeId);
            recipes3Dao.deleteStepByRecipeId(recipeId);

            List<RecipesIngre3> ingreList = dto.getIngredients();
            if (ingreList != null) {
                for (RecipesIngre3 ing : ingreList) {
                    ing.setRecipeId(recipeId);
                    recipes3Dao.insertIngre(ing);
                }
            }

            List<RecipesStep3> stepList = dto.getSteps();
            if (stepList != null) {
                for (RecipesStep3 step : stepList) {
                    step.setRecipeId(recipeId);
                    recipes3Dao.insertStep(step);
                }
            }

            return 1;
        } catch (Exception e) {
            throw e;
        }
    }

    // -------------------------
    // 나머지 서비스 메서드 (기존 구현 유지)
    // -------------------------
    @Override
    @Transactional
    public int deleteRecipe(int recipeId) {
        int deleted = recipes3Dao.deleteRecipe(recipeId);
        return deleted > 0 ? 1 : 0;
    }

    @Override
    public Recipes3Dto getRecipeById(int recipeId) {
        return recipes3Dao.selectRecipeById(recipeId);
    }

    @Override
    public List<Recipes3Dto> selectRecipeAllPaged(Map<String, Object> params) {
        return recipes3Dao.selectRecipeAllPaged(params);
    }

    @Override
    public int countAll(Integer category) {
        Map<String, Object> params = new HashMap<>();
        params.put("category", category);
        return recipes3Dao.countSearchRecipes(params);
    }

    @Override
    public int countSearchRecipes(Map<String, Object> params) {
        return recipes3Dao.countSearchRecipes(params);
    }

    @Override
    public List<Recipes3Dto> searchRecipesPaged(Map<String, Object> params) {
        return recipes3Dao.searchRecipesPaged(params);
    }

    @Override
    public int incrementViews(int recipeId) {
        return recipes3Dao.incrementViews(recipeId);
    }

    @Override
    public List<RecipesIngre3> getIngredients(int recipeId) {
        return recipes3Dao.selectIngreByRecipeId(recipeId);
    }

    @Override
    public List<RecipesStep3> getSteps(int recipeId) {
        return recipes3Dao.selectStepByRecipeId(recipeId);
    }

    @Override
    @Transactional
    public void likeRecipe(int appUserId, int recipeId) {
        Map<String, Object> params = new HashMap<>();
        params.put("appUserId", appUserId);
        params.put("recipeId", recipeId);
        int exists = recipes3Dao.existsLike(params);
        if (exists > 0) return;
        recipes3Dao.insertLike(params);
    }

    @Override
    @Transactional
    public void unlikeRecipe(int appUserId, int recipeId) {
        Map<String, Object> params = new HashMap<>();
        params.put("appUserId", appUserId);
        params.put("recipeId", recipeId);
        recipes3Dao.deleteLike(params);
    }

    @Override
    public int countLikesByRecipe(int recipeId) {
        return recipes3Dao.countLikesByRecipe(recipeId);
    }

    @Override
    public void saveSearchHistory(Integer appUserId, String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) return;
        Map<String, Object> params = new HashMap<>();
        params.put("appUserId", appUserId);
        params.put("keyword", keyword);
        recipes3Dao.insertSearchHistory(params);
    }

    @Override
    public List<Map<String, Object>> topKeywords(int limit) {
        return recipes3Dao.topKeywords(limit);
    }

    @Override
    public List<Map<String, Object>> getAllBadWords() {
        return recipes3Dao.selectAllBadWords();
    }

    @Override
    public void addBadWord(String word) {
        if (word == null || word.trim().isEmpty()) return;
        Map<String, Object> params = new HashMap<>();
        params.put("word", word.trim());
        recipes3Dao.insertBadWord(params);
    }

    @Override
    public void deleteBadWordById(int wordId) {
        recipes3Dao.deleteBadWordById(wordId);
    }

    @Override
    public List<Map<String, Object>> getAllAiUsage() {
        return recipes3Dao.selectAllAiUsage();
    }

    @Override
    public void deleteAiUsageById(int aiHistId) {
        recipes3Dao.deleteAiUsageById(aiHistId);
    }

    @Override
    public List<Map<String, Object>> getAllCategories() {
        return recipes3Dao.selectAllCategories();
    }

    @Override
    public String getCategoryName(int category) {
        return recipes3Dao.selectCategoryName(category);
    }
}
