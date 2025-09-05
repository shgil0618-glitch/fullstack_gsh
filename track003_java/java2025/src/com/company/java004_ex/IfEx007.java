package com.company.java004_ex;

import java.util.Scanner;

public class IfEx007 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1, num2;
        char ch;
        double result = 0.0;
        boolean check1 = true;

        System.out.print("정수 하나를 입력하시오 : ");
        num1 = scanner.nextInt();
        System.out.print("정수 하나를 입력하시오 : ");
        num2 = scanner.nextInt();
        System.out.print("연산자 하나를 입력하시오(+,-,*,/) : ");
        ch = scanner.next().charAt(0);

        if (ch == '+') {
            result = num1 + num2;
        } else if (ch == '-') {
            result = num1 - num2;
        } else if (ch == '*') {
            result = num1 * num2;
        } else if (ch == '/') {
           result = (double) num1 / num2;}
            else { check1 = false;}

        if (check1) {
            System.out.printf(
                (result == (int) result) ? "%d %c %d = %d\n" : "%d %c %d = %.2f\n",
                num1, ch, num2,
                (result == (int) result) ? ((int) result) : result
            );
        } else {
            System.out.println("올바른 연산자를 입력하시오");
        }
    }
}
/*
 * | 항목    | 설명                                                                  |
| ----- | ------------------------------------------------------------------- |
| ❌ 문제점 | 삼항 연산자 결과가 `int` 또는 `double`일 수 있어서 `printf(Object...)` 인자 타입 추론 실패 |
| 🎯 원인 | primitive 타입은 박싱 없이 삼항 연산자에서 공통 `Object` 타입으로 자동 변환 안 됨             |
| ✅ 해결  | `(Object)(Integer)` / `(Object)(Double)` 으로 **명시적 박싱 + 업캐스팅**       |
| 💡 결과 | `printf`에 타입 맞게 안전하게 인자 전달 가능                                       |
 */

/*

연습문제7)   
패키지명 : com.company.java004_ex
클래스명 :  IfEx007
출력내용 :  계산기

1. 정수를 하나 입력해주세요 > 10
2. 정수를 하나 입력해주세요 > 3
3. 연산자를 입력해주세요(+,-,*,/) > +
10+3=13

1. 정수를 하나 입력해주세요 > 10
2. 정수를 하나 입력해주세요 > 3
3. 연산자를 입력해주세요(+,-,*,/) > -
10-3=7 
*/