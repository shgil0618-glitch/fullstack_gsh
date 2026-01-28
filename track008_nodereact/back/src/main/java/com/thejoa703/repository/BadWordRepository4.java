package com.thejoa703.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.BadWord4;

@Repository
public interface BadWordRepository4 extends JpaRepository<BadWord4, Long> {
    // 기본 findAll 및 페이징(Pageable) 활용
    boolean existsByWord(String word);
}
