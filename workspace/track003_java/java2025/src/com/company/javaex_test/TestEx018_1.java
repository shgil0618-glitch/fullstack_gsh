package com.company.javaex_test;

public class TestEx018_1 {
	public static void main(String[] args) {
		System.out.println("강아지가 등장합니다!.");
		dog();
		
		System.out.println("\n강아지가 시험을 봤습니다. 점수를 공개합니다!");
		disp(7,'*');
		
		System.out.println("\n평가 결과는?");
		System.out.println("당신의 평균은? " +stdavg(88));
	}
	public static void dog() {
		System.out.println("멍멍");
	}
	public static String disp(int num, char ch) {
		String ch1 = "";
		for(int i=0;i<num;i++) {
			ch1 += ch;
		}
		System.out.println(ch1);
		return ch1;
	}
	public static char stdavg(int avg) {
		char ch2 = ' ';
		if(avg>90) ch2 = 'A';
		else if(avg>80) ch2 = 'B';
		else if(avg>70) ch2 = 'C';
		else ch2 = 'D';
		return ch2;
	}
	
}
