 

--## ✅ 공통 사용자 모듈 (필수 테이블만)

```sql
-- MBTI 유형 테이블
CREATE TABLE MbtiType (
  mbti_type_id NUMBER(3) PRIMARY KEY,
  name VARCHAR2(10),
  description VARCHAR2(100)
);

-- 사용자 테이블
CREATE TABLE AppUser (
  app_user_id NUMBER(5) PRIMARY KEY,
  email VARCHAR2(100),
  password VARCHAR2(255),
  mbti_type_id NUMBER(3),
  created_at DATE,
  FOREIGN KEY (mbti_type_id) REFERENCES MbtiType(mbti_type_id)
);
```

※ `UserRole`, `JwtToken`, `UserLoginLog` 등은 인증 서버 구축 시 필요하므로 JSP 단독 프로젝트에서는 생략 가능합니다.

INSERT INTO MbtiType VALUES (1, 'ISTJ', '신중하고 책임감 있는 현실주의자');
INSERT INTO MbtiType VALUES (2, 'ISFJ', '헌신적이고 따뜻한 보호자');
INSERT INTO MbtiType VALUES (3, 'INFJ', '통찰력 있고 조용한 이상주의자');
INSERT INTO MbtiType VALUES (4, 'INTJ', '논리적이고 전략적인 성향');
INSERT INTO MbtiType VALUES (5, 'ISTP', '실용적이고 분석적인 문제 해결자');
INSERT INTO MbtiType VALUES (6, 'ISFP', '조용하고 감성적인 예술가');
INSERT INTO MbtiType VALUES (7, 'INFP', '이상과 가치 중심의 중재자');
INSERT INTO MbtiType VALUES (8, 'INTP', '호기심 많고 논리적인 사색가');
INSERT INTO MbtiType VALUES (9, 'ESTP', '활동적이고 현실적인 행동가');
INSERT INTO MbtiType VALUES (10, 'ESFP', '사교적이고 즉흥적인 즐거움 추구자');
INSERT INTO MbtiType VALUES (11, 'ENFP', '열정적이고 창의적인 성향');
INSERT INTO MbtiType VALUES (12, 'ENTP', '재치 있고 논쟁을 즐기는 혁신가');
INSERT INTO MbtiType VALUES (13, 'ESTJ', '체계적이고 단호한 관리자');
INSERT INTO MbtiType VALUES (14, 'ESFJ', '친절하고 협력적인 조정자');
INSERT INTO MbtiType VALUES (15, 'ENFJ', '카리스마 있고 타인을 이끄는 지도자');
INSERT INTO MbtiType VALUES (16, 'ENTJ', '결단력 있고 효율적인 통솔자');




---

## 💡 PROJECT1: MBTI 테스트 + 결과보기

```sql
-- 질문 테이블
CREATE TABLE Question (
  question_id NUMBER(5) PRIMARY KEY,
  text VARCHAR2(500),
  created_by NUMBER(5),
  created_at DATE,
  FOREIGN KEY (created_by) REFERENCES AppUser(app_user_id)
);

-- 보기 테이블
CREATE TABLE Choice (
  choice_id NUMBER(5) PRIMARY KEY,
  question_id NUMBER(5),
  text VARCHAR2(255),
  mbti_type_id NUMBER(3),
  FOREIGN KEY (question_id) REFERENCES Question(question_id),
  FOREIGN KEY (mbti_type_id) REFERENCES MbtiType(mbti_type_id)
);

-- 사용자 응답 기록
CREATE TABLE QuestionLog (
  log_id NUMBER(5) PRIMARY KEY,
  app_user_id NUMBER(5),
  question_id NUMBER(5),
  choice_id NUMBER(5),
  timestamp DATE,
  FOREIGN KEY (app_user_id) REFERENCES AppUser(app_user_id),
  FOREIGN KEY (question_id) REFERENCES Question(question_id),
  FOREIGN KEY (choice_id) REFERENCES Choice(choice_id)
);

-- 질문 태그 정의
CREATE TABLE Tag (
  tag_id NUMBER(3) PRIMARY KEY,
  name VARCHAR2(50)
);

-- 질문과 태그 연결 (다대다)
CREATE TABLE QuestionTagMap (
  question_id NUMBER(5),
  tag_id NUMBER(3),
  PRIMARY KEY (question_id, tag_id),
  FOREIGN KEY (question_id) REFERENCES Question(question_id),
  FOREIGN KEY (tag_id) REFERENCES Tag(tag_id)
);

-- 질문 변경 이력
CREATE TABLE QuestionAudit (
  audit_id NUMBER(5) PRIMARY KEY,
  question_id NUMBER(5),
  action_type VARCHAR2(50),
  changed_by NUMBER(5),
  changed_at DATE,
  FOREIGN KEY (question_id) REFERENCES Question(question_id),
  FOREIGN KEY (changed_by) REFERENCES AppUser(app_user_id)
);
```
 