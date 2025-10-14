package com.company.java014;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

//1. 콜렉션 프레임워크 - [배열]의 단점을 개선한 [객체]만 저장가능 [동적배열]
//2. List, Set, Map
//3. List[기차] : 순서 O, 중복 O , 		add, get(순서), size, remove(순서), contains
//4. Set[주머니] : 순서 X, 중복 X , 	add/향상된for, iterator, size, remove(객체), contains
//5. Map[사전] : Key:Value (entry) 	put/ get(key),향상된 for,  iterator/ size, remove, contains



public class Map001 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		
		System.out.println("1 : "+ map);
		System.out.println("2 : "+ map.get("two"));
		System.out.println("3 : "+ map.size());
		System.out.println("4 : "+ map.remove("two"));
		System.out.println("5 : "+ map.containsKey("one"));
		System.out.println(map.entrySet());		//Key:value 한묶음, 한쌍 - [one=1, three=3]
		
		for(Entry<String,Integer> one:map.entrySet()) {
			System.out.println(one.getKey() + "/" + one.getValue());
			}
		
		Iterator<Entry<String, Integer>> iter = map.entrySet().iterator();	// 1) 줄세우기 iter -> [one=1, three=3]
		while(iter.hasNext()) { // 2) 처리대상 확인 [iter -> one=1, three=3]
			Entry<String, Integer> temp =iter.next();	// [one = 1]
			System.out.println(temp.getKey() + "/" + temp.getValue());
		}
	}
}
