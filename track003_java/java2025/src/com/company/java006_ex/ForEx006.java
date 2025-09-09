package com.company.java006_ex;

import java.util.Scanner;

public class ForEx006 {
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int num1=-1, num2=-1;
	char ch = ' ';
	double result = 3.14;
	
	for(;;) {//1.무한반복 ##
		if(!(num1>=0 && num1<=100)) {	//1-1. 0~100범위가 아니라면 0
			System.out.print("숫자1을 입력하시오 : ");	// 1-2. 입력받기
			num1 = scanner.nextInt();	
			continue;	//1-3. 아래쪽 진행하지 말것! skip 건너뛰기! 잘 입력받았는지 체크
		}
		if(!(num2>=0 && num2<=100)) {
			System.out.print("숫자2을 입력하시오 : ");
			num2 = scanner.nextInt();
			continue;
		}
		if(!(ch=='+' || ch=='-' || ch=='*'|| ch=='/')) {
			System.out.print("연산자를 입력하시오 : ");
			ch = scanner.next().charAt(0);
			continue;
		}
		break;	// break를 만났다면 num1,num2,ch 잘 쓴 경우
		
		
	}
	
	
	
	}
}

/*
연습문제6)  for 무한반복
패키지명 : com.company.java006_ex
클래스명 :  ForEx006
출력내용 :  계산기

1)  각 연산자에 맞게 계산처리
2)  숫자1, 숫자2는 0~100사이만 입력가능하게 아니면 무한반복
3)  연산자는 +, - ,*, /만 입력가능하게 아니면 무한반복
     

1. 정수를 하나 입력해주세요 > 10   
2. 정수를 하나 입력해주세요 > 3
3. 연산자를 입력해주세요(+,-,*,/) > +
10+3=13
*/
