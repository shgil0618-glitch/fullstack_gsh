package com.company.java010;

// 클래스는 부품객체
// 클래스는 상태(멤버변수)와 행위(멤버함수) 
// 1. final - 변경하지마!
// 멤버변수 - 상속 X , [상수	: 변하지않는 값]		멤버함수 - [오버라이딩 : 자식한테 내꺼쓰지마!]X 


class FinalEx extends Object {									// 공용으로 쓰는거는 static가 좋음.
	final static String gaecheon = "10-3";		// 클래스변수 - method - new x - 생성자 - this x > 지금 바로 사용
	String name;
	final void show() {System.out.println(FinalEx.gaecheon+"\t"+name);}
}

class Finalson extends FinalEx{		//오버라이드 - 상속시 자식클래스에서 부모의 클래스를 재수정
	
}

//////////////////////////////////////////////////////
public class Final001 {
	public static void main(String[] args) {
	//	FinalEx.gaecheon = "10-1";		//The final field FinalEx.gaecheon cannot be assigned
		FinalEx saram = new FinalEx();
		saram.name = "gsh";
		saram.show();
	}
}
//////////////////////////////////////////////////////

