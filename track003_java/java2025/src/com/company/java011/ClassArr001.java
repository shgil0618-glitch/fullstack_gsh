package com.company.java011;

import java.util.Arrays;

public class ClassArr001 {
	public static void main(String[] args) {
		// 1) Toy[] 나 주소 받을수 있어~!
		Toy[] toys = new Toy[3];	// 2)new 번지, Toy형태 자료형 3개
		//Q) 이떄 toys[0][1] 찍으면 toys[0]의 age가 호출되나?	안되네
		System.out.println("1. " + toys);
		System.out.println("2. " + Arrays.toString(toys));
		
		toys[0] = new Toy();
		toys[0].setName("할로위키티");		toys[0].setAge(52);
		System.out.println("3. "+ toys[0]);
	
		Toy[] toys2 = new Toy[] {
			new Toy("할로윈 키티", 52), new Toy("건담", 47) 	
		};
		
		for(int i=0; i<toys2.length;i++) {
			toys2[i].show();
		}
	}
}
