package com.company.java016_ex;

class Papa{  
	int money = 10000;     
	public Papa() { super(); }
	public void sing() {  System.out.println("GOD-거짓말");  }
}

class Son2 extends Papa{ 
	int money = 1500;
	public Son2() { super(); }
	@Override public void sing() { System.out.println("빅뱅-거짓말"); }
} 

public class Repeat001_oop7 {
  public static void main(String[] args) {
	Papa mypapa = new Son2();   

	System.out.println(mypapa.money);  // money = 10000    
	mypapa.sing();     // 빅뱅-거짓말 
	
	System.out.println(((Son2)mypapa).money); // 1500 
  }
}






