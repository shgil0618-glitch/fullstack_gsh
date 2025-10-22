-- 1
select * from emp;

-- 2. 집계함수 - sum, count, max, min, avg
select sum(sal) from emp; -- 1개

-- 3. 부서의 직업별 급여의 평균
select deptno, job, avg(sal) from emp group by deptno,job;

-- 4. where vs having - [급여의 평균]에서 2000이상
select deptno, job, avg(sal)    --5
from emp                --1
where sal >=1500        --2 전체데이터에q서 필터링
group by deptno, job    --3 [부서의 직업별], 급여의 평균
having avg(sal) >2000   --4 3번에서 나온 급여의 평균으로 having
;

-- 5. rollup, cube, grouping sets / pivot, unpivot
-- [부서의 직업별],명수,급여평균
-- rollup : 10부서의 직업 급여의 평균-> 20부서의 급여의 평균-> 30부서의 급여의 평균 -> 전체 총계  (작은거 -> 큰거)
select deptno, job, count(*), round(avg(sal),1)
from emp
group by rollup(deptno, job);

-- cube :전체총계(job+deptno) -> job총계 -> deptbo 총계 -> deptno+job각각의 세부내용           (큰거 -> 작은거)
select deptno, job, count(*), round(avg(sal),1)
from emp
group by cube(deptno, job);

-- grouping  뭘로 묶였는지 확인 - 해당컬럼이 실제로 그룹화 되었니?  0 그룹화에 포합됨 / 1 그룹화에 포함되지 않음.
select deptno, job, grouping(deptno), grouping(job)  
from emp                    -- 1
group by cube(deptno, job); -- 2            deptno+job , job, deptno, 둘다세부

-- pivot 행데이터를 열로
select *
from  ( select 컴럼1,컬럼2,집계대상컬럼 from 테이블명 )          -- 원본데이터 : pivot을 적용할 대상
pivot ( 집계함수(집계대상) for 컬럼기준 in (값1,값2,값3,,,) );         -- 집계함수   : 어떤 컬럼기준으로 만들것인지 지정

select *
from (select deptno,job,sal from emp)
pivot ( max(sal) for deptno in (10,20,30) );  -- job별 부서(10,20,30)의 최대급여

-- 1) job별 부서 10,20,30의 최대급여
select *
from (select deptno,job,sal from emp)
pivot (max(sal) for deptno in (10,20,30));

-- 2) 직무별 부서별 사원수 - job별 부서 10,20,30의 최대급여
select *
from (select deptno,job,empno from emp)
pivot (count(empno) for deptno in (10,20,30));

-- 부서별 직무 평균 급여
select *
from (select deptno,job,sal from emp)
pivot (avg(sal) for job in ('MANAGER','CLERK','SALESMAN'));

-- unpivot 열데이터를 행으로
-- decode(job,'MANAGER',sal) job필드에서 clerk인 경우만 sal 반환, 아니면 null
select *
from (
select deptno, max(decode(job,'CLERK',sal)) CLERK,
max(decode(job,'MANAGER',sal)) MANAGER 
from emp 
group by deptno
)    -- 원본데이터 : unpivot을 적용할 대상 (열형태로 집계된 데이터)
unpivot (
sal for job in (CLERK,MANAGER)
);     -- unpivot : 열을 행으로 변환, 기준컬럼 열이름이였던것을 행 값으로 변환
-- unpivot 열데이터를 행으로
-- 풀이1) deptno, clerk(열), manager(열)
-- 풀이2) deptno, job      , sal
--                CLERK
--                MANAGER


----------------------------------------------------------------------------------------
-- Q25 ~ Q39  https://sally03915.github.io/stackventure_250825/004_oracle/oracle005_select_group#38
-- 25. 부서별(큰그룹) 직책(소그룹)의 사원수, 가장 높은 급여, 급여의 합, 평균급여를 출력하시오.
select deptno, job, count(*), max(sal), sum(sal), avg(sal) --3
from emp --1
group by rollup(deptno,job); --2

-- 26. 부서별(큰그룹) 직책(소그룹)의 사원수, 가장 높은 급여, 급여의 합, 평균급여를 출력하시오.
select deptno, job, count(*), max(sal), sum(sal), avg(sal) 
from emp
group by CUBE(DEPTNO, JOB);

-- 27. DEPTNO를 먼저 그룹화한후 ROLLUP 함수에 JOB을 지정하여 사원수를 출력하시오
select deptno, job, count(*)
from emp
group by deptno ,rollup(job);

-- 28.JOB을 먼저 그룹화한후 ROLLUP 함수에 DEPTNO을 지정하여 사원수를 출력하시오.
select deptno, job, count(*)
from emp
group by job,rollup(deptno);

-- 29. GROUPING SETS (DEPTNO, JOB) 함수를 사용하여 열별 그룹으로 묶어어 결과로 출력하시오.
select deptno,job,count(*)
from emp
group by grouping sets (deptno,job);



-- 30. EMP 테이블에서 DEPTNO JOB열의 그룹화결과를 GROUPING 함수로 출력하시오.
select  deptno,job,count(*),max(sal),sum(sal),avg(sal),grouping(deptno),grouping(job)
from emp
group by cube(deptno,job);

-- 31. DECODE문으로 GROUPING 함수를 적용하여 결과를 표기하시오오
select decode(grouping(deptno),1,'ALL_DEPT',deptno) as DEPTNO -- grouping(deptno)가 1이라면 적용안되었다는 의미 ALL_DEPT
, decode(grouping(job),1,'ALL_JOB',job) as JOB
, count(*), max(sal), sum(sal), avg(sal)
from emp
group by cube(deptno,job)
order by deptno,job;




-- 32. DEPTNO, JOB을 함께 명시한 GROUPING_ID 함수를 사용하시오.
-- grouping_id : 집계수준 (몇번집계)
SELECT 
  deptno, job,
  COUNT(*), SUM(sal),
  GROUPING(deptno), GROUPING(job),
  GROUPING_ID(deptno, job)
FROM emp
GROUP BY cube(deptno, job)
order by deptno,job;

1) deptno(o)        job(0),         grouping_id(o)  정상조합
2) deptno(o)        job(1:null)     grouping_id(1)  deptno 실제값, job null
3) deptno(1:null)   job(0)          grouping_id(2)  deptno null, job 실제값
3) deptno(1:null)   job(1:null)     grouping_id(3)  전체집계    둘다 null                 
grouping_id() 안에 숫자 grouping 애들 값으로 이진법 00 01 10 11

-- 33. EMP 테이블에서 GROUP BY로 그룹화하여 부서번호와 사원이름을 출력하시오.
select deptno, ename
from emp
group by deptno,ename ;

-- 34. EMP 테이블에서 부서별 사원이름을 나란히 나열하여 출력하시오.
-- LISTAGG( 나열할 열, 구분자) WITHIN GROUP(ORDER BY 나열할 열의 정렬기준
select deptno, LISTAGG(ename, ',') WITHIN GROUP(order by sal desc) enames
from emp
group by deptno;

-- 35. EMP 테이블에서 부서, 직책별 그룹화하여 최고급여데이터를 출력하시오
select deptno, job, max(sal)
from emp
group by deptno,job
order by deptno,job;

-- 36. EMP 테이블에서 PIVOT함수를 사용하여 직책별* 부서별 최고급여를 2차원 표 형태로 출력하시오
select *  
from (select deptno,job,sal from emp)
pivot (max(sal) for deptno in (10,20,30));

-- 37. EMP 테이블에서 PIVOT함수를 사용하여 부서별*직책책별 최고급여를 2차원 표 형태로 출력하시오
select *
from (select deptno,job,sal from emp)
pivot (max(sal) for job in ('CLERK','SALESMAN','PRESIDENT','MANAGER','ANALYST'));

-- 38. EMP 테이블에서 DECODE문을 활용하여 PIVOT 함수와 같은 결과를 출력하시오
SELECT 
  deptno,
  MAX(DECODE(job, 'CLERK',     sal)) AS CLERK,
  MAX(DECODE(job, 'SALESMAN',  sal)) AS SALESMAN,
  MAX(DECODE(job, 'PRESIDENT', sal)) AS PRESIDENT,
  MAX(DECODE(job, 'MANAGER',   sal)) AS MANAGER,
  MAX(DECODE(job, 'ANALYST',   sal)) AS ANALYST
FROM emp
GROUP BY deptno
ORDER BY deptno;

-- 39. EMP 테이블에서 UNPIVOT 활용하여 열로 구분된 그룹을 행으로 출력하시오
select *
from (
select deptno, max(decode(job,'CLERK',sal)) CLERK,
max(decode(job,'MANAGER',sal)) MANAGER ,
max(decode(job,'PRESIDENT',sal)) PRESIDENT ,
max(decode(job,'SALESMAN',sal)) SALESMAN ,
max(decode(job,'ANALYST',sal)) ANALYST
from emp 
group by deptno
order by deptno
)   
unpivot (
sal for job in (CLERK,MANAGER,PRESIDENT,SALESMAN,ANALYST)
);