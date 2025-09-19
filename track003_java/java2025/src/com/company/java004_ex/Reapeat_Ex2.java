package com.company.java004_ex;

import java.util.Scanner;

public class Reapeat_Ex2 {
	public static void main(String[] args) {
		int num1, num2;
		char ch;
		double result=3.14;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("정수를 하나 입력해주세요 : ");
		num1 = scanner.nextInt();
		System.out.print("정수를 하나 입력해주세요 : ");
		num2 = scanner.nextInt();
		System.out.print("연산자를 하나 입력해주세요(+,-,*,/) : ");
		ch = scanner.next().charAt(0);
		
		if(ch == '+') {result = num1+num2;}
		else if (ch=='-') {result = num1 - num2;}
		else if (ch=='*') {result = num1 * num2;}	
		else if(ch=='/'){result = (double)num1 / num2;}	
		else {System.out.println("올바른 연산자가 아닙니다.");}
		
		if(ch=='/') {System.out.printf("%d %s %d = %.2f",num1,ch,num2,(Object)(double)result);}
		else {System.out.printf("%d %s %d = %d",num1,ch,num2,(Object)(int)result);}
	}
}
