package com.thejoa703.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class BadWordRequest4 {
    private Long wordId;
    @NotBlank
    private String word;
}