package com.company.javaex_test;

import java.util.Scanner;

public class TestEx015_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		for(int i=5;i>=1;i--) {System.out.print(i+" ");}
		System.out.println();
		
		int j=5;
		while(j>=1) {System.out.print(j+" "); j--;}
		
		System.out.println();
		int z=5;
		do {System.out.print(z+" "); z--;}
		while(z>=1);
	}
}

