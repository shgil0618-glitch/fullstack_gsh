package com.company.java008_ex;

public class MethodEx003 {
	public static void main(String[] args) {
		printProfile("홍길동", 25, "서울");
		checkAge(17);   
		repeatMessage("안녕하세요!", 3); 
		drawBox(5, '#');  
	}
	public static void printProfile(String name, int age, String contry) {
		System.out.println("=== 사용자 프로필 ===");
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("지역 : " + contry);
		System.out.println("===================");
	}
	public static void checkAge(int age) {
		if(age >= 19) {
			System.out.println("성인입니다");
		}
		else {System.out.println("미성년자 입니다.");}
	}
	public static void repeatMessage(String ch, int num) {
		for(int i =0; i<num;i++) {
			System.out.println(ch);
		}
	}
	public static void drawBox(int score, char ch) {
		for(int i=0;i<score;i++) {
			for(int j=0;j<score;j++) {
				System.out.print(ch);
			}
			System.out.println();
		}
	}
	
}

/*
패키지명 : com.company.java008_ex 
클래스명 : MethodEx003 다음과 같이 
printProfile(), checkAge(), repeatMessage(), drawBox() 메서드를 정의하시오.

public static void main(String[] args) {
    // public static 리턴값 메서드명(파라미터)
    printProfile("홍길동", 25, "서울");   // 이름, 나이, 지역 출력
    checkAge(17);                      // 미성년자 여부 판단
    repeatMessage("안녕하세요!", 3);     // 메시지 반복 출력
    drawBox(5, '#');                   // 문자로 박스 출력
}
■ 출력 예시
=== 사용자 프로필 ===
이름: 홍길동
나이: 25
지역: 서울
===================
미성년자입니다.
안녕하세요!
안녕하세요!
안녕하세요!
#####
#####
#####
#####
#####
*/
