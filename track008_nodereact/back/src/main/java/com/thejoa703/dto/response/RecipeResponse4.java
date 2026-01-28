package com.thejoa703.dto.response;

import com.thejoa703.entity.Recipe4;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class RecipeResponse4 {
    private Long id;
    private String title;
    private String description;
    private String image;
    private Integer cookTime;
    private String difficulty;
    private Integer servings;
    private String status;
    private Long views;
    private String rUrl;
    private LocalDateTime createdAt;
    
    // 조인 데이터
    private Long authorId;
    private String authorNickname;
    private Long categoryId;
    private String categoryName;

    // 상세 리스트 (v3 Mapper의 collection 기능 대체)
    private List<RecipeIngredientResponse4> ingredients;
    private List<RecipeStepResponse4> steps;

    public static RecipeResponse4 fromEntity(Recipe4 recipe) {
        return RecipeResponse4.builder()
                .id(recipe.getId())
                .title(recipe.getTitle())
                .description(recipe.getDescription())
                .image(recipe.getImage())
                .cookTime(recipe.getCookTime())
                .difficulty(recipe.getDifficulty())
                .servings(recipe.getServings())
                .status(recipe.getStatus())
                .views(recipe.getViews())
//                .rUrl(recipe.getRUrl())
                .createdAt(recipe.getCreatedAt())
                .authorId(recipe.getUser().getId())
                .authorNickname(recipe.getUser().getNickname())
                .categoryId(recipe.getCategory().getId())
                .categoryName(recipe.getCategory().getCategoryName())
                .build();
    }
}