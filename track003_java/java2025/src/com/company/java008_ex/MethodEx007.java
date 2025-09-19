package com.company.java008_ex;

public class MethodEx007 {
	   public static int add(int x, int y) {return x+y;}	// 1번
	   
	   public static int  add(byte x, byte y)   {return x+y;}   //2번
	   public static int  add(short x, short y) {return x+y;}   //3번
//	   public static long add(int a, int b)    {return a+b;}   	//4번
	   public static long add(long  x, long y)  {return x+y;}   //5번
	   
	   public static void main(String[] args) { 
		   //Q1. 메서드 오버로딩? - 비슷한 목적의 메서드 이름을 같게하는것.
		   // 메서드 오버로딩이란 메서드의 [매개변수의 자료형]과 [갯수]가 똑같기 때문에 발생하는 문제로 프로그램상으로는 같은 구조로 파악하기때문 오류가 발생한다.
		   //Q2. 왜 오류? - 파라미터의 개수와 자료형으로 구분
		   // 1,4 번의 파라미터의 자료형과 갯수가 같음
	   }
	}
