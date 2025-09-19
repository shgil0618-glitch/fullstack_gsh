package com.company.java004_ex;

import java.util.Scanner;

public class IfEx005 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char ch;
		
		System.out.print("문자 한개를 입력하시오 : ");
		ch = scanner.next().charAt(0);
		
		if(ch>=65 && ch<=90) { System.out.printf("%s 의 대소문자 변경된 문자는 : %s",ch,ch = (char)(ch+32));}
		else if (ch>=97 && ch<=122) {System.out.printf("%s 의 대소문자 변경된 문자는 : %s",ch,ch = (char)(ch-32));}
		else {System.out.println("영문자가 아닙니다.");}
		
	}
}

/*
연습문제5)
패키지명 : com.company.java004_ex
클래스명 :  IfEx005
출력내용 : 문자한개를 입력받아 
   대문자인지 이면 소문자로,  소문자이면 대문자로 변경하는 프로그램을 작성하시오.
   ※  a = 'A' + 32    
*/