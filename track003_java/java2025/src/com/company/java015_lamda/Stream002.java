package com.company.java015_lamda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream002 {
	public static void main(String[] args) {
		
		Integer arr[] = {1,2,5,4,3,4,5,1,2,1,1,1,1,1,1};	//배열
		List<Integer> list = Arrays.asList(arr);
		
		// 1단계 - stream
		Stream<Integer> sarr = Arrays.stream(arr);
		Stream<Integer> slist =  list.stream();
		
		// 2단계 - 중간연산
		//boolean java.util.function.Predicate.test( T t )
		//void java.util.function.Consumer.accept( T t )
		sarr.filter(t -> t%2 !=0)		// 홀수 필터링
		.distinct()						// 중복제거	1,5,3
		.sorted()						// 정렬		1,3,5
		.skip(1)						// skip		3,5
		.forEach(System.out::print);					// 3단계 - 최종연산
		
		System.out.println();
		
		slist.filter(t -> t%2 !=0)		// 홀수 필터링
		.distinct()						// 중복제거	1,5,3
		.sorted()						// 정렬		1,3,5
		.skip(1)						// skip		3,5
		.forEach(System.out::print);					// 3단계 - 최종연산
		
		System.out.println();
		// #3. collect
		System.out.println(Arrays.stream(arr).collect(Collectors.toList()));
		System.out.println(list.stream().collect(Collectors.toList()));
		
	}
}
