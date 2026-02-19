package com.thejoa703.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WinnerDto {
    private Integer winnerId;       // PK
    private Integer participantId;  // FK
    private Integer winRank;        // 당첨 등수 (1~4)
    private String winReason;       // 당첨 사유 (PRESET, RANGE, RANDOM)
    private String winDate;         // 당첨 처리일
}