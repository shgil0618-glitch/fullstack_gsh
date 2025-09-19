package com.company.java004_ex;

import java.util.Scanner;

public class IfEx001 {
	public static void main(String[] args) {
		int score;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("평균을 입력하시오 : ");
		score = scanner.nextInt();
		
		if(score>=60) {System.out.println("합격 입니다.");}
		else {System.out.println("불합격 입니다.");}
		
		System.out.println(score >= 60 ? "합격" : "불합격");
	}
}
 /*
연습문제1)
패키지명 : com.company.java004_ex
클래스명 :  IfEx001
출력내용 : 평균을 입력받아 60점이상이면 합격,  불합격여부를 출력하는 프로그램을 IF로 작성하시오.
*/