package com.company.javaex_test;

import java.util.Scanner;

public class TestEx014_4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i = 0, j = 0, z = 0;

		for (i = 1; i <= 5; i++) {
			System.out.print(i + " ");
		}

		System.out.println();
		j = 1;
		while (j <= 5) {
			System.out.print(j + " ");
			j++;
		}

		System.out.println();
		z = 1;
		do {
			System.out.print(z + " ");
			z++;
		} while (z <= 5);
	}
}
