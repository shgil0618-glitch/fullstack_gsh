package com.thejoa703.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.RecipeIngredient4;
import com.thejoa703.entity.RecipeStep4;

@Repository
public interface RecipeStepRepository4 extends JpaRepository<RecipeStep4, Long> {
    List<RecipeStep4> findByRecipeIdOrderByIdAsc(Long recipeId);
    void deleteByRecipeId(Long recipeId);
}
