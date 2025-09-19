package com.company.java002;

import java.util.Scanner;

public class input001 {
	public static void main(String[] args) {
		//자료형의 분류 : 기본형(값) / 참조형(주소)
		//기본형 : 논리형(boolean), 정수형(byte,short,int,long), 실수형(float,double)
		
		//OOP? 클래스(부품객체) 조립해서 완성해가는 프로그램
		//변수
		int 	like	= 0;
		Scanner scanner	= new Scanner(System.in);	//자동참조 : ctrl + shift + o   사용방법 : 클릭+f2
		//1. new 공간빌리기		heap 1000 번지 [    ]
		//2. Scanner(System.in)	Scanner() 사용할수 있게 초기화 - System.in : 키보드 입력
		//3. 사용법 : Scanner.	변수명.
		
		//입력
		System.out.print("정수를 입력하세요 : ");
		like = scanner.nextInt();	// 입력받기 커서가 깜빡
		
		//처리 X
		
		//출력
		System.out.println("입력한 정수는"+like+"입니다.");
		
	}
}
