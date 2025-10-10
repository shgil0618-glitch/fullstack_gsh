package com.company.javaex_test;

//1. 클래스는 부품객체
//2. 상태(멤버변수)와 행위(멤버함수)
class Coffee{
   String name;  int price, num;
   
   void show() {
	   System.out.println("=====커피\r\n"
   		+ "커피명 : "+this.name+"\r\n"
   		+ "커피잔수 : "+this.num+"\r\n"
   		+ "커피가격 : "+this.price+"\r\n");
   }
   Coffee(String name, int num,int price){
	   this.name = name;  this.num=num; this.price=price;
   }
   Coffee(){this.name = "아메리카노";  this.num=2; this.price=2000;}   //1) 생성자 오버로딩   2) 상속
}
public class Repeat001_oop1 {
	public static void main(String[] args) {
		Coffee  a1 = new Coffee("까페라떼" , 2 , 4000);
		//new: 메모리빌리고, 객체생성   Coffee("까페라떼" , 2 , 4000) 초기화
		a1.show();
		Coffee  a2 = new Coffee(); a2.show(); 
	}
}

/**************
Repeat001.java                   <  javac Repeat001.java
Coffee.class , Repeat001.class   <  java  Repeat001 
------------------------------------------------------------
[method : 정보보관]
[1번지]Coffee.class  
[2번지]Repeat001.class  ##1
------------------------------------------------------------
[heap:동적]                             |		 [stack:지역]
[2000]번지							    <----[a2 | 2000번지]
{ name="아메리카노", num=1 , price=1500 }											  
[1000]번지							    <----[a1 | 1000번지]
{  name="까페라떼", num=2, price=4000  }   [main          ]
------------------------------------------------------------
*/


/*
=====커피
커피명 : 까페라떼
커피잔수 : 2
커피가격 : 4000
=====커피
커피명 : 아메리카노
커피잔수 : 1
커피가격 : 2000
*/