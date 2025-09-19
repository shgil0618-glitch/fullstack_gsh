package com.company.java008_ex;

import java.util.Arrays;

public class MethodEx008_4 {
	public static void main(String[] args) {
		String apt[][] = {
				{"아이유", "손흥민", "지민"},
				{"이정재", "리사", "유재석"},
				{"박지성","강호동","전현무"}
		};
		System.out.println("main) apt - " + Arrays.deepToString(apt));
		ringbell(apt);
		System.out.println("main) apt - bell :" + Arrays.deepToString(apt));
		
	}
	public static void ringbell(String apt[][]) {
		apt[1][1] = "(띠링)";
		}
}

/*
[heap]							[stack]
							<-	ringbell(1000번지)
1000번지 apt[][]				<-	apt[1000번지]
apt[1001번지,1002번지,1000번지]		
*/