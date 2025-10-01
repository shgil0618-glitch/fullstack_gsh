package com.company.java013_ex;

import java.util.Calendar;

interface Launch{  int MONEY=10000;  void eat(); }
class Burger      implements Launch{ 
	int price;
	public Burger() { this.price = 3900; }
	@Override public String toString() { return "Burger"; }
	@Override public void eat() { System.out.println("Burger 냠냠!"); } 
}
class KimchiStew  implements Launch{ 
	int price;
	public KimchiStew() { this.price = 4000; }
	@Override public String toString() { return "KimchiStew"; }
	@Override public void eat() { System.out.println("KimchiStew 냠냠!"); } 
}
class User{
	int money;
	int cnt;
	Launch[] plate;
	public User() { this.money = Launch.MONEY; plate = new  Launch[3];     cnt = 0; }
	
	void order(Launch a) {  // Launch a = new Burger(); / Launch a = new KimchiStew();
		//1. 주문한 메뉴의 값 확인
		int temp=0;
		     if(  a  instanceof  Burger     ) {System.out.println("버거하나요~ ");   temp     =((Burger)a).price;}
		else if(  a  instanceof  KimchiStew ) {System.out.println("김치찌개하나요~ ");temp =((KimchiStew)a).price;}
		
		//2. 내가 가진돈 확인 
		if(money<temp) {  System.out.println(">> 잔액부족 주문불가능");  return;  }
		money-=temp;
		
		//3. plate에 주문받은거 넣기 
		plate[cnt++] = a;       //System.out.println( money + "-" + Arrays.toString(plate)  );
		
	}  // 주문   버거하나요~   김치찌개하나요~  버거하나요~  /  잔액부족 주문불가능
	
	void  show() {
		String order="주문 : ";
		for(  int i=0; i<cnt; i++ ) {  order+=  ((i!=0)? ",":" ") +  plate[i];  }
		System.out.println("\n\n" + order);
		System.out.println("주문금액 : " + (Launch.MONEY - money));
		System.out.println("잔액    : " + money);
		
		Calendar today = Calendar.getInstance();  
		//System.out.println(today);
		System.out.println(today.get(1)   + "년 " +  //년
		                 (today.get(2)+1) + "월 " +  //월 0~11 (0 : 1월)
				             today.get(5) + "일 " ); //일
		
		//java.lang.NullPointerException - 공간은 있으나 값이 없다.
		//for(Launch a : plate){ a.eat(); }   //부모에서 메서드호출시 @Override- 자식메서드 호출
		for(  int i=0; i<cnt; i++ ) {   plate[i].eat();  }
	}   
}
 
/* 연관관계
	 			     <<interface>>   static final  MONEY=10000   
User        →            Launch		abstract      void eat();	 		
money				  		↑     ↑
plate				 Burger        KimchiStew
				 	price=3900     price=4000
				 	eat()          eat()        @Override 

*/


public class InetrfaceEx003_2 {
	public static void main(String[] args) {
		 User launch_order = new User();
		     		//리턴값 메서드명(파라미터)
		launch_order.order(new Burger());   //void order(Launch a){}
		launch_order.order(new KimchiStew());   //Launch a = new Kimchi()  부모=자식
		launch_order.order(new Burger());   //Launch a = new Burger()  부모=자식
					
		launch_order.show();//리턴값 메서드명(파라미터)
		// void   show(){}
	}
}

/*

연습문제3)  
패키지명 :  package com.company.java013_ex;
클래스명 :  public class InterfaceEx003

1. 인터페이스를 활용한 점심 주문 시뮬레이션
다음은 점심 메뉴 주문을 인터페이스로 추상화한 프로그램이다. 
Launch 인터페이스는 모든 메뉴가 공통적으로 가져야 할 기능을 정의하며, 
Burger, KimchiStew 클래스는 이를 구현하여 각각의 메뉴 정보를 제공한다. 
User 클래스는 메뉴를 주문하고, 주문 내역을 출력하는 기능을 담당한다.

2. 주어진 조건
interface Launch {
    int MONEY = 10000;
    void eat();
}
class Burger      implements Launch{ 
	int price;
	public Burger() { this.price = 3900; }
	@Override public String toString() { return "Burger"; }
	@Override public void eat() { System.out.println("Burger 냠냠!"); } 
}
class KimchiStew  implements Launch{ 
	int price;
	public KimchiStew() { this.price = 4000; }
	@Override public String toString() { return "KimchiStew"; }
	@Override public void eat() { System.out.println("KimchiStew 냠냠!"); } 
}
class User {  
    int money;
    int cnt;
    Launch[] plate;
- order(Launch a) 메서드로 메뉴 주문
  주문 시 메뉴 종류에 따라 가격 확인
  잔액 부족 시 주문 거절
  주문 성공 시 배열에 저장
- show() 메서드로 주문 내역 출력
  주문한 메뉴 목록
  총 주문 금액
  잔액
  오늘 날짜
  각 메뉴의 eat() 호출
}
3. main
public class InterfaceEx004_Ex {
	public static void main(String[] args) {
		 User launch_order = new User();
		 								     //리턴값 메서드명(파라미터)
		 launch_order.order(new Burger());   //void order(Launch a){}
		 launch_order.order(new KimchiStew());   //Launch a = new Kimchi()  부모=자식
		 launch_order.order(new Burger());   //Launch a = new Burger()  부모=자식
		 									
		 launch_order.show();//리턴값 메서드명(파라미터)
		 				     // void   show(){}
	}
}


4. 실행 예시 
버거하나요~ 
Burger 냠냠!
김치찌개하나요~ 
KimchiStew 냠냠!
버거하나요~ 
Burger 냠냠!


주문 :  Burger, KimchiStew, Burger
주문금액 : 11800
잔액    : -1800
2025년 9월 30일
Burger 냠냠!
KimchiStew 냠냠!
Burger 냠냠!
※ 실제 실행 결과는 날짜 및 주문 순서에 따라 달라질 수 있습니다.
*/