package com.company.java005_ex;

import java.util.Scanner;

public class ForEx003 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int i,j=0,z=0;
		
		for(i=1;i<=10;i++) {
			j += i;
		}
		System.out.println(j);
		
		
		for (i=1;i<=10;i++) {
			if(i==10) { System.out.print(i); }
			else { System.out.print(i+"+"); }
			z += i;	
		}
		System.out.print("="+j);
		
		
	}
}

/*
 for(i=1;i<=10;i++) {
		if(i==10)
		{ System.out.print(i); }
		else
		{ System.out.print(i+"+"); }
			for(j=1;j<=10;j++) {
				z+=j;
			}
		}
		System.out.print("="+(z/10));
 */

/*     2중 포인트 빼고 도전
연습문제3)  
패키지명 : com.company.java005_ex
클래스명 :  ForEx003
출력내용 :   for 이용
1~10까지의 합을 구하시오.

upgrade)  시간나면 도전!
1+2+3+4+5+6+7+8+9+10=55

*/
