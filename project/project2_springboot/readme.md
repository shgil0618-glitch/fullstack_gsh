# 🍽️ 오늘 뭐먹지? v1

Spring · MyBatis 기반 레시피 UGC 웹 서비스 (기본 기능 구현 프로젝트)

---

## 1. 프로젝트 개요

**“오늘 뭐먹지?” v1**은 레시피 공유를 주제로 한 **UGC(User Generated Content) 웹 서비스**로,
Spring MVC와 MyBatis를 활용해 **웹 서비스의 기본 구조 설계**, **CRUD 구현**, **권한별 UI 분리**, **검색·페이징 성능 개선**에 집중한 팀 프로젝트입니다.

이 프로젝트를 통해 **백엔드 기본기**, **SQL 최적화 경험**, **UI 흐름 설계의 중요성**을 체득했습니다.

---

## 2. 기간 / 인원

* **기간**: 2025.11.02 ~ 2025.12.03
* **인원**: 3명

---

## 3. 기술 스택

### Backend

* Java 11 (JDK 11)
* Spring Framework 4.3 (MVC, Security)
* MyBatis 3.5

### Database

* Oracle 11g

### Frontend

* HTML5 / CSS3
* JavaScript (ES11)
* jQuery 3.7
* Bootstrap 5

---

## 4. 주요 기능

* 회원 관리 기능

  * 회원가입 / 로그인 / 정보 수정
* 게시판 CRUD

  * 레시피 등록 / 수정 / 삭제 / 조회
* 재료 관리 및 게시글 연동
* 검색 · 카테고리 정렬 기능
* AJAX 기반 페이징 처리
* 권한 분리

  * 사용자 / 관리자 UI 분리

---

## 5. 담당 업무 및 성과

### 1) 권한별 UI 설계 및 템플릿 분리
![alt text](https://raw.githubusercontent.com/shgil0618-glitch/fullstack_gsh/master/project/project2_springboot/img/image.png)
* Spring Security 기반 권한 구분
* 헤더 · 네비게이션을 권한별로 동적 구성
* 템플릿 단위 분리 및 재사용 구조 설계
* **성과**: 권한별 UI 흐름 안정화, 유지보수성 향상

### 2) 검색 · 카테고리 정렬 로직 구현
![alt text](https://raw.githubusercontent.com/shgil0618-glitch/fullstack_gsh/master/project/project2_springboot/img/image-1.png)

* 검색어 + 카테고리 기준 검색 구조 설계
* 복합 JOIN · 서브쿼리 활용
* 조건 기반 쿼리 최적화
* **성과**: 검색 정확도 및 조회 속도 개선

### 3) AJAX 페이징 및 실시간 검색 반영
![alt text](https://raw.githubusercontent.com/shgil0618-glitch/fullstack_gsh/master/project/project2_springboot/img/image-2.png)
* 페이지 전체 새로고침 없이 부분 갱신 방식 적용
* 검색 조건 변경 시 실시간 결과 반영
* **성과**: 로딩 속도 개선 및 UX 향상

### 4) 게시판 CRUD 구현
![](https://raw.githubusercontent.com/shgil0618-glitch/fullstack_gsh/master/project/project2_springboot/img/image-3.png)
![alt text](https://raw.githubusercontent.com/shgil0618-glitch/fullstack_gsh/master/project/project2_springboot/img/image-4.png)
![alt text](https://raw.githubusercontent.com/shgil0618-glitch/fullstack_gsh/master/project/project2_springboot/img/image-5.png)
* 게시글 생성 / 수정 / 삭제 / 조회 기능 구현
* 입력 값 검증 및 예외 처리
* **성과**: 안정적인 커뮤니티 기능 확보

---

## 6. 트러블슈팅

### 사례 1. 대량 데이터 환경에서 검색 성능 저하

**문제**

* 복합 JOIN · 서브쿼리 사용으로 조회 속도 저하
* 페이지 로딩 지연 발생

**원인**

* ERD 설계 복잡성
* 불필요한 데이터 스캔으로 인한 성능 저하

**해결**

* 전체 ERD 및 데이터 흐름 재검토
* EXISTS 조건 적용으로 불필요한 스캔 제거
* 조건 기반 쿼리 재작성

**성과**

* 검색 속도 개선 및 성능 안정화 달성

**학습**

* SQL 최적화 기법 실무 적용 경험 확보
* 대규모 데이터 환경에서도 안정적인 검색 기능 구현 가능


---

## 7. 프로젝트 회고

* 단순 기능 구현을 넘어 **사용자 니즈를 시스템으로 구조화하는 경험**을 얻음
* 복잡한 쿼리 구조와 데이터 관계 정리에 어려움을 겪었으나, 문제 정의 및 해결 과정을 통해 기술 이해도 향상
* 초기 설계 부족으로 구조 수정이 필요했던 점은 아쉬움으로 남았으며, 이후 프로젝트에서 설계 단계 보완 예정

이번 프로젝트를 통해 **성능 최적화 · UI 설계 · 데이터 안정성**을 종합적으로 고려하는 개발자로 성장할 기반을 마련했습니다.

---
