package com.company.java011_ex;

import java.util.Arrays;

import com.company.java011_ex.Apple;

public class ClassArrEx1 {
	public static void main(String[] args) {
		Apple[] apples = new Apple[3];

		apples[0] = new Apple("RED", "iron", 2, 1000);
		apples[1] = new Apple("GREEN", "hulk", 1, 1500);
		apples[2] = new Apple("GOLD", "captain", 3, 2000);

		System.out.println("ver-1 for");
		for (int i = 0; i < apples.length; i++) {
			System.out.println(apples[i]);
		}
		
		System.out.println("\nber-2 향상된 for");
		//
		for(Apple a : apples) {System.out.println(a);}
		
		for (int i = 0; i < apples.length; i++) {
		System.out.println(Arrays.deepToString(apples));
		}
		
		for(int i=0; i<apples.length;i++) {
			apples[i].show();
		}
		
	}
	
	
}
/*
연습문제1)  클래스배열
패키지명 : com.company.java011_ex
클래스명 : ClassArrEx1
다음과 같이 코드를 작성하시오.
ㅁ출력된 화면
Apple [name=RED, order=iron, num=2, price=1000]
Apple [name=GREEN, order=hulk, num=1, price=1500]
Apple [name=GOLD, order=captain, num=3, price=2000]

ㅁ주어진 옵션
public class Apple{   //// 실행 main과 파일을 분리해주세요!
   private String name;
   private String order;
   private int num;
   private int price;
}

public class ClassArrEx1{
  public static void main(String[] args) {
        Apple[] apples= new Apple[3]; 
        //위의 화면처럼 값 셋팅
        //위의 화면처럼 출력
  }
}

 
*/