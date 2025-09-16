package com.company.java008_ex;

public class MethodEx002 {
	public static void main(String[] args) {

		test1(10);
		test2(1.2);
		hap(3, 5);
		disp(7, '*');
	}

	public static void test1(int a) {
		System.out.println(a);
	}

	public static void test2(double b) {
		System.out.printf("%.1f", b);
		System.out.println();
	}

	public static void hap(int c, int d) {
		int result =0;
		for (int i = c; i <= d; i++) {
			result += i;
		}
		
		System.out.println(result);
	}

	public static void disp(int e, char f) {
		for (int i = 0; i <= e; i++) {
			System.out.print(f);
		}
	}
}

/*
연습문제2)  method
패키지명 : com.company.java008_ex
클래스명 :  MethodEx002
다음과 같이 test1(), test2(), hap(), disp()메서드를 정의하시오.

public static void main(String[] args) {
    // public static  리턴값 메서드명(파라미터)
    test1(10);    //10 출력
     test2(1.2);   // 1.2 출력
     hap(3,5);     // 3+4+5한값  12 출력
     disp(7, '*');  // *******출력
}

*/