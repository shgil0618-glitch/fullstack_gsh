-- 1
select * from emp;

-- 2. 집계함수 - sum, count, max, min, avg
select sum(sal) from emp;   -- 1개

-- 3. 부서의  직업별 급여의 평균  group by>  deptno , job
select deptno , job ,    avg(sal) from emp  group by deptno , job ; 

-- 4. where  vs having - [급여의 평균]에서 2000이상
select   deptno , job ,    avg(sal)  -- 5.
from     emp              -- 1
where    sal>=1500        -- 2 전체데이터에서 필터 
group by deptno , job     -- 3 [부서의  직업별], 급여의 평균
having   avg(sal) > 2000; -- 4. 3번에서 나온  급여의 평균 으로 having


-- 5. rollup ,cube, grouping sets / pivot, unpivot
--       [부서의  직업별] , 명수,     급여의 평균
--  rollup :  10부서의 직업 급여의 평균, 20부서의  급여의 평균 , 30부서의  급여의 평균 = 전체 총계   작은>큰거
select      deptno, job ,  count(*) ,  round( avg(sal) , 1)
from        emp
group by    rollup(deptno , job) ; 

--  cube :  deptno + job전체총계 , job 총계 , deptno 총계 , deptno + job각각의 세부내용   큰거에서 > 작은걸로
select      deptno, job ,  count(*) ,  round( avg(sal) , 1)
from        emp
group by    cube(deptno , job) ; 

-- grouping 뭘로묶였는지 확인 - 해당컬럼이 실제로 그룹화되었니?   0 그룹화에 포함됨 / 1 그룹화에 포함이 되지 않음.
select      deptno, job ,  grouping(deptno) , grouping(job) 
from        emp    -- 1
group by    cube(deptno , job) ; -- 2         deptno + job, job, deptno , 둘다세부

--  pivot  행데이터를 열로
select   *
from     (   select  컬럼1, 컬럼2 , 집계대상컬럼 from 테이블명          )   -- 원본데이터 : pivot을 적용할 대상
pivot    (   집계함수(집계대상) for  컬럼기준 in (값1, 값2, 값3 ,,,)    );  -- 집계함수   : 어떤컬럼기준으로 만들 것인지 지정

-- 1) job별 부서 10,20,30의 최대급여 
select  * 
from     (     select  deptno, job, sal from emp  )
pivot    (     max(sal)  for deptno in(10,20,30)  );  

-- 2) 직무별 부서  사원 수   - job별 부서 10,20,30의 사원 수
select    *
from     (  select  job, deptno , empno  from emp   )    
pivot    (  count(empno)   for  deptno  in (10,20,30)    );

-- 3) 부서별 직무 평균 급여   
select    * 
from    ( select deptno, job , sal  from emp  )
pivot   ( avg(sal)  for  job in ( 'CLERK'  , 'MANAGER', 'SALESMAN' )   );

-- unpivot  열데이터를 행으로 
-- decode(job,'CLERK' , sal)  JOB필드에서   CLERK 인경우만 SAL 반환, 아니면 NULL
select  *
from    (
    select  deptno, max(  decode(job,'CLERK' , sal)    ) CLERK 
                  , max(  decode(job,'MANAGER' , sal)  ) MANAGER    --#3
    from emp   --#1
    group by deptno  --#2
)  -- 원본데이터 : unpivot을 적용할대상( 열형태로 집계된 데이터)
unpivot (
    SAL FOR  JOB  IN (CLERK ,MANAGER  )
); --  unpivot : 열을 행으로 변환, 기준컬럼 열이름이었던것을 행 값으로 변환
-- 풀이1) DEPTNO , CLERK(열) , MANAGER(열)
-- 풀이2) DEPTNO ,    JOB ,  SAL
--                   CLERK
--                   MANAGER

--1)             ↓(열)       ↓(열)
    DEPTNO      CLERK    MANAGER
---------- ---------- ----------
        30        950       2850
        20       1100       2975
        10       1300       2450


-- 2) unpivot
    DEPTNO JOB                   SAL
---------- -------------- ----------
        30 CLERK                 950   → (행)
        30 MANAGER              2850   →
        20 CLERK                1100   →
        20 MANAGER              2975
        10 CLERK                1300
        10 MANAGER              2450
-- 

-- #### https://sally03915.github.io/stackventure_250825/004_oracle/oracle005_select_group#38
-- Q25~39

--Q025
--EMP 테이블에서 ROLLUP 함수를 이용하여  
--부서별(큰그룹) 직책(소그룹)의  
--사원수, 가장 높은 급여, 급여의 합, 평균급여를 출력하시오.

select     deptno, job,  count(*) , max(sal), sum(sal), avg(sal)  
from       emp   
group by   rollup( deptno, job );   

--Q026
--EMP 테이블에서 CUBE(DEPTNO, JOB) 함수를 이용하여
--부서별(큰그룹) 직책(소그룹)의
--사원수, 가장 높은 급여, 급여의 합, 평균급여를 출력하시오.( deptno + job(총), job(중간분류), deptno(중간분류) deptno+job(세부사항) )

select     deptno, job,  count(*) , max(sal), sum(sal), avg(sal)  
from       emp   
group by   cube( deptno, job );


--Q027
--EMP 테이블에서
--DEPTNO를 먼저 그룹화한후 ROLLUP 함수에 JOB을 지정하여
--사원수를 출력하시오.
select deptno, job, count(*)
from   emp
group by deptno, rollup(  job  );



--Q028
--EMP 테이블에서
--JOB을 먼저 그룹화한후 ROLLUP 함수에 DEPTNO을 지정하여
--사원수를 출력하시오.
select deptno, job, count(*)
from   emp  -- 1 
group by job, rollup(  deptno  );



--Q029
--EMP 테이블에서
--GROUPING SETS (DEPTNO, JOB) 함수를 사용하여
--열별 그룹으로 묶어 결과로 출력하시오.  ## 풀기
select deptno, job, count(*)
from   emp   
group by GROUPING SETS (DEPTNO, JOB);

## 풀이)
-- 다중그룹을 한번에 지정
1) group by DEPTNO      -- job은  null로
2) group by JOB         -- deptno null로

## RESULT)
    DEPTNO JOB                  COUNT(*)
---------- ------------------ ----------
           CLERK                       4
           SALESMAN                    4
           PRESIDENT                   1
           MANAGER                     3
           ANALYST                     2
        30                             6
        20                             5
        10                             3



--Q030
--EMP 테이블에서 DEPTNO JOB열의 그룹화결과를 GROUPING 함수로 출력하시오 ( 기준점적용 : 0 )
SELECT     DEPTNO, JOB, COUNT(*), MAX(SAL),  SUM(SAL), AVG(SAL) , GROUPING(DEPTNO), GROUPING(JOB) 
FROM       EMP
GROUP BY   CUBE(DEPTNO, JOB);




--Q031
--DECODE문으로 GROUPING 함수를 적용하여 결과를 표기하시오오
--  GROUPING(DEPTNO) 가 1이라면 적용안되었다라는의미    ALL_DEPT  
SELECT   DECODE( GROUPING(DEPTNO),1  , 'ALL_DEPT' , DEPTNO    ) AS DEPTNO 
        ,DECODE( GROUPING(JOB)   ,1  , 'ALL_JOB'  , JOB       ) AS JOB
        ,COUNT(*), MAX(SAL), SUM(SAL), AVG(SAL)
FROM    EMP
GROUP   BY  CUBE(DEPTNO, JOB)
ORDER   BY   DEPTNO, JOB;


--Q032
--DEPTNO, JOB을 함께 명시한 GROUPING_ID 함수를 사용하시오.  ##안내   GROUPING_ID : 집계수준(몇번집계)
SELECT    DEPTNO, JOB , COUNT(*), SUM(SAL), GROUPING(DEPTNO), GROUPING(JOB) , GROUPING_ID(DEPTNO, JOB)
FROM      EMP
GROUP BY  CUBE(DEPTNO, JOB)
ORDER BY  DEPTNO, JOB;

1) DEPTNO (O), JOB(0)               GROUPING_ID(0)  정상조합                   0*2^1 + 0*2^0 = 0
2) DEPTNO (O), JOB(1: NULL)         GROUPING_ID(1)  DEPNO 실제값, JOB NULL     0*2^1 + 1*2^0 = 1
3) DEPTNO (1: NULL), JOB(0)         GROUPING_ID(2)  JOB 실제값  , DEPTNO NULL  1*2^1 + 0*2^0 = 2
3) DEPTNO (1: NULL), JOB(1: NULL)   GROUPING_ID(3)  전체집계   둘다 NULL        1*2^1 + 1*2^0 = 3    2^0은 1      



--Q033
--EMP 테이블에서 GROUP BY로 그룹화하여 부서번호와 사원이름을 출력하시오.
select    DEPTNO, ENAME
from      emp
group by  DEPTNO, ENAME;


--Q034
--EMP 테이블에서 부서별 사원이름을 나란히 나열하여 출력하시오.
--LISTAGG( 나열할 열, 구분자)
--WITHIN GROUP(ORDER BY 나열할 열의 정렬기준)  ##안내
--        그룹핑    이름들을 가로방향으로 나열-                    SAL 내림차순
SELECT    DEPTNO,   LISTAGG(  ENAME, ', ' )  WITHIN  GROUP(   ORDER BY SAL DESC )  ENAMES
FROM      EMP
GROUP BY  DEPTNO ;

--Q035
--EMP 테이블에서 부서, 직책별 그룹화하여 최고급여데이터를 출력하시오
SELECT     DEPTNO, JOB , MAX(SAL)
FROM       EMP
GROUP BY   DEPTNO, JOB 
ORDER BY   DEPTNO, JOB ;


--Q036  (행-> 열)
--EMP 테이블에서 PIVOT함수를 사용하여 직책별* 부서별 최고급여를 2차원 표 형태로 출력하시오
SELECT *
FROM  (  SELECT DEPTNO, JOB , SAL FROM EMP   )  
PIVOT (  MAX(SAL)  FOR DEPTNO IN (10,20,30) );


--Q037
--EMP 테이블에서 PIVOT함수를 사용하여 부서별*직책책별 최고급여를 2차원 표 형태로 출력하시오
SELECT *
FROM  (   SELECT  DEPTNO, JOB, SAL FROM EMP   )
PIVOT (   MAX(SAL)  FOR  JOB  IN( 'PRESIDENT' , 'MANAGER',  'ANALYST' , 'CLERK', 'SALESMAN'  )  );


--Q038
--EMP 테이블에서 DECODE문을 활용하여 PIVOT 함수와 같은 결과를 출력하시오
SELECT   DEPTNO  
         , MAX(  DECODE(  JOB , 'CLERK'        , SAL )  )   CLERK
         , MAX(  DECODE(  JOB , 'SALESMAN'     , SAL )  )   SALESMAN
         , MAX(  DECODE(  JOB , 'PRESIDENT'    , SAL )  )   PRESIDENT
         , MAX(  DECODE(  JOB , 'MANAGER'      , SAL )  )   MANAGER
         , MAX(  DECODE(  JOB , 'ANALYST'      , SAL )  )   ANALYST
FROM     EMP
GROUP BY DEPTNO;



--Q039
--EMP 테이블에서 UNPIVOT 활용하여 열로 구분된 그룹을 행으로 출력하시오



--https://sally03915.github.io/stackventure_250825/004_oracle/oracle005_select_group#58
-- Ex001~Ex005

--Ex001
--EMP 테이블을 이용하여 다음과 같이 출력하시오.
--부서번호(DEPTNO) , 평균급여(AVG_SAL) , 최고급여(MAX_SAL) , 최저급여(MIN_SAL) , 사원수(CNT) 를 조회하시오
--평균급여를 출력시 소수점을 제외하고 각 부서번호별로 출력하시오.


--Ex002
--EMP 테이블을 이용하여 다음과 같이 출력하시오.
--같은직책(JOB)에 종사하는 사원이 3명 이상인 직책과 인원수를 출력하시오.


--Ex003
--EMP 테이블을 이용하여 다음과 같이 출력하시오.
--사원들의 입사년도(HIRE_YEAR)를 기준으로 부서별 몇명이 입사했는지 조회하시오.

--Ex004
--EMP 테이블을 이용하여 다음과 같이 출력하시오.
--추가수당(COMM)을 받는 사원수와 받지않는 사원수를 조회하시오.

--Ex005
--EMP 테이블을 이용하여 다음과 같이 출력하시오.
--각 부서의 입사연도별 사원수, 최고급여, 급여합, 평균급여를 출력하고
--각 부서별 소계와 총계를 출력하시오. (ROLLUP)

