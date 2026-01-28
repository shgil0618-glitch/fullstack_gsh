package com.thejoa703.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class AiUsageHistoryResponse4 {
    private Long id;
    private String action;
    private LocalDateTime createdAt;
}