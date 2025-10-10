package com.company.javaex_test;

//1. 클래스는 부품객체
//2. 상태(멤버변수)와 행위(멤버함수)
class A{
	int a; // 인스턴스변수 , heap area, new O, 실체화 this 각각
	static String company; // 클래스변수, method area , new X, 공용
	void method() {int a = 0; System.out.println(a);} // 지역변수, stack , 임시 ★주의사항 : 초기화
}
public class Repeat001_oop2 {
	public static void main(String[] args) {

	}
}
