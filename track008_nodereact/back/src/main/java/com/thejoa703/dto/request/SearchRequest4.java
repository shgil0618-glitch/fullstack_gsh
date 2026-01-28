package com.thejoa703.dto.request;

import lombok.*;
import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class SearchRequest4 {
    private String keyword;
    private String searchField;
    private List<String> fields;
    private String sort;
    private Long categoryId;
    private Long appUserId;

    private int currentPage = 1;
    private int pageSize = 10;

    public int getRStart() { return (currentPage - 1) * pageSize + 1; }
    public int getREnd() { return currentPage * pageSize; }
}