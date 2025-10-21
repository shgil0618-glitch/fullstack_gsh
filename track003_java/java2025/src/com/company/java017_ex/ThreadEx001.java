package com.company.java017_ex;

import java.util.Scanner;

import javax.swing.JOptionPane;

class QuestionCount extends Thread{

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=10;i>0;i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class NameCheck extends Thread {
	@Override
	public void run() {
		
		String answer = JOptionPane.showInputDialog("사과 알파벳을 입력하시오.");
		System.out.println(answer.toLowerCase().equals("apple")? "정답" : "오답");
		
		
		/*
		Scanner scanner = new Scanner(System.in);
		System.out.print("사과 알파벳을 입력하세요 : ");
		String name = scanner.nextLine();
		if( name.toUpperCase().equals("APPLE") ) {
			System.out.println("정답입니다.");
		}
		else {System.out.println("정답이 아닙니다.");}
		*/
	}
	
}


public class ThreadEx001 {
	public static void main(String[] args) {
		Thread namecheck = new NameCheck(); namecheck.start();
		Thread cnt = new QuestionCount(); cnt.start();
		
		
	}
}
/*
연습문제1)  Thread
패키지명 : com.company.java016_ex
클래스명 : ThreadEx001
1.  QuestionCount  - 10부터 1까지 
      카운트 1초에 10 ,
                2초에 9, 
                3초에  8.....

2. 사과알파벳을 입력하세요.
   사과를 입력을받으면 정답입니다 / 정답이 아닙니다.
*/