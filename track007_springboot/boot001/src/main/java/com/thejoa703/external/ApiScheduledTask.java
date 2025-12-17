package com.thejoa703.external;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class ApiScheduledTask {
	
	/*
	 * @Scheduled(fixedRate = 5000) // 1000이 1초
	 * public void runTesk1() {
	 * System.out.println(".......스케쥴러 실행중 : " + System.currentTimeMillis()); }
	 */
	
//	@Scheduled(fixedDelay = )	// 어떤 작업이 끝난후에 지정된 시간에 실행
	@Scheduled(cron="0 39 12 * * ? ")	//	초 분 시 날짜 월 요일 
	public void runTesk2() {
		System.out.println(".......스케쥴러 실행중 : " + System.currentTimeMillis()); 
	}
}


/****************************
  1. 스케쥴링 구동
@SpringBootApplication
@EnableScheduling
public class Boot001Application { 
  2. 스케쥴링 부품
@Component
public class ApiScheduledTask {
@Scheduled(fixedRate = 5000) // 1000이 1초 5초마다 실행
@Scheduled(fixedDelay = )	// 어떤 작업이 끝난후에 지정된 시간에 실행
@Scheduled(cron="0 37 12 * * ? ")	//
public void runTesk1()
cron="0 0 0  * * ? ")	//	0초 0분 0시 일 월 요일(?특정하지 않음)  - 매월 자정
cron="0 0 12  * * ? ")	//	0초 0분 12시 일 월 요일(?특정하지 않음)  - 매월 정오
cron="0 30 18  * * ? ")	//	0초 30분 18시 일 월 요일(?특정하지 않음) 
cron="0 0 0  1 * ? ")	//	매월 1일 자정
cron="0 0 0  ? * MON ")	//	매주 월요일 자정

 * 제한없는 모든값
 ? 특정값 없음

 ****************************/

/*
- 스케쥴링
- naver 개발자 (api 보기기본)
- mail
- 크롤링
- map
- chatgpt ★
- Kma 
- coolsms (인증번호 문자)
- kakaopay
***************************
 
 */
