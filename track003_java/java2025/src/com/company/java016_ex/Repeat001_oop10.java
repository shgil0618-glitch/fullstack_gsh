package com.company.java016_ex;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Repeat001_oop10 {
	public static int nextInt() throws InputMismatchException{  //##2-2 발생한지점
		int a=-1;
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자1 입력 > ");
		a = scanner.nextInt();  //1. nextInt() 숫자입력받기를 기다림.
								// 'a'
		return a;
	}
	public static void main(String[] args) /* throws Exception */ {
		int a=-1;
		while(true) {
			try {
				//System.out.println(nextInt());
				a=nextInt();  //##2-2   오류났어! InputMismatchException
				if(a==1)break;
			}catch(Exception e) {  System.out.println("오류났어!"); }
		}
		System.out.println("결과물 : " + a);
	}
}
