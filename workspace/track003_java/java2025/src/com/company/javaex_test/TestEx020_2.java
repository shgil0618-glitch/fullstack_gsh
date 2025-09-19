package com.company.javaex_test;

public class TestEx020_2 {
	  public static void main(String[] args) {
	      int ch[][] = new int[2][3];
	      int num = 101;
	      
	      for(int i=0;i<ch.length;i++) {
	         for(int j=0;j<ch[i].length;j++) {
	            ch[i][j] = num++;
	            System.out.print(ch[i][j]+"\t");
	         }
	         num +=97;
	         System.out.println();
	      }
	      
	   }
}
