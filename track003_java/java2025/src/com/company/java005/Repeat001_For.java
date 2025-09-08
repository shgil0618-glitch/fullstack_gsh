package com.company.java005;

public class Repeat001_For {
	public static void main(String[] args) {
	//step 1	system.out.print() 3번 사용해서 1 2 3
	System.out.println("step1");
	System.out.print(1 + "\t");	// 복사할 구문
	System.out.print(2 + "\t");	// ctrl + c , ctrl + 2번
	System.out.print(3 + "\t");	// 안에 숫자 2,3
	// for(시작;종료;변화){구문}
	
	//step 2
	System.out.println("\n\nstep2");	//{ } { 변수 } for(시작;종료;변화)
	for(int i=1;i<=3;i++){
		System.out.print(i + "\t");
	}
	
	//step 3 
	System.out.println("\n\nstep3");
	// 1~5
	for(int i=1;i<=5;i++){ System.out.print(i + "\t"); }	//ctrl+alt+j 한줄로 만들기
	System.out.println();
	
	// 11~20
	for(int i=11;i<=20;i++){ System.out.print(i + "\t"); }	//ctrl+alt+j 한줄로 만들기
	System.out.println();
	
	// 3~8
	for(int i=3;i<=8;i++){ System.out.print(i + "\t"); }	//ctrl+alt+j 한줄로 만들기
	System.out.println();
	
	// 1 3 5
	for(int i=1;i<=5;i=i+2){ System.out.print(i + "\t"); }	//ctrl+alt+j 한줄로 만들기
	System.out.println();
	
	// hello1 hello2 hello3
	for(int i=1;i<=3;i++) {System.out.print("hello" + i +"\t");}
	System.out.println();
	}
}
