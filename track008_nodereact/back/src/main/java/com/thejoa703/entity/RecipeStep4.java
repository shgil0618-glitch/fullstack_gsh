package com.thejoa703.entity;

import jakarta.persistence.Column;
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

//--- 조리 단계 엔티티 ---
@Entity
@Table(name = "RECIPE_STEP4")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class RecipeStep4 {
 @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rs4_seq")
 @SequenceGenerator(name = "rs4_seq", sequenceName = "RECIPE_STEP4_SEQ", allocationSize = 1)
 private Long id;

 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "RECIPE_ID")
 private Recipe4 recipe;

 @Column(length = 1000)
 private String stepDesc;
 private String stepImage;
}