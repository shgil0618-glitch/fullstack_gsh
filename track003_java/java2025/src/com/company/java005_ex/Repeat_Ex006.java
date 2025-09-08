package com.company.java005_ex;

import java.util.Scanner;

public class Repeat_Ex006 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String ch="";
		char val;
		int str,hap=0;
		
		System.out.print("숫자열을 입력하시오 : ");
		ch = scanner.nextLine();
		
		str = ch.length();
		for(int i=0;i<str;i++) {
		val = ch.charAt(i);
		hap += (int)val-48;
		}
		System.out.println(hap);
		
	}
}

/*
 스트링으로 받은 숫자 각 자리 합
 12345 => 15
 */