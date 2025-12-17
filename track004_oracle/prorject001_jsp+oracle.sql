create table authorities(
    email varchar2(100),
    auth   varchar2(100)
);

select * from appuser;

drop table authorities;

ALTER TABLE authorities
RENAME COLUMN userid TO email;

insert into authorities (email, auth) values ('q3@q3','MEMBER');
insert into authorities (email, auth) values ('q3@q3','ADMIN');

SELECT u.email, u.password, a.auth
FROM appuser u
JOIN authorities a
  ON u.email = a.email
where u.email = 'q3@q3';

SELECT u.email, u.password, a.auth
FROM appuser u
LEFT JOIN authorities a
  ON u.email = a.email
  where u.email = 'q3@q3';
   
select * from authorities;

create table appuser(
    APP_USER_ID                                NUMBER(5) primary key,
      EMAIL                                    VARCHAR2(100) NOT NULL,
      PASSWORD                                           VARCHAR2(100),
      MBTI_TYPE_ID                                       NUMBER(3),
      CREATED_AT                                   TIMESTAMP(6) default sysdate,
      UFILE                                       VARCHAR2(255),
      MOBILE                                    VARCHAR2(50),
      NICKNAME                                   VARCHAR2(50)
);

select * from appuser;
select * from authorities;
commit;

delete from appuser where email = 'ff@ff';
--------------------------------------------------------------------------------------


# ✅ 1. 회원가입 (CREATE)

```sql
INSERT INTO appuser (
    APP_USER_ID,
    EMAIL,
    PASSWORD,
    MBTI_TYPE_ID,
    UFILE,
    MOBILE,
    NICKNAME
) VALUES (
    1,
    'test@example.com',
    '1234',
    10,
    'profile.png',
    '010-1111-2222',
    'hsh'
);
```
---
# ✅ 2. 로그인 (READ: 이메일 + 비밀번호)

```sql
SELECT *
FROM appuser
WHERE email = 'test@example.com'
  AND password = '1234';
```
---

# ✅ 3. 아이디 찾기 (READ: 해당 이메일 존재 여부)

```sql
SELECT APP_USER_ID, EMAIL
FROM appuser
WHERE email = 'test@example.com';
```
---

# ✅ 4. 비밀번호 찾기 (READ: 이메일 기준)

```sql
SELECT PASSWORD
FROM appuser
WHERE email = 'test@example.com';
```
---

# ✅ 5. 이메일로 EMAIL, PASSWORD, MBTI, UFILE, MOBILE 가져오기
```sql
SELECT EMAIL, PASSWORD, MBTI_TYPE_ID, UFILE, MOBILE, NICKNAME
FROM appuser
WHERE email = 'test@example.com';
```
---


select u.email, u.password, a.auth
from appuser u left join  authorities a on  u.email = a.email
where u.email='1@1';


```

# ✅ 6. 정보 수정 (UPDATE: 특정 ID의 회원 정보 수정)
```sql
UPDATE appuser
SET
    EMAIL = 'new@example.com',
    PASSWORD = 'abcd1234',
    MBTI_TYPE_ID = 15,
    UFILE = 'new_profile.png',
    MOBILE = '010-2222-3333',
    NICKNAME = 'HSH2'
WHERE APP_USER_ID = 1;
```
---
# ✅ 7. 회원 삭제 (DELETE)

```sql
DELETE FROM appuser
WHERE APP_USER_ID = 1;
```

---





--------------------------------------------------------------------------------------


ALTER TABLE appuser
ADD MOBILE VARCHAR2(50);

ALTER TABLE appuser
ADD NICKNAME VARCHAR2(50);


desc appuser;
commit;

ALTER TABLE appuser
ADD CONSTRAINT uq_appuser_email UNIQUE (EMAIL);

ALTER TABLE appuser
ADD ufile VARCHAR2(255) DEFAULT 'default.png';


SELECT email, COUNT(*)
FROM appuser
GROUP BY email
HAVING COUNT(*) > 1;


select * from appuser; 
select * from appuser_seq;
create sequence appuser_seq;

commit;


CREATE TABLE sboard(
      ID                                         NUMBER primary key,
      APP_USER_ID                                NUMBER NOT NULL,
      BTITLE                                    VARCHAR2(1000)  NOT NULL,
      BCONTENT                                   CLOB NOT NULL,
      BPASS                                      VARCHAR2(255) NOT NULL,
      BFILE                                        VARCHAR2(255),
      BHIT                                     NUMBER(10) default 0,
      BIP                                       VARCHAR2(255) NOT NULL ,
      CREATED_AT                                 TIMESTAMP(6) default sysdate
);
DROP TABLE SBOARD;

CREATE SEQUENCE sboard_seq;
  
INSERT INTO sboard (    ID, APP_USER_ID, BTITLE, BCONTENT, BPASS, BIP
) VALUES (    sboard_seq.nextval, 1001, '첫 번째 게시글입니다', '이것은 게시글 내용입니다.', '1234', '192.168.0.1');

SELECT   * from  sboard WHERE ID = 2;

SELECT    * FROM   sboard ORDER BY     ID DESC;

UPDATE sboard SET  BTITLE = '수정된 게시글 제목',    BCONTENT = '수정된 게시글 내용입니다.'  WHERE ID = 1 and BPASS='1234';

DELETE FROM sboard WHERE ID = 3 and BPASS='1234';

commit;


CREATE TABLE sboard1(
      ID                                         NUMBER primary key,
      APP_USER_ID                                NUMBER NOT NULL,
      BTITLE                                    VARCHAR2(1000)  NOT NULL,
      BCONTENT                                   CLOB NOT NULL,
      BPASS                                      VARCHAR2(255) NOT NULL,
      BFILE                                        VARCHAR2(255),
      BHIT                                     NUMBER(10) default 0,
      BIP                                       VARCHAR2(255) NOT NULL ,
      CREATED_AT                                 TIMESTAMP(6) default sysdate
);

CREATE SEQUENCE sboard1_seq;

select * from sboard1;

--------------------------------------------------
create table milk(
 MNO                                      NUMBER  primary key ,
 MNAME                                     VARCHAR2(100) NOT NULL,
 MNUM                                      NUMBER NOT NULL ,
 MTOTAL                                     NUMBER
);

CREATE SEQUENCE milk_seq;
drop table milk;
commit;


INSERT INTO milk (MNO, MNAME, MNUM, MTOTAL)
VALUES (milk_seq.NEXTVAL, 'gsh', 10, 10);

SELECT * FROM milk WHERE MNO = 1;
SELECT * FROM milk;
UPDATE milk SET MNAME = 'banana milk', MNUM = 20, MTOTAL = 200 WHERE MNO = 1;
DELETE FROM milk WHERE MNO = 1;








CREATE TABLE userinfo (
    NO      NUMBER  NOT NULL PRIMARY KEY,
    EMAIL   VARCHAR(100) NOT NULL,
    AGE     NUMBER
);

drop table userinfo;
CREATE SEQUENCE userinfo_seq;

INSERT INTO userinfo VALUES (userinfo_seq.NEXTVAL, 'asdasd@asd', 10);
INSERT INTO userinfo VALUES (userinfo_seq.NEXTVAL, 'qweqwe@asd', 20);
INSERT INTO userinfo VALUES (userinfo_seq.NEXTVAL, 'zxczxc@asd', 30);

select * from userinfo;
SELECT * FROM userinfo WHERE NO = 2;
UPDATE userinfo SET EMAIL = 'rtyrty@asd', AGE = 40 WHERE NO = 2;
DELETE FROM userinfo WHERE NO = 2; 

commit;

insert into userinfo values (1,'asdasd@asd',10);
insert into userinfo values (2,'qweqwe@asd',20);
insert into userinfo values (3,'zxczxc@asd',30);
select * from userinfo;
select * from userinfo where no=2;
update userinfo set NO=4,email='rtyrty@asd',age=40 where no=2;
delete from userinfo where NO=40;

 
 

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
 