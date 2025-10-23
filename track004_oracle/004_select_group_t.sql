select * from emp;

--2. 집계 sum, max, min, avg, count
select sum(sal) from emp;       -- 급여의 합
select sum(comm) from emp;      -- null 값이 있어도 계산가능
--      14줄, 1줄 ,       1줄       
-- select sal, sum(sal), max(sal), min(sal), avg(sal), count(sal) from emp;  --error
select sum(sal) 합, max(sal) 최대, min(sal) 최소, round(avg(sal),2) 평균, count(sal)갯수 from emp;

-- 3. group by
--select      -- 5
--from        -- 1
--where       -- 2
--group by    -- 3 그룹핑
--having      -- 4 그룹핑안에서 조건 (그룹핑 후 필터링)
--order by;   -- 6

-- 부서[별] 급여의 합
select deptno, sum(sal) 
from emp
group by deptno;

-- 4. having (합계를 구했을때 9000이상인 그룹)
select deptno, sum(sal), max(sal), count(*)
from emp
group by deptno
having sum(sal)>=9000;

-- Q1~Q24
-- 1. EMP 테이블에서 SUM 함수를 이용하여 급여 합계(SAL)를 출력하시오.
select sum(sal) from emp;

-- 2. EMP 테이블에서 SUM 함수를 이용하여 사원이름과 급여 합계를 출력하시오.
--에러가 난다면 그이유를 적으시오.
-- select name, sum(sal) from emp; 줄수가 맞지 않아서
select ename, sum(sal) from emp group by ename;

-- 3.EMP 테이블에서 SUM 함수를 이용하여 추가수당(COMM) 합계를 출력하시오.
select sum(comm) from emp;

-- 4. EMP 테이블에서 SUM (DISTINCT, ALL)함수를 이용하여 급여 합계를 출력하시오.
select sum(distinct sal), sum(all sal), sum(sal) from emp;

-- 5. EMP 테이블에서 COUNT를 이용하여 데이터의 갯수를 출력하시오.
select count(*) from emp;

-- 6. EMP 테이블에서 COUNT를 이용하여 부서번호가(EMPNO) 30인 데이터의 갯수를 출력하시오.
SELECT COUNT(*) FROM emp where DEPTNO = 30;

-- 7. EMP 테이블에서 COUNT ( DISTINCT, ALL) 를 이용하여 데이터의 갯수를 출력하시오.
select count(distinct sal) , count(all sal), count(sal) from emp;

-- 8. EMP 테이블에서 COUNT를 이용하여 추가수당(COMM) 열의 갯수를 출력하시오.
select count(comm) from emp;

-- 9. EMP 테이블에서 COUNT를 이용하여 추가수당(COMM) 열의 갯수를 출력하시오.
select count(comm) from emp;

-- 10. EMP 테이블에서 MAX를 이용하여 부서번호(DEPTNO)가 10번인 사원들의 최대 급여를 출력하시오.
select max(sal) from emp where deptno = 10;

-- 11. EMP 테이블에서 부서번호(DEPTNO)가 10번인 사원들의 최소 급여를 출력하시오.
select min(sal) from emp where deptno=10;

-- 12. EMP 테이블에서 부서번호가 20인 사원의 입사일(HIREDATE) 중 제일 오래된 입사일을 출력하시오.
select min(hiredate) from emp where deptno=20;

-- 13. 
select max(hiredate) from emp where deptno=20;

-- 14. EMP 테이블에서 부서번호가 30인 사원의 평균급여를 출력하시오.
select avg(sal) from emp where deptno=30;

-- 15. EMP 테이블에서 부서번호가 30인 사원의 DISTINCT로 중복을 제거한 급여 열의 평균급여를 출력하시오.
select avg(distinct sal) from emp where deptno=30;

-- 16. EMP 테이블에서집합연산자(UNION ALL) 를 사용하여 각 부서별 평균급여를 출력하시오.
select avg(sal), deptno
from emp
where deptno =10
group by deptno
union all
select avg(sal), deptno
from emp
where deptno =20
group by deptno
union all
select avg(sal), deptno
from emp
where deptno =30
group by deptno;

-- 17. EMP 테이블에서 GROUP BY를 사용하여 부서별 평균급여를 출력하시오.
select avg(sal), deptno
from emp
where deptno in (10,20,30)
group by deptno;

--18. EMP 테이블에서 부서번호(DEPTNO) 및 직책별(JOB) 평균급여(SAL)로 정렬한 후 출력하시오.
select deptno, job, avg(sal)
from emp
group by deptno,job        -- 집계함수 앞에 있는건 싹다 그룹핑
order by deptno,job;

-- 19. EMP 테이블에서 GROUP BY절에 없는 열을 SELECT절에 포함하면 에러가 난다.
-- select ename, deptno, avg(sal) from emp; -- 줄수가 달라서
select ename, deptno, avg(sal) from emp group by ename, deptno;

-- 20. EMP 테이블에서 GROUP BY 와 HAVING 절을이용하여
-- 각부서의 직책별 평균급여를 구하되 그 평균급여가 2000이상인 그룹만 출력하시오.
select deptno, job, avg(sal) from emp
group by deptno,job having avg(sal) >=2000
order by deptno, job;

-- 21. 다음 코드가 오류나는 이유를 적으시오
select deptno, job, avg(sal) from emp
where avg(sal) >=2000 group by deptno,job order by deptno, job;     -- avg 함수는 집계함수로 그룹화 후에 계산되는데 그룹화 되기전에 where로 계산이 들어가기때문에

-- 22. WHERE 절을 사용하지 않고 HAVING절만 사용한 경우
select deptno, job, avg(sal) from emp
group by deptno,job having avg(sal) >=2000
order by deptno, job;

-- 23. WHERE절과 HAVING절을 모두 사용한경우
select deptno, job, avg(sal) from emp where job IN ('MANAGER','ANALYST')
group by deptno,job having avg(sal) >=2000
order by deptno,job;

-- 24. 
select deptno, job, count(*), max(sal), sum(sal), avg(sal) from emp
group by deptno, job;
