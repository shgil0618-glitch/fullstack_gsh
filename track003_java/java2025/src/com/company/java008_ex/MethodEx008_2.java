package com.company.java008_ex;

import java.util.Arrays;

public class MethodEx008_2 {
	
	public static void main(String[] args) {
		char ch[] = {'A','B','C','1','@'};
		lower(ch); //
		/* [HEAP]					[STACK]
		 
		 							4)LOWER(1000번지) 7번째줄
		  2)1000번지				<-	3)CH[1000번지]	6번째줄			
		{'A','B','C','1','@'}		
									1)MAIN
		
		 */
		System.out.println(Arrays.toString(ch));
	}
	public static void lower(char ch[]) {
		for (int i=0; i<ch.length;i++) {
			if(ch[i] >='A' && ch[i] <= 'Z') {ch[i] += 32;}
		}
	}
}
