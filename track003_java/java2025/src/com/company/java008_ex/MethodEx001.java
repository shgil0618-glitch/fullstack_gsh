package com.company.java008_ex;

public class MethodEx001 {
	public static void main(String[] args) {
		dog();
		line();
		cat();
		line();
	}
	public static void dog() {System.out.println("멍멍");}
	public static void cat() {System.out.println("야옹");}
	public static void line() {System.out.println("=========");}
}

/*
연습문제1)  method
패키지명 : com.company.java008_ex
클래스명 :  MethodEx001
다음과 같이 dog(), line(), cat() 메서드를 정의하시오.

public static void main(String[] args) {
  dog();  // 멍멍 출력
  line();   //========= 출력 
  cat();    // 야옹 출력
  line();   //========= 출력
}
*/