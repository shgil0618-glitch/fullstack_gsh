package com.company.java005_ex;

import java.util.Scanner;

public class ForEx008 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i;
		int j;
		int z;

		System.out.println("1.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  1 2 3 4 5");

		System.out.print("for문 : ");
		for (i = 1; i <= 5; i++) {
			System.out.print(i + "\t");
		}

		System.out.print("while문 : ");
		i = 1;
		while (i <= 5) {
			System.out.print(i + "\t");
			i++;
		}

		System.out.print("do while문 : ");
		i = 1;
		do {
			System.out.print(i + "\t");
			i++;
		} while (i <= 5);

		System.out.println();
		System.out.println("2.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  5 4 3 2 1");

		System.out.print("for문 : ");
		for (j = 5; j >= 1; j--) {
			System.out.print(j + "\t");
		}
		j = 5;

		System.out.print("while문 : ");
		while (j >= 1) {
			System.out.print(j + "\t");
			j--;
		}

		System.out.print("do while문 : ");
		j = 5;
		do {
			System.out.print(j + "\t");
			j--;
		} while (j >= 1);

		System.out.println();
		System.out.println("3.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  JAVA1   JAVA2  JAVA3");

		System.out.print("for문 : ");
		for (z = 1; z <= 3; z++) {
			System.out.print("JAVA" + z + "\t");
		}

		System.out.print("while문 : ");
		z = 1;
		while (z <= 3) {
			System.out.print("JAVA" + z + "\t");
			z++;
		}

		System.out.print("do while문 : ");
		z = 1;
		do {
			System.out.print("JAVA" + z + "\t");
			z++;
		} while (z <= 3);
	}
}
/*
연습문제8)  for, while, do while
패키지명 : com.company.java005_ex
클래스명 :  ForEx008 
1.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  1 2 3 4 5
2.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  5 4 3 2 1
3.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  JAVA1   JAVA2  JAVA3
 */