package com.company.java003_ex;

import java.util.Scanner;

public class CastingCharEx {
	public static void main(String[] args) {
		char upper = ' ';
		char lower = ' ';
		int var;
		Scanner scanner = new Scanner(System.in);
			
		System.out.print("대문자를 입력하시오 : ");
		upper = scanner.next().charAt(0);	//next() 문자열 입력 charAt(0) 첫번째 문자
		lower = (char)(upper+32);
		
		System.out.println("입력하신 대문자 " +upper+ ", 소문자 변환 : " + lower);
		
	}
}

/*
 연습문제1)
클래스명 : CastingCharEx 
- 대문자입력받아서 소문자로 변경프로그램을 작성하시오.


 */