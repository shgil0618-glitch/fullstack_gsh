-- 008_object.sql

-- 1. 시퀀스 : 자동번호 생성기 ★
-- 2. 뷰 : 가상 테이블 (select 문 결과를 저장한 객체) ★
-- 3. 동의어 : 객체에 대한 별칭
-- 4. 인덱스 : 검색 성능 향상 ★
-- 5. 클러스터 : 여러 테이블을 물리적으로 같은 공간에 저장

--------------------------------------------------------------------------------
-- 1. 시퀀스
-- #1. 시퀀스 만들기
create sequence emp_seq; -- 1부터 시작, 증가단위 1, 최대값 10^27

create sequence dept_seq;

create sequence emp_seq2
start with 1000 -- 시퀀스 시작값
increment by 1  -- 몇개씩 증가?
maxvalue 9999   -- 최대값
nocache;        -- 미리 데이터값을 몇개 저장해둘지...

-- #2. 시퀀스 사용하기
select emp_seq.nextval from dual;

select dept_seq.nextval from dual;

insert into dept_temp values (dept_seq.nextval, 'ai', 'INCHEON');
select * from dept_temp;

-- Q1. appuser_seq 시퀀스 만들기;
create sequence appuser_seq;
desc appuser;

alter table appuser modify email varchar2(100) unique;

select coulmn

create table appuser(
APP_USER_ID  NUMBER NOT NULL,   
EMAIL        VARCHAR2(100) NOT NULL UNIQUE,
PASSWORD     VARCHAR2(255),
MBTI_TYPE_ID     NUMBER,   
CREATED_AT       DATE   
);

SELECT table_name, constraint_name, column_name
FROM user_cons_columns
WHERE constraint_name IN (
  SELECT constraint_name
  FROM user_constraints
  WHERE constraint_type = 'U'
);

select * from appuser;





