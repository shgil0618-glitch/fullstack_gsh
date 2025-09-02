/*연습문제1)
패키지명 : com.company.java002_ex
클래스명 : InputEx2001
출력내용 :  Scanner이용해서 파이값을 입력받고 출력하시오. 
     파이값을 입력하시오 > _입력받기    3.141592    ( 자료형선택 )
     파이값은 **입니다.*/

package com.company.java002_ex;

import java.util.Scanner;

public class InputEx2001 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		float f = 3.14f;
		double d = 3.14;
		System.out.print("파이값을 입력하시오 >");
		d = scanner.nextDouble();
		System.out.println("파이값은 "+d+" 입니다.");
	}
}


