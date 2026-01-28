package com.thejoa703.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class RecipeStepResponse4 {
    private Long id;
    private String description; // stepDesc -> description
    private String image;       // stepImage -> image
}