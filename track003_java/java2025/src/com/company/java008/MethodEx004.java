package com.company.java008;

import java.util.Random;

public class MethodEx004 {
	public static void main(String[] args) {
		// public static 리턴값 메서드명(파라미터)
		// 1. 당신의 이름은? 전설의_마법의_도끼를_든_도끼겅듀
		System.out.println("1. 당신의 이름은? : " + sign());
		// 2. 이름,직업,레벨을 주면 위에서 소개문장
		// 캐릭터 설명? : [홍길동]님은 레벨 [9]
		System.out.println("2. 캐릭터 설명? : " + intro("홍길동", 9));
		System.out.println("2. 캐릭터 설명? : " + intro(sign(), 10));
		// 3. 두개의 숫자를 넣어주면 나누기 처리
		System.out.println("3. 반타작 저주 : " + spell(9));
		// 4. 랜덤 오늘의 운세 (1~100)
		System.out.println("4. 오늘의 운세 : " + luck());
	}

	public static String sign() {
		return "전설의_마법의_도끼를_든_도끼겅듀";
		// System.out.println("........"); //리턴 밑으로는 짤린다.
	}

	public static String intro(String name, int level) {
		return "[" + name + "]은 레벨 [" + level + "]";
	}

	public static double spell(int num) {
		return num / 2.0;
	}

	public static int luck() {
		Random rand = new Random();
		int result = rand.nextInt(100)+1;	// 0~100보다 작은 숫자 랜덤
		return result;
	}
}
