package com.company.javaex_test;

class Sawon005{  
	   // (1)  인스턴스변수 , heap, new  O, 실체화, this 각각
	   int pay      =10000;
	   
	   // (2)  클래스변수  , method, new X, 공유      
	   static int su=10;  
	   
	   // (3)  클래스(static)  static에서는 인스턴스사용불가
	   // static int basicpay=pay;  

	   // (4)  클래스변수  , method, new X, 공유      
	   static int basicpay2;
	   static {  basicpay2=20000; }
	 
	   // (5) 클래스메서드 , method, new X, 공유  Sawon005.showSu();
	   public static void showSu() {   System.out.println(su);  }         
	   
	   // (6) 인스턴스메서드, heap, new O, 실체화, this
	   public  void  showAll001() {   
	       System.out.println(su);
	       System.out.println(this.pay);
	   }
	   // (7)  클래스(static)  인스턴스사용불가
	   public static  void  showAll002() {
	       //showAll001();     
	       //System.out.println(this.pay); 
	   } 
} 

public class Repeat001_oop3 {
  public static void main(String[] args) {
   Sawon005  sola = new Sawon005();  
   sola.showAll001();
  }
}

