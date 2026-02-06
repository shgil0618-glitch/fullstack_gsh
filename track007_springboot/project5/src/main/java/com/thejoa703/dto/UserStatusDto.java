package com.thejoa703.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserStatusDto {
    private Integer appUserId;     // BUG5.APPUSERID
    private String status;         // ACTIVE, SUSPEND, WITHDRAW
    private String suspendReason;
    private LocalDate suspendUntil;
    private LocalDateTime updatedAt;
}