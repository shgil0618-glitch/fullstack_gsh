package com.thejoa703.dto;


import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipes3Dto {

    private Integer recipeId;
    private Integer appUserId;
    private String title;
    private Integer category;
    private String image;
    private Integer cookTime;
    private String difficulty;
    private Integer servings;
    private String description;
    private String status;
    private Date createdAt;
    private Date updatedAt;
    private Integer views;
    private String rUrl;

    private String nickname;
    private String categoryName;

    private List<RecipesIngre3> ingredients;
    private List<RecipesStep3> steps;
}
