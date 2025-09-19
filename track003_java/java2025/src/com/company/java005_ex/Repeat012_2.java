package com.company.java005_ex;

import java.util.Scanner;

public class Repeat012_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num =0;
		
		System.out.print("숫자 한개를 입력하시오 : ");
		num = scanner.nextInt();
		
		if(num == 1) {System.out.println("one");}
		else if (num == 2) {System.out.println("two");}
		else if (num == 3) {System.out.println("three");}
		else {System.out.println("1,2,3이 아닙니다.");}
	}
}
