package com.company.java005_ex;

import java.util.Scanner;

public class Repeat012_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num =0;
		System.out.print("숫자 한개를 입력하시오 : ");
		num = scanner.nextInt();
		 
		 switch(num) {
		 case 1 : System.out.println("one"); break;
		 case 2 : System.out.println("two"); break;
		 case 3 : System.out.println("three"); break;
		 default : System.out.println("1,2,3이 아닙니다.");
		 }
	}
}
