package com.company.javaex_test;

public class TestEx017_2 {
	public static void main(String[] args) {
		char ch[][] = new char[2][3];
		char ch1 = 'A';
		for(int i=0 ; i<ch.length;i++) {
			
			for(int j=0;j<ch[i].length;j++){
				ch[i][j] = ch1++;
				System.out.print(ch[i][j] + "\t");
			}
			ch1 = 'B';
			System.out.println();
		}
		
	}
}