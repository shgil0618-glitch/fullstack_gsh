package com.thejoa703.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmsLogDto {
    private Integer smsId;          // PK
    private Integer participantId;  // FK
    private String phoneNumber;     // 수신 번호
    private String msgType;         // ISSUE(번호발송), REMIND(미확인안내)
    private String sendDate;        // 발송 일시
}