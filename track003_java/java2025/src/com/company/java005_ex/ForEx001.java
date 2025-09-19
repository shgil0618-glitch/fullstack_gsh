package com.company.java005_ex;

import java.util.Scanner;

public class ForEx001 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i,j;
		for(i=1;i<=9;i++) {
			switch(i) {
			case 1 : System.out.print("q"+i + " for문을 이용해서 다음과 같이 출력하시오 : ");
			for(j=1;j<=5;j++) {System.out.print( j+"\t");}
			System.out.println();
			break;
			
			case 2 : System.out.print("q"+i + " for문을 이용해서 다음과 같이 출력하시오 : ");
			for(j=5;j>=1;j--) {System.out.print( j+"\t");}
			System.out.println();
			break;
			
			case 3 : System.out.print("q"+i + " for문을 이용해서 다음과 같이 출력하시오 : ");
			for(j=1;j<=3;j++) {System.out.print("java"+ j+"\t");}
			System.out.println();
			break;
			
			case 4 : System.out.print("q"+i + " for문을 이용해서 다음과 같이 출력하시오 : ");
			for(j=3;j>=1;j--) {System.out.print("happy"+ j+"\t");}
			System.out.println();
			break;
			
			case 5 : System.out.print("q"+i + " for문을 이용해서 다음과 같이 출력하시오 : ");
			for(j=1;j<=3;j++) {System.out.print( j+"\t");}
			System.out.println();
			break;
			
			case 6 : System.out.print("q"+i + " for문을 이용해서 다음과 같이 출력하시오 : ");
			for(j=1;j<=99;j++) {System.out.print( j+"\t");}
			System.out.println();
			break;
			
			case 7 : System.out.print("q"+i + " for문을 이용해서 다음과 같이 출력하시오 : ");
			for(j=10;j>=1;j--) {System.out.print( j+"\t");}
			System.out.println();
			break;
			
			case 8 : System.out.print("q"+i + " for문을 이용해서 다음과 같이 출력하시오 : ");
			for(j=0;j<=8;j=j+2) {System.out.print( j+"\t");}
			System.out.println();
			break;
			
			case 9 : System.out.print("q"+i + " for문을 이용해서 다음과 같이 출력하시오 : ");
			for(j=0;j<=18;j=j+2) {System.out.print( j+"\t");}
			System.out.println();
			break;
			}
		}
	}
}

/*
연습문제1)  
패키지명 : com.company.java005_ex
클래스명 :  ForEx001
출력내용 :   for 이용
q1  for문을 이용해서 다음과 같이 출력하시오 :   1 2 3 4 5 
q2  for문을 이용해서 다음과 같이 출력하시오 :   5 4 3 2 1 
q3  for문을 이용해서 다음과 같이 출력하시오 :   JAVA1   JAVA2  JAVA3  
q4  for문을 이용해서 다음과 같이 출력하시오 :   HAPPY3   HAPPY2  HAPPY1  
q5  for문을 이용해서 다음과 같이 출력하시오 :   0,1,2  
q6  for문을 이용해서 다음과 같이 출력하시오 :   0,1,2, ,,,중간생략 ,,, 99  
q7  for문을 이용해서 다음과 같이 출력하시오 :   10, 9,,,,중간생략 ,,, , 1 
q8  for문을 이용해서 다음과 같이 출력하시오 :   0, 2, 4, 6, 8 
q9  for문을 이용해서 다음과 같이 출력하시오 :   0, 2, 4, 6, 8 ,,,중간생략 ,,, 18 
*/