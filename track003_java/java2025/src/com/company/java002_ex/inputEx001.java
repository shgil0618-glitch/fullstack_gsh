package com.company.java002_ex;

import java.util.Scanner;

public class inputEx001 {
	public static void main(String[] args) {
		int age = 0;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("당신의 나이를 입력하시오 > ");
		age = scanner.nextInt();
		
		System.out.println("내 나이는" + age + "살 입니다.");
	}
}





//습문제1)    ※ Input002  참고
//패키지명 : com.company.java002_ex
//클래스명 : InputEx001
//출력내용 : 
//  1-1.  나이를 입력받을 자료형 선택후  변수명  age로 하시오.  예) 10,20
//   1-2.  Scanner이용해서 나이 입력받고 출력하시오.
  
//    당신의 나이를 입력하시오 > _입력받기
//    내 나이는 ** 입니다.
