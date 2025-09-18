package com.company.java008;

import java.util.Arrays;

public class Method005_OverLoading {
	public static void main(String[] args) {
		int arr[] = {10,20,30};
					// call by value : 배열값 변경 안됨
		call(10);	// +10	- 값을 복사
		call(arr[0]);	
		
		System.out.println("[1]main : " + System.identityHashCode(arr));
		System.out.println("[2]main : " + Arrays.toString(arr));
		System.out.println();
		
					// call by reference : 배열값 변경[됨]
		call(arr);	//+100	-	주소를 참조
		System.out.println("[3]main : " + System.identityHashCode(arr));
		System.out.println("[4]main : " + Arrays.toString(arr));
	}
	public static void call(int a) {a+= 10; System.out.println(a + " : " + (a+10));}
	public static void call(int arr[]) {
		for (int i=0;i<arr.length;i++) {
			arr[i] += 100;
		}
		System.out.println("call [주소] " +System.identityHashCode(arr) + Arrays.toString(arr));
	}
}
