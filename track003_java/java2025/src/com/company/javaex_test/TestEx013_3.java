package com.company.javaex_test;

import java.util.Scanner;

public class TestEx013_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num=0;
		
		for(;;) {
			System.out.print("숫자 한개를 입력하시오 : ");
			num = scanner.nextInt();
			
			if(num==1) {break;}
			else {System.out.println("원하는 값을 입력받을때까지 반복됩니다.");}
		}
	}
}
