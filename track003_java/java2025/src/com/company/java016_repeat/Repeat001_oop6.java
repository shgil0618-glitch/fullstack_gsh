package com.company.java016_repeat;

/*  
1. 상속을 사용하는 이유는 재사용에 용이하게 만들기 위해서이다.
2. class 자식  extends 부모
	  객체호출순서 :   C1()   B1()   A1()  Object()
	  객체생성순서 :   Object   A1   B1    C1
 */
class A1 extends Object { int a; public A1() { super(); } }
class B1 extends A1     { int b; public B1() { super(); } }
class C1 extends B1     { int c; public C1() { super(); }  
	public void showC() {
		System.out.println("상속받은 A클래스의 a : " + a);
		System.out.println("상속받은 B클래스의 b : " + b);
		System.out.println("자신멤버의 C클래스의 c: " + c);
	}
}
public class Repeat001_oop6 extends Object {
  public static void main(String[] args) { 				 
	C1  myc = new C1();   
	myc.a = 10; myc.b=20; myc.c=30;
	myc.showC();
  }
}
