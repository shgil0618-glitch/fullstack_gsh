package com.thejoa703.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.Category4;

@Repository
public interface CategoryRepository4 extends JpaRepository<Category4, Long> {
    // findAll()로 전체 조회 가능
    Optional<Category4> findById(Long id);
}