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

//--- AI 사용 기록 ---
@Entity
@Table(name = "AI_USAGE_HISTORY4")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class AiUsageHistory4 {
 @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ai4_seq")
 @SequenceGenerator(name = "ai4_seq", sequenceName = "AI_USAGE4_SEQ", allocationSize = 1)
 private Long id;

 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "APPUSERID")
 private AppUser user;

 private String aiAction; // EX: "GENERATED_STEPS", "MODERATION"
 private LocalDateTime createdAt;
 @PrePersist protected void onCreate() { this.createdAt = LocalDateTime.now(); }
}