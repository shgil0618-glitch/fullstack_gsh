-- 조건에 맞는 데이터 조회
-- #1. WHERE
-- #2. 비교연산자 : (같다) =, (다르다) !=, <>, ^=
-- #3. 논리연산자 : AND, OR, NOT / BETWEEN   AND (범위 지정), OR IN
-- #4. LIKE      : 패턴검색
-- #5. NULL처리   : NULL 여부확인
-- #6. 집합연산자  : UNION (중복 제거하고 합집합), UNION ALL (중복 포함하고 합집합), INTERSECT (교집합)

-- #1. 전체데이터 조회 (EMP 테이블에서)
select * from emp;

-- #2. where 조건조회
select * from emp where empno = 7839;   -- 같다 = 
select * from emp where empno != 7839;  -- 다르다 !=
select * from emp where empno <> 7839;  -- 다르다 <>
select * from emp where empno ^= 7839;  -- 다르다 ^=     

select * from emp where ename = 'KING';

select * from emp where empno = 7839 and ename = 'KING';    -- AND 두가지 다 조건이 맞아야함
select * from emp where empno = 7839 and ename = 'SCOTT';   -- 
select * from emp where empno = 7839 or ename = 'SCOTT';    -- or 둘중에 하나

select * from emp where sal*12 = 36000;
select * from emp where sal>3000;

select * from emp where ename >= 'S';
select * from emp where ename <= 'SOR';

select * from emp where deptno>=20 and deptno<=30; -- 이상 이하
select * from emp where deptno between 20 and 30;   -- between and 는 이상과 이하

select * from emp where deptno =10 or deptno =30;   -- 
select * from emp where deptno in (10,30);          -- or =10, =30

select * from emp where ename = 'ADAMS';    -- 이름을 알때
select * from emp where ename LIKE 'A%';    -- A로 시작하는 문자
select * from emp where ename LIKE '%A%';   -- 가운데 A가있는 문자
select * from emp where ename LIKE '%G';    -- G로 끝나는 문자
select * from emp where ename like '_I%';   -- -(첫글자) 두번째 글자가 I

select * from emp where comm = null; -- X null (데이터 없어 - 상태 - 값X)
select * from emp where comm is null; -- O
select * from emp where comm is not null; -- 0도 값이다.

-- 연습문제
-- Q001 - EMP테이블의 모든 열을 조회하시오.
select * from emp;

--Q002 EMP테이블에서 부서번호가 30인 데이터만 조회하시오.
select * from emp where deptno =30;

--Q003 EMP테이블에서 AND를 이용하여 부서번호가 30이고 JOB이 'SALESMAN' 인 데이터만 조회하시오.
select * from emp where deptno=30 and job = 'SALESMAN';

--Q004 EMP테이블에서 OR를 이용하여 부서번호가 30이거나 JOB이 'CLERK' 인 데이터만 조회하시오.
select * from emp where deptno =30 or job = 'CLERK';

--Q005 EMP테이블에서 SAL 열에 12를 곱한값이 36000인 행을 조회하시오.
select * from emp where SAL*12 =36000; 

---- SQL처리순서
--SELECT                 3) *(모든컬럼값)
--FROM EMP               1) EMP 전체 테이블 읽어오기
--WHERE SAL*12 =36000;   2) 각행에 대해 (한 명분의 자료) (가로행) 조건 평가

--Q006 EMP테이블에서 SAL 열이 3000이상인 행을 조회하시오.
select * from emp where sal >= 3000;

--Q007 EMP테이블에서 ENAME 열의 첫문자가 F와 같거나 뒤에 있는 행을 조회하시오.
select * from emp where ename >= 'F'; 

--Q008 EMP테이블에서 ENAME 열의 문자열이 첫문자 F, 두번째 문자 O, 세번째 문자 R, 네번째문자열이 Z 인 문자열보다 앞에 있는 행을 조회하시오.
select * from emp where ename <= 'FORZ';

--Q009 EMP테이블에서 != 를 이용하여 SAL열이 3000이 아닌 행을 조회하시오.
select * from emp where sal != 3000;

--Q010 EMP테이블에서 <> 를 이용하여 SAL열이 3000이 아닌 행을 조회하시오.
select * from emp where sal <> 3000;

--Q011 EMP테이블에서 ^= 를 이용하여 SAL열이 3000이 아닌 행을 조회하시오.
select * from emp where sal ^= 3000;

--Q012 EMP테이블에서 NOT를를 이용하여 SAL열이 3000이 아닌 행을 조회하시오.
select * from emp where not sal = 3000;

--Q013 EMP테이블에서 OR 를 이용하여 JOB 열이 'MANAGER' ,'SALESMAN' , 'CLERK' 중 하나라도 포함되는 행을 조회하시오.
select * from emp where job = 'MANAGER' or job = 'SALESMAN' or job = 'CLERK';

--Q014 EMP테이블에서 IN 를 이용하여 JOB 열이 'MANAGER' ,'SALESMAN' , 'CLERK' 중 하나라도 포함되는 행을 조회하시오.
select * from emp where job in ('MANAGER','SALESMAN','CLERK');

--Q015 EMP테이블에서 등가연산자(!= , <>, ^=)와 AND 를 이용하여 JOB 열이 'MANAGER' ,'SALESMAN' , 'CLERK' 중 하나라도 포함되지않는 행을 조회하시오.
select * from emp where job != 'MANAGER' and job != 'SALESMAN' and job != 'CLERK';

--Q016 EMP테이블에서 NOT IN 를 이용하여 JOB 열이 'MANAGER' ,'SALESMAN' , 'CLERK' 중 하나라도 포함되지않는 행을 조회하시오.
select * from emp where JOB NOT in ('MANAGER','SALESMAN','CLERK');

--Q017 EMP테이블에서 대소비교연산자(<= , >= ) and 를 이용하여 sal 열이 2000이상 3000이하인인 행을 조회하시오.
select * from emp where sal >=2000 and sal <=3000;

--Q018 EMP테이블에서 BETWEEN AND 를 이용하여 sal 열이 2000이상 3000이하인인 행을 조회하시오.
select * from emp where sal between 2000 and 3000;

--Q019 EMP테이블에서 NOT BETWEEN AND 를 이용하여 sal 열이 2000이상 3000이하인 사이 이외의 행을 조회하시오.
select * from emp where sal not between 2000 and 3000;

--Q020 EMP테이블에서 ENAME이 S로 시작하는 행을 조회하시오.
select * from emp where ename LIKE 'S%';

--Q021 EMP테이블에서 ENAME의 두번째 글자가 L인 행을 조회하시오.
select * from emp where ename like '_L%';

--Q022 EMP테이블에서 ENAME에 AN이 포함되어 있는 행을 조회하시오.
select * from emp where ename like '%AM%';

--Q023 EMP테이블에서 ENAME에 AN이 포함되어 있지 않는 행을 조회하시오.
select * from emp where ENAME  NOT LIKE '%AM%';

--Q024 EMP테이블에서 별칭을 사용하여 다음과 같이 '연간총수입' 행을 조회하시오.
select ENAME,SAL,SAL*12+COMM AS ANNSAL,COMM from emp; 

-- 25. NULL의 의미
select * from emp where COMM = NULL;

-- 26. NULL 상태확인
select * from emp where COMM IS NULL;

-- 27. EMP테이블에서 직속상관이 있는데이터만 조회하시오
select * from emp where MGR IS NOT NULL;

--Q028 - 되는 코드는? 안된다
SELECT *
  FROM EMP
 WHERE SAL > NULL       -- 그냥 비어있는 상태이기떄문에 안됨. 비교할게 없음.
   AND COMM IS NULL;

--Q029 - 되는 코드는? 된다
SELECT *
  FROM EMP
 WHERE SAL > NULL
    OR COMM IS NULL;


