package com.company.java010_ex;

import java.util.Scanner;

public class Pet{  
	
	   private String name;  
	   private int walkTime, snackCount, cuddleCount, moodScore;  
	   private String snackStars, tailWag, todayMessage;
	   public Pet() {
		super();
		// TODO Auto-generated constructor stub
	   }
	   public Pet(String name, int walkTime, int snackCount, int cuddleCount) {
		super();
		this.name = name;
		this.walkTime = walkTime;
		this.snackCount = snackCount;
		this.cuddleCount = cuddleCount;
	   }
	   @Override
	   public String toString() {
		return "Pet [name=" + name + ", walkTime=" + walkTime + ", snackCount=" + snackCount + ", cuddleCount="
				+ cuddleCount + ", moodScore=" + moodScore + ", snackStars=" + snackStars + ", tailWag=" + tailWag
				+ ", todayMessage=" + todayMessage + "]";
	   }
	   public String getName() {
		   return name;
	   }
	   public void setName(String name) {
		   this.name = name;
	   }
	   public int getWalkTime() {
		   return walkTime;
	   }
	   public void setWalkTime(int walkTime) {
		   this.walkTime = walkTime;
	   }
	   public int getSnackCount() {
		   return snackCount;
	   }
	   public void setSnackCount(int snackCount) {
		   this.snackCount = snackCount;
	   }
	   public int getCuddleCount() {
		   return cuddleCount;
	   }
	   public void setCuddleCount(int cuddleCount) {
		   this.cuddleCount = cuddleCount;
	   }
	   public int getMoodScore() {
		   return moodScore;
	   }
	   public void setMoodScore(int moodScore) {
		   this.moodScore = moodScore;
	   }
	   public String getSnackStars() {
		   return snackStars;
	   }
	   public void setSnackStars(String snackStars) {
		   this.snackStars = snackStars;
	   }
	   public String getTailWag() {
		   return tailWag;
	   }
	   public void setTailWag(String tailWag) {
		   this.tailWag = tailWag;
	   }
	   public String getTodayMessage() {
		   return todayMessage;
	   }
	   public void setTodayMessage(String todayMessage) {
		   this.todayMessage = todayMessage;
	   }  
	   
	   public void input() {
		   Scanner scanner = new Scanner(System.in);
		   System.out.print("이름 입력 : ");
		   this.name = scanner.nextLine();
		   System.out.print("산책시간 입력 : ");
		   this.walkTime = scanner.nextInt();
		   System.out.print("간식개수 입력 : ");
		   this.snackCount = scanner.nextInt();
		   System.out.print("쓰다듬횟수 입력 : ");
		   this.cuddleCount = scanner.nextInt();
	   }
	   
	   public void moodScore() {
		   this.moodScore = walkTime + (snackCount * 10) + (cuddleCount * 5);
	   }
	   
	   public void snackStars() {
		   if(this.moodScore>=90) { this.snackStars ="*****";}
		   else if(this.moodScore>=70) { this.snackStars ="****";}
		   else if(this.moodScore>=50) { this.snackStars ="***";}
		   else if(this.moodScore>=30) { this.snackStars ="**";}
		   else{ this.snackStars ="*";}
	   }
	   
	   public void tailWag() {
		   if(this.moodScore>=90) {this.tailWag = "흔들흔들흔들";}
		   else if(this.moodScore>=60) {this.tailWag = "흔들흔들";}
		   else if(this.moodScore>=40) {this.tailWag = "살짝 흔들";}
		   else {this.tailWag = "꼬리 내림";}
	   }
	   
	   public void todayMessage() {
		   if(this.moodScore>=90) {this.todayMessage = "오늘은 정말 행복했어요!";}
		   else if(this.moodScore>=60) {this.todayMessage = "좋은 하루였어요!";}
		   else if(this.moodScore>=40) {this.todayMessage = "조금 더 놀아줘요!";}
		   else {this.todayMessage = "외로웠어요...";}
	   }

	   
	  public static void info() {
		  System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		  System.out.println("이름\t산책시간\t간식개수\t쓰다듬횟수\t행복도\t간식보상\t꼬리흔들기\t오늘의멘트");
		  System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
	  } 
	  public void show() {
		  moodScore();
		  snackStars();
		  tailWag();
		  todayMessage();
		  System.out.printf("%s\t%d분\t%d개\t%d회\t%d\t%s\t%-10s\t%-10s\t \n",this.name,this.walkTime,this.snackCount,this.cuddleCount,this.moodScore,this.snackStars,this.tailWag,this.todayMessage);
	  } 
	}



/*
  ㅁ출력된화면  
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
이름   산책시간   간식개수   쓰다듬횟수   행복도   간식보상   꼬리흔들기   오늘의멘트  
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
콩이   60분       3개       10회       95       ★★★★★     흔들흔들흔들   "오늘은 정말 행복했어요!"  
나비   10분       1개       2회        40       ★★         살짝 흔들     "조금 더 놀아줘요!"  



ㅁ주어진조건  

1) 항목별 조건 및 계산 방식
 간식개수 (snackCount)
사용자가 직접 입력하는 값 (예: kong.setSnackCount(3);)
행복도 계산 시 10점씩 반영됨 → snackCount * 10

2) 쓰다듬횟수 (cuddleCount)
사용자가 직접 입력하는 값 (예: kong.setCuddleCount(10);)
행복도 계산 시 5점씩 반영됨 → cuddleCount * 5

3) 행복도 (moodScore)
계산 공식:
코드
moodScore = walkTime + (snackCount * 10) + (cuddleCount * 5)
예: 산책 60분, 간식 3개, 쓰다듬 10회 → 60 + 30 + 50 = 140

4) 간식보상 (snackStars)
행복도 점수 범위   간식보상 출력
90 이상   ★★★★★
70 이상   ★★★★
50 이상   ★★★
30 이상   ★★
그 외   ★

5)  꼬리흔들기 (tailWag)
행복도 점수 범위   꼬리흔들기 출력
90 이상   흔들흔들흔들
60 이상   흔들흔들
40 이상   살짝 흔들
그 외   꼬리 내림

6)  오늘의 멘트 (todayMessage)
행복도 점수 범위   출력 멘트
90 이상   "오늘은 정말 행복했어요!"
60 이상   "좋은 하루였어요!"
40 이상   "조금 더 놀아줘요!"
그 외   "외로웠어요..."
 */
