package com.company.java011;

// 1. 상속? 클래스의 재사용
/*
 실선(확장-연결) - 속이빈화살표(일반화)
 Object				3) 			{ Object()}		4) 
  	↑
  	A	int a=10	2)  		{a		A()		 5) a=10}
  	↑
  	B	int b=20	1) new : 1번지 {b -> B()}		변수 a가있네? A()로			 6) b=20
 
 	B b1 = new B(); b1.show();
 	1) extends 상속
 	2) is a : A 는 Object이다, B도 Object
 	3) 생성자호출 : B() -> A() -> Object		1-2-3
 	4) 객체생성 : Object -> A -> B				4-5-6
 */
class A extends Object{
	int a=10;
	public A() {super();}
}
class B extends A{
	int b=20;
	public B() {super();}		//여기서의 super는 부모:a값을 가져옮
	public void show() {System.out.println(this.a+"\t"+this.b);}
}

public class Extends001 {
	public static void main(String[] args) {
		B b1 = new B();
		b1.show();
	}
}
