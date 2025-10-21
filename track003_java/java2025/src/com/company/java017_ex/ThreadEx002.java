package com.company.java017_ex;
// 1. Candy를 Mento 클래스가 상속받는 경우 1초에 1개팔렸다고 실행클래스 만들려고함.


class Candy {
	String name;
	public void sell() {System.out.println(this.name+"가 1개 팔렸습니다.");}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

class MentolSeller extends Candy implements Runnable{	// 2. MentolSeller extends Thread 불가능. 여기서 사용할 수 있는거는 Runnable 이용
// 3. 구현내용 run 1초에 Thread.sleep(1000) 1개씩 팔렸다.
	 public MentolSeller(String name) {
	        setName(name);  
	    }
	@Override public void run() {
		while(true) {
			
			super.sell();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

// 문제점 확인 : 손님이 없는데.... 가 1개 팔렸습니다. 계속 처리됨 끄는 방법은?
public class ThreadEx002 {
	public static void main(String[] args) {
// 4. MentolSeller start 실행해주기
		Thread seller =new Thread(new MentolSeller("멘톨캔디")); 
		//seller.setName("멘톨캔디");
		seller.start();
		
		for(int i=0;i<5;i++) {
			System.out.println("손님 기다리는 중.....");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		seller.stop();
	}
}
