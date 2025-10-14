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

