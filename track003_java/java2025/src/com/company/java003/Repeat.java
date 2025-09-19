package com.company.java003;

import java.util.Scanner;

public class Repeat {
	public static void main(String[] args) {
		int kor, eng, mat, total;
		double avg;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("국어점수를 입력시하시오 : ");
		kor = scanner.nextInt();
		
		System.out.print("영어점수를 입력시하시오 : ");
		eng = scanner.nextInt();
		
		System.out.print("수학점수를 입력시하시오 : ");
		mat = scanner.nextInt();
		
		total = kor+eng+mat;
		avg = total/3.0;
		
		System.out.println("총점 : "+total);
		System.out.println("평균 : "+avg);
	}
}
