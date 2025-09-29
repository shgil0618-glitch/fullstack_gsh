package com.company.java012;

/*
  	Object
  	  ↑
  	Animal	{String name; int age;}
  	  ↑	
  	 Cat	{String number; void show(); }
-------------------------------------------  	  
  	Object
  	  ↑
  	Animal	{String name; int age;}
  	  ↑	
  	Person	{String jumin; void show(); }
 
 */
class Animal { 
	String name; int age;
	public Animal() { super();  }	//object() -디폴트생성자 / 컴파일러가 자동생성 x -> 오버로딩과 상속시
	public Animal(String name, int age) { super(); this.name = name; this.age = age; }	//생성자 오버로딩
	public void show() {System.out.println("Animal");}
	
}

class Cat extends Animal {
	String number;
	public void show() {System.out.println("cat : " +super.name+ "/" + super.age);}
}

class Person extends Animal {
	String jumin;
	public void show() {System.out.println("Person : " +super.name+ "/" + super.age);}
}

public class Poly005 {
	public static void main(String[] args) {
		// 하나의 타입(부모)으로 여러타입의 객체(자식들)를 관리
		// 부모 = 자식 / 업캐스팅 / 타입캐스팅 x
		Animal anis[]					 = {new Cat() , new Cat(), new Person(), new Person() };
	//1. 보장 : {String name; int age; / show() }
	//						= new Cat{number, @show()} - Animal{String name; int age; / ------}
	//1. 보장 : {String name; int age; / show()}
	//						= new Person{jumin, @show()} - Animal{String name; int age; / ------}
		Animal controller = null;
		controller = anis[0]; controller.show(); //cat
		controller = anis[1]; controller.show();
		controller = anis[2]; controller.show(); //person
		controller = anis[3]; controller.show();
		
	}

}
