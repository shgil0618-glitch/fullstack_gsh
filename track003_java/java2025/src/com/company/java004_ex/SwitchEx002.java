package com.company.java004_ex;

import java.util.Scanner;

public class SwitchEx002 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1;
		
		System.out.print("숫자 한개를 입력하시오 : ");
		num1 = scanner.nextInt();
		
		switch(num1) {
		case 1:case 2:case 12: System.out.println("겨울 입니다."); break;
		case 3:case 4:case 5: System.out.println("봄 입니다."); break;
		case 6:case 7:case 8: System.out.println("여름 입니다."); break;
		case 9:case 10:case 11: System.out.println("가을 입니다."); break;
		}
	}
}

/*

연습문제2)  
패키지명 : com.company.java004_ex
클래스명 :  SwitchEx002
출력내용 :   switch 이용
     숫자한개 입력받아
     3,4,5이면 봄
     6,7,8이면 여름
     9,10,11이면 가을
     12,1,2이면 겨울
*/