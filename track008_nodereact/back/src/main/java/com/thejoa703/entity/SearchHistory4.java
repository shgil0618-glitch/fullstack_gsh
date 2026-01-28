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

//--- 검색 기록 ---
@Entity
@Table(name = "SEARCH_HISTORY4")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SearchHistory4 {
 @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sh4_seq")
 @SequenceGenerator(name = "sh4_seq", sequenceName = "SEARCH_HISTORY4_SEQ", allocationSize = 1)
 private Long id;

 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "APPUSERID")
 private AppUser user;

 private String keyword;
 private LocalDateTime createdAt;
 @PrePersist protected void onCreate() { this.createdAt = LocalDateTime.now(); }
}