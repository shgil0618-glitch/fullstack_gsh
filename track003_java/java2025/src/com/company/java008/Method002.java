package com.company.java008;

public class Method002 {
	//(1) 마법상자 정의
	//public static 리턴값 메서드명(파라미터) {  }
	public static void myint(int a) {System.out.println(a);}
	
	public static void ten(int money) {System.out.println(money*10);}
	
	public static void add(int money, int bitcoin) {System.out.println(money+bitcoin);}
	///////////////////////////////////////////
	public static void main(String[] args) {
		//(2) 사용
		myint(1);
		myint(2);
		
		ten(1);
		ten(100);
		
		add(100, 20);
		add(200,30);
	}
	///////////////////////////////////////////
}
