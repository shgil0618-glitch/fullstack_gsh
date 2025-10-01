package com.company.java014_ex;

import java.util.ArrayList;
import java.util.List;

public class ListEx001 {
	public static void main(String[] args) {
		List<String> colors = null;
		
		 colors = new ArrayList<>();
		
		colors.add("red");
		colors.add("green");
		colors.add("blue");
		
		System.out.println("1 : " + colors);
		System.out.print("2 : size + get  -");
		for(int i=0;i<colors.size();i++) {System.out.print(  "\t" +colors.get(i));}
		
		System.out.println();
		System.out.print("3 : 향상된 for  - ");
		for(String c : colors) {System.out.print("\t"+ c ) ;}
		}
}
/*
연습문제1)  Collection  Framework
패키지명 : com.company.java014_ex
클래스명 : ListEx001
다음과 같이 코드를 작성하시오.
 1.  ArrayList이용해서 colors 만들기
 2. red, green, blue 데이터 추가
 3. 출력


*/