package com.thejoa703.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class RecipeIngredientResponse4 {
    private Long id;
    private String name;
    private String amount;
    // RecipeId는 부모 객체에 있으므로 응답에서는 보통 제외합니다.
}