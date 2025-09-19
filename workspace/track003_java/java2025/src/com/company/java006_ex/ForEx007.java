package com.company.java006_ex;

import java.util.Scanner;

public class ForEx007 {
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int kor=-1, mat=-1, eng=-1, total=0;
	String num = "" ,pass = "", mvp = "", level="";
	double avg=3.14;
	
	System.out.print("학번을 입력하시오 : ");
	num = scanner.nextLine();
		
	for(;;) {
		if(!(kor>=0 && kor <=100)) {
			System.out.print("국어점수 입력 : ");
			kor=scanner.nextInt();
			continue;
		}
		if(!(mat>=0 && mat <=100)) {
			System.out.print("수학점수 입력 : ");
			mat=scanner.nextInt();
			continue;
		}
		if(!(eng>=0 && eng<=100)) {
			System.out.print("영어점수 입력 : ");
			eng=scanner.nextInt();
			continue;
		}
		
		/*		이방법도 가능
		for(;;) {
			System.out.print("국어점수 입력 : "); kor=scanner.nextInt();
			if(kor>=0 && kor<=100) {break;}
		}
		*/
		
		total = kor+mat+eng;
		avg = total/3.0;
		
		if(avg>=60 && (kor >=40 && mat >=40 && eng >=40)) {pass += "합격";}
		else {pass += "불합격";}
		if(avg>=95) {mvp += "장학생";}
		else {mvp += "X";}
		if(avg>=90) {level += "수";}
		else if(avg>=80) {level += "우";}
		else if(avg>=70) {level += "미";}
		else if(avg>=60) {level += "양";}
		else {level += "가";}	
	break;
	}
	
	System.out.println("============================================================== ");
	System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생 ");
	System.out.println("============================================================== ");
	System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s",num,kor,eng,mat,total,avg,pass,level,mvp);
	}
}

/*
클래스명 :  ForEx007
출력내용 :  성적처리 프로그램입니다.

1. 총점 구하기
2. 평균 구하기
3. 평균이 60점이상이고  각과목이 40점 미만이면 아니라면 합격/ 아니면 불합격
4. 평균이 95점이상이면 장학생
5. 평균이  90점이상이면 수, 80점이상이면 우, 70점이상이면 미, 60점이상이면 양, 아니라면 가 

학번 입력 > std111
국어점수 입력 > 100    ※ 0~100사이만입력받기
수학점수 입력 > 100    ※ 0~100사이만입력받기
영어점수 입력 > 99      ※ 0~100사이만입력받기

============================================================== 
학번   국어   영어   수학   총점   평균   합격여부   레벨   장학생
============================================================== 
std111   100   100   99   299   99.67   합격   수   장학생
*/