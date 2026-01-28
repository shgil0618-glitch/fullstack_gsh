package com.thejoa703.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class RecipeRequest4 {
    private Long recipeId;
    private Long appUserId;

    @NotBlank(message = "제목은 비어있을 수 없습니다.")
    private String title;

    @NotNull(message = "카테고리를 선택해주세요.")
    private Long categoryId;

    private String image;
    private Integer cookTime;
    private String difficulty;
    private Integer servings;

    @NotBlank(message = "레시피 설명을 입력해주세요.")
    private String description;

    private String status; // PUBLIC, PRIVATE
    private String rUrl;

    private List<RecipeIngredientRequest4> ingredients;
    private List<RecipeStepRequest4> steps;
}