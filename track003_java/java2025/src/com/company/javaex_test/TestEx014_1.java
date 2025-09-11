package com.company.javaex_test;

import java.util.Scanner;

public class TestEx014_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char ch = ' ';

		System.out.print("문자 입력 : ");
		ch = scanner.next().charAt(0);

		if (ch == 'x') {
			System.out.println("x-ray");
		} else if (ch == 'y') {
			System.out.println("yogurt");
		} else if (ch == 'z') {
			System.out.println("zebra");
		} else {
			System.out.println("x,y,z가 아닙니다.");
		}
	}
}
