package com.company.java003_ex;

import java.util.Scanner;

public class repeat002 {
	public static void main(String[] args) {
		int num1, num2;
		double result;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("숫자1 입력 : ");
		num1 = scanner.nextInt();
		System.out.print("숫자2 입력 : ");
		num2 = scanner.nextInt();
		
		result = (double)num1/num2;
		
		System.out.printf("%d / %d = %.2f",num1,num2,result);
		
	}
}
