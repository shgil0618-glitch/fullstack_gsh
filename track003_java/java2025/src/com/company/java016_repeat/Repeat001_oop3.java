package com.company.java016_repeat;

class Sawon005{  
	   int pay      =10000;      
	   static int su=10;        
	   static int basicpay2;
	   static {  basicpay2=20000; }
	 
	   public static void showSu() {   System.out.println(su);  }        
	 //  public static void  showPay() { System.out.println(this.pay); }	//스태틱 함수 및 변수는 실행과 동시에 method 영역에 저장이 되는 영역이다 하지만 this는 new를 통해 동적할당 받은걸 저장하는 것이므로 메모리 할당 시간상 맞지 않다.
	   
	   public  void  showAll001() {   
	       System.out.println(su);
	       System.out.println(this.pay);
	   }
	   public  void  showAll002() {   
		   showAll001();
	       System.out.println(this.pay);
	   }   
} 

public class Repeat001_oop3 {
  public static void main(String[] args) {
   Sawon005  sola = new Sawon005();  
   sola.showAll001();
  }
}

