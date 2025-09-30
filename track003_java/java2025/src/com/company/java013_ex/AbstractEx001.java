package com.company.java013_ex;



/*   Abstract  : 일반클래스 + 설계 - 추상클래스: 공통기능 설계

Object
  ↑
 Robot {   abstract charge() , move() , speak() }
↑          ↑               ↑ 
CleaningRobot  SecurityRobot   CookingRobot   
{@charge() ,    {@charge() ,    {@charge() ,
@ move() ,     @move() ,       @move() , 
@ speak() }}    @speak() }}     @speak() }}
*/

abstract class Robot{
	String model; int batteryLevel;
	abstract void charge();	//충전방식
	abstract void move();	//이동방식
	abstract void speak();	//말하기방식
}
class CleaningRobot extends Robot {
	@Override void charge() { System.out.println(super.model + " 청소로봇 충전 중... 베터리" + super.batteryLevel + "%");   }
	@Override void move() 	{ System.out.println(super.model + " 청소로봇: 먼지를 제거합니다!");  }
	@Override void speak() 	{ System.out.println(super.model + " 청소로봇: 반가워요!"); } 
	
}
class SecurityRobot extends Robot {
	@Override void charge()	{ System.out.println(super.model +" 경비로봇 태양광 충전 중... 베터리" + super.batteryLevel + "%");   }
	@Override void move()	{ System.out.println(super.model + " 경비로봇: 이상 없음. 안전 확보!");   }
	@Override void speak()	{ System.out.println(super.model + " 경비로봇: 반가워요!");   }
	
}
class CookigRobot extends Robot {
	@Override void charge()	{ System.out.println(super.model + " 요리로봇 인덕션 충전 중... 베터리" + super.batteryLevel + "%");   }
	@Override void move()	{ System.out.println(super.model + " 요리로봇: 오늘의 메뉴는 파스타입니다!");  }
	@Override void speak()	{ System.out.println(super.model + " 요리로봇: 반가워요!");   }
	
}


public class AbstractEx001 {
	public static void main(String[] args) {
	// Robot robot = new Robot();	//Q1) 설계만 되있고, 구현부가 없기때문에 에러
		//	부모		=			자식1					자식2						자식3
		Robot bots[] = {new CleaningRobot(), new SecurityRobot(), new CookigRobot()} ;
		bots[0].batteryLevel=50;
		bots[1].batteryLevel=70;
		bots[2].batteryLevel=95;
		
		
	    System.out.println("--- 로봇 배열 시뮬레이션 ---");
	    int cnt = 0;
        for (Robot bot : bots) {
        	bot.model = "Robot" + ++cnt; 
            bot.charge();
            bot.move();
           // bot.speak();
        }
        // bots[0] = 1번지 CleaningRobot{@charge(), @move(), @speak() } - Robot{model,batteryLevel,charge(), move(), speak()}
        // bots[1] = 2번지 SecurityRobot{@charge(), @move(), @speak() } - Robot{model,batteryLevel,charge(), move(), speak()}
        // bots[2] = 3번지 CookigRobot{@charge(), @move(), @speak() } - Robot{model,batteryLevel,charge(), move(), speak()}
	}
}

/*
heap area: 동적,배열              stack area : 임시
1번지{model, battery, charge()X} ← robot(1번지)
 
--- 로봇 배열 시뮬레이션 ---
Robo1 청소로봇 충전 중... 배터리 50%
Robo1 청소로봇: 먼지를 제거합니다!
Robo2 경비로봇 태양광 충전 중... 배터리 70%
Robo2 경비로봇: 이상 없음. 안전 확보!
Robo3 요리로봇 인덕션 충전 중... 배터리 95%
Robo3 요리로봇: 오늘의 메뉴는 파스타입니다!
*/
