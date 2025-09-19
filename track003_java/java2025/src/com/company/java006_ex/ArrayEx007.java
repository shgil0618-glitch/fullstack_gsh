package com.company.java006_ex;

public class ArrayEx007 {
	public static void main(String[] args) {
		char arr[] = new char[5];

		char data = 'A';
		for (int i = 0; i < arr.length; i++) {
			arr[i] = data;
			System.out.print(arr[i] + " ");
			data += 1;
		}

	}
}

/*

연습문제7)  array
패키지명 : com.company.java007_ex
클래스명 :  ArrayEx007
    new 연산자 이용해서 배열만들기
    1. 배열명 : arr     
    2. 값 넣기 : A   B   C   D   E    for+length 이용해보기
    3. for + length 로 출력


*/