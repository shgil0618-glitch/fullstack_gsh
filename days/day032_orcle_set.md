#1. 저장단위
변수 < 배열 < 클래스 < 콜렉션프레임워크 < file < DB
※ DB (mysql, oracle, mssql)

> java : jdbc -> dbcp -> orm (★ mybatis, jpa)

#2. RDB (Relationship DataBase) ★
-   관계형 데이타 베이스
-   테이블 관계
1. 엔티티(Entity)      - 테이블  - 관리할대상       (고객,주문,상품)
2. 속성(Attribute)    - 컬럼(열)     - 대상의 특징      (주민번호,이름,나이,주문번호)
3. 관계(Relationship) - 외래키   - 대상간의 연결 - 고객은 주문을 한다.

#3.  데이터베이스 언어  ★
1. 정의어(DDL) - CREATE(생성), ALTER(수정), DROP(삭제) --- CAD
2. 조작어(DML) - INSERT(삽입), SELECT(조회), UPDATE(수정), DELETE(지우기) --- CRUD
3. 제어어(DCL) - GRANT, REVOKE

<<사원>>
SQL> desc emp;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 EMPNO                                     NOT NULL NUMBER(4)
 ENAME                                              VARCHAR2(10)
 JOB                                                VARCHAR2(9)
 MGR                                                NUMBER(4)
 HIREDATE                                           DATE
 SAL                                                NUMBER(7,2)
 COMM                                               NUMBER(7,2)
 DEPTNO                                             NUMBER(2)

<<부서>>
SQL> desc dept;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 DEPTNO                                    NOT NULL NUMBER(2)
 DNAME                                              VARCHAR2(14)
 LOC                                                VARCHAR2(13)

>부서는 많은 사원을 가질수 있다.
관리대상(table) : dept      emp
속성(Attribute): deptno     empno,deptno,,,
연결(Relationship) : deptno (관리대상의 공통점)

#4. SELECT

[실습]
1. 테이블 구조확인 
    desc emp;
    desc dept;
2. 테이블 전체정보확인 
    select * from emp;

```dml
-- #1. 테이블구조확인
desc emp;
desc dept;

show user;      -- 실행) 현재줄 선택하고 ctrl+enter
select table_name from user_tables; -- 사용할수 있는 테이블 확인

-- #2. 전체테이블 조회
SELECT * FROM emp;

-- #3. 열조회 
select empno, ename from emp;
select ename, job from emp;

-- #4. 중복제거 (distinct)
select distinct job from emp;
select all      job from emp;

-- #5. 연산 및 별칭
desc emp;
-- as 생략가능 / "이름" 붙여줘야함
select ename "유저", sal as "월급", sal+sal+sal as "3달치 월급" from emp;

-- #6. 정렬 (오름/내림)
select ename, sal 
from emp 
order by sal asc;   -- asc) 오름차순

select ename, sal 
from emp 
order by sal desc;  -- desc) 내림차순

-- ## step3 연습문제

-- Q001 EMP 테이블 구성을 살펴보시오
desc emp;

-- Q002 DEPT 테이블 구성을 살펴보시오
desc dept;

-- Q003 SALGRADE 테이블 구성을 살펴보시오
desc salgrade;

-- Q004 EMP 테이블 전체열을 조회하시오
select * from emp;

-- Q005 EMP 테이블의 EMPNO, ENAME, DEPTNO 열을 조회하시오
select empno,ename,deptno from emp;

-- Q006 EMP 테이블의 DEPTNO 열의 중복을 제거하고 조회하시오
select distinct deptno from emp;

-- Q007 EMP 테이블의 JOB, DEPTNO열의 중복을 제거 조회하시오
select distinct job ,deptno from emp; 

-- Q008 EMP 테이블의 JOB, DEPTNO열의 중복을 제거하지 않고 그대로 모두 조회하시오
select all job, deptno from emp;
select     job, deptno from emp;

-- Q009 EMP 테이블의열에에 연산식을 이용하여 '연간총수입'을 조회하시오. 
select ename, sal, sal*12+comm , comm from emp;

-- Q010 EMP 테이블의 열열 더하기 연산식을이용하여 '연간총수입'을 조회하시오.
select ename, sal, sal+sal+sal+sal+sal+sal+sal+sal+sal+sal*comm ,comm from emp;

-- Q011 EMP 테이블의 열 별칭을 사용하여 '연간총수입'을 조회하시오.
select ename, sal, sal*12*comm as annsal, comm from emp;

-- Q012 EMP 테이블의 모든 열을 급여기준으로 오름차순 정렬하시오.
select * from emp order by sal asc;
select * from emp order by sal;     -- asc는 기본속성으로 생략 가능.

-- Q013 EMP 테이블의 모든 열을 급여기준으로 내림차순순 정렬하시오.
select * from emp order by sal desc;

-- Q014 EMP 테이블의 모든 열을 전체열을 부서번호(오름차순)와 급여(내림차순)으로 정렬하시오.
select * from emp order by empno asc , sal desc;
```