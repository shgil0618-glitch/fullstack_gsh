package com.company.java011;

public class Toy {
	private String name;	//인스턴스변수 - heap - new O - 생성자 O - this (각각)
	private int age;
	static final String company="(주) 703toyland";		// Toy.company 클래스.변수 , 클래스변수 - method - new x - (now)		//final 변하지 않는 값(변경하지 마!!)
	static int num;								// static - 클래스 변수 (공용)
	static {num = 0;}

	public String getName() { return name; }       public void setName(String name) { this.name = name; }  
	public int getAge() { return age; }       public void setAge(int age) { this.age = age; }  

	public Toy() { super();  }
	public Toy(String name, int age) { super(); this.name = name; this.age = age; }
	
	
	
	public void show() {
		System.out.println("name : "+ this.name);
		System.out.println("age : "+ this.age);
		
	}
	@Override
	public String toString() {
		return "Toy [name=" + name + ", age=" + age + "]";
	}
	
	
}
