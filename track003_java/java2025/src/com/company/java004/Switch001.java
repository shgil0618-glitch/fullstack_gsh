package com.company.java004;

import java.util.Scanner;

public class Switch001 {
	public static void main(String[] args) {
		// 변수
		int a;
		Scanner scanner = new Scanner(System.in);
		
		// 입력
		System.out.print("숫자 한개 입력 : ");
		a = scanner.nextInt();
		
		// 처리 + 출력 (1) if (조건식이 복잡하고 여러개일때 && >= )
		if( a ==1 ) {System.out.println("1이다");}	// 조건이 맞다면 else 부분 안봄
		else if( a ==2 ) {System.out.println("2이다");}
		else if( a ==3 ) {System.out.println("3이다");}
		else {System.out.println("1,2,3이외의 숫자다.");}
	
		
		// 처리 + 출력 (2) switch		switch case break
		switch(a) {	//처리 대상
		case 1 : System.out.println("1이다"); break;	/* a == 1 */  /* 조건이 맞아도 순서대로 진행(break 만날때까지)*/
		case 2 : System.out.println("2이다"); break;	/* a == 2 */
		case 3 : System.out.println("3이다"); break;	/* a == 3 */
		}
		
		
	}
}
