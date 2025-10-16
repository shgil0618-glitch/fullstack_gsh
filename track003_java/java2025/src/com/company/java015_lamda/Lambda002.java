package com.company.java015_lamda;

interface InterA2 {
	void hi();
}

interface InterB2 {
	void hi(String name);
}

interface InterC2 {
	String hi();
}

interface InterD2 {
	String hi(int num, String name);
}

public class Lambda002 {
	public static void main(String[] args) {
		System.out.println("\n\n[STEP1] 매개변수 X, 리턴값 X"); // InterA2
		// 1-1. 익명객체 HI출력
		InterA2 a1 = new InterA2() {
			@Override
			public void hi() {
				System.out.println("1) hi");
			}
		};
		a1.hi();

		// 1-2. 람다식 () -> {}
		InterA2 a2 = () -> {
			System.out.println("2) hi");
		};
		a2.hi();

		InterA2 a3 = () -> System.out.println("3) hi");
		System.out.println("5) hi");
		a3.hi(); // 처리할일이 한줄 {} 생략가능

		// 2. interface InterB2 {void hi(String name);}
		System.out.println("\n\n[STEP2] 매개변수O , 리턴값 X");
		// 2-1. 익명객체 hi sally! 출력
		InterB2 b = new InterB2() {
			@Override
			public void hi(String name) {
				System.out.println("hi! " + name);
			}
		};
		b.hi("chily");

		// 2-2. 람다식 () -> {}
		InterB2 b2 = (String name) -> {
			System.out.println("hi! " + name);
		};
		b2.hi("2. chily");

		InterB2 b3 = (name) -> {
			System.out.println("hi! " + name);
		};
		b3.hi("3. chily");

		InterB2 b4 = (String name) -> System.out.println("hi! " + name);
		b4.hi("4. chily");

		// 3. interface InterC2{void String();}
		System.out.println("\n\\n[STEP3] 매개변수O , 리턴값 X");
		InterC2 c = new InterC2() {
			@Override
			public String hi() {
				return "good";

			}
		};
		System.out.println(c.hi());
		InterC2 c2 = () -> {
			return "Good :Day";
		};
		System.out.println(c2.hi());

		InterC2 c3 = () -> "Good :Day";
		System.out.println(c3.hi());

		// 4. interface InterD2{void hi(int num, String name);}
		System.out.println("\n\\n[STEP4] 매개변수O , 리턴값 O");
		// 4-1. 익명객체
		InterD2 d1 = new InterD2() {
			@Override
			public String hi(int num, String name) {
				String star = "★";
				for (int i = 0; i < num; i++) {
					star += "★";
				}
				return "hi " + name + star;
			}
		};
		System.out.println(d1.hi(1, "alpha"));
		System.out.println(d1.hi(2, "beta"));

		// 4-2. 람다식
		InterD2 d2 = (int num, String name) -> {
			String star = "★";
			for (int i = 0; i < num; i++) {
				star += "★";
			}
			return "hi " + name + star;
		};
		System.out.println(d1.hi(3, "alpha"));
		System.out.println(d1.hi(4, "beta"));

		InterD2 d3 = (num, name) -> {
			String star = "★";
			for (int i = 0; i < num; i++) {
				star += "★";
			}
			return "hi " + name + star;
		};
		System.out.println(d3.hi(5, "alpha"));
		System.out.println(d3.hi(6, "beta"));

//		InterD2 d4 = (int num, String name) ->  String star = "★"; for (int i = 0; i < num; i++) { star += "★"; } return "hi" + name + star;
//		System.out.println(d4.hi(7, "alpha"));
//		System.out.println(d4.hi(8, "beta"));

	}
}
