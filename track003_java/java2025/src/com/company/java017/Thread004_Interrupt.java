package com.company.java017;
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
////////////////////////////////////////////////방법2)
	 	@Override public void run() {
		for(int i=0;i<10;i++) {
			if(Thread.currentThread().isInterrupted()) {	// 방해를 받았었다.
				System.out.println("판매 중단 요청됨.");
				break;
			}
			super.sell();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {		
				System.out.println("판매중 인터럽트 발생!");
				// 인터럽트 상태를 상태복수 -> isInterrupted() true로 감지
				Thread.currentThread().interrupt();		//방해를 받았다.
			}
		}
////////////////////////////////////////////////
//////////////////////////////////////////////// 방법1)
		/*
		for(int i=0;i<10;i++) {
			
			super.sell();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {		//interupt 요청 받았을때 실행
				System.out.println("판매 중단 요청됨.");
				break;			// 반복종료 = 방법1
			}
		}
		*/
//////////////////////////////////////////////
	}
	
}

// 문제점 확인 : 손님이 없는데.... 가 1개 팔렸습니다. 계속 처리됨 끄는 방법은?
public class Thread004_Interrupt {
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
		System.out.println(".... 손님이 없어서 판매를 중단합니다.");
		seller.interrupt(); 	//###### 스레드 중단 요청1) 
		
		
		
	}
}
