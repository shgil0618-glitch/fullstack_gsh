package com.thejoa703.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.SearchHistory4;

import io.lettuce.core.dynamic.annotation.Param;

@Repository
public interface SearchHistoryRepository4 extends JpaRepository<SearchHistory4, Long> {
    // [기존 topKeywords] 인기 검색어 통계 (Native Query)
    @Query(value = "SELECT KEYWORD, COUNT(*) as cnt FROM SEARCH_HISTORY4 " +
                   "GROUP BY KEYWORD ORDER BY cnt DESC FETCH FIRST :limit ROWS ONLY", nativeQuery = true)
    List<Object[]> findTopKeywords(@Param("limit") int limit);
}
