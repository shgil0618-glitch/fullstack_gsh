package com.company.javaex_test;

public class TestEx020_5 {
	   public static void main(String[] args) {
		      char ch[][] = new char[2][3];
		      int num = 65; 
		      for (int i=0;i<ch.length;i++) {
		         for(int j=0; j<ch[i].length;j++) {
		            ch[i][j] = (char)num;
		            num++;
		            System.out.print(ch[i][j] + "\t");
		         }
		         System.out.println();
		         num += 29;
		      }
		      
		   }
		
}
