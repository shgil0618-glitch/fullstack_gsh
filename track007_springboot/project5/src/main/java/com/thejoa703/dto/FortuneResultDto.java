package com.thejoa703.dto;

import lombok.Data;
import java.util.Date;

@Data
public class FortuneResultDto {
    private int resultId;
    private int userId;
    private int categoryId;
    private String categoryName; // 조인해서 가져올 용도
    private String fortuneText;  // CLOB 대응
    private int score;
    private String summary;
    private Date createdAt;

    // 오행(Elements) 정보 (elements_balance 테이블 조인용)
    private int wood;
    private int fire;
    private int earth;
    private int metal;
    private int water;
    private String dominantElement;
}