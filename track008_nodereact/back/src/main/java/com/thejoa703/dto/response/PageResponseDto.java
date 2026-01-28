package com.thejoa703.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class PageResponseDto<T> {
    private List<T> content;     // 데이터 리스트
    private int currentPage;     // 현재 페이지
    private long totalElements;  // 전체 개수
    private int totalPages;      // 전체 페이지 수
    private boolean last;        // 마지막 페이지 여부
}