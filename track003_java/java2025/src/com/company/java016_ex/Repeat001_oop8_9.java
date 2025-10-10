package com.company.java016_ex;

// abstract 과 interface 의 공통점과 차이점
// 공통점 : 둘 다 객체의 설계를 정의하며, 인스턴스를 직접 만들 수 없음.
// 차이점 : 추상화정도가 interface 가 더 크다 
//		abstract는 구현 일부 포함 가능, interface는 순수 메서드 선언만 가능


interface Vehicle{public void run();}
class MotorCycle implements Vehicle{
	@Override public void run()
	{System.out.println("오토바이가 달립니다.");}
	public void helmet() {System.out.println("헬멧을 착용합니다");}
}

class Car implements Vehicle{
	@Override public void run()
	{System.out.println("자동차가 달립니다.");}
}

class Driver{
	void drive(Vehicle v) {
		v.run();
		// ((MotorCycle) v).helmet();
		if( v instanceof MotorCycle ) {  ((MotorCycle) v).helmet(); }
		// v instanceof MotorCycle는 단순 클래스 확인인줄 알았는데 이게 없으면 출력에서 오류가 발생합니다 이유가 뭘까요...?
		// 답변 : 위에 상속도를 보면 하나의 부모에 두개의 자식이있는데, 누구의 자식인지 찾을려고 사용. 
		// else if로 하나 더하면 안되네. if구문 여러개로 사용
	}
}

public class Repeat001_oop8_9 {

	public static void main(String[] args) {
		Driver driver = new Driver();
		
		MotorCycle motorCycle = new MotorCycle();
		Car car = new Car();
		
		driver.drive(car); 

		System.out.println("\n\n>>자동차가 고장나서 교통수단을 바꿉니다");

		driver.drive(motorCycle);
	}

}