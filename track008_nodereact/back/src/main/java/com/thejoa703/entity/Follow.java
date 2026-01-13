package com.thejoa703.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
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
import lombok.Getter;
import lombok.Setter;

@Entity    
@Table(name= "FOLLOWS")
@Getter  @Setter 
public class Follow {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "follow_seq")  //시퀀스 사용
   @SequenceGenerator(name = "follow_seq", sequenceName = "FOLLOW_SEQ" , allocationSize = 1) 
   private Long id; //PK
   
   @Column(nullable = false , name="CREATED_AT")
   private LocalDateTime createdAt; // 생성일시
   
   @PrePersist
   void onCreate() {
      this.createdAt = LocalDateTime.now();
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "FOLLOWER_ID", nullable = false)
   private AppUser  followerId;	// 나를 구독
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "FOLLOWEE_ID",nullable=false)
   private AppUser  followeeId;	// 내가한 구독

   
   public Follow(AppUser  followerId, AppUser  followeeId) {
	super();
	this.followerId = followerId;
	this.followeeId = followeeId;
   }
}

/*
  FOLLOWER	FOLLOWEE
  1(나)		2(카리나)
  1(나)		3(윈터)
 */



