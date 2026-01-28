package com.thejoa703.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RecipeLikeRequest4 {
    @NotNull
    private Long appUserId;
    @NotNull
    private Long recipeId;
}