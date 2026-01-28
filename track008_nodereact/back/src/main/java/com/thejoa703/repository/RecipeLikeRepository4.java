package com.thejoa703.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.Recipe4;
import com.thejoa703.entity.RecipeLike4;


import io.lettuce.core.dynamic.annotation.Param;

@Repository
public interface RecipeLikeRepository4 extends JpaRepository<RecipeLike4, Long> {
    int countByRecipeId(Long recipeId);
    Optional<RecipeLike4> findByUserIdAndRecipeId(Long userId, Long recipeId);
    void deleteByUserIdAndRecipeId(Long userId, Long recipeId);
    
    // [기존 selectLikedRecipes] 내가 좋아요 누른 레시피만 조인해서 가져오기
    @Query("SELECT rl.recipe FROM RecipeLike4 rl WHERE rl.user.id = :userId ORDER BY rl.createdAt DESC")
    List<Recipe4> findLikedRecipesByUserId(@Param("userId") Long userId);
}
