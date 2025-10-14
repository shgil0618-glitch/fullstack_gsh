package com.company.java014;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// 1. 콜렉션 프레임워크 - [배열]의 단점을 개선한 [객체]만 저장가능 [동적배열]
// 2. List, Set, Map
//3. List[기차] : 순서 O, 중복 O , 		add, get(순서), size, remove(순서), contains
//4. Set[주머니] : 순서 X, 중복 X , 	add/향상된for, iterator, size, remove(객체), contains
//5. Map[사전] : Key:Value (entry) 	add, get(key) / iterator, size, remove, contains

class Candy {
	String name;
	int price;
	public Candy(String name, int price) { super(); this.name = name; this.price = price; }
	public Candy() { super(); }
	@Override public String toString() { return "Candy [name=" + name + ", price=" + price + "]"; }
	// 1. Candy 클래스확인용도
	@Override public int hashCode() { return Objects.hash(name, price); }
	// 2. 사용자가 넣어준 값을 비교
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candy other = (Candy) obj;
		return Objects.equals(name, other.name) && price == other.price;
	}
	
	
}

public class Set001 {
	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<>();

		set1.add(1);				// Integer e = 1	(객체)
		set1.add(new Integer(1));	// Integer e = new Interger(1) (부품객체) 
		set1.add(1);				// 부품객체 = 기본값 (Integer - wrapper 클래스)
		set1.add(2);				// 기본값을 자동으로 - 객체화 - 부품객체 [wrapper 클래스]
		set1.add(3);				// int -> Integer / float -> Float 오토박싱.
		System.out.println(set1);	// [1,2,3] 종복혀용 x
		
		Set<Candy> set2 = new HashSet<>();
		set2.add(new Candy("츕파츕스",3000));
		set2.add(new Candy("츕파츕스",3000));
		set2.add(new Candy("츕파츕스",3000));
		set2.add(new Candy("청포도 알사탕",4500));
		set2.add(new Candy("멘톨",5500));
		System.out.println(set2);
		System.out.println(set2.size());
		
		
	}
}
