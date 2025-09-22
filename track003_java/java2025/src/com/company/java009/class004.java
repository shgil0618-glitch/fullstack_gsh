package com.company.java009;

//1. 클래스는 부품객체
//2. 클래스는 상태와 행위
/*	 Object		2) Object()	 { }			3)
 		↑
   	Product		1) Product() { super(); }	4) Product p1 = new Product();
 */

class Product  {		//extends Object 생략, 상속받을께 Object, Object 생략가능
	String name;
	int price;
	
	// alt + shift + s ★ 밑에서 3번째(2,3,4)
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}


/////////////////////////////////////////////////////////
}

public class class004 {
	public static void main(String[] args) {
		Product p1 = new Product();	// 1. 메모리빌리고 객체생성 2. 생성자 호출 3. p1 주소
		System.out.println(p1);
	}
}
/////////////////////////////////////////////////////////

/*
----------------------------------------------------	[runtime data area]
[method : 클래스 정보, static, final : 공용정보] Product.class, Class004.class
----------------------------------------------------
[heap : 동적]							[stack : 잠깐 빌리기]	Product p1 = new Product();
					Object();
1번지{name=null, price=0}			 <-	p1[1번지]
									| main 
----------------------------------------------------

 */

