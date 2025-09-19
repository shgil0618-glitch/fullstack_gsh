package com.company.java002_ex;

import java.util.Scanner;

public class inputEx002 {
	public static void main(String[] args) {
		int var = 0; //num 변수도 좋네
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("좋아하는 수(정수) 입력하시오 > ");
		var = scanner.nextInt();
				
		System.out.println("좋아하는 숫자는 " + var + " 입니다.");
	}
}



//연습문제2)
//패키지명 : com.company.java002_ex
//클래스명 : InputEx002
//출력내용 :  Scanner이용해서 나이 입력받고 출력하시오.
//    좋아하는 수(정수)   입력하시오 > _입력받기
//    좋아하는 숫자는 ** 입니다.