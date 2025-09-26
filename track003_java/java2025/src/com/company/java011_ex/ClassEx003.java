package com.company.java011_ex;

class Grand extends Object {
    public void one() { System.out.println("grand : one"); }
    public void two() { System.out.println("grand : two"); }
	@Override public String toString() { return "Grand []"; }
    
}

class Father extends Grand{
    public void three() { System.out.println("Father : three"); }

	@Override public String toString() { return "Father []"; }
    
}

class Uncle extends Grand {
	//public void one() {System.out.println("Uncle : one");}
	@Override public void two() {System.out.println("Uncle : two");}
	public void four() {System.out.println("Uncle : four");}

	}

class Aunt extends Object {
	String name = "mini";

	@Override public String toString() { return "Aunt [name=" + name + "]"; }
	
}

public class ClassEx003 {
	public static void main(String[] args) {
		Grand grand = new Grand();
		Father father = new Father();
		Uncle uncle = new Uncle();
		Aunt aunt = new Aunt();
		
		grand.one();
		grand.two();
		System.out.println();
		father.three();
		father.two();
		father.one();
		System.out.println();
		uncle.one();
		uncle.two();
	//	uncle.three();
		uncle.four();
		

//		aunt.two();
	}

}
/*
연습문제3)    클래스 상속과 메서드 호출 우선순위
패키지명 : com.company.java011_ex 
클래스명 : ClassEx003.java

1. 아래 조건에 맞게 ClassEx003.java 파일을 작성하고, 
   빈칸을 채운 뒤 main() 메서드를 실행하여 출력 결과를 예상하시오.
2. 주어진 코드 (수정 전)
```java
class Grand extends Object {
    public void one() { System.out.println("grand : one"); }
    public void two() { System.out.println("grand : two"); }
}
// (1) Father 클래스가 Grand 클래스를 상속받도록 수정
public class Father {
    public void three() { System.out.println("Father : three"); }
}

```
3. 출력 결과  
 
grand : one
grand : two
Father : three

4. 클래스 구조 설명
클래스명        상속 관계       주요 메서드
1) Object   최상위 클래스           -
2) Grand      Object → Grand         one(), two()
3) Father   Grand → Father       three()
4) Uncle      Object → Uncle 
5) Aunt      Object → Aunt     
- 모든 클래스는 Object 클래스를 기본적으로 상속받음
- Grand 클래스는 one()과 two() 메서드를 정의
- Father 클래스는 Grand를 상속받아 three() 메서드를 추가

5. 요구사항
- Father 클래스가 Grand 클래스를 상속받도록 extends 키워드를 활용할 것
- main() 메서드에서 Father 객체를 생성하고 one(), two(), three() 메서드를 순서대로 호출할 것
- 상속 관계에 따라 메서드 호출 우선순위를 이해하고 출력 결과를 정확히 예측할 것
- Uncle, Aunt 클래스도 Object를 상속받는 구조로 확장 가능하므로, 필요 시 추가 구현할 것

*/