package com.company.java003_ex;

import java.util.Scanner;

public class CastingEx001 {
	public static void main(String[] args) {
		int var1, var2;
		double div;
		Scanner scanner = new Scanner(System.in);
				
		System.out.print("숫자1 입력 : ");
		var1 = scanner.nextInt();
		
		System.out.print("숫자2 입력 : ");
		var2 = scanner.nextInt();
		
		div = (double)var1/var2;
		
		System.out.printf("\n%d / %d = %.2f",var1,var2,div);
		System.out.println("\n");
				
		System.out.println("정수(숫자1) / 정수(숫자2) = 정수(" +(var1/var2) + ")");
		System.out.println("정수(숫자1) / 실수[(float)숫자2] = 실수("+ (var1/(float)var2) + ")");
		System.out.println("실수[(float)숫자1] / 정수(숫자2) = 실수("+ ((float)var1/var2) + ")");
		System.out.println("실수[(float)숫자1] / 실수[(float)숫자2] = 실수("+((float)var1/(float)var2) + ")\n");
		
		System.out.println(var1 +" / "+var2+ " = " +String.format("%.2f", div));
		System.out.printf("%d / %d = %.2f",var1,var2,div);
	}
}

/*연습문제1)
패키지명 : com.company.java003_ex
클래스명 : CastingEx001
출력내용 :  Scanner이용해서 나누기 프로그램만들기 
   숫자입력1>  _입력받기  10   ( ☆자료형을 int )
   숫자입력2>  _입력받기  3     ( ☆자료형을 int )              
   
   10 / 3 = 3.33

   1단계)  변수 - 입력- 처리 - 출력
   2단계)  정수/정수 = 정수
              정수/실수 = 실수
              실수/정수 = 실수
              실수/실수 = 실수    
      ※  형변환법 :    by = (byte) in;   나 잠깐만 byte할게.... 데이터 누수있을수 있음!
*/