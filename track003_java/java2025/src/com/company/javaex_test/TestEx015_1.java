package com.company.javaex_test;

import java.util.Scanner;

public class TestEx015_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char ch;
		
		System.out.print("문자 한개를 입력하시오 : ");
		ch = scanner.next().charAt(0);
		
		if(ch=='m') {System.out.println("mango");}
		else if(ch=='n') {System.out.println("noodle");}
		else if(ch=='o') {System.out.println("orange");}
		else {System.out.println("m,n,o가 아닙니다.");}
		
	}
}
