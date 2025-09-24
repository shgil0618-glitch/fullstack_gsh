package com.company.java010_ex;


class LunchTray {
	//멤버변수
    String owner;        // 인스턴스 변수
    int rice = 90;         //	인스턴스 변수      
    int soup = 85;         //	인스턴스 변수
    String std = "";
    static int trayCount = 0;      // 클래스 변수
    // static int totalFood = rice + soup;	// 클래스 변수 // 클래스변수에 인스턴스 변수가 들어가서 오류 (먼저 할당받아야하는데 값이 없는 현상 발생)
    int totalFood = rice + soup;
    static int maxRice = 100;       // 클래스 변수
    
    
    
    public LunchTray() {
    	this.owner = "std-" + ++trayCount;
	}
    
    

	public int getFoodAmount() {	// 인스턴스 메서드
        return rice + soup;         
    }

    public static void showTrayCount() {	// 클래스 메서드
    	
        System.out.println("전체 급식판 수: " + trayCount);   
    }

   // public static void showOwner() { 	// 클래스 메서드
    public static void showOwner() { 
	//	 System.out.println(this.owner);			// 클래스 메서드에 인스턴스 변수가 들어감
    
	
    }

    public void showTray() {	// 인스턴스 메서드
        System.out.println("\n\n:: 주인 이름: " + this.owner);                
        System.out.println("총 음식량: " + getFoodAmount());     
    }
}


public class MemberVarEx003 {
   public static void main(String[] args) {
        LunchTray tray1 = new LunchTray();   
        tray1.showTray();                    
        LunchTray.showTrayCount();         

        LunchTray tray2 = new LunchTray();   
        tray2.showTray();                   
        LunchTray.showTrayCount();         
   }
} 
/*
 ------------------------[ runtime data area]
[method: 정보, static, final : 공용정보]
> LunchTray.class / MemberVarEx003.class
> static : LunchTray.trayCount, LunchTray.maxRice, LunchTray.showTrayCount(), LunchTray.showOwner
------------------------------------
[heap: 동적]           			 | [stack : 잠깐빌리기]
2번지{pay=0, showall001()}		<-	tray2[2번지]
1번지{pay=0, showall001()}		<-	tray1[1번지]
									main
------------------------------------
 
 
연습문제3)  멤버변수
패키지명 : com.company.java010_ex
클래스명 :  MemberVarEx003
//- 문제 1. 다음 코드에서 인스턴스변수, 클래스변수, 지역변수를 구분하시오.  ( 보관되는 영역도 추가 )
//- 문제 2. 인스턴스메서드와 클래스메서드를 구분하시오.  
//- 문제 3. 오류가 발생하는 이유를 설명하시오.
//- 문제 4. runtime data area 위치영역 그림그리기
//- 문제 5. 다음과 같이 출력되도록 코드를 작성하시오.
:: 주인 이름: std-1
총 음식량: 175
전체 급식판 수: 1


:: 주인 이름: std-2
총 음식량: 175
전체 급식판 수: 2

 
class LunchTray {
    String owner;        
    int rice = 90;               
    int soup = 85;               

    static int trayCount = 0;      

    static int totalFood = rice + soup;

    static int maxRice = 100;       

    public int getFoodAmount() {
        return rice + soup;         
    }

    public static void showTrayCount() {
        System.out.println("전체 급식판 수: " + trayCount);   
    }

    public static void showOwner() { 
       System.out.println(owner);
    }

    public void showTray() {
        System.out.println("\n\n:: 주인 이름: " + owner);                
        System.out.println("총 음식량: " + getFoodAmount());     
    }
}


public class MemberVarEx003 {
   public static void main(String[] args) {
        LunchTray tray1 = new LunchTray();   
        tray1.showTray();                    
        LunchTray.showTrayCount();         

        LunchTray tray2 = new LunchTray();   
        tray2.showTray();                   
        LunchTray.showTrayCount();         
   }
} 






*/