package com.company.javaex_test;

interface InterC2 {String hi();}
interface Ex2{void print(String s);}

public class TestEx034_1 {
	public static void main(String[] args) {
		InterC2 c = new InterC2() {
			@Override
			public String hi() {
				return "GOOD :DAY";
			}
		};
		System.out.println(c.hi());
		
		InterC2 c2 = () -> {return "Good :Day";};
		System.out.println(c2.hi());
		
		Ex2 ex2 = System.out::println;
		System.out.println("Good DAY");
		
		Ex2 ex3 = (String s) -> {System.out.println(s);};
		ex3.print("good day");
		
	}
}


