package com.company.javaex_test;

import java.util.Scanner;

public class TestEx014_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char ch = ' ';

		System.out.print("문자 입력 : ");
		ch = scanner.next().charAt(0);

		switch (ch) {
		case 'x':
			System.out.println("x-ray");
			break;
		case 'y':
			System.out.println("yogurt");
			break;
		case 'z':
			System.out.println("zebra");
			break;
		default:
			System.out.println("x,y,z가 아닙니다.");
		}
	}
}
