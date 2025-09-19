package com.company.javaex_test;

public class TestEx017_1 {
	public static void main(String[] args) {
		int num[][] = new int[2][3];
		int result = 101;
		
		for(int i=0 ; i<num.length;i++) {
			for(int j=0;j<num[i].length;j++){
				num[i][j] = result++;
				System.out.print(num[i][j] + "\t");
			}
			System.out.println();
		}
		
	}
}
