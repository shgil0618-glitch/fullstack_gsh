package com.company.java009;

// 1. 클래스는 부품객체
// 2. 클래스는 속성(멤버변수)과 행위(멤버함수)

class animal002{
	// 속성 - 멤버변수
	String name;
	int age;
	// 행위 - 멤버함수
	void show() {System.out.println("이름 : " +this.name +"\t나이 : " + this.age);} 
}

//////////////////////////////////////////////////
public class class002_oop {

	public static void main(String[] args) {
		animal002 a1 = new animal002(); 
		//1. new(1번지, 객체생성)	2. animal002() 초기화		3. a1 주소 = 1번지
		a1.name="dog"; a1.age=3; a1.show();
		
		animal002 a2 = new animal002(); 
		a2.name="cat"; a2.age=5; a2.show();

	}
}
//////////////////////////////////////////////////

/*
----------------------------------------------------	[runtime data area]
[method : 클래스 정보, static, final : 공용정보] 
		animal002.class, class002.class						클래스(설계도) -> (인스턴스화) 객체(object/a1,a2) -> 인스턴스(dog,cat)
----------------------------------------------------
[heap : 동적]							[stack : 잠깐 빌리기]	객체(전체) : (a, a2, a3)
									a2.show() {현재번지의 show(2번지)출력}
23째줄 : 2번지						<-	a2[2번지] {name:cat, age:5}
22째줄 : 2번지						<-	a2[2번지] {name:null, age:0}
									a1.show() {현재번지의 show(1번지)출력}
20째줄 : 1번지						<-	a1[1번지] {name:dog, age:3}
18째줄 : 1번지						<-	a1[1번지] {name:null, age:0}
									| main 
----------------------------------------------------



*/