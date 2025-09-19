package com.company.java004_ex;

import java.util.Scanner;

public class IfEx002 {
	public static void main(String[] args) {
		int num1;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("숫자를 입력하시오 : ");
		num1 = scanner.nextInt();
		
		if(num1>0) {System.out.println("양수입니다.");}
		else if(num1<0) {System.out.println("음수입니다.");}
		else {System.out.println("zero");}
		
	}
}

/*
연습문제2)
패키지명 : com.company.java004_ex
클래스명 :  IfEx002
출력내용 : 숫자 한개를 입력받아 
   양수라면 양수  , 음수라면 음수  ,0이라면 zero를 출력하는 프로그램을 작성하시오.
*/
