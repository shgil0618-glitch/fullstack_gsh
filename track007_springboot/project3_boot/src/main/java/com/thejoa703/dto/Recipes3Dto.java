package com.thejoa703.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipes3Dto {
    private int recipeId;
    private int appUserId;
    private String title;
    private int category;
    private String image;
    private int cookTime;
    private String difficulty;
    private int servings;
    private String description;
    private String status; // PUBLIC, PRIVATE, DRAFT
    private Date createdAt;
    private Date updatedAt;
    private int views;
    private String rUrl;
    private String nickname; // join해서 가져올 경우
    private String categoryName; // join해서 가져올 경우

    private List<RecipesIngre3> ingredients;
    private List<RecipesStep3> steps;
}
