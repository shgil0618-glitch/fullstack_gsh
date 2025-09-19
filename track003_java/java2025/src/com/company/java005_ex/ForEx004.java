package com.company.java005_ex;

import java.util.Scanner;

public class ForEx004 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i,j=0,k=0;
		
		
		System.out.print("3의 배수 : ");		
		for(i=1;i<=10;i++) {
			if(i%3==0) {
				j++;
				if(i==9)
				{ System.out.print(i); }
				else
				{System.out.print(i+",");}	

			}
		}
		
		System.out.println();
		System.out.println("3의 배수 갯수 : " +j);
	}
}

/*
 		int i,j=0,k=0;
		int[] ch = new int[10];
		
		for(i=1;i<=10;i++) {
			if(i%3==0) {
				j++;
				ch[j] += i;
			}
		}
		System.out.print("3의 배수 : ");
		
		for(k=1;k<=j;k++) {
			if(k==j)
			{ System.out.print(ch[k]); }
			else
			{System.out.print(ch[k]+",");}	
		}
		
*/

/*		배열 뺴고 도전
연습문제4)  
패키지명 : com.company.java005_ex
클래스명 :  ForEx004
출력내용 :   for 이용
1~10까지 3의 배수 갯수를 출력   

upgrade)  시간나면 도전!
3의배수 : 3,6,9    
갯수 : 3개


*/