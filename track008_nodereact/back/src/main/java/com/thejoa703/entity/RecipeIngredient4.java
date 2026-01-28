package com.thejoa703.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//--- 재료 엔티티 ---
@Entity
@Table(name = "RECIPE_INGREDIENT4")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class RecipeIngredient4 {
 @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ri4_seq")
 @SequenceGenerator(name = "ri4_seq", sequenceName = "RECIPE_INGRE4_SEQ", allocationSize = 1)
 private Long id;

 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "RECIPE_ID")
 private Recipe4 recipe;

 private String ingreName;
 private String ingreNum;
}