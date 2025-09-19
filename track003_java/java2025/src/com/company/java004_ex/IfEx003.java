package com.company.java004_ex;

import java.util.Scanner;

public class IfEx003 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1;
		
		System.out.print("숫자를 입력하시오(0~9) : ");
		num1 = scanner.nextInt();
		
		if(num1 == 1) {System.out.println("one");}
		else if(num1 == 2) {System.out.println("two");}
		else if(num1 == 3) {System.out.println("three");}
		else{System.out.println("1,2,3이 아니다.");}
	}
}

/*
연습문제3)
패키지명 : com.company.java004_ex
클래스명 :  IfEx003
출력내용 : 숫자한개를 입력받아 
   만약 1을 입력했다면   one ,   
   만약 2을 입력했다면   two ,
   만약 3을 입력했다면   three ,
   1,2,3이 아니라면  1,2,3이 아니다를 출력하는 프로그램을 작성하시오.
*/