package com.company.java010;

class Farm{
	//상태 - 멤버변수
	String name;	//인스턴스변수 - heap area - new (o) = 생성자 / CAT(1번지).name , cat(1번지).age
	int age;		//인스턴스변수 - heap area - new (o) = 생성자 / dog(2번지).name , dog(2번지).age
	static String farmname ="(주)동물농장";	//클래스변수 - Farm.farmname	(명시적초기화)
	static int farmnum;						//클래스변수 - method area - new(x) - 생성자 x
	static String farmboss;
	static {farmnum=2;	farmboss="신동엽";}	//초기화블록
	
	//행위 - 멤버함수
	static void num_plus() {	//클래스 메서드(스태틱 붙으면 클래스 메서드?) (static - this. 사용불가!! - why?) new의 동적메모리를 빌려와야하는데 그러지 않아서)
		farmnum++;	
	}
	
	void show() {	//인스턴스메서드
		System.out.println("\n==================");
		System.out.println("::이름 : " + this.name);
		System.out.println("::나이 : " + this.age);
		System.out.println("::인원 : " + this.farmnum);
	}
}



public class Static001 {
	public static void main(String[] args) {
		System.out.println("\n\n0. 동물농장");
		System.out.println("회사이름 : " + Farm.farmname);
		System.out.println("회사인원 : " + Farm.farmnum);
		System.out.println("회사사장 : " + Farm.farmboss);
		
		System.out.println("\n1. 동물농장 식구 - this - 각각");
		Farm cat = new Farm();		// 조립 : 1) new : 메모리빌리기, 객체생성	2) Farm() 초기화	3)cat 번지
		cat.name = "gsh"; cat.age=3; cat.show();	// 갖고놀기 사용하기
		Farm dog = new Farm();
		dog.name = "ggg"; dog.age=3; Farm.num_plus(); /*dog.num_plus();*/ dog.show();	
	}
}
/*
///////////////////////////////////////////////////////////////////////////
초기화 순서 :	 기본값				명시적초기화				초기화블록					생성자
farmnum		0					null					(O) 2					X
farmboss	null				null					(O) 신동엽				X
farmname	null				(주)동물농장				(X) (주)동물농장			null
///////////////////////////////////////////////////////////////////////////
cat		name=null,age=0		(X)name=null,age=0			(X)name=null,age=0			name=null,age=0
dog		name=null,age=0		(X)name=null,age=0			(X)name=null,age=0			name=null,age=0
///////////////////////////////////////////////////////////////////////////
------------------------[ runtime data area]
[method: 정보, static, final : 공용정보]
Farm.class, static001.class
Farmnum=2;	Farmboss="신동엽";	Farmname="(주)동물농장";
------------------------------------
[heap: 동적]            | [stack : 잠깐빌리기]
1번지{name,age}
						main
------------------------------------
*/