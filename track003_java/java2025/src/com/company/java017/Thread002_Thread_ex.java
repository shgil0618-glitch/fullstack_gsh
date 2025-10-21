package com.company.java017;

// 수행클래스 1) Thread 상속 2) run 실행해야하는 내용 3) start 실행

class Cow extends Thread {
	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("음메#" + (i+1) + " ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class Chichen extends Thread {
	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("꼬끼오#" + (i+1) + " ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class Thread002_Thread_ex {
	public static void main(String[] args) {
		Thread cow = new Cow(); cow.start();
		Thread chichen = new Chichen(); chichen.start();
	}
}
