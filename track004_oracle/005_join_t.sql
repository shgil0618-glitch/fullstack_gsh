-- 1. JOIN
-- 여러테이블을 한개의 데이블처럼 사용하는 것
-- 공통컬럼 기준으로 연결
-- 1-1. 내부조인
--      등가조인  (=)   : 매칭되는 행.           where 절       emp.deptno = dept.deptno
--      비등가조인(= X) :                 sal  between  losal  and  hisal
--      자체조인       :   emp e1, emp e2
-- 1-2. outer join    :  매칭되지 않은 행도 포함.  left, right, full outer join

-- ERD : Entity(테이블) , Relationship(관계) , diagram(표)
--       Entity(테이블) , Relationship(관계) , Attribute(속성)

-- #1. 내부조인 (등가조인)
select *
from   emp e, dept  d
where  e.deptno = d.deptno;   -- 14 * 4 = 56

select *
from   emp e  JOIN dept  d   on( e.deptno = d.deptno); 

select *
from   emp e  JOIN dept  d   using( deptno ); 

select *
from   emp  e  natural join dept d;


-- #2. 외부조인 ( 매칭되지 X )

SELECT * FROM DEPT;   -- DEPTNO 10,20,30,40( 40 , OPERATIONS ,BOSTON)
SELECT * FROM EMP;    -- DEPTNO 10,20,30

-- 1. 조건(+)   ORACLE에서만    -- (+) 없는데이터 NULL 보충해줄께, (+) 안붙은 테이블의 데이터를 보장
SELECT  ENAME , DNAME
FROM    EMP E , DEPT D
WHERE   E.DEPTNO = D.DEPTNO(+);  --14   EMP 테이블 보장, DEPT에서 모자라는 데이터 없는데이터 NULL 채울께

SELECT  ENAME , DNAME
FROM    EMP E , DEPT D
WHERE   E.DEPTNO(+) = D.DEPTNO;  --15  DEPT 테이블 보장,  EMP에서 모자라는 데이터 없는데이터 NULL 채울께

-- 2.  LEFT JOIN  ,  RIGHT JOIN  (ANSI조인=표준)
SELECT  ENAME , DNAME
FROM    EMP E INNER JOIN DEPT D  ON( E.DEPTNO = D.DEPTNO );    -- OUTER JOIN 아님!!!  INNER JOIN , 내부조인 , 겹치는 애들만

SELECT  ENAME , DNAME
FROM    EMP E RIGHT OUTER JOIN DEPT D 
ON     ( E.DEPTNO = D.DEPTNO);   -- RIGHT 쪽에 있는 테이블 보장   (null,  OPERATIONS)

SELECT  ENAME , DNAME
FROM    DEPT D LEFT OUTER JOIN    EMP E 
ON     ( E.DEPTNO = D.DEPTNO);   -- LEFT 쪽에 있는 테이블 보장   (null,  OPERATIONS)

-- 3. FULL OUTER JOIN ( 두 테이블에 있는 모든데이터를 결합)
SELECT ENAME, DNAME
FROM    EMP E    FULL OUTER  JOIN  DEPT D
ON   E.DEPTNO = D.DEPTNO;

-- 비표준  = , (+)
-- 표준   NATURAL JOIN , JOIN ON , JOIN USING , LEFT JOIN , RIGHT JOIN , FULL JOIN


-- 1. emp e , dept d별명  / empno, ename , deptno, dname
select  empno, ename, e.deptno, dname
from    emp e, dept d  
where   e.deptno = d.deptno;

select  empno, ename, e.deptno, dname
from    emp e  join dept d   on(  e.deptno = d.deptno );

select  empno, ename, deptno, dname
from    emp e  join dept d   using(  deptno );

select  empno, ename, deptno, dname
from    emp e  natural join dept d;


-- https://sally03915.github.io/stackventure_250825/004_oracle/oracle006_select_join#14
-- Q1~8
desc emp;
desc dept;


-- Q1 EMP, DEPT 테이블을 이용하여 FROM 절에 여러 테이블을 선언해해 다음과 같이 출력하시오
--    모든 행과 열이 곱해진 값
select * from emp, dept  order by empno;


-- Q2   EMP, DEPT 테이블을 이용하여 EMP의 DEPTNO와 DEPT테이블의 DEPTNO가 같은 데이터를 다음과 같이 출력하시오
select *
from emp , dept
where emp.DEPTNO =  dept.DEPTNO
order by empno;

select *
from emp join dept on(emp.DEPTNO =  dept.DEPTNO)
order by empno;

select *
from emp join dept using(DEPTNO)
order by empno;

select *
from emp natural join dept 
order by empno;


-- Q3
-- EMP, DEPT 테이블을 이용하여
--  FROM 절에  EMP 테이블의 별칭은 E, DEPT 테이블의 별칭은 D로   다음과 같이 출력하시오
select *
from   emp e, dept d
where  e.deptno = d.deptno
order  by empno;

select *
from   emp e join dept d
on( e.deptno = d.deptno)
order  by empno;

select *
from   emp e join dept d
using( deptno)
order  by empno;

select *
from   emp e natural join dept d 
order  by empno;

-- Q4   DEPTNO의 필드가 누구테이블인지 확인불가능
SELECT EMPNO, ENAME, DEPTNO, DNAME, LOC
  FROM EMP E, DEPT D
 WHERE E.DEPTNO = D.DEPTNO;

-- Q5 겹치는 부분만 D.    E. ,  모든필드에 E.
SELECT E.EMPNO, E.ENAME, D.DEPTNO, D.DNAME, D.LOC
  FROM EMP E, DEPT D
 WHERE E.DEPTNO = D.DEPTNO;

SELECT  EMPNO,  ENAME, D.DEPTNO,  DNAME, LOC
  FROM EMP E, DEPT D
 WHERE E.DEPTNO = D.DEPTNO;

-- Q6   = , JOIN ON , JOIN USING, NATURAL JOIN  ( 4가지다 표현도전)
--- EMP, DEPT 테이블을 이용하여
--  급여가 3000이상인 사원의  사원번호, 이름, 급여, 근무부서를   다음과 같이 출력하시오
--힌트)
--SELECT     사원번호, 이름, 급여, 근무부서
--FROM       EMP, DEPT 테이블을
--WHERE      급여가 3000이상인;

SELECT     empno, ename, sal, d.deptno , dname , loc
FROM       EMP e, DEPT d 
WHERE      e.deptno = d.deptno  and  e.sal >=3000;

SELECT     empno, ename, sal, d.deptno , dname , loc
FROM       EMP e join DEPT d   on(e.deptno = d.deptno )
WHERE      e.sal >=3000;

SELECT     empno, ename, sal, deptno , dname , loc    -- deptno
FROM       EMP e join DEPT d   using(deptno)          --  using(deptno)   
WHERE      e.sal >=3000;

SELECT     empno, ename, sal, deptno , dname , loc     
FROM       EMP e  natural join DEPT d  
WHERE      e.sal >=3000;


-- Q7  비등가조인
--- EMP, SALGRADE 테이블을 이용하여
--  유저 정보, 급여등급 , 그 등급의 최소급여와 최대급여를  다음과 같이 출력하시오
--힌트)
--SELECT * FROM SALGRADE;   -- GRADE , LOSAL(최소급여), HISAL(최대급여)
--SELECT  *
--FROM    EMP, SALGRADE 테이블
--WHERE   유저의 급여가  BETWEEN  최소급여   AND      최대급여;

SELECT * FROM SALGRADE;

select *
from   emp e, SALGRADE s
where  e.sal  >= losal  and  e.sal <=hisal;

select *
from   emp e join  SALGRADE s  on( e.sal  >= losal  and  e.sal <=hisal);

--select *
--from   emp e join  SALGRADE s  using( 겹치는 필드가 안보임 x -서브쿼리로 가능 );

select *
from   emp e, SALGRADE s
where  e.sal  between losal  and  hisal;   -- 비등가조인

select *
from   emp e join SALGRADE s  on( e.sal  between losal  and  hisal );  -- 비등가조인

--select *
--from   emp e join SALGRADE s  using( 겹치는 필드가 안보임 x -서브쿼리로 가능 );



-- Q8  자체조인
--- EMP테이블을 2번 이용하여
--  사원정보(EMPNO, ENAME, MGR) 와  직속상관(EMPNO, ENAME)의 사원번호를 다음과 같이 출력하시오
--힌트)
--SELECT    사원정보(EMPNO, ENAME, MGR) , 직속상관(EMPNO, ENAME)
--FROM      EMP E1, EMP E2
--WHERE     E1.MGR     = E2.EMPNO;  -- 사원의 직속상관(MGR) , 직속상과(EMPNO)

SELECT   E1.EMPNO, E1.ENAME, E1.MGR , E2.EMPNO  MGR_EMPNO , E2.ENAME    MGR_ENAME
FROM     EMP E1 , EMP E2
WHERE    E1.MGR = E2.EMPNO
ORDER    BY E1.MGR ASC;
 
SELECT   E1.EMPNO, E1.ENAME, E1.MGR , E2.EMPNO  MGR_EMPNO , E2.ENAME    MGR_ENAME
FROM     EMP E1  JOIN EMP E2 ON( E1.MGR = E2.EMPNO)
ORDER    BY E1.MGR ASC; 
 
--SELECT   E1.EMPNO, E1.ENAME, E1.MGR , E2.EMPNO  MGR_EMPNO , E2.ENAME    MGR_ENAME
--FROM     EMP E1  JOIN EMP E2  USING(같은필드 X)
--ORDER    BY E1.MGR ASC; 
 
-- https://sally03915.github.io/stackventure_250825/004_oracle/oracle006_select_join#33
-- Q9~16

--Q009
--- EMP테이블을 2번 이용하여
--1.  사원정보(EMPNO, ENAME, MGR) 와  직속상관(EMPNO, ENAME)의 사원번호를 다음과 같이 출력하시오
--2.  직속상관이 없는 사원의 정보도 출력하시오  ##

select   e1.empno, e1.ename , e1.mgr , e2.empno  MGR_EMPNO ,   e2.ename  MGR_ENAME
from     emp  e1 , emp e2
where    e1.mgr =  e2.empno(+) 
order by  e1.empno;   -- (+) null 채워줄께

select   e1.empno, e1.ename , e1.mgr , e2.empno  MGR_EMPNO ,   e2.ename  MGR_ENAME
from    emp  e1  left join emp e2  on(  e1.mgr =  e2.empno)  
order by  e1.empno;  -- 왼쪽테이블의 데이터가 무조건 다나오게

select   e1.empno, e1.ename , e1.mgr , e2.empno  MGR_EMPNO ,   e2.ename  MGR_ENAME
from     emp e2 right join   emp  e1  on(  e1.mgr =  e2.empno)  
order by  e1.empno;  -- 오른쪽테이블의 데이터가 무조건 다나오게


--Q010
---  (+)의 위치를 바꿔서 출력해보고 다음이 의미하는 바를 적으시오

select   e1.empno, e1.ename , e1.mgr , e2.empno  MGR_EMPNO ,   e2.ename  MGR_ENAME
from     emp  e1 , emp e2
where    e1.mgr(+) =  e2.empno 
order by  e1.empno;   -- (+) null 채워줄께 , 매너저들의 번호와 이름은 있으나,,,, 관리하는 사원이 없음.


--Q011 표준문법 (NATURAL JOIN)
--- EMP , DEPT 테이블 이용하여
--  EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM를 다음과 같이 출력하시오
--1.   NATURAL JOIN
--  - 알아서 두 테이블의 이름과 자료형이 같은 열을 찾은 후
--  - 그 열을 기준으로 등가조인을 해주는 방식
select   empno, ename, job, mgr, hiredate , sal, comm, deptno, dname, loc
from     emp    natural join  dept  
order by deptno , empno;


--Q012 표준문법 (JOIN USING)
--- EMP , DEPT 테이블 이용하여
--  EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM를 다음과 같이 출력하시오
--1.  JOIN USING
--  - USING에 조인기준열 명시
--  - 그 열을 기준으로 등가조인을 해주는 방식
select   empno, ename, job, mgr, hiredate , sal, comm, deptno, dname, loc
from     emp    join  dept  using(deptno)
where    sal >= 3000
order by deptno , empno;

select   empno, ename, job, mgr, hiredate , sal, comm, e.deptno, dname, loc
from     emp  e  join  dept d  on(e.deptno = d.deptno)
where    sal >= 3000
order by deptno , empno;



-- Q013  표준문법 (JOIN ON)
--- EMP , DEPT 테이블 이용하여 EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM를 다음과 같이 출력하시오
select   empno, ename, job, mgr, hiredate , sal, comm, e.deptno, dname, loc
from     emp  e  join  dept d  on(e.deptno = d.deptno)
where    sal <= 3000
order by deptno , empno;



--Q014   표준문법 (LEFT OUTER JOIN )
--- EMP테이블을 2번 이용하여   다음과 같이 출력하시오
--
--1.  LEFT OUTER JOIN
--  - 왼쪽 외부조인을 기준으로 NULL보장
select   e1.empno, e1.ename, e1.mgr , e2.empno MGR_EMPNO,  e2.ename  MGR_ENAME
from     emp e1  LEFT OUTER JOIN emp e2  on ( e1.mgr =  e2.empno)
order    by e1.empno ;

--Q015 표준문법 (RIGHT OUTER JOIN )
--- EMP테이블을 2번 이용하여  다음과 같이 출력하시오
--1.  RIGHT OUTER JOIN- 오른른쪽 외부조인을 기준으로 NULL보장
select   e1.empno, e1.ename, e1.mgr , e2.empno MGR_EMPNO,  e2.ename  MGR_ENAME
from     emp e2  right OUTER JOIN emp e1  on ( e1.mgr =  e2.empno)   -- e1, e2 테이블 위치 바꾸기
order    by e1.empno ;
 
 
--Q016 표준문법 (FULL OUTER JOIN )
--- EMP , DEPT 테이블 이용하여  다음과 같이 출력하시오
--1.  FULL OUTER JOIN - 양쪽모두두 외부조인을 기준으로 NULL보장
select   e1.empno, e1.ename, e1.mgr , e2.empno MGR_EMPNO,  e2.ename  MGR_ENAME
from     emp e2  full OUTER JOIN emp e1  on ( e1.mgr =  e2.empno)   
order    by e1.empno ;


-- https://sally03915.github.io/stackventure_250825/004_oracle/oracle006_select_join#54

-- 사고확장(연습문제)
--EX001
--EMP, DEPT 테이블을 이용하여
--SQL-99 이전 방식다음 , SQL-99방식 두가지 방식으로 다음과 같이 출력하시오.
--급여(SAL)이 2000초과인 사원들의 부서정보, 사원정보를 출력하시오.
--SQL-99 이전   =    (+)

SELECT   D.DEPTNO , DNAME, EMPNO, ENAME, SAL
FROM     DEPT D, EMP E
WHERE    D.DEPTNO = E.DEPTNO   AND  SAL > 2000;

--SQL-99       inner join , left outer join , right outer join, full outer join 
SELECT   D.DEPTNO , DNAME, EMPNO, ENAME, SAL
FROM     DEPT D  JOIN EMP E  ON(D.DEPTNO = E.DEPTNO )
WHERE    SAL > 2000;

SELECT   DEPTNO , DNAME, EMPNO, ENAME, SAL
FROM     DEPT    JOIN EMP    USING( DEPTNO   )
WHERE    SAL > 2000;

SELECT   DEPTNO , DNAME, EMPNO, ENAME, SAL
FROM     DEPT   NATURAL JOIN EMP    
WHERE    SAL > 2000;
--힌트)
--SELECT   DEPTNO , DNAME, EMPNO , ENAME, SAL
--FROM     DEPT D , EMP E
--WHERE    위의 두 테이블에서 DEPTNO 가 같다면    AND   급여가(SAL) > 2000


--EX002
--EMP, DEPT 테이블을 이용하여
--SQL-99 이전 방식다음 , SQL-99방식 두가지 방식으로 다음과 같이 출력하시오.
--각 부서별 평균급여, 최대급여, 사원수를 출력하시오.
--SQL-99 이전   =    (+)
--힌트)
SELECT   D.DEPTNO , DNAME, TRUNC(AVG(SAL)) AVG_SAL , MAX(SAL) MAX_SAL, MIN(SAL) MIN_SAL, COUNT(*) CNT
FROM     DEPT D , EMP E
WHERE    D.DEPTNO = E.DEPTNO
GROUP BY D.DEPTNO , DNAME;

--SQL-99       inner join , left outer join , right outer join, full outer join
SELECT   D.DEPTNO , DNAME, TRUNC(AVG(SAL)) AVG_SAL , MAX(SAL) MAX_SAL, MIN(SAL) MIN_SAL, COUNT(*) CNT
FROM     DEPT D JOIN EMP E  ON( D.DEPTNO = E.DEPTNO )
GROUP BY D.DEPTNO , DNAME;

SELECT   DEPTNO , DNAME, TRUNC(AVG(SAL)) AVG_SAL , MAX(SAL) MAX_SAL, MIN(SAL) MIN_SAL, COUNT(*) CNT
FROM     DEPT D JOIN EMP E  USING( DEPTNO )
GROUP BY DEPTNO , DNAME;

SELECT   DEPTNO , DNAME, TRUNC(AVG(SAL)) AVG_SAL , MAX(SAL) MAX_SAL, MIN(SAL) MIN_SAL, COUNT(*) CNT
FROM     DEPT   NATURAL JOIN EMP    
GROUP BY DEPTNO , DNAME;

--EX003
--EMP, DEPT 테이블을 이용하여
--SQL-99 이전 방식다음 , SQL-99방식 두가지 방식으로 다음과 같이 출력하시오.
--모든 부서정보와 사원정보를 부서번호, 사원이름 순으로 정렬해 출력하시오.
--SQL-99 이전   =    (+)
--SQL-99       inner join , left outer join , right outer join, full outer join
SELECT   D.DEPTNO , DNAME, EMPNO,ENAME, JOB, SAL
FROM     DEPT D , EMP E
WHERE    D.DEPTNO = E.DEPTNO(+)
ORDER BY D.DEPTNO , E.ENAME;

--SQL-99       inner join , left outer join , right outer join, full outer join
SELECT   D.DEPTNO , DNAME, EMPNO,ENAME, JOB, SAL
FROM     DEPT D LEFT OUTER JOIN EMP E  ON( D.DEPTNO = E.DEPTNO )
ORDER BY D.DEPTNO , E.ENAME;

SELECT   DEPTNO , DNAME, EMPNO,ENAME, JOB, SAL
FROM     DEPT   LEFT OUTER JOIN EMP    USING(DEPTNO)
ORDER BY DEPTNO , ENAME;


SELECT   D.DEPTNO , DNAME, EMPNO,ENAME, JOB, SAL
FROM     EMP E  RIGHT OUTER JOIN  DEPT D ON( D.DEPTNO = E.DEPTNO )
ORDER BY D.DEPTNO , E.ENAME;

SELECT   DEPTNO , DNAME, EMPNO,ENAME, JOB, SAL
FROM     EMP E  RIGHT OUTER JOIN  DEPT D    USING(DEPTNO)
ORDER BY DEPTNO , ENAME;


--힌트)   값 중에 NULL 이 있으므로  OUTER JOIN
--SELECT   DEPTNO , DNAME, EMPNO, JOB, SAL
--FROM     DEPT D , EMP E
--WHERE    위의 두 테이블에서 DEPTNO 가 같다면    


--EX004
--EMP, DEPT 테이블을 이용하여
--SQL-99 이전 방식다음 , SQL-99방식 두가지 방식으로 다음과 같이 출력하시오.
--모든 부서정보와 사원정보, 급여등급정보, 각사원의 직속상관의 정보를
--부서번호, 사원번호 순서로 정렬해 출력하시오.
--SQL-99 이전   =    (+)
select d.deptno, d.dname, e.empno, e.ename, e.mgr, e.sal, e.deptno, s.losal, s.hisal, s.grade, e2.empno, e2.ename
from emp e right outer join dept d on (e.deptno = d.deptno) 
left join salgrade s on (e.sal between s.losal and s.hisal)
left join emp e2 on (e.mgr = e2.empno)
order by d.deptno;

select d.deptno, dname, e1.empno, e1.ename, e1.mgr, e1.sal, e1.deptno, losal, hisal, grade, e2.empno, e2.ename
from emp e1, dept d, salgrade s, emp e2
where e1.deptno(+) = d.deptno  and e1.sal between losal(+) and hisal(+) and e1.mgr = e2.empno(+)
order by d.deptno,e1.deptno;


--SQL-99       inner join , left outer join , right outer join, full outer join



--힌트)   값 중에 NULL 이 있으므로  OUTER JOIN
--SELECT   DEPTNO , DNAME, EMPNO, ENAME, MGR ,  SAL, DEPTNO_1, LOSAL, HISAL, GRADE, MGR_EMPNO, MGR_ENAME
--FROM     EMP E1 , DEPT D ,  SALGRADE S, EMP E2
--WHERE    JOIN의 조건  




