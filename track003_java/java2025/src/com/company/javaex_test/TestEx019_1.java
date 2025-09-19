package com.company.javaex_test;

public class TestEx019_1 {
	public static void main(String[] args) {
        System.out.println("🤖 탐사 로봇이 기동합니다!");
        start();  // "부우웅..." 출력

        System.out.println("\n🪐 행성 스캔 중...");
        scan(5, '#');  // ##### 출력

        System.out.println("\n📡 신호 강도 분석 결과:");
        System.out.println("신호 등급: " + signalGrade(65));  // C 출력

        System.out.println("\n🔋 배터리 충전 중...");
        System.out.println("충전 완료: " + charge(40, 40) + "%");  // 80 출력
    }
	public static void start() {
		System.out.println("부우웅...");
	}
	public static String scan(int i, char ch) {
		String ch1 ="";
		for(int j=0; j<i;j++) {
			ch1 += ch;
		}
		System.out.println(ch1);
		return ch1;
	}
	public static char signalGrade(int num) {
		char ch2 = ' ';
		if(num>90) {ch2 = 'A';}
		else if(num>80) {ch2 = 'B';}
		else if(num>70) {ch2 = 'D';}
		else {ch2 = 'C';}
		return ch2;
	}
	public static int charge(int num1,int num2) {
		int result=0;
		result = num1 + num2;
		return result;
	}
	
}
