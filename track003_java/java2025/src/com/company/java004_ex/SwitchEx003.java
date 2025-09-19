package com.company.java004_ex;

import java.util.Scanner;

public class SwitchEx003 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1,num2;
		char ch;
		double result = 0;
		
		System.out.print("정수를 입력하시오 : ");
		num1 = scanner.nextInt();
		System.out.print("정수를 입력하시오 : ");
		num2 = scanner.nextInt();
		System.out.print("연산자를 입력하시오 : ");
		ch = scanner.next().charAt(0);
		
		switch(ch) {
		case '+' : result = num1 + num2; break;
		case '-' : result = num1 - num2; break;
		case '*' : result = num1 * num2; break;
		case '/' : result = (double)num1 / num2; break;
		default : System.out.println("올바른 연산자가 아닙니다.");
		}
		
		/*
		switch(ch) {
		case '+' : System.out.printf("%d %s %d = %d",num1,ch,num2, num1+num2);break;
		case '-' : System.out.printf("%d %s %d = %d",num1,ch,num2, num1-num2);break;
		case '*' : System.out.printf("%d %s %d = %d",num1,ch,num2, num1*num2);break;
		case '/' : System.out.printf("%d %s %d = %.2f",num1,ch,num2, (double)num1/num2);break;
		}
		*/
		
		if(ch == '/') {System.out.printf("%d %s %d = %.2f",num1,ch,num2,(Object)(double)result);}
		else {System.out.printf("%d %s %d = %d",num1,ch,num2,(Object)(int)result);}
	}
}

/*
연습문제3)  3
패키지명 : com.company.java004_ex
클래스명 :  SwtichEx003
출력내용 :  계산기

1. 정수를 하나 입력해주세요 > 10
2. 정수를 하나 입력해주세요 > 3
3. 연산자를 입력해주세요(+,-,*,/) > +
10+3=13

1. 정수를 하나 입력해주세요 > 10
2. 정수를 하나 입력해주세요 > 3
3. 연산자를 입력해주세요(+,-,*,/) > -
10-3=7 
*/