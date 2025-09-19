package com.company.java004_ex;

import java.util.Scanner;

public class IfEx004 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char ch1;
		
		System.out.print("문자 한개를 입력하시오 : ");
		ch1 = scanner.next().charAt(0);
		
		if(ch1>='A' && ch1 <= 'Z') {System.out.println("대문자 입니다.");}
		else if(ch1>=97  &&  ch1<=122) {System.out.println("소문자 입니다.");}
		else {System.out.println("영문자가 아닙니다.");}

		
	}
}

/*
연습문제4)
패키지명 : com.company.java004_ex
클래스명 :  IfEx004
출력내용 : 문자한개를 입력받아 
   대문자인지,  소문자인지 판별하는 프로그램을 작성하시오.
   ※  대문자  ch>='A' && ch<='Z' / 소문자  ch>='a'  &&  ch<='z'  
*/