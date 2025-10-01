package com.company.java014;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;




// 1. 콜렉션 프레임워크 - 동적배열
// 2. 배열의 단점 개선 - 한가지 자료형으로 사이즈 고정

public class List001 {
	public static void main(String[] args) {
		//step1. Array
		String arr[] = new String[3];	//String 자료형 공간 3개 [고정]
		arr[0] = "헐크";
		System.out.println(Arrays.toString(arr));
		
		//step2. 동적배열 - List 사용법(1)
		//부모
		List list =  null;	//ctrl+shift+o
		/*
			 list = new ArrayList<>();	//자식
			 list = new LinkedList<>();	//자식
			 list = new Vector<>();	//자식
		*/
			 list = new ArrayList();	//자식
			 list = new LinkedList();	//자식
			 list = new Vector();	//자식
		
		//step3. <> <-재네릭스
		//List list2 = new ArrayList();	//자료형에 상관없이 내가 넣고 싶은만큼
		List<String> list2 = new ArrayList<String>();
		list2.add("one");	// object obj = "one"
		//list2.add(1);		// Object obj =1;
		list2.add(new String("two"));	// Object obj = new String("two");
		//list2.add(3.14);
		//list2.add('A');
		System.out.println(list2);
			 
		//step4. add(추가), get(가져오기), size(갯수), remove(식제), contains ■ 
		List<String> list3 = new ArrayList<String>();
		list3.add("apple");
		list3.add("banana");
		list3.add("apple");
		list3.add("coconut");
		
		System.out.println(list3);
		System.out.println(list3.get(0));
		System.out.println(list3.size());
		System.out.println(list3.remove(0) + " / " + list3);
		System.out.println(list3.contains("melon"));
		System.out.println(list3.contains("coconut"));
		
		
	}
}
