package com.company.java011;

/* 1. 상속 : 클래스의 재사용 (재활용)
	Object	(실선-속이빈화살표)	3) Object {							4) (열고/닫고의 뜻인가? 여는 순이랑 닫는순(생성)이랑 역순)}
	  ↑
  	Animal	2) Animal()	{name=null, age=0 / eat(), sleep(), poo() 		5)	}
  	↑	↑	1) Cat() 	{{animal_card / qukquk()				6)	}
Person	Cat 0) 1번지  	{ }	
----------------------------------------------------
Cat gsh = new Cat();
----------------------------------------------------
1) Cat은 Animal이다	↑
2) 생성자호출 : Cat() -> Animal() -> Object()
3) 객체생성 : Object -> Animal  -> Cat
----------------------------------------------------
 */

class Animal{
	String name;
	int age;
	void eat() 		{System.out.println("먹고");}
	void sleep()	{System.out.println("자고");}
	void poo() 		{System.out.println("배변");}
}
class Cat extends Animal {
	String animal_card;
	void qukquk() {System.out.println(this.name + "-꾹꾹이");}
	
}
class Person{}

public class Extends002 {
	public static void main(String[] args) {
		Cat gsh = new Cat();
		gsh.name = "kitty";
		gsh.animal_card = "ani-1234";
		gsh.age = 28;
		gsh.eat(); gsh.sleep(); gsh.poo(); gsh.qukquk();
	}
}
