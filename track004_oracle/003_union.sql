-- #7. 집합 연산자 : union (중복제거하고 합집합), union all (중복 포함하고 합집합), minus (차집합), intersect(교집합)
---------------------------------------------
select *
from emp
where deptno =10
---------------------------------------------
union
---------------------------------------------
select *
from emp
where deptno =10;
---------------------------------------------

-- #8. union all (중복 포함하고 합집합)
---------------------------------------------
select *
from emp
where deptno =10
---------------------------------------------
union all
---------------------------------------------
select *
from emp
where deptno =10;
---------------------------------------------

-- #9.  minus (차집합)
---------------------------------------------
select *
from emp
---------------------------------------------
minus
---------------------------------------------
select *
from emp
where deptno =20;
---------------------------------------------

-- #10.  intersect(교집합)
---------------------------------------------
select *
from emp
---------------------------------------------
intersect
---------------------------------------------
select *
from emp
where deptno =20;
---------------------------------------------

-- Q030 UNION을 이용하여 DEPTNO가 10이거나, 20인 데이터의 EMPNO, ENAME, SAL, DEPTNO 열을 조회하시오.
select EMPNO, ENAME, SAL, DEPTNO from emp where deptno = 10 
union
select EMPNO,ENAME,SAL,DEPTNO from emp where deptno=20;

-- Q031 에러가 나는 이유는?
--ORA-01789: query block has incorrect number of result columns     //ctrl + / 전체 주석
--
--https://docs.oracle.com/error-help/db/ora-01789/01789. 00000 -  "query block has incorrect number of result columns"
--*Cause:    All of the queries participating in a set expression do
--           not contain the same number of SELECT list columns.
--*Action:   Check that all the queries in the set expression have
--           the same number of SELECT list columns.
select EMPNO,ENAME,SAL,DEPTNO from emp where deptno =10
union
select EMPNO,ENAME,SAL from emp where deptno = 20;
-- 열의 갯수가 달라서

-- Q032 에러가 나는 이유는? ★속성의 갯수와 자료형
--ORA-01790: expression must have same datatype as corresponding expression
--
--https://docs.oracle.com/error-help/db/ora-01790/01790. 00000 -  "expression must have same datatype as corresponding expression"
--*Cause:    A SELECT list item corresponds to a SELECT list item
--           with a different datatype in another query of the same set
--           expression.
--*Action:   Check that all corresponding SELECT list items have
--           the same datatypes. Use the TO_NUMBER, TO_CHAR, and TO_DATE
--           functions to do explicit data conversions.
--70행, 14열에서 오류 발생
select EMPNO,ENAME,SAL,DEPTNO from emp where deptno =10
union
select EMPNO,DEPTNO,ENAME,SAL from emp where deptno = 20;
-- 자료형이 다를때 (★속성의 갯수와 자료형)

-- Q033 동작하는 이유는? ★속성의 갯수와 자료형
select EMPNO,ENAME,SAL,DEPTNO from emp where deptno =10
union
select EMPNO,ENAME,DEPTNO,SAL from emp where deptno = 20;
-- 자료형이 다를때 (★속성의 갯수와 자료형) (순서는 무관하지만 속성의 갯수와 자료형은 맞춰야된다. 첫번째 함수로 순서 배정)

-- Q034 UNION과 UNION ALL의 차이는?
select EMPNO, ENAME, SAL, DEPTNO from emp where deptno = 10 
union 
select EMPNO,ENAME,SAL,DEPTNO from emp where deptno=10;
-- Q035 UNION과 UNION ALL의 차이는?
select EMPNO, ENAME, SAL, DEPTNO from emp where deptno = 10 
union all
select EMPNO,ENAME,SAL,DEPTNO from emp where deptno=10;
-- union은 중복제거 후 합집합 / union all 은 중복 허용 합집합

-- Q036 MINUS의 의미는?
select EMPNO,ENAME,SAL,DEPTNO from emp 
minus
select EMPNO,ENAME,SAL,DEPTNO from emp where deptno = 10;

-- Q037 INTERSECT 의미는? 교집합
select EMPNO,ENAME,SAL,DEPTNO from emp
intersect
select EMPNO,ENAME,SAL,DEPTNO from emp where deptno = 10;

-- EX001 EMP테이블에서 ENAME이 S로 끝나는 사원데이터를 모두 조회하시오
select * from emp where ename like '%S';
-- EX002 EMP테이블에서 DEPTNO가 30인 사원 중 직책이(JOB)이 SALESMAN 인 사원의 EMPNO, ENAME, JOB, SAL, DEPTNO를 조회하시오
select EMPNO, ENAME, JOB, SAL, DEPTNO from emp where deptno =30 and job = 'SALESMAN';

-- EX003 집합연산자( UNION을 )를 사용하지 않은 방식 
-- EMP테이블에서 IN 연산자를 이용하여 DEPTNO 가 20 또는 30인 사원의 SAL이 2000 초과인 사원을 조회하시오
select EMPNO, ENAME, JOB, SAL, DEPTNO from emp where deptno in (20,30) and sal > 2000;

--EX003 집합연산자( UNION을 )를 사용한 방식
--EMP테이블에서 IN 연산자를 이용하여 DEPTNO 가 20 또는 30인 사원의 SAL이 2000 초과인 사원을 조회하시오
select EMPNO, ENAME, JOB, SAL, DEPTNO from emp where deptno in (20) and sal >2000
union all
select EMPNO, ENAME, JOB, SAL, DEPTNO from emp where deptno in (30) and sal > 2000;

-- EX004 EMP테이블에서 NOT BETWEEN AND 연산자를 사용하지 않고 SAL이 2000이상 3000이하의 값을 가진 데이터만 조회하시오.
select * from emp where sal < 2000 or sal > 3000;

-- EX005 EMP테이블에서 ENAME에 E가 포함되고 DEPTNO가 30인 사원의 급여가 1000~2000사이가 아닌 사원의 ENAME, EMPNO, SAL, DEPTNO 를 조회하시오
select  ENAME, JOB, SAL, DEPTNO from emp where deptno = 30 and ename like '%E%' AND sal not between 1000 and 2000;

-- EX006 EMP테이블에서 COMM 이 없고 , MGR은 존재하면 JOB 이 'MANAGER', 'CLERK' 인 사원 중 사원의 이름2번째 글자기 L 이 아닌 사원의 정보를 조회하시오.
select * from emp where comm is null and mgr is not null and job in ('MANAGER','CLERK') and ename not like '_L%';

select * from emp where comm is null and mgr is not null and (job = 'MANAGER' or job = 'CLERK') and ename not like '_L%';
