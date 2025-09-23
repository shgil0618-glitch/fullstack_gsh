package com.company.java010_ex; // package값이 달라 defalut,package 사용불가

import com.company.java010.UserInfo;

class Userson1 extends UserInfo {
	public void show() {
		System.out.println("부 이름: " + super.name); // 자식 - public
		System.out.println("부 금고번호 : " + super.safecode); // 자식 - protected
		// System.out.println("부 집: " + super.house); // 자식 - package (같은폴더에서)
		// System.out.println("부 iq: " +super. iq); //
		System.out.println("부 iq: " + super.getiq()); //
	} // Q1) super.house를 못쓰는 이유는 userinfo 클래스의 house는 접근자가 package
} // userson2클래스는 java010_ex 폴더 안에 있음.

// alt+shift+s 	/sourse (geter, seter)
////////////////////////////////////////////////////
public class Modifier002_public_private {
	public static void main(String[] args) {
		System.out.println("\n\n1. 홍길동 아버지 정보"); // 본인 : public > protected > default > private(x)
		UserInfo user = new UserInfo();
		user.name = "홍상직"; // public 아무데서나 접근 (홍길동 아버지)
		// user.safecode = "1234"; // protected 본인꺼 접근 가능 //Q2) extends 상속받은적이 없음.
		// user.house = "장성군"; // //Q3) 같은폴더아님 - java010_ex 폴더 안에 있음.
		// user.iq = 145; // private : The field UserInfo.iq is not visible
		user.setiq(148); // private
		System.out.println(user.getiq());

	}
}
/////////////////////////////////////////////////////
