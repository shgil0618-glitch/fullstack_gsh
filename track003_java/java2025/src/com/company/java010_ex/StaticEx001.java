package com.company.java010_ex;

import java.util.Scanner;

class Area1{
	static double pi=3.14159;

	static double rect(int row, int height) {
		return row*height;
	}
	
	static double  triangle(int row, int height) {
		return row*height*0.5;
	}
}

public class StaticEx001 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("원의 면적    : " + 10 * 10 * Area1.pi);		//클래스명.변수, 클래스변수, method, static
		System.out.println("사각형의 면적 : " + Area1.rect(10, 5));			//클래스명.변수, 클래스변수, method, static
		System.out.println("삼각형의 면적 : " + Area1.triangle(10, 5));		//클래스명.변수, 클래스변수, method, static
	}
}
/*
연습문제1)  static
패키지명 : com.company.java010_ex
클래스명 :  StaticEx001
-- class Area1 작성해주세요   ※ pi값은 3.14159
public class StaticEx001{
  public static void main(String[] args) {  
   System.out.println("원의 면적    : " + 10 * 10 * Area1.pi);
   System.out.println("사각형의 면적 : " + Area1.rect(10, 5));
   System.out.println("삼각형의 면적 : " + Area1.triangle(10, 5));
  }
}

출력내용 : 
원의 면적    : 314.159
사각형의 면적 : 50.0
삼각형의 면적 : 25.0

*/