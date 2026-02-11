
# 🍽️ Project 1 – Servlet 기반 레시피 커뮤니티 웹 프로젝트

Java Servlet과 MVC 패턴을 기반으로 구현한
**레시피 게시판 · 커뮤니티 기능 중심 팀 프로젝트**

---

## 1. 프로젝트 개요

본 프로젝트는 **Java Servlet 기반 MVC 구조**를 학습·적용하기 위해 진행한 팀 프로젝트로,
레시피 게시판과 커뮤니티 기능을 중심으로 **요청 분기 처리**, **Service 계층 분리**,
**DTO를 활용한 데이터 전달 구조**를 직접 설계·구현했습니다.

특히 Controller 단에서 모든 요청을 수신한 뒤
**Command(Service) 객체로 로직을 위임하는 구조**를 적용하여
유지보수성과 확장성을 고려한 웹 애플리케이션 흐름을 경험하는 데 목적을 두었습니다.

* **프로젝트 성격**: Java 웹 기초 학습 · 팀 프로젝트
* **핵심 목표**: Servlet 기반 MVC 요청 처리 흐름 이해

---

## 2. 프로젝트 정보

* **기간**: 2024.11 ~ 2024.12
* **구분**: 팀 프로젝트
* **개발 환경**: Eclipse
* **사용 기술**: Java, Servlet, JSP

---

## 3. 기술 스택

### Backend

* Java 11
* Servlet / JSP
* MVC Pattern
* Command(Service) Pattern

### Database

* Oracle DB

### Frontend

* HTML / CSS
* JSP

---

## 4. 전체 구조 요약

```text
Client Request
   ↓
Controller (RecipeController / ComuController)
   ↓
Service(Command) 객체
   ↓
DTO (RecipeDto 등)
   ↓
View(JSP)
```

* 모든 요청은 Controller에서 단일 진입
* URL 패턴에 따라 Service 로직 분기
* 비즈니스 로직은 Controller에 직접 작성하지 않음



---

## 4. 주요 기능

* 레시피 게시판 중심의 기본 커뮤니티 기능 구현
* Servlet 기반 MVC 구조를 활용한 요청 처리 흐름 설계

  * 레시피 목록 / 상세 조회 / 등록 / 수정 / 삭제
* 커뮤니티 게시판 기능 구현

  * 게시글 목록 / 상세 조회
  * 게시글 등록 및 삭제
* 사용자 입력 기반 화면 흐름 제어

  * 요청 URL에 따른 기능 분기
  * JSP 기반 화면 전환 처리

---

## 5. 담당 업무 및 성과

### 1) 레시피 게시판 CRUD 기능 구현

![alt text](https://raw.githubusercontent.com/shgil0618-glitch/fullstack_gsh/master/project/project1_Eclipse/img/project4-0.PNG)


* 레시피 목록 조회 및 상세 조회 기능 구현
* 레시피 등록 / 수정 / 삭제 기능 전체 흐름 설계
* 사용자 요청에 따라 기능별 Service 로직 분기 처리
* **성과**: 레시피 게시판의 기본 CRUD 기능을 독립적으로 완성



### 2) 레시피 등록 · 수정 화면 흐름 설계

■ 글쓰기 폼
![alt text](https://raw.githubusercontent.com/shgil0618-glitch/fullstack_gsh/master/project/project1_Eclipse/img/project4-3글쓰기.PNG)
■ 상세보기 폼
![alt text](https://raw.githubusercontent.com/shgil0618-glitch/fullstack_gsh/master/project/project1_Eclipse/img/project4-4상세보기.PNG)

* JSP 기반 입력 폼 구성
* 사용자 입력 → 처리 → 결과 화면 이동 흐름 설계
* 잘못된 요청 시 이전 화면으로 복귀 처리
* **성과**: 콘솔이 아닌 웹 환경에서의 사용자 입력 흐름 이해



### 3) 커뮤니티 게시판 기능 구현
■ 수정 폼 (등록 데이터 유지)
![alt text](https://raw.githubusercontent.com/shgil0618-glitch/fullstack_gsh/master/project/project1_Eclipse/img/project4-5수정.PNG)
■ 수정 버튼 클릭 시 (상세보기 이동)
![alt text](https://raw.githubusercontent.com/shgil0618-glitch/fullstack_gsh/master/project/project1_Eclipse/img/project4-5수정2.PNG)
■ 삭제 버튼 클릭 시
![alt text](https://raw.githubusercontent.com/shgil0618-glitch/fullstack_gsh/master/project/project1_Eclipse/img/project4-6글삭제.PNG)
* 커뮤니티 게시판 목록 및 상세 조회 기능 구현
* 게시글 등록 및 삭제 기능 처리
* 게시판과 레시피 기능을 분리한 구조 설계
* **성과**: 게시판 기능 확장에 용이한 구조 확보



### 4) 요청 분기 및 MVC 흐름 제어

![alt text](https://raw.githubusercontent.com/shgil0618-glitch/fullstack_gsh/master/project/project1_Eclipse/img/project4-7.PNG)
* 단일 Controller에서 요청 URL을 기준으로 기능 분기
* 비즈니스 로직은 Service 계층으로 위임
* Controller는 요청 처리와 화면 이동만 담당
* **성과**: MVC 패턴의 역할 분리 개념을 코드로 구현



### 5) 사용자 입력 검증 및 예외 상황 처리
■  if-else문을 활용하여 예외처리 진행
![alt text](https://raw.githubusercontent.com/shgil0618-glitch/fullstack_gsh/master/project/project1_Eclipse/img/project4-8.PNG)

* 잘못된 요청(URL, 파라미터 누락 등)에 대한 기본 예외 처리
* 비정상 접근 시 클라이언트 측 화면 복귀 처리 (history.back())
* **성과**: 안정적인 웹 애플리케이션 실행 흐름 확보



### ✨ 이 파트의 의미 (한 줄 정리)

> 이 프로젝트는 **Servlet 기반 MVC 구조에서
> “웹 애플리케이션의 기본 동작 원리”를 실제로 구현한 경험**입니다.

---



## 6. 트러블슈팅

### 사례 1. Controller 로직 비대화 문제

**문제**

* 초기 구현 단계에서 Controller에 로직이 집중되어 가독성 저하

**원인**

* 요청 처리와 비즈니스 로직의 역할 분리 부족

**해결**

* Service(Command) 패턴 도입
* Controller는 요청 분기만 담당하도록 리팩토링

**성과**

* Controller 코드 단순화
* 기능별 책임 분리 명확화

**학습**

* MVC 패턴에서 Controller의 역할 이해
* 로직 분리의 중요성 체감

---

## 7. 프로젝트 회고

* Servlet 기반 MVC 구조를 **이론이 아닌 실제 코드 흐름으로 이해**
* Front Controller + Command 패턴을 직접 구현하며
  이후 Spring MVC 구조를 학습하는 데 큰 도움이 됨
* DTO를 활용한 데이터 전달 구조를 통해
  계층 분리 설계의 중요성을 체감
* 팀 프로젝트를 통해 Controller 역할 분담, 코드 통합, 협업 흐름 경험


