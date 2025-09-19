package com.company.javaex_test;

import java.util.Scanner;

public class TestEX013_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char ch;
		//a="", b="", c="";
		
		System.out.print("영문자를 입력하시오 : ");
		ch = scanner.next().charAt(0);

		
		switch(ch) {
		case 'a' : System.out.println("apple"); break;
		case 'b' : System.out.println("banana"); break;
		case 'c' : System.out.println("coconut"); break;
		default : System.out.println("a,b,c가 아닙니다.");
		}

	
	}
}
