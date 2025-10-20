package com.company.java016_repeat;


class Coffee{
   String name;  int price, num;	// 인스턴스 변수 - heap area - new 관련o - this 관련 - 각각
   
   void show() {
	   System.out.println("=====커피");
	   System.out.println( "커피명 : "+this.name);
	   System.out.println("커피잔수 : "+this.num);
	   System.out.println("커피가격 : "+this.price);
   }
   		
   Coffee(String name, int num,int price){
	   this.name = name;  this.num=num; this.price=price;
   }
   Coffee(){this.name = "아메리카노";  this.num=2; this.price=2000;}  
}
public class Repeat001_oop1 {
	public static void main(String[] args) {
		Coffee a1 = null;			//	2번지에 있는 클래스 자료형으로 a1이라는 장난감 만들꺼야라고했지... 장난감 만든적 없음.
			   a1 = new Coffee("까페라떼" , 2 , 4000);	// 2단계 장난감 조립
		// 3. a1(1000번지)		= 1. new메모리빌리고(1000번지) 객체(장난감)생성 2.coffee 생산자로 장난감 만드는 방법 - 초기화) 
		a1.show();										// 3단계 갖고놀기 (1000번지).show()
		Coffee  a2 = new Coffee();
		// 3. a2(2000번지	)	= 1. new메모리빌리고(2000번지) 객체(장난감)생성 2.coffee 생산자로 장난감 만드는 방법 - 초기화) 
		a2.show(); 										// 3단계 갖고놀기 (2000번지).show()
	}
}

/************** 
java016_ex.java
java016_ex.class	Coffee.class
[method : 정보보관] 
[1번지] publc java016_ex.class
[2번지] Coffee.class
------------------------------------------------------------
[heap:동적]                           			|       [stack:지역] 

												←	a1(1000번지).show()	(a1 실제로 만든 장난감, 객체, 인스턴스)
1000번지 
{name="카페라떼",num=2,price=4000/show()}			←	a1(1000번지)
										    		a1(null)
												| main
------------------------------------------------------------
*/
