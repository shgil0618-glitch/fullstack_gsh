package com.thejoa703.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RECIPES4")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Recipe4 {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe4_seq")
    @SequenceGenerator(name = "recipe4_seq", sequenceName = "RECIPES4_SEQ", allocationSize = 1)
    @Column(name = "RECIPE_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APPUSERID")
    private AppUser user; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private Category4 category;

    @Column(nullable = false)
    private String title;

    private String image;
    private Integer cookTime;
    private String difficulty;
    private Integer servings;

    @Lob
    private String description;

    @Builder.Default
    private Long views = 0L;

    private String status; // PUBLIC, PRIVATE
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // --- 영속성 전이(Cascade) 설정: 레시피 저장/삭제 시 하위 요소도 자동 처리 ---
    
    @Builder.Default
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecipeIngredient4> ingredients = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecipeStep4> steps = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecipeLike4> likes = new ArrayList<>();
    
    
    public void addIngredient(RecipeIngredient4 ingredient) {
        this.ingredients.add(ingredient);
        if (ingredient.getRecipe() != this) {
            ingredient.setRecipe(this);
        }
    }

    /**
     * 연관관계 편의 메서드: 조리 단계 추가
     */
    public void addStep(RecipeStep4 step) {
        this.steps.add(step);
        if (step.getRecipe() != this) {
            step.setRecipe(this);
        }
    }
    

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }


}