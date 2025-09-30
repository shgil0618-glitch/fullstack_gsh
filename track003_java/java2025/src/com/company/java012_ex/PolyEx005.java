package com.company.java012_ex;
/*
 object									3		4
  ↑
 Parent7	{int X=100, method()}		2		5
  ↑
 Child7		{int x=200, @method()}		1		6
 
 */

class Parent7 extends Object {
	int x = 100;
	public Parent7() { super(); }
	void method() { System.out.println("Parent Method"); }
}

class Child7 extends Parent7 {
	int x = 200;
	public Child7() { super(); }
	@Override void method() { System.out.println("Child Method"); }
	void papamethod() {super.method();}
}

public class PolyEx005 {
	public static void main(String[] args) {
		Parent7 p = new Child7();
		// Q3. Parent7 p 보장하는 범위
		// Parent7 / Child7
		// Q4. 인스턴스화 했을때 사용가능한 범위 : new Child7()
		// {x=100; method()} - {x = 200; method()}

		Child7 c = new Child7();
		System.out.println("p.x = " + p.x); // Q5. 출력되는 내용 	// p.x = 100
		p.method(); // Q6. 출력되는 내용							// Child Method
		System.out.println("c.x = " + c.x); // Q7. 출력되는 내용	// c.x = 200
		c.method(); // Q8. 출력되는 내용							// Child Method
		//Q9. MAIN에서 부모 메서드 호출하기? - PARENT METHOD
		((Parent7)p).method(); //안됨 / 오버라이딩 된 메서드 직접 호출하는것은 불가능
		c.papamethod();			// 자식에서 부모호출 가능
		((Child7)p).papamethod();	// 타입캐스팅 - 부모가 자식메서드 호출가능 ( 자식생성자 호출시 )
	}
}
/*
연습문제5)  다형성
패키지명 : com.company.java012_ex
클래스명 : PolyEx005
다음과 같이 코드를 작성하시오.
class Parent7  extends Object{
   int x = 100;
   public Parent7() { super(); }
   void method() { System.out.println("Parent Method"); }
} 
class Child7 extends Parent7 {
   int x = 200;
   public Child7() { super(); }
   @Override  void method() { System.out.println("Child Method"); }
}
public class PolyEx002 {
   public static void main(String[] args) {
      Parent7 p = new Child7();     
      // Q3.  Parent7 p   보장하는 범위   
      // Q4. 인스턴스화 했을때 사용가능한 범위 : new Child7()  
      
                            Child7 c = new Child7();     
      System.out.println("p.x = " + p.x);  // Q5. 출력되는 내용   
      p.method();  // Q6. 출력되는 내용     
      System.out.println("c.x = " + c.x);   // Q7. 출력되는 내용  
      c.method();   // Q8. 출력되는 내용   
   }
}
*/