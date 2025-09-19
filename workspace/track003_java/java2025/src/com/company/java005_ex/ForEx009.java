package com.company.java005_ex;

import java.util.Scanner;

public class ForEx009 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i=0, sum=0;
		
		System.out.println("1. for문");
		for(i=1;i<=10;i++) {
			if(i%3==0) {sum += i; System.out.print((sum == 18) ? i : i+ "+");}
		}
		System.out.println("="+sum);
		
		System.out.println("2. while문");
		sum=0;
		i=1;
		while(i<=10) {
			if(i%3==0) {sum += i; System.out.print((sum == 18) ? i : i+ "+");}
			i++;
		}
		System.out.println("="+sum);
		
		System.out.println("3. do while문");
		i=1;
		sum=0;
		do {
			if(i%3==0) {sum += i; System.out.print((sum == 18) ? i : i+ "+");}
			
			i++;
			
		}while(i<=10);
		System.out.println("="+sum);
		
	}
}
/*


연습문제9)  for/while/do while
패키지명 : com.company.java005_ex
클래스명 :  RepeatEx009
for , while , do while 3가지 버젼으로 
1~10까지 3의 배수의 합 : 18

힌트)
ver-1)
1이  3의 배수라면  합을더해주변수에누적
2가  3의 배수라면  합을더해주변수에누적
3이  3의 배수라면  합을더해주변수에누적

ver-2)
if( 1이  3의 배수라면 ){ 합을더해주변수에누적 }
if( 2가  3의 배수라면 ){ 합을더해주변수에누적 }
if( 3이  3의 배수라면 ){ 합을더해주변수에누적 }

*/