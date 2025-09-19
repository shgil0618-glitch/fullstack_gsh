package com.company.javaex_test;

import java.util.Scanner;

public class TestEx013_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char ch;
		//a="", b="", c="";
		
		System.out.print("영문자를 입력하시오 : ");
		ch = scanner.next().charAt(0);
		
		if(ch=='a') {System.out.println("apple");}
		else if (ch=='b') {System.out.println("banana");}
		else if (ch=='c') {System.out.println("coconut");}
		else {System.out.println("a,b,c가 아닙니다.");}
		
	}
}
