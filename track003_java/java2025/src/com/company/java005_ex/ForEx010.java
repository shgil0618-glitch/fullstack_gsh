package com.company.java005_ex;

import java.util.Scanner;

public class ForEx010 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i = 0;
		int j = 0;

		System.out.println("1.for문");
		for (i = 65; i <= 90; i++) {
			j++;
			System.out.printf("%c", (char) i);
			if (j % 5 == 0) {
				System.out.println();
			}
		}

		System.out.println("\n2.while문");
		i = 65;
		j = 0;
		while (i <= 90) {
			j++;
			System.out.printf("%c", (char) i);
			if (j % 5 == 0) {
				System.out.println();
			}
			i++;
		}

		System.out.println("\n3.do while문");
		i = 65;
		j = 0;
		do {
			j++;
			System.out.printf("%c", (char) i);
			if (j % 5 == 0) {
				System.out.println();
			}
			i++;
		} while (i <= 90);

	}
}
/*
연습문제10)  for/while/do while
패키지명 : com.company.java005_ex
클래스명 :  RepeatEx010
for , while , do while 3가지 버젼으로 
ABCDE   
FGHIJ
KLMNO
PQRST
UVWXY
Z 

*/