package com.company.java016_ex;

// abstract 과 interface 의 공통점과 차이점
// 공통점 : 자손객체를 통해서 코드를 구현
// 차이점 : 추상화정도가 interface 가 더 크다 
//		abstract  - 인스턴스변수, 인스턴스메서드 사용가능
//      interface - 상수     , abstract 메서드
/*
 		 Vehicle (run)
 		↑ 		↑
 MotorCycle     Car(run) @Override
*/

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
	void drive(Vehicle a) {
		a.run();
		if( a instanceof MotorCycle ) {  ((MotorCycle) a).helmet(); }
	}
}
public class Repeat001_oop8_9 {

	public static void main(String[] args) {
		Driver driver = new Driver();
		
		MotorCycle motorCycle = new MotorCycle();
		Car car = new Car();
		
		driver.drive(car); // 리턴값 메서드명(파라미터)
						   // void drive(car)   
		   				   // void drive(motorCycle) 
		System.out.println("\n\n>>자동차가 고장나서 교통수단을 바꿉니다");

		driver.drive(motorCycle);
	}

}