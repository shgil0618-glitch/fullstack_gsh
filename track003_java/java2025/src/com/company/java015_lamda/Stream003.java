package com.company.java015_lamda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Stream003 {
	public static void main(String[] args) {
		Integer ages[] = {17,21,26,45,18};
		
		// EX1
		double avg = Arrays.stream(ages)
		.mapToInt(age -> age)	//객체는 기본값
		.average()	//평균값 처리
		.orElse(0.0);	// 값없으면 0.0
		System.out.println("평균나이 : " + avg);
		
		//EX2 짝수만 출력
		//STEP1) 스트림 만들기
		Stream<Integer> num = Arrays.stream(ages);
		//java.util.function.Predicate<T>
		num.filter(t -> t%2 == 0)
		.forEach(System.out::print);
				
		//STEP2) 짝수 필터링 - filter
		//STEP3) 출력 - foreach
		
	     //Ex3  성이 김씨인친구들
	      List<String> names = Arrays.asList("김수지" , "이나영" , "김나영" , "유재석" , "강호동");
	      System.out.println(names.get(0).startsWith("김"));  // 힌트) 문자열에서 startWith("문자") 시작하는
	      //step1) 스트림만들기 
	      //step2) 김으로 시작하는 값찾기 -filter 이용
	      //step3) 출력  -  forEach
	      //boolean java.util.function.Predicate.test( T t )
	      System.out.println();
	      names.stream()
	      .filter(t -> t.startsWith("김"))
	      .forEach(System.out::print);
	      
	      System.out.println();
	      //EX4 names 정렬 후 출력
	      names.stream()
	      .sorted()
	      .forEach(System.out::print);
	      
	      System.out.println();
	      //EX5 제일 나이 많은(max) 사람
	    //				1단계-스트림			객체를 숫자로		최대값	못찾으면 -1
	      int max = Arrays.stream(ages) .mapToInt(age->age).max().orElse(-1);
	      System.out.println(max);
		
	}
}
