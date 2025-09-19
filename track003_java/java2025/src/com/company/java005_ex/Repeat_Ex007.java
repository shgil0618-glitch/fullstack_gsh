package com.company.java005_ex;

import java.util.Scanner;

public class Repeat_Ex007 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = "";
		int str1=0, str2=0;
		
		System.out.print("문자 혹은 숫자열을 입력하시오 : ");
		input = scanner.nextLine();
		
		str1 = input.length();
		str2 = str1/2;
		boolean ok = false;
		
		for(int i=0;i<str2;i++) {
			if(input.charAt(i) == input.charAt(str1-1-i)) {ok = true;} 	
		}
		if(ok) {
		System.out.println("입력하신 문자는 회문수 입니다. (O)");
		}
		else {
		System.out.println("입력하신 문자는 회문수가 아닙니다. (X)"); 
		}
	}
}
// 숫자를 입력받았을때 변환하는 식이 필요함...

/*
	회문수 입력받은 문자,숫자가 좌우 데칼코마니인지 확인
*/
