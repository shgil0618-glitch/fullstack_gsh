package com.company.javaex_test;

import java.util.Scanner;

public class TestEx014_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = 0;

		for (;;) {
			System.out.print("숫자를 입력하시오 : ");
			num = scanner.nextInt();

			if (num == 7) {
				System.out.println("종료합니다!");
				break;
			} else {
				System.out.println("특정 숫자가 나올때까지 반복됩니다!");
			}
		}
	}
}
