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

-- ※ 테이블 emp
-- 사용 가능한 테이블 확인
select table_name from user_tables;
-- emp 데이터 삭제 (복구X)
drop table emp;
select table_name from user_tables;

-- emp 테이블 만들기 정의어(DDL) - CREATE, ALTER, DROP
CREATE TABLE emp (
  empno NUMBER(4),
  ename VARCHAR2(10),
  job VARCHAR2(9),
  mgr NUMBER(4),
  hiredate DATE,
  sal NUMBER(7,2),
  comm NUMBER(7,2),
  deptno NUMBER(2)
);

desc emp;
-- emp 테이블 만들기

