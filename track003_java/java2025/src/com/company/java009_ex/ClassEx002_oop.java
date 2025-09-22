package com.company.java009_ex;

import java.util.Scanner;

class MyPrice001 {
	String name;
	int price;

	void input() /* 입력받는 기능 */
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("상품이름 입력 : ");
		this.name = scanner.nextLine();
		System.out.print("상품가격 입력 : ");
		this.price = scanner.nextInt();

	}

	void show() /* 출력해주는 기능 */
	{
		System.out.println("상품정보입니다.");
		System.out.println("상품이름: " + this.name + "\t /\t" + "상품가격: " + this.price);
	}
}

public class ClassEx002_oop {
	public static void main(String[] args) {
		MyPrice001 p1 = new MyPrice001();
		p1.input();
		p1.show();
	}
}
/*
연습문제2)  class
패키지명 : com.company.java009_ex
클래스명 :  ClassEx002
class MyPrice001{
  멤버변수 : String name;  int price;
  멤버함수 : void input()  입력받는 기능 / void show()  출력해주는 기능
}
public class ClassEx002{
   public static void main(String[] args) {
        MyPrice001   p1 = new MyPrice001();
        p1.input();
        p1.show();
   }
}
출력내용 : 
  상품이름 입력 >  apple
  상품가격 입력 >  1500

  상품정보입니다
  상품이름 : apple  / 상품가격 : 1500
*/