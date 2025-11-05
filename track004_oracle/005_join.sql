-- 1. JOIN
-- 여러테이블을 한개의 테이블처럼 사용하는 것을 의미
-- 공통컬럼 기준으로 연결
-- 1.1 등가조인(=)      : where 절   emp.deptno = dept.deptno                  - 매칭되는 행
--     비등가조인(= x)  :            sal between losal and hisal
--     자체조인         : emp e1, emp e2
-- 1-2 외부조인         : 매칭되지 않은 행도 포함. left, right, full outer join   -매칭되지 않은 행도 포함

-- ERD : Entity(테이블), Relationship(관계), Diagram(표)
-- 특징 : Entity(테이블), Relationship(관계), Attribute(속성)



-- #1. 등가조인
select *
from emp e, dept d
where e.deptno = d.deptno;

select *
from emp e join dept d on (e.deptno = d.deptno);        -- join on

select *
from emp e join dept d using(deptno);                   -- join using

select * 
from emp e natural join dept d;                         -- natural join

-- #2. 외부조인 (매칭되지 x)

select * from dept; -- deptno 10~40 (40,OPERATIONS,BOSTON)
select * from emp;  -- deptno 10~30

-- 1. 조건(+) 오라클에만 있음.       -- (+) 없는 데이터 null로 보충해줄게, (+) 안붙은 테이블의 데이터를 보장
select ename, dname                -- ★★★★★★★★★ (+) 반대쪽을 보장!!!!!!!!!!!!!  ★★★★★★★★★
from emp e, dept d
where e.deptno = d.deptno;      -- 14줄    emp 테이블 보장, dept에서 모자라는 데이터 없는 데이터 null 채울게.
-- 위아래 비교해보자!
select ename, dname
from emp e, dept d             
where e.deptno(+)=d.deptno;     -- 15줄 dept 테이블 보장, 
-- 위아래 비교용
select ename, dname
from emp e, dept d
where d.deptno(+)=e.deptno;

-- 2. left join, right join     (ANSI 표준)
select ename, dname
from emp e inner join dept d on (e.deptno=d.deptno);  -- INER JOIN , 내부조인, 겹치는 애들만) 오른쪽 보장

select ename, dname
from emp e right outer join dept d on (e.deptno=d.deptno);  -- 15줄 dept보장(오른쪽 보장) (null,operations) 

select ename, dname
from emp e left outer join dept d on (e.deptno=d.deptno);  -- 14줄 emp보장(왼쪽 보장)


-- 3. full outer join  (두 테이블에 있는 모든 데이터를 결합)
select ename, dname
from emp e full outer join dept d
on e.deptno = d.deptno;

-- 비표준 = , (+)
-- 표준 natual join, join on, join using, left join, right join, full outer join


-- 1. emp e, dept d / empno, ename, deptno, dname
select  empno, ename, e.deptno, dname
from emp e, dept d
where e.deptno = d.deptno;

select  empno, ename, e.deptno, dname
from emp e join dept d on(e.deptno = d.deptno);

select  empno, ename, deptno, dname
from emp e join dept d using(deptno);

select  empno, ename, deptno, dname
from emp e natural join dept d;


-- q1~ q8 [내부조인]
-- 1.EMP, DEPT 테이블을 이용하여 FROM 절에 여러 테이블을 선언해해 다음과 같이 출력하시오 모든 행과 열이 곱해진 값
select * 
from emp e, dept d;

-- 2.EMP, DEPT 테이블을 이용하여 EMP의 DEPTNO와 DEPT테이블의 DEPTNO가 같은 데이터를 다음과 같이 출력하시오
select *
from emp e, dept d
where e.deptno = d.deptno;

select * from emp;
select * from dept;

-- 3.EMP, DEPT 테이블을 이용하여 FROM 절에 EMP 테이블의 별칭은 E, DEPT 테이블의 별칭은 D로 다음과 같이 출력하시오
select *
from emp e, dept d
where e.deptno = d.deptno;

select *
from emp e join dept d on (e.deptno = d.deptno);

select *
from emp e join dept d using(deptno);

select * 
from emp e natural join dept d;

-- 4.EMP, DEPT 테이블을 이용하여 두테이블에 부서번호가 같은 열의이름이 포함되었을때 다음과 같이 출력하시오 (에러발생)
SELECT EMPNO, ENAME, DEPTNO, DNAME, LOC     -- deptno의 필드가 누구테이블인지 확인 불가능.
  FROM EMP E, DEPT D
 WHERE E.DEPTNO = D.DEPTNO;        

-- 5.EMP, DEPT 테이블을 이용하여 열 이름에 각각의 테이블 이름도 함께 명시시 다음과 같이 출력하시오 ( 위의 문제 해결 )
SELECT EMPNO, ENAME, D.DEPTNO, DNAME, LOC
  FROM EMP E, DEPT D
 WHERE E.DEPTNO = D.DEPTNO;
 
-- 6.[등가조인] EMP, DEPT 테이블을 이용하여 급여가 3000이상인 사원의 사원번호, 이름, 급여, 근무부서를 다음과 같이 출력하시오
select empno, ename, sal, d.deptno, dname, loc
from emp e, dept d
where e.deptno = d.deptno and SAL >= 3000;

select empno, ename, sal, d.deptno, dname, loc
from emp e join dept d on ( e.deptno = d.deptno)
where sal >= 3000;

select empno, ename, sal, deptno, dname, loc
from emp e join dept d using(deptno)    --? 여기는 d.deptno 가 아니라 그냥 deptno네
where sal >= 3000;

select empno, ename, sal, deptno, dname, loc
from emp e natural join  dept d        
where sal >= 3000;

-- [비등가조인]7.EMP, SALGRADE 테이블을 이용하여 유저 정보, 급여등급 , 그 등급의 최소급여와 최대급여를 다음과 같이 출력하시오
select *
from emp e ,SALGRADE s 
where e.sal between s.losal and s.hisal ;   -- 뭐지.. 뭘기준으로 SALGRADE값을 붙이는 거지..?

select *
from emp e join SALGRADE s on (e.sal between s.losal and s.hisal);

select *
from emp e join SALGRADE s using (s.losal);           -- ? (x겹치는 필드가 안보임 - 서브쿼리로 가능)

select *
from emp e natural join SALGRADE s                
where e.sal between s.losal and s.hisal ;

select * from SALGRADE;
select * from emp;

-- 8. [자체조인]EMP테이블을 2번 이용하여 사원정보(EMPNO, ENAME, MGR) 와 직속상관(EMPNO, ENAME)의 사원번호를 다음과 같이 출력하시오
select e1.empno, e1.ename, e1.mgr, e2.empno, e2.ename
from emp e1, emp e2
where e1.mgr = e2.empno
order by e1.mgr;

select e1.empno, e1.ename, e1.mgr, e2.empno, e2.ename
from emp e1 join emp e2 on (e1.mgr = e2.empno);

select empno, e1.ename, mgr,empno, e2.ename
from emp e1 join emp e2 using(empno,mgr)           -- 사실상 안된다. 결과가 이상해짐...
order by mgr;

select empno, e1.ename, mgr, empno, e2.ename
from emp e1  natural join emp e2 on (mgr = empno); --?


-- q9~q16
-- 9. EMP테이블을 2번 이용하여 사원정보(EMPNO, ENAME, MGR) 와 직속상관(EMPNO, ENAME)의 사원번호를 다음과 같이 출력하시오 
-- 직속상관이 없는 사원의 정보도 출력하시오
select e1.empno, e1.ename, e1.mgr, e2.empno, e2.ename 
from emp e1 left join emp e2 on (e1.mgr = e2.empno)
order by e1.empno ;

SELECT E1.EMPNO, E1.ENAME, E1.MGR,
       E2.EMPNO AS MGR_EMPNO,
       E2.ENAME AS MGR_ENAME
  FROM EMP E1, EMP E2
 WHERE E1.MGR = E2.EMPNO(+)
ORDER BY E1.EMPNO;

-- 10. (+)의 위치를 바꿔서 출력해보고 다음이 의미하는 바를 적으시오
select e1.empno, e1.ename, e1.mgr, e2.empno, e2.ename
from emp e1, emp e2
where e1.mgr (+)= e2.empno 
order by e1.empno ;

-- 11. EMP , DEPT 테이블 이용하여 EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM를 다음과 같이 출력하시오
select e.EMPNO, e.ENAME, e.JOB, e.MGR, e.HIREDATE, e.SAL, e.COMM,deptno,d.dname,d.loc
from emp e natural join dept d;

-- 12. EMP , DEPT 테이블 이용하여 EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM를 다음과 같이 출력하시오
select e.EMPNO, e.ENAME, e.JOB, e.MGR, e.HIREDATE, e.SAL, e.COMM ,deptno, d.dname, d.loc  
from emp e join dept d using(deptno)
where e.sal>=3000;

-- 13. EMP , DEPT 테이블 이용하여 EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM를 다음과 같이 출력하시오
select e.EMPNO, e.ENAME, e.JOB, e.MGR, e.HIREDATE, e.SAL, e.COMM ,d.deptno, d.dname, d.loc 
from emp e join dept d on (e.DEPTNO = d.DEPTNO)
where sal <= 3000;

-- 14. EMP , DEPT 테이블 이용하여 다음과 같이 출력하시오 LEFT OUTER JOIN 왼쪽 외부조인을 기준으로 NULL
select e.empno, e.ename, e.mgr, d.empno, d.ename
from emp e left outer join emp d on (e.mgr = d.empno)
order by e.empno;                   --? emp 끼리인데요...?

-- 15.EMP , DEPT 테이블 이용하여 다음과 같이 출력하시오 RIGHT OUTER JOIN- 오른른쪽 외부조인을 기준으로 NULL보장
select e.empno, e.ename, e.mgr, d.empno, d.ename
from emp e right outer join emp d on (e.mgr = d.empno)
order by e.empno; 

-- 16.EMP , DEPT 테이블 이용하여 다음과 같이 출력하시오 FULL OUTER JOIN - 양쪽모두두 외부조인을 기준으로 NULL보장
select e.empno, e.ename, e.mgr, d.empno, d.ename
from emp e full outer join emp d on (e.mgr = d.empno)
order by e.empno; 


-- EX1) EMP, DEPT 테이블을 이용하여 SQL-99 이전 방식다음 , SQL-99방식 두가지 방식으로 다음과 같이 출력하시오.
-- 급여(SAL)이 2000초과인 사원들의 부서정보, 사원정보를 출력하시오.
select d.deptno, d.dname, e.empno, e.ename, e.sal 
from emp e join dept d on (d.deptno = e.deptno)
where e.sal > 2000
order by d.deptno;

select * from dept;
select * from emp order by deptno;

SELECT d.deptno, d.dname, e.empno, e.ename, e.sal
FROM emp e, dept d
WHERE d.deptno = e.deptno
  AND e.sal > 2000
ORDER BY d.deptno;


-- EX2) EMP, DEPT 테이블을 이용하여 SQL-99 이전 방식다음 , SQL-99방식 두가지 방식으로 다음과 같이 출력하시오.
-- 각 부서별 평균급여, 최대급여, 사원수를 출력하시오.
select d.deptno, d.dname, round(avg(sal),0), max(sal), min(sal),count(*) 
from emp e join dept d on (d.deptno = e.deptno)
group by d.deptno, d.dname;

select d.deptno, d.dname, round(avg(sal),0), max(sal), min(sal),count(*) 
from emp e, dept d
where d.deptno = e.deptno
group by d.deptno, d.dname
order by d.deptno;


-- EX3) EMP, DEPT 테이블을 이용하여 SQL-99 이전 방식다음 , SQL-99방식 두가지 방식으로 다음과 같이 출력하시오.
-- 모든 부서정보와 사원정보를 부서번호, 사원이름 순으로 정렬해 출력하시오.
select d.deptno, d.dname, e.empno, e.ename, e.job, e.sal
from emp e right join dept d on (d.deptno = e.deptno);

select  d.deptno, d.dname, e.empno, e.ename, e.job, e.sal
from emp e, dept d
where d.deptno = e.deptno(+)
order by d.deptno,e.deptno;

select d.deptno, d.dname, e.empno, e.ename, e.job, e.sal
from emp e , dept d
where e.deptno = d.deptno
union
select d.deptno, d.dname, NULL , NULL, NULL, NULL
from emp e , dept d
where d.deptno = 40 and d.deptno not in (select deptno from emp)
order by deptno;

-- EX4) EMP, DEPT 테이블을 이용하여 SQL-99 이전 방식다음 , SQL-99방식 두가지 방식으로 다음과 같이 출력하시오.
-- 모든 부서정보와 사원정보, 급여등급정보, 각사원의 직속상관의 정보를 부서번호, 사원번호 순서로 정렬해 출력하시오.
select d.deptno, d.dname, e.empno, e.ename, e.mgr, e.sal, e.deptno, s.losal, s.hisal, s.grade, e2.empno, e2.ename
from emp e right outer join dept d on (e.deptno = d.deptno) 
left join salgrade s on (e.sal between s.losal and s.hisal)
left join emp e2 on (e.mgr = e2.empno)
order by d.deptno;

select d.deptno, dname, e1.empno, e1.ename, e1.mgr, e1.sal, e1.deptno, losal, hisal, grade, e2.empno, e2.ename
from emp e1, dept d, salgrade s, emp e2
where e1.deptno(+) = d.deptno  and e1.sal between losal(+) and hisal(+) and e1.mgr = e2.empno(+)
order by d.deptno,e1.deptno;


select * from SALGRADE;
select * from dept;
select * from emp order by deptno;


