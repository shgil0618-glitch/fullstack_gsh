package com.thejoa703.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//--- 좋아요 엔티티 ---
@Entity
@Table(name = "RECIPE_LIKE4")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class RecipeLike4 {
 @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rl4_seq")
 @SequenceGenerator(name = "rl4_seq", sequenceName = "RECIPE_LIKE4_SEQ", allocationSize = 1)
 private Long id;

 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "APPUSERID")
 private AppUser user;

 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "RECIPE_ID")
 private Recipe4 recipe;

 private LocalDateTime createdAt;
 
 @PrePersist protected void onCreate() { this.createdAt = LocalDateTime.now(); }
}