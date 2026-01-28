package com.thejoa703.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.RecipeIngredient4;

@Repository
public interface RecipeIngredientRepository4 extends JpaRepository<RecipeIngredient4, Long> {
    List<RecipeIngredient4> findByRecipeId(Long recipeId);
    void deleteByRecipeId(Long recipeId); // 레시피 삭제 시 관련 재료 일괄 삭제
}
