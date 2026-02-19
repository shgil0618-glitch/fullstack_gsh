package com.thejoa703.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantDto {
    private Integer participantId;  // PK
    private Integer eventId;        // FK
    private String phoneNumber;     // 휴대폰 번호 (Unique)
    private Integer entryOrder;     // 참가 순번 (1~10,000)
    private String joinDate;        // 참여일
    private String verified;        // 인증 여부 (Y/N)
}