package com.company.javaex_test;

import java.util.Scanner;

public class TestEx015_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num;
		System.out.print("숫자 한개를 입력하시오 : ");
		num = scanner.nextInt();
		
		switch(num) {
		case 1 : System.out.println("mango"); break;
		case 2 : System.out.println("noodle"); break;
		case 3 : System.out.println("orange"); break;
		default : System.out.println("1,2,3이 아닙니다.");
		}
		
	}
}

