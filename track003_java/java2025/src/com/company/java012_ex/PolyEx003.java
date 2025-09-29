package com.company.java012_ex;

/*
object									3		4
  ↑
 TestA4	{int a, toString}				2		5
  ↑
 TestB4	{int b, toString}				1		6

*/
//Q1. 상속도를 그리시오. 
class TestA4  extends Object{  
 int a=10;
 @Override public String toString() { return "TestA4 [a=" + a + "]"; }
}
class TestB4  extends TestA4{  
 int b=20;
 @Override public String toString() { return "TestB4 [b=" + b + "]"; }
}
/////////////////////////////////////////////////
public class PolyEx003 {
 public static void main(String[] args) {
    TestA4  ta = new TestA4();
    //Q2. TestA4  ta 사용할수 있는범위는?
    // TestA4
    //Q3. new TestA4() 는  heap area 에서 호출되는 생성자의 순서와 객체가 만들어지는 순서는?
    // A :생성자 testa4() -> object /객체 object -> testa4
    //		ta{int a, toString} = 1000번지 {int a, toString} = {}
    TestB4  tb = new TestB4();  
    //Q4. TestB4  tb 사용할수 있는범위는?
    // TestA4 / TestB4
    //Q5. new TestB4() 는  heap area 에서 호출되는 생성자의 순서와 객체가 만들어지는 순서는?
    // A : 생성자 : 1->2->3 testb4->testa4->object	/ 객체 4->5->6
    // tb {int b, toString} - {a:10 /----------}
    // ＃ 부모 = 자식 / 업케스팅 / 타입캐스팅 x
    ta = new TestB4();
    //Q6. ta가 사용할수 있는 보장하는 변수와 메서드는?
    // {int a, toString}	
    //Q7.ta = new TestB4(); 에서 new TestB4() 에서 사용할수 있는 범위는? 
    // TestB4
    // ta {a=10/tostring} = 3000번지 {b=20/[@tostring} - {a=10]/-------}
    // ＃ 자식 = 부모 / 다운캐스팅 / 타입캐스팅 o
    tb         = (TestB4) ta;   
    //Q8. tb         = (TestB4) ta;   에서 tb가 사용할수 있는 범위는?
    // TestA4
    //Q9. 컴피일러시  tb         = (TestB4) ta;  오류가 안나는 이유는?
    System.out.println(tb);  //Q10. 출력내용과 그이유는?  //TestB4 
    System.out.println(tb.b);//Q11. 출력내용?		//20
    System.out.println(tb.a);//Q12. 출력내용?		//10
    
 }
}

