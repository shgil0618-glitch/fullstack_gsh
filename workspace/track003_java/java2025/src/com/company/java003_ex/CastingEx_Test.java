package com.company.java003_ex;

import java.util.Scanner;

public class CastingEx_Test {
	public static void main(String[] args) {
		int walk, exer, sleep;
		int walkct,exerct,sleepct,total,hlevel;
		double avg;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1. 사용자로부터 다음 세 가지 정보를 입력받습니다.");
		System.out.print("하루 걸음 수 (예: 7500) : ");
		walk = scanner.nextInt();
		System.out.print("운동 시간 (분 단위, 예: 45) : ");
		exer = scanner.nextInt();
		System.out.print("수면 시간 (시간 단위, 예: 7) : ");
		sleep = scanner.nextInt();
		
		walkct = walk/1000;
		exerct = exer/10;
		sleepct = sleep*2;
		total = walkct+exerct+sleepct;
		avg = total/3.0;
		hlevel = (int)avg/2;
		
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println(":: HEALTH TRACKER ::");
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("걸음수   운동시간   수면시간   총점    평균   건강레벨");
		System.out.printf("%-5d\t%-5d\t%-5d\t%-5d\t%-5.2f\t%-5d\n",walk, exer, sleep, total, avg, hlevel);	
		
	}
}


/*
번외문제) 건강 점수 계산기 만들기
당신은 건강 추적 애플리케이션의 초기 버전을 개발 중입니다. 사용자의 하루 활동 데이터를 입력받아 건강 점수를 계산하고, 평균 점수를 기반으로 건강 레벨을 출력하는 프로그램을 작성하세요.

● 요구사항

1. 사용자로부터 다음 세 가지 정보를 입력받습니다:
   - 하루 걸음 수 (예: 7500)
   - 운동 시간 (분 단위, 예: 45)
   - 수면 시간 (시간 단위, 예: 7)

2. 각 항목을 다음 기준으로 점수화합니다:
   - 걸음 수: 1000걸음당 1점
   - 운동 시간: 10분당 1점
   - 수면 시간: 1시간당 2점

3. 총점과 평균 점수를 계산합니다.
   - 평균은 `double` 타입으로 계산하며 소수점 둘째 자리까지 출력합니다.

4. 평균 점수를 기준으로 건강 레벨을 산정합니다:
   - 건강 레벨 = 평균 점수를 `int`로 변환한 후 2로 나눈 값

5. 다음 형식으로 결과를 출력합니다:
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
:: HEALTH TRACKER ::
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
걸음수   운동시간   수면시간   총점   평균   건강레벨
7500   45      7      22   7.33   3

● 조건

- `Scanner` 클래스를 사용하여 입력을 처리할 것
- `System.out.printf`를 사용하여 평균 점수를 소수점 둘째 자리까지 출력할 것
- 형 변환을 적절히 사용할 것 (`(int)` 등)

 */