package com.company.java002_ex;

import java.util.Scanner;

public class inputEx003 {
	public static void main(String[] args) {
		int year = 0;
		int age = 0;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("당신의 탄생 년도를 입력하시오 : ");
		year = scanner.nextInt();
		
		age = 2025-year+1;
		
		System.out.println("당신의 나이는 " + age + "살 입니다.");
		System.out.println("당신의 나이는 " + (2025-year+1) + "살 입니다.");
	}
}

