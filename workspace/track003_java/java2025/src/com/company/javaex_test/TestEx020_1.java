package com.company.javaex_test;

import java.util.Scanner;

public class TestEx020_1 {
	  public static void main(String[] args) {
	      char ch =' ';
	      boolean check = false;
	      Scanner scanner = new Scanner(System.in);
	      
	      
	      for(;;) {
	         System.out.println();
	         System.out.print("주어진 문자를 입력하시오 : ");
	         ch = scanner.next().charAt(0);
	         if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
	            check = true;
	            break;
	         }
	         else {System.out.print("원하는 문자열이 아닙니다.");}
	         
	         if(check==true) {
	            System.out.println("프로그램이 종료됩니다.");
	         break;
	         }
	      }
	      /*
	      while(true) {
	         System.out.print("주어진 문자를 입력하시오 : ");
	         ch = scanner.next().charAt(0);
	         if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
	         check = true;
	            break;
	         }
	         else {System.out.print("원하는 문자열이 아닙니다.");}
	         if(check==true) {
	         System.out.println("프로그램이 종료됩니다.");
	         break;
	         }
	      }
	      
	      do {
	         System.out.print("주어진 문자를 입력하시오 : ");
	         ch = scanner.next().charAt(0);
	         if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
	         check = true;
	            break;
	         }
	         else {System.out.print("원하는 문자열이 아닙니다.");}
	         if(check==true) {
	         System.out.println("프로그램이 종료됩니다.");
	         break;
	         }
	      }while(true);
	      */
	   }
}
