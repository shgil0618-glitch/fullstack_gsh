package com.thejoa703.dto.request;

import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AiUsageHistoryRequest4 {
    private Long aiHistId;
    private Long appUserId;
    private String aiAction;
    private LocalDateTime createdAt;
}