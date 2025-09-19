package com.company.java003_ex;

public class OperatorEx001 {
	public static void main(String[] args) {
	    int a=3, b=10;
	    System.out.println(  b+=10 - a-- );		// b += 10 - 3 // b = 10+7
	    System.out.println(  a+=5 );			// 2 + 5 = 7
	    System.out.println(  a>=10 || a<0 && a>3);	// 7>=10 || 7<0 && 7>3
	    											//  false or false and true ==false
	}
}

/*
연습문제1) 결과값은? 연산되는 순서는?
클래스명 : OperatorEx001
    int a=3, b=10;
    System.out.println(  b+=10 - a-- );   
    System.out.println(  a+=5 );
    System.out.println(  a>=10 || a<0 && a>3);
 */