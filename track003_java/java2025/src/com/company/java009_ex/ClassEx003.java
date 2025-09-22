package com.company.java009_ex;

class Coffee {
	String name;
	int price, num;

	public Coffee(String name, int num, int price) {
		this.name = name;
		this.num = num;
		this.price = price;
	}

	public Coffee() {
		this.name ="아메리카노";
		this.num = 1;
		this.price = 2000;
	}

	void show() {
		System.out.println("=====커피");
		System.out.println("커피명 : " + this.name);
		System.out.println("커피잔수 : " + this.num);
		System.out.println("커피가격 : " + this.price*this.num);
	} // 커피정보출력

	@Override
	public String toString() {
		return "Coffee [name=" + name + ", price=" + price + ", num=" + num + "]";
	}
	

}

public class ClassEx003 {
	public static void main(String[] args) {
		Coffee a1 = new Coffee("까페라떼", 2, 4000);
		a1.show();
		Coffee a2 = new Coffee();
		a2.show();
	}
}
/*
연습문제3)  class
패키지명 : com.company.java009_ex
클래스명 :  ClassEx003
-- 생성자 작성하시오.
class Coffee{
  멤버변수 : String name;  int  price, num;
  멤버함수 : void show(){}   //커피정보출력
}
public class Class003 {
   public static void main(String[] args) {
   Coffee a1 = new Coffee("까페라떼" ,2 , 4000);  a1.show();
   Coffeea2 = new Coffee();                            a2.show();
  }
}
출력내용 :
=====커피
커피명 : 까페라떼
커피잔수 : 2 
커피가격 : 8000
=====커피
커피명 : 아메리카노
커피잔수 : 1
커피가격 : 2000

*/