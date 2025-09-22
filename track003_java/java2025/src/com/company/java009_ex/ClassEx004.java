package com.company.java009_ex;

import java.util.Scanner;

class TV {
	String channel;
	int volume;


	@Override
	public String toString() {
		return "TV [channel=" + channel + ", volume=" + volume + "]";
	}

	public TV(String channel, int volume) {
		super();
		this.channel = channel;
		this.volume = volume;
	}

	public TV() {
		super();
		// TODO Auto-generated constructor stub
	}

	void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("채널 입력 : ");
		this.channel = scanner.nextLine();
		System.out.print("볼륨 입력 : ");
		this.volume = scanner.nextInt();

	}

	void show() {
		System.out.println(this.channel + "\t" + this.volume);
	}
}

public class ClassEx004 {
	public static void main(String[] args) {
		TV t1 = new TV("JDBC", 8);
		t1.show();
		TV t2 = new TV();
		t2.input();
		t2.show();
	}
}
/*
연습문제4)  class
패키지명 : com.company.java009_ex
클래스명 :  ClassEx004
-- 생성자 작성하시오.
class TV{
//상태-멤버변수  : 채널/볼륨 String channel; int volume;   
//행위-멤버함수  : 채널, 볼륨 입력: input() / 출력 : show()
}
public class ClassEx004 {
    public static void main(String[] args) {
   TV  t1 = new TV("JDBC" , 8);
   t1.show(); 
   TV  t2 = new TV();
   t2.input();  
   t2.show();
   }
}
출력내용 :
JDBC   8

* channel입력>youtube
* volume 입력>10
youtube   10
 
*/