package com.company.java010;

// public(아무데서나) > protected(extends) > default(같은폴더내에서만) > private(클래스 안에서만) 


class Userson1 extends UserInfo{
	public void show() {
		System.out.println("부 이름: " + super.name);			// 자식 - public
		System.out.println("부 금고번호 : " + super.safecode);	// 자식 - protected
		System.out.println("부 집: " + super.house);			// 자식 - package (같은폴더에서)
	//	System.out.println("부 iq: " +super. iq);			// 
		System.out.println("부 iq: " +super. getiq());		//
	}
}

// alt+shift+s 	/sourse (geter, seter)
////////////////////////////////////////////////////
public class Modifier001_public_private {
	public static void main(String[] args) {
		System.out.println("\n\n1. 홍길동 아버지 정보");	// 본인 : public > protected > default > private(x)
		UserInfo user = new UserInfo();
		user.name = "홍상직";		// public 아무데서나 접근 (홍길동 아버지) 
		user.safecode = "1234";	// protected 본인꺼 접근 가능
		user.house = "장성군";	//
	//	user.iq = 145;			// private : The field UserInfo.iq is not visible
		user.setiq(148);						// private
		System.out.println(user.getiq());
		
	}
}
/////////////////////////////////////////////////////
