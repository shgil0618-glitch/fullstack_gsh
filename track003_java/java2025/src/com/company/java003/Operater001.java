package com.company.java003;

import java.util.Scanner;

public class Operater001 {
	public static void main(String[] args) {
		// 먼저() 값(+,-,*,/,%,++,--) 비교(>,<) 조건(&&,||,?:) 대입(=)
		// syso (ctrl+space) - 자동완성
	
		//1. 값
		int a = 10, b=3;
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);	//몫 3
		System.out.println(a%b);	//나머지 1
		
		//2. 비교 (==, !=, <, >, <=, >=)
		System.out.println(10 > 3);
		System.out.println(10 == 3);	
		//Q1. a가 짝수니?
		System.out.println(a%2 ==0);
		//Q2. b가 3의 배수니?
		System.out.println(b%3 ==0);
		
		//3. && (모든조건만족시) || (여러조건중에 하나라도 만족시 true)
		System.out.println(true & true);	// true : true
		System.out.println(true && true);	// true : 모든조건만족시 true
		System.out.println(false & true);	// false : & 처음에 false 뒤에 조건까지 읽음
		System.out.println(false && true);	// false : Dead code (앞에가 틀리면 뒤에꺼는 읽지않음)
		
		System.out.println(true | true);	// true : t
		System.out.println(true || true);	// true : Dead code 
		System.out.println(false | true);	// true : 
		System.out.println(false || true);	// true : 
		
		//Q1. A가 2의 배수이면서 5의 배수라면 TRUE/FALSE
		System.out.println(a%2==0 && a%5==0);
		//Q2. A가 2의 배수이거나 5의 배수라면 TRUE/FALSE
		System.out.println(a%2==0 || a%5==0);
		
		//4. 삼항연산자 (조건)? 참:겨짓
		System.out.println(a==10 ? "10이다" : "10이 아니다");
		/*
		//Q3. 숫자를 입력받아 0보다 그면 양수, 0보다 작으면 음수, 아니라면 0
		Scanner scanner = new Scanner(System.in);
		int q3 = scanner.nextInt();
		//				조건		?	참 : (조건 ? 참 : 거짓)
		String result = q3 >0 ? "양수" : (q3 < 0 ? "음수" : "0");
		*/
		//5. 대입 연산자
		a=10;	b=3;
		System.out.println("1: " + (a+=b));	//1) a+b	2)a=13
		System.out.println("2: " + (a-=b));	//1) a-b	2)a=10
		
		//6. 단항
		int a1=1,b1=1,c1=1,d1=1;
		System.out.println(++a1);	// 2	증가 출력
		System.out.println(a1);		// 2
		System.out.println(b1++);	// 1	출력 증가
		System.out.println(b1);		// 2
		
		System.out.println(--c1);	// 0	감소 출력
		System.out.println(c1);		// 0
		System.out.println(d1--);	// 1	출력 감소
		System.out.println(d1);		// 0
		
	}
}
