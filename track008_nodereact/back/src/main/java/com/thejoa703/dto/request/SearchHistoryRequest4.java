package com.thejoa703.dto.request;

import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class SearchHistoryRequest4 {
    private Long searchId;
    private Long appUserId;
    private String keyword;
    private LocalDateTime createdAt;
}