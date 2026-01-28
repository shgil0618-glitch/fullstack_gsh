package com.thejoa703.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.Recipe4;

import io.lettuce.core.dynamic.annotation.Param;

@Repository
public interface RecipeRepository4 extends JpaRepository<Recipe4, Long> {
    // [기존 searchRecipesPaged] 동적 필드 검색 + 페이징
    @Query(value = "SELECT * FROM ( " +
                   "  SELECT r.*, ROWNUM as rnum FROM ( " +
                   "    SELECT res.* FROM RECIPES4 res " +
                   "    LEFT JOIN APPUSER u ON res.APPUSERID = u.APP_USER_ID " +
                   "    WHERE (:category IS NULL OR res.CATEGORY_ID = :category) " +
                   "    AND (:keyword IS NULL OR ( " +
                   "         CASE WHEN :searchField = 'TITLE' THEN res.TITLE " +
                   "              WHEN :searchField = 'AUTHOR' THEN u.NICKNAME " +
                   "              WHEN :searchField = 'DESCRIPTION' THEN res.DESCRIPTION " +
                   "              ELSE (res.TITLE || u.NICKNAME || res.DESCRIPTION) END " +
                   "         LIKE '%' || :keyword || '%')) " +
                   "    ORDER BY " +
                   "      CASE WHEN :sort = 'VIEWS' THEN res.VIEWS END DESC, " +
                   "      CASE WHEN :sort = 'LATEST' OR :sort IS NULL THEN res.CREATED_AT END DESC " +
                   "  ) r " +
                   ") WHERE rnum BETWEEN :start AND :end", nativeQuery = true)
    List<Recipe4> searchRecipesPaged(@Param("keyword") String keyword, @Param("searchField") String searchField, 
                                    @Param("category") Integer category, @Param("sort") String sort, 
                                    @Param("start") int start, @Param("end") int end);

    // [기존 countRecipes] 페이징용 총 개수
    @Query(value = "SELECT COUNT(*) FROM RECIPES4 res LEFT JOIN APPUSER u ON res.APPUSERID = u.APP_USER_ID " +
                   "WHERE (:category IS NULL OR res.CATEGORY_ID = :category) " +
                   "AND (:keyword IS NULL OR (res.TITLE LIKE '%'||:keyword||'%' OR u.NICKNAME LIKE '%'||:keyword||'%'))", nativeQuery = true)
    long countRecipes(@Param("keyword") String keyword, @Param("category") Integer category);

    // [기존 selectMyRecipes] 내가 쓴 글 목록
    List<Recipe4> findByUserIdOrderByCreatedAtDesc(Long userId);
    
    @Query("SELECT r FROM Recipe4 r WHERE " +
    	       "(:category IS NULL OR r.category.id = :category) AND " +
    	       "(:kw IS NULL OR (r.title LIKE %:kw% OR r.user.nickname LIKE %:kw% OR r.description LIKE %:kw%))")
    	Page<Recipe4> findRecipesWithFilter(@Param("kw") String keyword, @Param("field") String field, 
    	                                     @Param("category") Integer category, Pageable pageable);

    // [기존 updateViews] 조회수 증가
    @Modifying
    @Query("UPDATE Recipe4 r SET r.views = r.views + 1 WHERE r.id = :id")
    void incrementViews(@Param("id") Long id);
}