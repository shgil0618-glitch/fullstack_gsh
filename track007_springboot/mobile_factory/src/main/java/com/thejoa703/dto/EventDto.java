package com.thejoa703.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
    private Integer eventId;        // PK
    private String name;            // 이벤트명
    private String startDate;       // 이벤트 시작일 (2025/02/01)
    private String endDate;         // 이벤트 종료일 (2025/03/31)
    private String announceStart;   // 발표 시작일 (2025/04/01)
    private String announceEnd;     // 발표 종료일 (2025/04/15)
    private String createDate;      // 생성일
}