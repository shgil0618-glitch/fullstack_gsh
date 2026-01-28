package com.thejoa703.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class SearchHistoryResponse4 {
    private Long id;
    private String keyword;
    private LocalDateTime createdAt;
}