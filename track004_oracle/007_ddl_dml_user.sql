
-- ★ 데이터베이스 언어
-- crud                  (create,     read,          update,         delete)
-- 1. dml 조작어(데이터) - insert(삽입), select(조회), update(수정), delete(지우기) → CRUD
-- 2. ddl 정의어(구조) - create(만들기), alter(테이블 수정), drop(삭제:복구안됨) → CAD
-- 3. dcl 제어어(접근권한) - grant(권한주기), revoke(권한빼기) 
-- 4. tcl 제어어(트랜잭션) - commit(반영), rollback(되돌리기), savepoint(지점)


------------------------------------------------------------------------------------------
-- 1. dml 조작어(데이터) - insert(삽입), select(조회), update(수정), delete(지우기) → CRUD
------------------------------------------------------------------------------------------
-- #1. 테이블 복사 해오기
create table dept_temp as select * from dept;
desc dept_temp;
select * from dept_temp;

-- #2. insert
-- insert into 테이블명 (필드1, 필드2, ,,) values (값1,값2,,,);

insert into dept_temp (deptno,dname,loc) values (50,'DATABASE','SEOUL');
insert into dept_temp                    values (60, 'NETWORK','BUSAN');
insert into dept_temp                    values (70, 'WEB', NULL);
insert into dept_temp (deptno,loc,dname) values (80,'FRONT','');
insert into dept_temp (LOC,DNAME,DEPTNO) values ('INCHEON','BACK',90);
insert into dept_temp (DEPTNO,DNAME) values (99,'MOBILE');

commit; -- 반영

select * from dept_temp;

-- Q1. EMP 테이블을 복사해 EMP_TEMP 테이블을 만드시오. (구조확인, 전체데이터 확인)
create table emp_temp as select * from emp;
desc emp_temp;
select * from emp_temp;

-- Q2. 모든 필드 명시하는 방법이용해서 다음의 값 넣기
--  9999, '홍길동', 'PRESIDENT', NULL, '2001/01/01', 5000, 1000, 10
insert into emp_temp (empno,ename,job,mgr,hiredate,sal,comm,deptno) values (9999, '홍길동', 'PRESIDENT', NULL, '2001/01/01', 5000, 1000, 10);

-- Q3. 필드 명시 안하는 방법이용해서 방법이용해서 다음의 값 넣기
-- 1111, '성춘향', 'MANAGER', 9999, '2001-01-05', 4000, NULL, 20
insert into emp_temp  values (1111, '성춘향', 'MANAGER', 9999, '2001-01-05', 4000, NULL, 20);

commit;
select * from emp_temp;

------------------------------------------------------------------------------------------
-- 1. dml 조작어(데이터) - insert(삽입), select(조회), update(수정), delete(지우기) → CRUD
------------------------------------------------------------------------------------------
10   ACCOUNTING   NEW YORK
20   RESEARCH   DALLAS
30   SALES   CHICAGO
40   OPERATIONS   BOSTON
50   DATABASE   SEOUL
60   NETWORK   BUSAN
70   WEB   
70   WEB   
80      FRONT
80   FRONT   
90   BACK   INCHEON
99   MOBILE   

create sequence sboard1;
-- #1
select * from dept_temp;

-- #2. update
update 테이블명
set 바꿀필드1=바꿀값1, 바꿀필드1=바꿀값1 ,,,
where 조건;

-- 2-1. 전체 데이터 업데이트
update dept_temp set loc = 'INCHEON';                   -- 전체데이터 업데이트 (하지마 이거!)
update dept_temp set loc = 'NEW YORK' where deptno = 10; -- 해당하는 조건 업데이트
update dept_temp set loc = 'DALLAS' where deptno = 20 and dname = 'RESEARCH';

-- 3.  delete
--------------------------------
delete from 테이블명 where 조건;
--------------------------------
delete from dept_temp;      -- 전체데이터 삭제
delete from dept_temp where deptno=10;
delete from dept_temp where deptno>=30;
commit;

select * from dept_temp;

-- 3-1 
select * from dept;
select * from dept_temp;

insert into dept_temp (deptno, dname, loc)
            select deptno, dname, loc from dept;
        
-- Q1. dept_temp 모든 데이터 삭제
delete from dept_temp;
-- Q2. insert 이용해서 데이터 삽입, 반영
insert into dept_temp (deptno,dname,loc)
select * from dept;
rollback;
commit;

-- Q3. dept_temp 테이블에서 40번부서의 이름을 DATABASE, 지역을 SEOUL로 수정하시오.
update dept_temp set dname='DATABASE',loc='SEOUL' where deptno=40;

-- Q4. 위에 데이터 되돌리기
select * from dept_temp;
rollback;       -- 되돌리기 (커밋 시점으로 돌아감.)

-- #0. 준비 -  다음 문제들을 풀으시오
-- Q1. DEPT 테이블을 복사해 DEPT_TCL테이블을 작성하시오.
create table dept_tcl as select * from dept; 
-- Q2. DEPT_TCL 테이블에 다음과 같이 데이터를 입력, 수정, 삭제 하시오. (변경후 commit 하자!)
--    2-1.  데이터 삽입   50, 'DATABASE', 'SEOUL'
insert into dept_tcl (deptno,dname,loc) values (50, 'DATABASE', 'SEOUL');
update dept_tcl set deptno = 60 where dname='DATABASE'and loc='SEOUL';
delete from dept_tcl where dname='DATABASE'and loc='SEOUL';
commit;
--    2-2.  부서번호가 40인  LOC를 INCHEON 으로 수정
update dept_tcl set loc='INCHEON' WHERE DEPTNO=40;
--    2-3.  DNAMD이 RESEARCH 인데이터 삭제
delete from dept_tcl where dname = 'RESEARCH';
--    2-4.  전체데이터 확인
select * from dept_tcl;


delete * from dept_tcl;
-- #1. 데이터 반영 (insert,update, delete)
commit;

-- #2. 데이터 되돌리기 (commit한 시점으로 돌아감)
rollback;

insert into dept_tcl dept_tcl  values (20, 'AI', 'INCHEON');
rollback;
select * from dept_tcl;

-- #3. savepoint
insert into dept_tcl values (60, 'AI', 'INCHEON');  --insert
savepoint sp_insert;     --기준점 설정1
update dept_tcl set deptno=30 where DEPTNO=30;
savepoint sp_update;     -- insert 확정, 이후 작업만 되돌리기 (기준점 설정2)

rollback to sp_insert;


----------------------------------------------------------------------------------
-- 2. ddl 정의어(구조) - create(만들기), alter(테이블 수정), drop(삭제:복구안됨) → CAD
----------------------------------------------------------------------------------
-- #1. Create 
-------------------------------------------
CREATE TABLE 테이블명 (
필드명1 자료형 옵션,
필드명2 자료형 옵션,
필드명3 자료형 옵션,
)
-------------------------------------------
필드명 - 영문소문자
자료형 - 숫자 NUMBER, 문자열 VARCHAR2(갯수), 날짜 DATE
옵션   - NOT NULL 필수입력, 기본값 PRIMARY KEY;
-------------------------------------------
create table DEPT_DDL(
    DEPTNO NUMBER(2) PRIMARY KEY,
    DNAME VARCHAR(50) NOT NULL,
    LOC   VARCHAR2(50)
);

DESC DEPT_DDL;
-------------------------------------------
ALTER TABLE 테이블명 ADD     필드명 자료형    (추가)
                    DROP    필드명 COLUMN   (삭제)
                    MODIFY  필드명 자료형    (변경);
-------------------------------------------
-- 컬럼추가;
ALTER TABLE dept_ddl ADD ADMIN VARCHAR(50);
ALTER TABLE dept_ddl MODIFY ADMIN VARCHAR(100) NOT NULL;
ALTER TABLE DEPT_DDL DROP COLUMN ADMIN;

-------------------------------------------
DROP TABLE 테이블명;    -- (드랍 복구 불가능)
-------------------------------------------
DROP TABLE DEPT_DDL;
ROLLBACK;
DESC DEPT_DDL;


-------------------------------------------------------------------
✅ 문제 1:  다음과 같이 테이블을 작성하고 데이터를 삽입하세요
※AppUser 의 FK는 무시하세요.

#### 1. `MbtiType`
| 필드명 | 타입 | 설명 |
|--------|------|------|
| mbti_type_id | INT (PK) | MBTI 유형 ID |
| name | VARCHAR(10) | 유형 이름 (예: ENFP) |
| description | TEXT | 성향 설명 |

**예시 데이터**
```sql
(3, 'ENFP', '열정적이고 창의적인 성향')
(7, 'INTJ', '논리적이고 전략적인 성향');
```

CREATE TABLE   MbtiType (
  mbti_type_id  NUMBER(5)  PRIMARY KEY,
  name          VARCHAR2(10) ,
  description   VARCHAR2(100)
);


insert into MbtiType values (3, 'ENFP', '열정적이고 창의적인 성향');
insert into MbtiType values (7, 'INTJ', '논리적이고 전략적인 성향');



#### 2. `AppUser`
| 필드명 | 타입 | 설명 |
|--------|------|------|
| app_user_id | INT (PK) | 사용자 고유 ID |
| email | VARCHAR(100) | 이메일 주소 |
| password | VARCHAR(255) | 암호화된 비밀번호 |
| mbti_type_id | INT (FK → MbtiType.mbti_type_id) | 연결된 MBTI 유형 |
| created_at | DATETIME | 가입일 |

**예시 데이터**
```sql
(1, 'alice@example.com', 'hashed_pw_123', 3, 2, '2025-10-01 10:00:00')
(2, 'bob@example.com', 'hashed_pw_456', 7, 1, '2025-10-02 14:30:00');
```

CREATE  TABLE  AppUser(
    app_user_id   NUMBER(5)  PRIMARY KEY, 
    email         VARCHAR2(100) , 
    password      VARCHAR2(255) ,
    mbti_type_id  NUMBER(3), 
    created_at    DATE
);

DESC APPUSER;
drop table AppUser;




✅ 문제 1: AppUser 테이블에 사용자 이름(name) 컬럼을 추가하세요.
컬럼 타입은 VARCHAR2(50)이며 NULL 허용
alter table AppUser add name VARCHAR2(50) null;

desc appuser;
✅ 문제 2: AppUser 테이블의 email 컬럼에 NOT NULL 제약을 추가하세요.
alter table appuser modify email VARCHAR(100) NOT NULL;

 
✅ 문제 3: AppUser 테이블의 password 컬럼 길이를 255 → 100으로 줄이세요.
alter table AppUser modify password VARCHAR(100) NOT NULL;

 
✅ 문제 4: MbtiType 테이블에 컬럼 category를 추가하세요.
타입은 VARCHAR2(20)이며 기본값은 '기본'
alter table MbtiType add category VARCHAR2(20);
 
✅ 문제 5: MbtiType 테이블의 description 컬럼 이름을 details로 변경 하세요.
update MbtiType set mbti_type_id = 'details' where  mbti_type_id='description';
ALTER TABLE MbtiType RENAME COLUMN description TO details;

desc MbtiType;
 
✅ 문제 6: AppUser 테이블의 name 컬럼을 삭제하세요.
alter table AppUser drop column name;
 
✅ 문제 7:  MbtiType 테이블 이름을 MbtiInfo로 변경하세요.
ALTER TABLE MbtiType RENAME  TO MbtiInfo;

ALTER TABLE MbtiType RENAME  TO MbtiType;

