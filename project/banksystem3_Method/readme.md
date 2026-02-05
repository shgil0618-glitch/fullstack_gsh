

# 🏦 BankSystem 3 - OOP & Method Isolation Version

> **객체지향 설계(OOP)**를 적용하여 각 기능을 독립된 클래스로 분리하고  
> 데이터 모델(`UserInfo`)과 행위(`Add`, `Deposit` 등)를 구조화한  
> **유지보수 중심의 뱅크 시스템**

---

## 📅 프로젝트 개요

- **제작일**: 2026-02  
- **프로젝트 배경**

기존 배열 기반의 절차지향 시스템은 기능이 추가될수록 코드가 비대해지고  
가독성이 떨어지는 한계가 있었습니다. 이를 해결하기 위해  
**클래스 기반의 객체지향 설계**를 도입했습니다.

각 기능을 `Add`, `Show`, `Deposit`, `Withdraw`, `Delete`, `Login` 등  
별도의 부품 객체로 설계하여 **코드의 응집도를 높이고**,  
`UserInfo` 객체를 통해 **데이터를 안전하게 관리(캡슐화)**하는  
구조적 개선을 목표로 했습니다.

---

## 🛠 사용 기술

- **Language**: Java  
- **Library**: `java.util.Scanner`  
- **Core Concepts**
- **Encapsulation**: `private` 멤버 변수와 `Getter/Setter`를 통한 데이터 보호
- **Class Architecture**: 기능을 독립된 클래스로 설계하여 부품화
- **Dependency Injection**: 생성자를 통한 객체 공유 (참조값 전달)
- **Memory Management**: 동일한 인스턴스를 공유하여 데이터 무결성 유지

---

## 🔄 프로그램 흐름 요약

```text
Bank_Main 실행 (UserInfo 및 서비스 객체들 생성)
 → 메인 루프 (while) 시작
 → 메뉴 선택 (1.추가, 2.조회, 3.입금, 4.출금, 5.삭제, 9.종료)
 → [추가] 선택 시 : Add.exec() 호출 → 데이터 저장
 → [그 외] 선택 시 : Login.exec() 인증
 → 인증 성공 시 해당 서비스.exec() 호출
 → UserInfo의 데이터 상태 업데이트 및 결과 출력
 → 종료 시 루프 탈출
```


## ▶ 실행 방법

1. Java 11 이상 환경에서 실행
2. `Bank_Main.java`의 `main` 메서드 실행 (또는 호출)
3. 콘솔의 안내에 따라 기능 번호 입력

---

## 🎮 주요 기능

### 1️⃣ 객체 기반 회원 정보 등록 (`Add`)

* `UserInfo` 객체의 상태를 초기화
* 아이디, 비밀번호, 초기 잔액을 입력받아 객체에 저장



### 2️⃣ 보안 및 로그인 (`Login`)

* 기능 수행 전 아이디와 비밀번호 일치 여부 검증
* `exit_check` 플래그를 통해 인증되지 않은 사용자의 접근 차단



### 3️⃣ 입금 및 출금 시스템 (`Deposit`, `Withdraw`)

* 현재 잔액(`getBalance()`)을 조회하여 연산 후 다시 저장(`setBalance()`)
* 데이터에 직접 접근하지 않고 메서드를 통해 상태를 변경하는
  **캡슐화 원칙 준수**



### 4️⃣ 정보 조회 및 삭제 (`Show`, `Delete`)

* **Show**
  현재 로그인된 사용자의 상세 정보(ID, 잔액 등) 출력

* **Delete**
  사용자 정보를 빈 값과 0으로 초기화하여 계정 삭제 로직 구현

---

## 🧩 코드 구조 요약

* **Model (`UserInfo.java`)**
  사용자의 ID, PASS, BALANCE 정보를 보관하는
  전용 DTO(Data Transfer Object)

* **Controller (`Bank_Main.java`)**
  전체 시스템의 흐름을 제어하고
  각 부품 객체를 초기화 및 실행

* **Service Classes**

  * `Add`: 사용자 정보 등록
  * `Login`: ID/PASS 일치 여부 확인 및 세션 체크
  * `Show` / `Deposit` / `Withdraw` / `Delete`
    각 기능별 비즈니스 로직 수행

---

## 👥 데이터 관리 구조

* **단일 사용자 객체 관리**
  `UserInfo` 클래스 인스턴스 하나를 생성하여
  모든 서비스 클래스가 공유

* **참조에 의한 전달**
  생성자를 통해 동일한 `UserInfo` 인스턴스의 주소값을 넘겨주어,
  어떤 클래스에서 데이터를 수정하든
  실시간으로 반영되는 구조

* **입력 일관성**
  각 서비스 내에서 `Scanner`를 활용해
  사용자 인터랙션 처리

---

## 🧯 Trouble Shooting

### 🔴 문제: 클래스 분리 시 데이터 불일치 및 공유 문제

각 기능을 클래스별로 나누다 보니,
`Deposit` 클래스에서 수정한 잔액이
`Show` 클래스에서 반영되지 않거나,

각 클래스마다 새로운 `UserInfo` 객체를 만들어
데이터가 따로 노는 문제가 발생할 가능성이 있었습니다.

---

### 🛠 해결 방법

**객체 주소 공유(Dependency Injection)** 방식을 사용하여 해결했습니다.

* `Bank_Main`에서 단 하나의
  `UserInfo userinfo = new UserInfo();` 생성
* 각 서비스 객체 생성 시
  동일한 `userinfo` 인스턴스를 인자로 전달

```java
// Bank_Main.java 예시
this.userinfo = new UserInfo();
this.deposit = new Deposit(this.userinfo); // 주소값 전달
this.show = new Show(this.userinfo);       // 동일한 주소값 전달
```

이로 인해 모든 클래스가
**메모리상의 동일한 객체**를 바라보게 되어,
한 곳에서의 데이터 변경이
전체 시스템에 즉각 반영되도록 설계했습니다.

---

### ✅ 결과

* 코드 길이가 늘어나도
  각 클래스만 수정하면 되는 **높은 유지보수성** 확보
* 데이터 모델과 비즈니스 로직 분리로 인한 **가독성 향상**
* 객체지향의 핵심인 **재사용성**과 **확장성** 체득

---
