-- join
-- emp (deptno), dept (deptno) 한테이블처럼 사용하는 방법

-- (0) 비표준
select empno , ename, d.deptno, dname
from emp e, dept d
where e.deptno = d.deptno;
group by
having
order by

-- (1) JOIN ON      sqp-99 표쥰
select empno , ename, d.deptno, dname
from emp e join  dept d on (e.deptno = d.deptno);

-- (2) JOIN USING       sqp-99 표쥰
select empno , ename, deptno, dname
from emp e join  dept d using (deptno);

-- (3) NATURAL JOIN     sqp-99 표쥰
select empno , ename, deptno, dname
from emp e natural join  dept d;

-- (4) (+) null 값 붙여줄게 - spl 99 이전
select empno , ename, d.deptno, dname
from emp e, dept d
where e.deptno(+) = d.deptno;

-- (5) RIGHT OUTER JOIN
select empno , ename, d.deptno, dname
from EMP E RIGHT OUTER JOIN DEPT D ON (e.deptno = d.deptno);

-- (6) LEFT OUTER JOIN
select empno , ename, d.deptno, dname
from DEPT D LEFT OUTER JOIN EMP E ON (e.deptno = d.deptno);

-- (7) FULL OUTER JOIN
select empno , ename, d.deptno, dname
from DEPT D FULL OUTER JOIN EMP E ON (e.deptno = d.deptno);


-- 서브쿼리  select 안에 select

-- #1. [단일행, =](2073) 서브쿼리 평균 급여보다 많이 받는 사원들
--STEP1)
--select ename, sal
--from emp
--where sal > [평균급여(2073)]
--order by sal desc;

-- STEP2)
select ename, sal
from emp
where sal > (select avg(sal) from emp)
order by sal desc;

-- #2. [다중행, in] deptno가 10인 부서의 job인 사원들 ename,sal
select ename, sal
from emp
where job in (select job from emp where deptno=10)
order by sal desc;

-- #3. 다중행 연산자
-- 1. in        "이 값이 목록에 있나요?"    deptno in (10,20,30)
-- 2. any,some  "하나라도 만족하면 ok"         < 값 >    ■최소,최대 사이값 (최소값 기준 비교)
--      컬럼 > any(서브쿼리) 최소값보다 크면 true
--      컬럼 < any(서브쿼리) 최대값보다 작으면 true
--       컬럼 > any(1,2,3)         |(1)    |(2)    |(3)        1보다 커야한다.
--       컬럼 < any(1,2,3)         |(1)    |(2)    |(3)        3보다 작아야한다.
        
-- 3. all       "모두 만족해야 ok"           값 >   < 값 ■최소,최대 바깥값 (최대값 기준 비교)
--      컬럼 > all(서브쿼리) 최대값보다 크면 true
--      컬럼 < all(서브쿼리) 최소값보다 작으면 true
--        컬럼 > any(1,2,3)         |(1)    |(2)    |(3)        3보다 커야한다 
--        컬럼 < any(1,2,3)         |(1)    |(2)    |(3)        1보다 작아야한다.
        
-- 암기) 컬럼 > any1    컬럼>all3
        
-- 4. exists    "서브쿼리가 존재하면 ok"          

-- 최대값(5) 보다 작다 [1,2,3,4]
select num  from atest where  num < any(select num from atest  where num in(3,4,5)) order by num;
-- 최소값(3) 보다 크다 [4,5,6]
select num  from atest where  num > any(select num from atest  where num in(3,4,5)) order by num;
-- 최소값(3) 보다 작다 [1,2]
select num  from atest where  num < all(select num from atest  where num in(3,4,5)) order by num;
-- 최대값(5) 보다 크다 [6]
select num  from atest where  num > all(select num from atest  where num in(3,4,5)) order by num;


-- #4. [다중열] 서브쿼리
-- where    sal > any , sal in any
select ename, deptno, job
from emp
where (deptno,job) in (select deptno, job from emp where sal >2000);

select * from emp order by sal;

-- #5. 인라인뷰 (from)
select empno, ename, d.deptno, dname
from emp e, dept d
where e.deptno = d.deptno;
▼
select empno, ename, d.deptno, dname
from (select * from emp where deptno=20) e , (select * from dept) d         -- 여기에 걸어놓으면 전체필터링때 더욱 빨리진다.
where e.deptno = d.deptno;


-- #6. WITH (구조체 느낌스인듯...?)
with 
e6 as (select * from emp where deptno=30)
,d6 as (select * from dept)
select empno, ename, d6.deptno, dname
from e6 , d6
where e6.deptno = d6.deptno;

with e6 as (select * from emp where deptno=30)
select count(*) from e6;

-- #7. 스칼라 서브쿼리
-- 데이터가 많은 경우 성능 저하
select empno, ename, sal
        ,(select grade from salgrade where emp.sal between losal and hisal) salgrade
        ,deptno
        ,(select loc from dept where emp.deptno = dept.deptno) location
from emp;



-- Q1~Q7
-- 1. EMP 테이블에서 다음과 같이 출력하시오. 사원이름이 JONES 인 사원의 급여를 출력하시오
select sal from emp where ename = 'JONES';

-- 2. EMP 테이블에서 다음과 같이 출력하시오. 급여가 2975보다 높은 사원정보를 출력하시오
select * from emp where sal > 2975;

-- 3. EMP 테이블에서 다음과 같이 출력하시오. JONES의 급여보다 높은급여를 받는 사원정보를 출력하시오.
select * from emp where sal > (select sal from emp  where ename = 'JONES');

-- 4. EMP 테이블에서 다음과 같이 출력하시오. SCOTT보다 빨리 입사한 사원목록을 출력하시오.
select * from emp where hiredate < (select hiredate from emp where ename = 'SCOTT');

-- 5. 20번부서에 속한 사원 중 전체사원의 평균급여보다 높은 급여를받는 사원정보와 소속부서정보를 출력하시오.
select e.empno, e.ename, e.job, e.deptno, d.dname, d.loc
from emp e join dept d on (e.deptno = d.deptno)
where sal > (select avg(sal) from emp) and e.deptno = 20;

-- 6. EMP 테이블에서 다음과 같이 출력하시오. 부서번호가 20이거나 30인 사원의 정보를 출력하시오
select * from emp where deptno in (20,30);

-- 7. EMP 테이블에서 다음과 같이 출력하시오. 각 부서별 최고급여와 동일한 급열르 받는 사원정보를 출력하시오.
select * from emp
where sal in (select max(sal) from emp group by deptno);

-- 8. EMP 테이블에서 다음과 같이 출력하시오. 부서번호 별로 최대 급여를 출력하시오. 7번문제가 잘풀렸는지 확인하시오.
select max(sal) from emp group by deptno;

-- 9. ANY 연산자를 이용하여 다음과같이 출력해보시오
SELECT * FROM EMP WHERE SAL = ANY(SELECT MAX(SAL) FROM EMP GROUP BY DEPTNO);

-- 10.EMP 테이블에서 다음과 같이 출력하시오. some 연산자를 이용하여 다음과같이 출력해보시오
SELECT * FROM EMP WHERE SAL = some(SELECT MAX(SAL) FROM EMP GROUP BY DEPTNO);

-- 11. ANY를 이용하여 30번 부서 사원들의 최대 급여보다 적은 급여를 받는 사원정보를 출력하시오.
select * from emp where sal < any(select max(sal) from emp where deptno = 30 group by deptno) order by sal ;
select * from emp where sal < any(select sal from emp where deptno = 30) order by sal;

-- 12.부서번호가 30인 사원들의 급여를 출력하시오.
select sal from emp where deptno = 30;

-- 13. ANY를 이용하여 30번 부서 사원들의 최소 급여보다 많은은 급여를 받는 사원정보를 출력하시오.
select * from emp where sal > any(select min(sal) from emp where deptno = 30) order by sal desc;

select * from emp where sal > any(select sal from emp where deptno = 30) order by sal desc;

-- 14. ALL를 이용하여 30번 부서 사원들의 최소 급여보다 더 적은 급여를 받는 사원정보를 출력하시오.
select * from emp where sal < all(select sal from  emp where deptno =30);

-- 15. ALL를 이용하여 30번 부서 사원들의 최대 급여보다 더 많은 급여를 받는 사원정보를 출력하시오.
select * from emp where sal > all(select sal from emp where deptno=30) order by sal;

-- 16. DEPT 테이블에 DEPTNO = 10인 행이 하나라도 존재하는 경우
SELECT * FROM EMP WHERE EXISTS (SELECT DNAME FROM DEPT WHERE DEPTNO=10);
select * from emp;

-- 17. DEPT 테이블에 DEPTNO = 50인 행이 하나라도 존재하는 경우
SELECT * FROM EMP WHERE EXISTS (SELECT DNAME FROM DEPT WHERE DEPTNO=50);

-- 18. 다중열 서브쿼리를 이용하여 WHERE (DEPTNO, SAL) IN ( ... ) 부서별 최대급여를 받는 사원정보를 출력하시오.
select * from emp where (deptno,sal) in (select deptno,max(sal) from emp group by deptno);

-- 19. FROM 절에서 사용하는 인라인 뷰를 이용하여 부서번호가 10인 사용자 정보와 부서정보를 가져와
-- EMPNO, ENAME, DEPTNO, DNAME, LOC 를 출력하시오
select empno, ename, d.deptno, dname, loc
from (select * from emp where deptno=10) e, (select * from dept where dname = 'ACCOUNTING') d;

-- 20.WITH / FROM 절에 명시하는 방식보다 몇십, 몇백줄의 규보가 되었을때 유용하게 사용됨.
with e as (select * from emp where deptno=10) ,d  as (select * from dept where dname = 'ACCOUNTING') 
select empno, ename, d.deptno, dname, loc
from e,d
where e.deptno = d.deptno;


-- 21. EMP 테이블의 EMPNO, ENAME, JOB, SAL EMP 테이블의 SAL을 이용하여 SALGRADE에서 등급(GRADE)을 구하고
-- EMP 테이블의 DEPTNO를 이용하여 DEPTNO가 같은 부서명(DNAME)을 구하시오.
select EMPNO, ENAME, JOB, SAL 
            ,(select grade from salgrade where emp.sal between losal and hisal) salgrade
            ,deptno
            ,(select dname from dept where emp.deptno = dept.deptno) dept
from emp;

select * from salgrade;
select * from dept;
select * from emp;

-- EX1) 전체 사원 중 ALLEN과 같은 직책(JOB)인 사원들의 사원정보, 부서정보를 다음과 같이 출력하시오.
-- =, join on, join using, natural join, with(테이블선언), 스칼라서브쿼리
-- 1.  = 
select job, empno, ename, sal, d.deptno, dname
from emp e , dept d
where e.deptno = d.deptno and job = (select job from emp where ename ='ALLEN');
-- 2. join on
select job, empno, ename, sal, d.deptno, dname
from emp e join dept d on (e.deptno = d.deptno)
where job = (select job from emp where ename ='ALLEN');
-- 3. join using
select job, empno, ename, sal, deptno, dname
from emp e join dept d using(deptno)
where job = (select job from emp where ename ='ALLEN');
-- 4. natural join 
select job, empno, ename, sal, deptno, dname
from emp e natural join dept d 
where job = (select job from emp where ename ='ALLEN');
-- 5. with (단일행 !추천!)
with 
e as (select * from emp where job = (select job from emp where ename ='ALLEN')),
d as (select * from dept)
select job, empno, ename, sal, d.deptno, dname
from e,d
where d.deptno = e.deptno;
-- 6. 스칼라서브쿼리
select job 
, empno
, ename 
, sal
, deptno
, (select dname from dept where emp.deptno = dept.deptno) dname
from emp
where job = (select job from emp where ename ='ALLEN');


select * from emp;
select * from dept;


-- EX2) 전체 사원의 평균급여(SAL) 보다 높은 급여를 받는 사원들의 사원정보, 부서정보, 급여등급정보를 출력하시오.
-- 급여가 많은 순으로 정렬하되 급여가 같은경우에는 사원번호를 기준으로 오름차순으로 정렬
select e.empno, e.ename, d.dname, e.hiredate, d.loc, e.sal, s.grade
from emp e , dept d, salgrade s
where e.deptno = d.deptno and e.sal >(select avg(sal) from emp) and e.sal between s.losal and s.hisal
order by e.sal desc , e.deptno;

-- EX3) 10번부서에서 근무하는 사원 중 30번부서에는 존재하지 않는 직책을 가진 사원들의 사원정보, 부서정보를 다음과 같이 출력하는 SQL문을 작성하시오.
select e.empno, e.ename, e.job, e.deptno, d.dname, d.loc
from emp e join dept d on (d.deptno = e.deptno)
where e.deptno = 10 and e.job not in (select job from emp where deptno =30);

-- EX4) 직책이 SALESMAN인 사람들의 최고급여보다 높은 급여를 급여를 받는 사원들의 사원정보, 급여등급정보를 다음과 같이 출력하시오.
-- 다중행 함수 사용하지 않는 방법, 다중행 함수 사용하는 방법 2가지로 작성하시오.
-- 사원번호를 기준으로 오름차순으로 정렬하시오.
select empno, ename, sal, grade
from emp e join salgrade s on (sal between s.losal and s.hisal )
where (sal,job) in (select sal,job from emp where sal > (select max(sal) from emp where job = 'SALESMAN'))
order by empno; 

select empno, ename, sal, grade
from emp e join salgrade s on (sal between s.losal and s.hisal )
where sal > all(select sal from emp where job = 'SALESMAN')
order by empno;


