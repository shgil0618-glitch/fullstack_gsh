package com.company.java008_ex;

import java.util.Arrays;

public class MethodEx008 {
	public static void main(String[] args) {
		char[] ch = {'a','b','c'};
		char ch1 = 'A';
		
	    upper(ch);   
		lower(ch1);
		System.out.println("ch1값" + ch1);
	    System.out.println("main. 배열값 : "      +  Arrays.toString(ch)          ); 	
	}
	public static void upper(char[] ch) {
		for(int i=0; i<ch.length;i++) {
			ch[i] -= 32;
		}
		//System.out.println("upper. 배열값 " + ch + Arrays.toString(ch));
		System.out.println(System.identityHashCode(ch) + Arrays.toString(ch));
	}
	public static void lower(char ch1) {
		ch1 = 'B';
	}
}
/*
연습문제8)  method
패키지명 : com.company.java008_ex
클래스명 :  MethodEx008

public class MethodEx008{ 
    char[] ch = {'a','b','c'};
    upper(ch);     
    System.out.println("main. 배열값 : "      +  Arrays.toString(ch)          );  // [A,B,C]
}
*/