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

//--- 비속어 관리 ---
@Entity
@Table(name = "BAD_WORD4")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class BadWord4 {
 @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bw4_seq")
 @SequenceGenerator(name = "bw4_seq", sequenceName = "BAD_WORD4_SEQ", allocationSize = 1)
 private Long id;

 @Column(unique = true)
 private String word;
}
