package com.company.java002;

public class Var {
	public static void main(String[] args) {
		
		//1. 변수? 자료형	변수명
		int a = 0;	//%d, 1,2,3 이런 정수형 담을수 있는 공간 a[     ]
		System.out.println("1:"+ a);
		
		a = 1000000; // A=B (대입 연산자)
		System.out.println("2:"+a);
		
		a = a-90000;
		System.out.println("3:"+a);
		
		//2. 변수의 범위
		{ int b=20; System.out.println(b);}
		// b=1000;	b cannot be resolved to a variable
		
		//3. 변수명
		//오픈박스(변수)
		int $1 = 1;	int _2 = 2;	int a3bc = 3;
		//밀봉박스(상수)
		final int HOME =4;
		//int static; //   Syntax error on token "static", invalid VariableDeclarator	Var.
		//int package
		//int void
		int main;

	}
}
