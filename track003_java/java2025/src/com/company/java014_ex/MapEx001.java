package com.company.java014_ex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

//map : 사전 - entry(key,value) / put,get,size,remove,contains
public class MapEx001 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		String cname;
		map.put("피구왕", "통키");
		map.put("제빵왕", "김탁구");
		map.put("요리왕", "비룡");

		System.out.println("==============================");
		System.out.println("KING\tNAME");
		System.out.println("==============================");
		for (Entry<String, String> hero : map.entrySet()) {
			System.out.println(hero.getKey() + "\t" + hero.getValue());
			System.out.println("---------------------");
		}
		System.out.println("KING의 정보를 제공중입니다");
		System.out.print("이름을 입력하세요 : ");
		cname = scanner.nextLine();
		System.out.println();
		
		System.out.println(map.containsKey(cname) ? "ㅁ" + cname + " - " + map.get(cname) : "찾는 왕 없음!");
		
		for (Entry<String, String> check : map.entrySet()) {
			if (check.getKey().equals(cname)) {
				System.out.println("ㅁ" + check.getKey() + " : " + check.getValue());
			}
		}
	}
}
/*
 연습문제2)  Collection  Framework
패키지명 : com.company.java014_ex
클래스명 : MapEx001
1. MAP 만들기
KEY   VALUE
피구왕   통키
---------------------
제빵왕   김탁구
---------------------
요리왕   비룡

Map<String, String> map = new HashMap<>();

2 다음과 같이 문제풀기
==============================
KING   NAME
==============================
피구왕   통키
---------------------
제빵왕   김탁구
---------------------
요리왕   비룡
---------------------
KING의 정보를 제공중입니다
이름을 입력하세요> 제빵왕

ㅁ제빵왕 : 김탁구



 */
