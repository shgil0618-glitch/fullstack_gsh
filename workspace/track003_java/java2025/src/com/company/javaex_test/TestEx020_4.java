package com.company.javaex_test;

public class TestEx020_4 {
	   public static void main(String[] args) {
		      
		      disp(7,'*');
		      System.out.println("당신의 학번은? : " + stdid(1111));
		   }
		   public static String disp(int a, char ch) {
		      String star ="";
		      for(int i=0; i<a; i++) {
		         star += ch;
		      }
		      System.out.println(star);
		      return star;
		   }
		   public static String stdid(int num) {
		      String str ="G";
		      str += num;
		      return str;
		   }
}
