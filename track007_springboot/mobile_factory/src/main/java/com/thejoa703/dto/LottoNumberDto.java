package com.thejoa703.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LottoNumberDto {
    private Integer lottoId;        // PK
    private Integer participantId;  // FK
    private String lottoNumber;     // 발급된 6자리 번호
    private String issueDate;       // 발급 일시
}