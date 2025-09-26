package com.company.java011_ex;

/* 클래스의 재사용
Object      {         }
  ↑
MobileNote   { show() }
  ↑
MobileNote7   { iris,face / newShow() } 
  ↑
MobileNote8   { ◎face     / ◎newShow() }  
  ↑
MobileNote9   { battery   / ◎newShow() } 

----------------------------------------------
MobileNote8 my8 = new MobileNote8();
----------------------------------------------

----------------------------------------------
MobileNote7 my7 = new MobileNote7();
----------------------------------------------
1.     MobileNote7  는    MobileNote 이다.
2.     생성자호출순서 :  MobileNote7()  → MobileNote()  → Object()
3.     객체생성순서  :  Object → MobileNote → MobileNote7 
    1번지 : { iris,face / newShow() } - { show() }
    2번지 : {face / newsnow() } -> { iris,face / newShow() } -> { show() }
    3번지 : { battery / newshow() } -> {face / newsnow() } -> { iris,face / newShow() } -> { show() }
    
    Q. note8, note7의 newshow() 호출방법은?
*/

class MobileNote{
	
	@Override
	public String toString() { return "MobileNote []"; }
	void show() {}
	
}
class MobileNote7 extends MobileNote {
	 private String iris;
	 private String face;
	 
	 public String getIris() { return iris; }  public void setIris(String iris) { this.iris = iris; }  
	public String getFace() { return face; }  public void setFace(String face) { this.face = face; }
	
	void newShow() {
		super.show();
		System.out.println("NOTE7 객체 기능(Overriding)");
		System.out.println("iris : "+this.getIris());
		System.out.println("face : "+this.getFace());
	}


}
class MobileNote8 extends MobileNote7 {
	private String face;
	public String getFace() { return face; }  public void setFace(String face) { this.face = face; }
	
	void newShow() {
		super.newShow();
		System.out.println("NOTE8 객체 기능(Overriding)");
		System.out.println("face : "+this.getFace());
	}

}
class MobileNote9 extends MobileNote8 {
	private int battery ;
	public int getBattery() { return battery; }  public void setBattery(int battery) { this.battery = battery; } 
	
	 void newShow() {
		 super.newShow();
		System.out.println("NOTE9 객체 기능(Overriding)");
		//System.out.println("iris : "+this.getIris());
		//System.out.println("face : "+this.getFace());
		System.out.println("battery : "+this.getBattery());
		
	}

	
	

}

public class ClassEx002 {
    public static void main(String[] args) {
    	/*
        MobileNote7 my7 = new MobileNote7();
        my7.setIris("brown");
        my7.setFace("pretty");
        my7.newShow();

        MobileNote8 my8 = new MobileNote8();
        my8.setFace("pretty");
        my8.newShow();

        MobileNote9 my9 = new MobileNote9();
        my9.setBattery(24);
        my9.newShow();
        */
    	
    	MobileNote9 my92 = new MobileNote9();
        my92.setIris("black");
        my92.setFace("cuty");
        my92.setBattery(24);
        my92.newShow();
        
    }
}
/*
연습문제2)     클래스 상속과 메서드 오버라이딩
패키지명 : com.company.java011_ex 
클래스명 : ClassEx002.java

1. 아래 조건에 맞게 ClassEx002.java 파일을 작성하고,
   main() 메서드를 수정하여 다음과 같은 출력 결과가 나오도록 하시오.
2. 주어진 코드 (수정 전)
```java
public class ClassEx002 {
    public static void main(String[] args) {
        MobileNote7 my7 = new MobileNote7();
        my7.setIris("brown");
        my7.setFace("pretty");
        my7.newShow();

        MobileNote8 my8 = new MobileNote8();
        my8.setFace("pretty");
        my8.newShow();

        MobileNote9 my9 = new MobileNote9();
        my9.setBattery(24);
        my9.newShow();
    }
}
```
3. 출력 결과 

NOTE7 객체 기능(Overriding)
iris = brown
face = pretty

NOTE8 객체 기능(Overriding) 추가
face = pretty

NOTE9 객체 기능(Overriding) 추가
battery 예쁘게 사용하기!
battery = 24

4. 클래스 구조 설명
클래스명      멤버변수        멤버메서드
MobileNote   없음                        void show()
MobileNote7   String iris, String face  void newShow()
MobileNote8   String face                 void newShow()
MobileNote9   int battery                 void newShow()
모든 멤버변수는 private으로 선언

-각 클래스는 MobileNote 클래스를 상속받음
-newShow() 메서드는 각 클래스에서 오버라이딩되어 고유한 출력 형식을 가짐

5. 요구사항
-MobileNote 클래스를 기반으로 상속 구조를 설계할 것 (MobileNote7, MobileNote8, MobileNote9 모두 상속)
-각 클래스에서 setter 메서드를 통해 멤버변수 값을 설정할 수 있도록 구현할 것
-newShow() 메서드를 오버라이딩하여 출력 형식을 문제에서 제시한 형태로 맞출 것
-출력 순서와 내용이 정확히 일치하도록 main() 메서드를 구성할 것

*/