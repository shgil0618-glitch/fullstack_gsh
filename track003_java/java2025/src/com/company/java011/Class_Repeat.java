package com.company.java011;

/*
 					기본값			명시적초기화				초기화블록					생성자 
 (static)company	null			="(주) 703toyland"		"(주) 703toyland"		X
 (static)num		0				X		0				0		0				x
 -------------------------------------------------------------------------------------------
 kitty {name=null, age=0}		유지			유지			유지			유지							this.name
 gundam	{name=null, age=0}		유지			유지			유지			{name="건담", age = 40}		this.name
 */
/*
class Toy{
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
}
*/

public class Class_Repeat {
	public static void main(String[] args) {
		Toy kitty = new Toy();					// 1)new 메모리,객체	2) 생성자		3) kitty 번지
	//	kitty.name = "할로윈키티";
		kitty.setName("할로윈키티");	kitty.setAge(52);	kitty.show();
		Toy gundam = new Toy("건담", 47);
		gundam.show();
		

	}
}

/*
=======================================================
Class_Repeat.class / Toy.class	/	Toy.company,	Toy.num
method [클래스정보]
--------------------------------------------------------
heap [동적]					stack [임시저장공간]
2번지{name,age}			←	gundam[2번지]
1번지{name, age}			←	kitty[1번지]
							main

=======================================================
*/