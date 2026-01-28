package com.thejoa703.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.AiUsageHistory4;

@Repository
public interface AiUsageHistoryRepository4 extends JpaRepository<AiUsageHistory4, Long> {
    List<AiUsageHistory4> findAllByOrderByCreatedAtDesc();
}
