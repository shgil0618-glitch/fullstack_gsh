package com.company.java006_ex;

import java.util.Scanner;

public class ForEx006_2 {
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int num1=0, num2=0;
	int level=1, level_before=0, val=1;
	char ch = ' ';
	double result = 3.14;
	
	for(;;) {
		
		
		if(level==1)
		{System.out.print("숫자1을 입력하시오 : ");
		num1 = scanner.nextInt(); }
		else if(level==2) {
		System.out.print("숫자2을 입력하시오 : ");
		num2 = scanner.nextInt(); }
		else if(level==3) {
		System.out.print("연산자를 입력하시오 : ");
		ch = scanner.next().charAt(0); }
		
		
		switch(level) {
		case 1 :	
			if(num1>=0 && num1<=100) {level=2; break;}
			 else {System.out.println("숫자1이 1~100 사이의 정수가 아닙니다."); level=5; level_before =1;break; }
				
		case 2 : 
			if(num2>=0 && num2<=100) {level=3; break;}
			else {System.out.println("숫자2가 1~100 사이의 정수가 아닙니다."); level=5; level_before =2;break;}
		
		case 3 : 
			if(ch=='+') {result = num1+num2; level=4; break;}
			else if(ch=='-') {result = num1-num2; level=4; break;}
			else if(ch=='*') {result = num1*num2; level=4; break;}
			else if(ch=='/') {result = (double)num1/num2; level=4; break;}
			else {System.out.println("올바른 연산자가 아닙니다.");  level=5; level_before =3;break;}	
				
		case 4 : if (ch=='/') {System.out.printf("%d %c %d = %.2f",num1,ch,num2,(Object)(double)result);}
			 else {System.out.printf("%d %c %d = %d",num1,ch,num2,(Object)(int)result);}
			 level_before =4; break;
			 
		case 5 : level = level_before;	break;
		}
		if(level_before==4) {break;}
		else {continue;}
		}
	
	
	}
}