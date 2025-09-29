package com.company.java012_ex;
 
/*
  	object
  	  ↑
  	 TestA2	{int a, ---------}
  	  ↑
  	 TestB2	{int b, toString}
 
 */

//Q1. 상속도를 그리시오. 
class TestA2 extends Object{  
   int a=10;
   @Override public String toString() { return "TestA2 [a=" + a + "]"; }    
}
class TestB2 extends TestA2{
   int b=10;
   @Override public String toString() { return "TestB2 [b=" + b + "]"; }   
}
/////////////////////////////////////////////////
public class PolyEx001 {
   public static void main(String[] args) {
      TestA2  ta = new TestB2();
      //Q2. TestA2  ta 는 클래스의 무엇을 사용할수 있을까요? 코드의 의미
      // TestA2
      //Q3. TestB2() 는 클래스의 무엇을 사용할 수 있을까요?
      // TestA2, TestB2
      
      System.out.println(ta); // Q4. 출력내용과 이유?  // TestB2 [b=10]	/ 자식TestB2부터 시작되는 것이기떄문에 TestB2에서 오버라이딩에 걸려 TestB2가 출력된다.												
      System.out.println(ta.a); //Q5.사용가능?		   // 가능 10 / ta가 애초에 TestA2	{int a, toString}의 형식을 취하고있기 때문에
      //System.out.println(ta.b); //Q6.사용가능?	   // 불가능 /  부모는 extends를 통해 object만을 확장자로 가지고있기때문에 TestB2의 값에 찾아 갈 수 없다.
   }
}
