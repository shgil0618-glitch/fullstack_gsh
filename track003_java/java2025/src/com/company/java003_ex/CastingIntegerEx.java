package com.company.java003_ex;

public class CastingIntegerEx {
	public static void main(String[] args) {
		// 1) 기본형 / 참조형
		// 2) boolean, 정수형(byte<short, char< int★ <long), 실수형(float< double★)
		
		short sh1 = 1;		// sh1 [ 1 ] 2byte
		short sh2 = 2;		// sh2 [ 2 ] 2byte
		
		// 산술연산(+)시 자동으로 int로 변환
		// int 보다 작은 타입들 다 적용됨 - byte, short, char		
		short result1 = (short)(sh1 + sh2);	// 1 (int) + 2(int) //short로 저장해도 사용될때는 int로 사용
		int result2 = sh1 + sh2;
		

		System.out.println("result1 : " + result1);	
		System.out.println("result2 : " + result2);
		
	}
}

/*
 연습문제2)
클래스명 : CastingIntegerEx
  short sh1 = 1;
  short sh2 = 2;
  short result = sh1 +sh2;

※ 자바자료형 범위 찾아보기
 */
