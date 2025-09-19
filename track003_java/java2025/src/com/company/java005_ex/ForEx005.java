package com.company.java005_ex;

import java.util.Scanner;

public class ForEx005 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i,j=0,k=0;
		
		for(i=97;i<=122;i++) {
			switch(i) {
			case 'a' : j++; break;
			case 'e' : j++; break;
			case 'i' : j++; break;
			case 'o' : j++; break;
			case 'u' : j++; break;
			default : k++;
			}
		}
		System.out.println("소문자 a~z까지 모음의 갯수는 = " +j);
		System.out.println("소문자 a~z까지 자음의 갯수는 = " +k);
		
	}
}

/*
 			if(i == 'a') {j++;}
			else if(i == 'e') {j++;}
			else if(i == 'i') {j++;}
			else if(i == 'o') {j++;}
			else if(i == 'u') {j++;}
			else {k++;}
 */

/*			switch문으로 도전
연습문제5)  
패키지명 : com.company.java005_ex
클래스명 :  ForEx005
출력내용 :   for 이용
소문자 a~z까지 모음의 갯수를 출력하시오. 


*/