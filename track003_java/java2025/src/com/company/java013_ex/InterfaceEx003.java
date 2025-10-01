/*
package com.company.java013_ex;


interface Launch {
    int MONEY = 10000;

    void eat();

    int getPrice();  // check1.  인터페이스에 getPrice() 선언한 건 좋음. 다만 MONEY를 사용하는 방식은 아래에서 개선 가능.
}

class Burger implements Launch {
    int price;

    public Burger() {
        this.price = 3900;
    }

    @Override
    public String toString() {
        return "Burger";
    }

    @Override
    public void eat() {
        System.out.println("Burger 냠냠!");
    }

    @Override
    public int getPrice() {
        return price;
    }
}

class KimchiStew implements Launch {
    int price;

    public KimchiStew() {
        this.price = 4000;
    }

    @Override
    public String toString() {
        return "KimchiStew";
    }

    @Override
    public void eat() {
        System.out.println("KimchiStew 냠냠!");
    }

    @Override
    public int getPrice() {
        return price;
    }
}

class User {
    int money = 0;  // check2.   개선 필요: Launch.MONEY로 초기화하면 잔액 계산이 더 직관적임
    String menu[] = {"","",""}; // check3  개선 필요: 메뉴 이름만 저장하므로 eat() 호출 불가. Launch[] plate로 바꾸면 다형성 활용 가능
    int cnt = 0;

    public void order(Launch a) {
        System.out.println(a + " 하나요~");
        a.eat();  // check4.  eat() 호출은 좋음

        money += a.getPrice();  // check5. 개선 필요: 주문 전에 잔액 확인 로직이 없음. 돈이 부족해도 주문됨

        menu[cnt] += (a.toString());  // check6. 개선 필요: 객체 저장이 아니라 문자열만 저장됨 → eat() 반복 호출 불가
        cnt++;
    }

    void show() {
        System.out.print("주문 : ");
        for (int i = 0; i < menu.length; i++) {
            System.out.print(menu[i]);
            if (i < menu.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        System.out.println("주문금액 : " + money);

        if(Launch.MONEY - money > 0) {
            System.out.println("잔액 : " + (Launch.MONEY - money));
        } else {
            System.out.println("잔액이 부족합니다.   잔액: " + Launch.MONEY);  // check7. 개선 필요: 실제 잔액이 아니라 초기값 출력됨
        }

         // check8. 개선아이디어 :  주문한 메뉴의 eat()를 반복 출력하려면 Launch[] plate 구조가 필요함
         //                               날짜 출력 기능 추가하면 사용자 경험 향상됨
    }
}

public class InterfaceEx003 {
    public static void main(String[] args) {
        User launch_order = new User();
        launch_order.order(new Burger());
        launch_order.order(new KimchiStew());
        launch_order.order(new Burger());

        launch_order.show();
    }
}

*/

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