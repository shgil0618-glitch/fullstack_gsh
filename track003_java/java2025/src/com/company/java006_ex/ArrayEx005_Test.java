package com.company.java006_ex;

import java.util.Scanner;

public class ArrayEx005_Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char ch = ' ';
		char cor[] = { 'A', 'C', 'B', 'A', 'A' };
		int num = 0, ok = 0, fail = 0;

		System.out.print("문제의 갯수를 입력하시오 : ");
		num = scanner.nextInt();
		scanner.nextLine();

		num -=1;
		
		char ans[] = new char[num];

		System.out.print("1번부터 차례대로 정답을 입력하시오 : ");
		for (int i = 0; i < num; i++) {
			ch = scanner.next().charAt(0);

			ans[i] = ch;

			if (ans[i] == cor[i]) {
				System.out.println((i+1) + "번: " + "정답");
				ok++;
			} else {
				System.out.println((i+1) + "번: " + "오답");
				fail++;
			}
		}
		System.out.println("정답 갯수 : " + ok);
		System.out.println("오답 갯수 : " + fail);
	}
}

/*
문제 설명
배열명: answers → 사용자의 답안: 'A', 'C', 'B', 'D', 'A'
배열명: correct  → 정답: 'A', 'C', 'B', 'A', 'A'
두 배열을 비교하여 맞은 개수를 출력하세요.
🧪 출력 예시
정답을 입력하시오. >   'A', 'C', 'B', 'A', 'A'
1번: 정답  
2번: 정답  
3번: 정답  
4번: 오답  
5번: 정답  
총 맞은 개수: 4개
*/