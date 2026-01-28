package com.thejoa703.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CategoryRequest4 {
    private Long categoryId;
    @NotBlank
    private String categoryName;
}