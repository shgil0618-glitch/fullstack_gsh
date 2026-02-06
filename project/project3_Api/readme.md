# 🍽️ 오늘 뭐먹지? v2

Spring Boot 기반 레시피 추천 UGC 웹 서비스 (기능 고도화 프로젝트)

---

## 1. 프로젝트 개요

**“오늘 뭐먹지?” v2**는 기존 v1 프로젝트를 기반으로 **UI/UX 개선**, **검색 기능 고도화**, **외부 API 연동**, **소셜 로그인**, **데이터 구조 최적화**를 목표로 한 팀 프로젝트입니다.
사용자와 관리자의 관점을 모두 고려하여 **편의성·비용·유지보수성**을 함께 개선하는 데 집중했습니다.

* **프로젝트 성격**: 팀 프로젝트 (기능 확장 & 구조 개선)
* **목표**: 실사용을 고려한 UGC형 레시피 서비스 고도화

---

## 2. 기간 / 인원

* **기간**: 2025.12.18 ~ 2026.01.02
* **인원**: 4명

---

## 3. 기술 스택

### Backend

* Java 11 (JDK 11)
* Spring Boot 2.7 (MVC, Security)
* MyBatis 3.5
* RESTful API

### Database

* Oracle 11g

### Frontend

* HTML5 / CSS3
* Bootstrap 5
* Thymeleaf

### Others

* JSON
* External API (자동완성, 번역, 비속어 필터링, 알러지 정보 등)

---

## 4. 주요 기능

* 기존 프로젝트(v1) 대비 **UI/UX 전반 개선**
* 레시피 검색 기능 고도화

  * 검색어 / 카테고리 / 정렬 기준 세분화
* 소셜 로그인 및 보안 기능

  * 소셜 로그인
  * 봇 자동 가입 방지
  * 비정상 사용자 탐지 및 알림 메일 발송
* 외부 API 연동

  * 자동 완성 / 자연어 검색
  * 비속어 자동 검출
  * 공공데이터 기반 알러지 정보 제공
  * 외부 구매 URI 연동
  * 댓글 자동 번역
  * 한 줄 요약 API

---

## 5. 담당 업무 및 성과

### 1) 사용자 · 관리자 중심 기능 개선
![alt text](https://raw.githubusercontent.com/shgil0618-glitch/fullstack_gsh/master/project/project3_Api/img/image-3.png)

* 관리자 페이지 기능 강화 (게시글·데이터 관리 효율 향상)
* 사용자 입력 흐름 단순화 및 직관적 UI 구성
* **성과**: 전체 사용 편의성 및 관리 효율 향상

### 2) 비용 최적화 기반 설계
![alt text](https://raw.githubusercontent.com/shgil0618-glitch/fullstack_gsh/master/project/project3_Api/img/image-1.png)
![alt text](https://raw.githubusercontent.com/shgil0618-glitch/fullstack_gsh/master/project/project3_Api/img/image-2.png)
* 외부 API 호출을 **자동 → 사용자 선택형** 구조로 개선
* 불필요한 API 호출 및 데이터 전송 최소화
* **성과**: 운영 비용 절감 및 시스템 안정성 확보

### 3) 검색 기능 고도화
![alt text](https://raw.githubusercontent.com/shgil0618-glitch/fullstack_gsh/master/project/project3_Api/img/image.png)
* 검색어 · 카테고리 · 정렬 기준을 조합한 검색 구조 설계
* EXISTS + JOIN 병행 사용으로 쿼리 최적화
* **성과**: 검색 정확도 및 조회 속도 개선


### 4) 커뮤니티 기능 확장
![](https://raw.githubusercontent.com/shgil0618-glitch/fullstack_gsh/master/project/project3_Api/img/image-4.png)
![alt text](https://raw.githubusercontent.com/shgil0618-glitch/fullstack_gsh/master/project/project3_Api/img/image-5.png)
* 좋아요 기능 추가
* 비속어 사전 구축 및 자동 필터링 적용
* **성과**: 건전한 커뮤니티 환경 조성

### 5) 데이터 구조 및 API 개선

* 중간 테이블 제거로 데이터 흐름 단순화
* 외부 API 연동 범위 확장
* **성과**: 유지보수성 및 관리 효율성 강화

---

## 6. 트러블슈팅

### 사례 1. 데이터 구조 복잡도 및 API 호출 비용 문제

**문제**

* 게시판–중간 테이블–재료/설명 구조로 인해 관리 비용 증가
* 외부 API 자동 호출 구조로 호출 횟수·데이터 전송량 증가

**원인**

* 과도하게 분리된 데이터 구조로 관리 효율 저하
* API 호출 방식이 일괄 자동화되어 불필요한 리소스 소모 발생

**해결**

* 중간 테이블 제거로 데이터 흐름 단순화
* API 호출 방식을 사용자 선택형으로 변경

**성과**

* 데이터 관리 효율 및 유지보수성 향상
* 운영 비용 절감 및 시스템 안정성 확보

**학습**

* 데이터 구조 단순화의 중요성 체득
* 비용을 고려한 API 설계 경험 확보

**향후 개선 계획**

* API 호출 빈도 모니터링 체계 구축
* 캐싱 전략 도입 검토를 통한 성능·비용 동시 최적화

---

## 7. 프로젝트 회고

* 사용자와 관리자의 관점을 동시에 고려한 기능 설계를 통해 **실제 서비스 운영 요소**를 경험
* 검색 기능 고도화, 커뮤니티 기능 확장, 데이터 구조 개선을 직접 설계·구현하며 기술 역량 향상
* 복합 쿼리 최적화와 권한 기반 UI 설계 경험은 이후 프로젝트의 중요한 자산이 됨
* 협업 과정에서 코드 관리·일정 조율 미흡으로 충돌과 지연이 발생한 점은 아쉬움으로 남았으며,
  이후 프로젝트에서는 협업 규칙과 일정 관리 체계를 강화할 계획

---

## 8. GitHub

* **Repository**: Project3 GitHub
