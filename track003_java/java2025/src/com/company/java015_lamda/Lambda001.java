package com.company.java015_lamda;

// 1. 클래스는 부품객체 - 설계도 (틀, can do this)
// 2. 상태 + 행위		- interface (public static final / public abstract)

/////////////////////////////////////////////////////////////////
interface Inter1 {void method();}
class Inter1Imp1 implements Inter1{
	@Override
	public void method() {
	System.out.println("hello :D");
	}
}
/////////////////////////////////////////////////////////////////

public class Lambda001 {
	public static void main(String[] args) {
		// #1. interface 구현객체(자식)
		Inter1 i1 = new Inter1Imp1();
		i1.method();
		// #2. 익명 이너 클래스 (test목적, 1번쓰고 버릴목적, 잘 안쓰는 이벤트)
		// Inter1 i2 = new Inter1();	interface는 추상메서드이기때문에 new 사용못함
		Inter1 i21 = new Inter1() {
			@Override
			public void method() {
				System.out.println("일회용 - HELLO :D");
			}
		};
		i21.method();
		
		Inter1 i22 = new Inter1() {
			@Override
			public void method() {
				System.out.println("일회용2 - HELLO :D");
			}
		};
		i22.method();
		
		// #3. lambda 
		Inter1 i3 = () -> {System.out.println("일회용lam - HELLO :D:D:D");};
		i3.method();
		
	}
}
