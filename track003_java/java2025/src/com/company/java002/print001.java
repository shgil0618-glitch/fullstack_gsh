package com.company.java002;	// 저장위치

public class print001 {	// 어디서든지 접근 가능한 부품객체 print001
	
	public static void main(String[] args){ // static - 메모리상에 먼저 올라가있는
		//1. System.out.println();
		System.out.println("1. 줄바꿈");
			
		//2. System.out.print();
		System.out.print("2. 줄바꿈 안됨.");
		System.out.print("줄바꿈 특수 \\n 이용\n");	
		
		//3. System.out.printf(); %s : 문자열, %d : 정수, %f : 실수
		System.out.printf("3. 정수 %d, 실수 %f, 문자열 %s\n",1,1.234,"ABC");
		
		//4. +의 의미
		System.out.println("10+3");	//13
		System.out.println(10+3 +"+" + 1+2);
		// 아래의 결과는?	숫자+숫자+문자열
		//				13 + "+" + 1(출력) + 2(출력)
		//				13	+	12
		System.out.println(10+3 + "+" + (1+2));
		// Q. system.out.println( 1+2=3)
		//		1+2=3 로 출력
		System.out.println("1+2=3");
		System.out.println(1 + "+" + 2 + "=" + (1+2));
		System.out.printf("%d+%d=%d",1,2,3);
	}
}
