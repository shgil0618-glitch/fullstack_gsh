package com.company.java004_ex;

import java.util.Scanner;

public class IfEx008 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int kor,eng,mat,total;
		double avg;
		String ch,a,level,b;
		
		
		System.out.print("학번 입력 : ");
		ch = scanner.nextLine();
		System.out.print("국어 점수 입력 : ");
		kor = scanner.nextInt();
		System.out.print("영어 점수 입력 : ");
		eng = scanner.nextInt();
		System.out.print("수학 점수 입력 : ");
		mat = scanner.nextInt();
		
		total = kor + eng + mat;
		avg = total/3.0;
		
		if( avg >=60 && (kor>40 && eng>40 & mat>40) ) { a = "합격";}
		else { a = "불합격";}
		
		
		if(avg>=95) {b = "장학생";}	//	95점이상일때만 들어가서 없으면 쓰레기값이 들어가서 오류발생 
									// 	만약 초기값선언을 하기싫다면 else로 부정일때도 값이 들어가게 설정
		
		if(avg>=90) {level = "수";}
		else if (avg>=80) {level = "우";}
		else if (avg>=70) {level = "미";}
		else if (avg>=60) {level = "양";}
		else {level = "가";}
		
		System.out.println("=================================================================================== ");
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t레벨장학생 ");
		System.out.println("=================================================================================== ");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s",ch,kor,eng,mat,total,avg,a,level,b);

	}
}

/*

연습문제8)  
패키지명 : com.company.java004_ex
클래스명 :  IfEx008
출력내용 :  성적처리 프로그램입니다.

1. 총점 구하기
2. 평균 구하기
3. 평균이 60점이상이고  각과목이 40점 미만이면 아니라면 합격/ 아니면 불합격
4. 평균이 95점이상이면 장학생
5. 평균이  90점이상이면 수, 80점이상이면 우, 70점이상이면 미, 60점이상이면 양, 아니라면 가 

학번 입력 > std111
국어점수 입력 > 100
수학점수 입력 > 100
영어점수 입력 > 99
=================================================================================== 
학번   국어   영어   수학   총점   평균   합격여부   레벨   장학생
=================================================================================== 
std111   100   100   99   299   99.67   합격   수   장학생
*/