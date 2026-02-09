# 🍽️ 오늘 뭐먹지? SNS

Spring Boot · JPA 기반 레시피 공유 SNS 웹 서비스 (실시간·인터랙션 중심 프로젝트)

---

## 1. 프로젝트 개요

**“오늘 뭐먹지? SNS”**는 기존 레시피 서비스에서 확장된 형태로,
레시피를 중심으로 한 **SNS(User Generated Content) 웹 서비스**를 목표로 한 팀 프로젝트입니다.
게시글 공유, 좋아요·리트윗·해시태그와 같은 **SNS 핵심 인터랙션** 을 구현하여 사용자 참여도를 높이는 데 집중했습니다.

* **프로젝트 성격**: 팀 프로젝트 (SNS 서비스 구축)
* **목표**: 실시간성과 상호작용을 갖춘 레시피 공유 SNS 구현

---

## 2. 기간 / 인원

* **기간**: 2026.01
* **인원**: 4명

---

## 3. 기술 스택

### Backend

* Java 11 (JDK 11)
* Spring Boot 3.4 (MVC, Security)
* JPA
* MyBatis 3.5
* RESTful API

### Database

* Oracle 11g
* Redis (캐싱 및 세션 관리)

### Frontend

* React
* Ant Design (Antd)

### Others

* JWT 인증
* WebSocket
* External API

### DevOps

* AWS (EC2, S3, RDS)
* GitHub Actions 기반 CI/CD

---

## 4. 주요 기능

1. **React 기반 UI/UX 향상**

   * 화면 템플릿 분할 및 테마 선택 기능 제공

2. **게시글 CRUD**

   * 게시글 작성·수정·삭제·조회 기능 구현

3. **JWT 인증 및 소셜 로그인**

   * 사용자 인증 처리 및 보안 강화

4. **SNS 인터랙션 기능**

   * 좋아요 · 리트윗 · 해시태그 기능 제공

5. **Redis 기반 캐싱 및 세션 관리**

   * 자주 조회되는 데이터 캐싱을 통한 성능 최적화

---

## 5. 담당 업무 및 성과

### 1) 게시글 CRUD 구현
![alt text](https://raw.githubusercontent.com/shgil0618-glitch/fullstack_gsh/master/project/project4_Node-React/img/pro5-4.PNG)
![alt text](https://raw.githubusercontent.com/shgil0618-glitch/fullstack_gsh/master/project/project4_Node-React/img/pro5-5.PNG)
 * 레시피 게시글 생성·수정·삭제·조회 API를 설계·구현하여 SNS 콘텐츠 생성 흐름을 안정화함.

<br>

### 2) SNS 인터랙션 기능 구현
![alt text](https://raw.githubusercontent.com/shgil0618-glitch/fullstack_gsh/master/project/project4_Node-React/img/project5-1.PNG)
![alt text](https://raw.githubusercontent.com/shgil0618-glitch/fullstack_gsh/master/project/project4_Node-React/img/pr5-2.PNG)
* 좋아요·리트윗·해시태그 기능을 구현하고 사용자 반응 상태 관리 로직을 적용함.

<br>

### 3) 반응 데이터 처리 최적화
![alt text](https://raw.githubusercontent.com/shgil0618-glitch/fullstack_gsh/master/project/project4_Node-React/img/pro5-6.PNG)
* JPA와 MyBatis를 병행 사용해 조회·상태 변경 로직의 처리 효율을 개선함.

---

## 6. 트러블슈팅

###  좋아요·리트윗 중복 반응 문제

* **문제**: 동일 사용자가 같은 게시글에 좋아요·리트윗을 반복 요청해 반응 수가 비정상적으로 증가함.
* **원인**: 사용자–게시글 반응 상태에 대한 중복 제어와 데이터 무결성 제약이 부족함.
* **해결**: 사용자 ID + 게시글 ID 기준 유니크 제약과 서버 측 반응 토글 로직을 적용함.
* **성과**: 반응 데이터 무결성을 확보하고 SNS 인터랙션 신뢰도를 향상시킴.
* **학습**: SNS 서비스에서는 UI뿐 아니라 데이터 레벨에서의 상태 관리가 필수적임을 이해함.

---

## 7. 프로젝트 소감

* 레시피 서비스를 SNS 구조로 확장하며 사용자 반응과 관계 중심의 백엔드 설계 경험을 쌓음.
* 좋아요·리트윗·해시태그 구현을 통해 데이터 모델이 서비스 정책에 직결됨을 체감함.
* WebSocket 기반 실시간 기능을 적용하며 상태 관리가 필요한 서비스 구조를 이해하게 됨.
* 단순 기능 구현을 넘어 확장성과 안정성을 고려하는 개발 관점을 갖게 됨.

---

