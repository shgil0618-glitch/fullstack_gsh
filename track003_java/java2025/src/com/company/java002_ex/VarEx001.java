package com.company.java002_ex;
//연습문제1)  
//패키지명 : com.company.java002_ex
//클래스명 : VarEx001
//출력내용 : 
//   1-1.  apple라는 변수만들기
//   1-2.  1-1.에서 만든 변수에 1000이라는 데이터 대입하시오.  ( 자료형 int )
//   1-3.  1-1.에서 만든 변수이용해서 
//           사과가격은 1000원입니다 출력
//   1-4.  1-1.에서 만든 변수에 2000이라는 데이터 대입하시오.  
//   1-5.  1-1.에서 만든 변수이용해서 
//          사과가격은 2000원입니다 출력

public class VarEx001 {
	public static void main(String[] args) {
		int apple;
		apple = 1000;
		System.out.println("어제 사과의 가격 : " + apple);
		apple = 2000;
		System.out.printf("오늘 사과의 가격 : %d",apple);
	}

}
