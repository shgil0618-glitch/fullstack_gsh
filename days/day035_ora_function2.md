


```sql

------------------------------------------------------------------
-- 003_select_function2.sql
-- 1. 문자열
-- 2. 숫자    : round/trunc(반올림/버림) , ceil(올림), floor (내림), mod(나머지)
-- 3. 날짜    : sysdate (시스템날짜), add_month(몇달뒤에), next_day, last_day
-- 4. 변환    : to_char(날짜형식변환) , to_date 
-- 5. 조건    : nvl, nvl2 (null), decode , case (조건분기)
------------------------------------------------------------------
-- 2. 숫자    : round/trunc(반올림/버림) , ceil(올림), floor (내림), mod(나머지)
select round(1234.5678) , round(1234.5678,2), trunc(1234.5678,2), ceil(1.1), floor(4.8), mod(10,3)
--          1235	                1234.57     	1234.56	        2	        4	        1
from dual;

------------------------------------------------------------------
-- 3. 날짜    : sysdate (시스템날짜,시간반환), add_month(몇달뒤에), months_between(두 날짜 사이) ,  next_day, last_day
select sysdate , add_months(sysdate,2), months_between('25-12-1','24-12-1')
from dual;
 
 select next_day(sysdate,'월요일') "다음주 월요일" , last_day(sysdate) "해당월의 마지막 날짜"
 from dual;
 
 select next_day(sysdate,1) "다음주 일요일" , last_day(sysdate) "해당월의 마지막 날짜"
 from dual;
------------------------------------------------------------------
-- 4. 변환    : to_char(날짜형식변환) , to_date 
--              날짜를     문자로                 문자를         날짜로
select to_char(sysdate,'YYYY-MM-DD'), to_date('2025-10-16', 'YYYY-MM-DD')
from dual;

--     숫자1234를 문자열로 변환 후 +1         (자동변환해서 오류가 안날수 있음.)
select to_char(1234)            +1   , to_number('5678')+1
from dual;

select to_char('일이삼사')            +1   , to_number('5678')+1      -- 오류
from dual;

select        "1234"+1   , 1+ "1234"            --자료형이 안맞으면 오류남.
from dual;
------------------------------------------------------------------
-- 5. 조건    : nvl, nvl2 (null), decode , case (조건분기)

select nvl(NULL,'대체값')   from dual;       -- NULL이면 대체값     / null value logic( replacement)
select nvl(comm,'입력안됨.')   from emp;        -- x 오류
select nvl(to_char(comm),'입력안됨.') from emp; -- o 자료형을 맞춰야함.

select nvl2(null,'A','B')   from dual;      -- NULL일때 B, 아니면 A

select nvl2(mgr,mgr,'--')   from emp;      -- 오류나는 이유는? 
select nvl2(mgr,to_char(mgr),'상위 관리자x')   from emp;      -- 해결방안    (nvl,nvl2 null일때 값 반환/ 자료형 맞추기)

select decode(deptno, 10, '부서10')
from emp;

select decode(deptno, 10, '부서10',20, '부서20',30,'부서30')
from emp;

select case 
            when deptno = 10 then '부서10' 
            when deptno = 20 then '부서20'
            when deptno = 30 then '부서30'
            else                  '부서x'
       end
from emp;

----

select case deptno
            when 10 then '부서10' 
            when 20 then '부서20'
            when 30 then '부서30'
            else         '부서x'
       end
from emp;

------------------------------------------------------------------

-- ##1. 문자열 연습문제 (45~49)

-- 45. EMP테이블에서 NVL 함수를 사용하여 다음과 같이 출력하시오.
select empno, ename, sal, comm, sal+comm, nvl(comm,0),to_char(sal)+nvl(comm,0) from emp;

-- 46. EMP테이블에서 NVL2 함수를 사용하여 다음과 같이 출력하시오.
select empno, ename, comm, nvl2(comm,'0','x'), sal*12+nvl2(comm,comm,0) as ANNSAL from emp; -- null은 더할수 없다. null 돼버림

-- 47. EMP테이블에서 DECODE 함수를 사용하여 다음과 같이 출력하시오.
--JOB이 MANAGER 는 급여의 10% 인상한 급여, SALESMAN 는 급여의 5% 인상한 급여, ANALYST 는 그대로, 나머지는 3% 인상된 급여
select empno, ename, job, sal, decode (job,'MANAGER', sal*1.1,'SALESMAN',sal*1.05,'ANALYST',sal,sal*1.03 ) as UPSAL
from emp;

-- 48. EMP테이블에서 CASE 함수를 사용하여 다음과 같이 출력하시오.
--JOB이 MANAGER 는 급여의 10% 인상한 급여, SALESMAN 는 급여의 5% 인상한 급여, ANALYST 는 그대로, 나머지는 3% 인상된 급여
select empno, ename, job, sal, 
case job
    when 'MANAGER' then sal*1.1
    when 'SALESMAN' then sal*1.05
    when 'ANALYST' then sal
    else sal*1.05
end as UPSAL
from emp;

-- 49. 기준데이터 없이 조건식으로만 CASE 사용가능
-- COMM 값이 NULL 이면 해당사항 없음, 0 이면 수당없음, 0 초과시 초과한 수당을 출력력
select empno, ename, comm, 
case 
    when comm is null then '해당사항 없음'
    when comm = 0 then '수당없음'
    when comm > 0 then '수당 : ' || to_char(comm)     -- 문자열 연결은 || or concat
end as COMM_TEXT
from emp;



-- 선생님 필기
-------------------------------------------------------------------------------------
-- 003_select_function.sql
-- 1. 문자열
-- 2. 숫자   :   round / trunc(반올림/버림) , ceil( 올림 ) , floor ( 내림) , mod  (나머지)
-- 3. 날짜   :   sysdate (시스템날짜), add_months(몇달뒤에) , next_day, last_day
-- 4. 변환   :   to_char (날짜형식변환), to_date
-- 5. 조건   :   nvl, nvl2 ( null) , decode, case ( 조건분기 ) 
-------------------------------------------------------------------------------------
-- 2. 숫자   :   round / trunc(반올림/버림) , ceil( 올림 ) , floor ( 내림) , mod  (나머지)
select   round(  1234.5678   )   , round(  1234.5678  , 2  ) , trunc(  1234.5678  , 2  ) , ceil(1.1) , floor(4.8)  , mod(10,3)
from dual;     -- 1235              1234.57                       1234.56                      2          4            1

-------------------------------------------------------------------------------------
-- 3. 날짜   :   sysdate (시스템날짜,시간반환), add_months(몇달뒤에) , next_day, last_day
select   SYSDATE  , add_months(  SYSDATE, 1) ,    months_between(  '25-12-1'  , '24-12-1' )
from     dual;

select  NEXT_DAY(SYSDATE,  '월요일')  "다음주 월요일" ,   LAST_DAY(SYSDATE)  "해당월의 마지막 날짜"
from dual;

select  NEXT_DAY(SYSDATE,  1)  "다음주 월요일" ,   LAST_DAY(SYSDATE)  "해당월의 마지막 날짜"
from dual;

-------------------------------------------------------------------------------------
-- 4. 변환   :   to_char (날짜형식변환), to_date
--                날짜를     문자로                         문자를         날짜로
select   TO_CHAR( SYSDATE , 'YYYY-MM-DD' ) ,  TO_DATE(  '2025-10-16' , 'YYYY-MM-DD'  )
from     dual;

--        숫자1234를 문자열로 변환한 다음 +1   ( 자동변환해서 오류가 안날수 있음. )
select    TO_CHAR(1234)               + 1       ,   TO_NUMBER('5678') + 1 
from     dual;

select    TO_CHAR('일이삼사')               + 1   ,   TO_NUMBER('5678') + 1   -- 오류
from     dual;

select           "1234"   + 1  , 1+"1234"       --  자료형이 안맞으면 오류남.
from     dual;

-------------------------------------------------------------------------------------
-- 5. 조건   :   nvl, nvl2 ( null) , decode, case ( 조건분기 ) 

select   nvl(  NULL , '대체값' )             from      dual; -- null 이면 대체값    / null  value  logic( replacement )
select   nvl(          comm  , '입력안됨.')   from     emp;   -- X 오류
select   nvl(  to_char(comm) , '입력안됨.')   from     emp;   -- O 자료형을 맞춰야함.

select  nvl2( NULL, 'A' , 'B'  )     from dual;    -- null 일때 b, 아니면 a
-----
select  nvl2( mgr,          mgr , '--'  )     from emp;   -- 오류나는이유는? 
select  nvl2( mgr, to_char(mgr) , '상위관리자 x'  )     from emp;   -- 해결방안    ( nvl, nvl2  null일때 값 반환 / 자료형맞추기)
-----
select decode( deptno, 10 , '부서10' , 20, '부서20' , 30, '부서30' )
from   emp;
-----
select case  
            when deptno=10 then  '부서10'  
            when deptno=20 then  '부서20'   
            when deptno=30 then  '부서30'  
            else                 '부서x'
       end
from   emp;
-----
select case deptno 
            when 10 then  '부서10'  
            when 20 then  '부서20'   
            when 30 then  '부서30'  
            else          '부서x'
       end
from   emp;
-------------------------------------------------------------------------------------
-- ##1. 문자열 연습문제   (45~49)   ~17:00
-- https://sally03915.github.io/stackventure_250825/004_oracle/oracle004_select_fn#61

-- Q045  EMP테이블에서 NVL 함수를 사용하여 다음과 같이 출력하시오   ( nvl 이용 comm 이 null 이면 0 )  - nvl( NULL, '반환값')
select empno, ename, sal, comm,  sal + comm  , nvl( comm , 0) , sal + nvl(comm, 0)
from   emp;

-- Q046  EMP테이블에서 NVL2 함수를 사용하여 다음과 같이 출력하시오. (nvl2 이용  comm이  null 이면 'X')- nvl2( NULL, 'NULL아님','반환값')
select empno, ename,  comm,   nvl2( comm , 'O' , 'X') , sal*12 + nvl2( comm , comm , 0)
from   emp;

-- Q047  EMP테이블에서 DECODE 함수를 사용하여 다음과 같이 출력하시오.  (decode)
--JOB이 MANAGER 는 급여의 10% 인상한 급여       SAL*1.1
--SALESMAN 는 급여의 5% 인상한 급여             SAL*0.5
--ANALYST 는 그대로                            SAL 
--나머지는 3% 인상된 급여         SAL*0.3
select  empno, ename, job, sal , 
        decode(  job 
            , 'MANAGER'  ,  SAL*1.1    -- when   then
            , 'SALESMAN' ,  SAL*1.05   -- when   then
            , 'ANALYST'  ,  SAL
            , SAL*1.03  -- else
        ) upsal
from    emp;
-- Q048
--EMP테이블에서 CASE 함수를 사용하여 다음과 같이 출력하시오.  (case when  then   else  end)
select  empno, ename, job, sal , 
        case 
            when  job='MANAGER'   then SAL*1.1 
            when  job='SALESMAN'  then SAL*1.05 
            when  job='ANALYST'   then SAL
            else  SAL*1.03  
        end   upsal
from    emp;

select  empno, ename, job, sal , 
        case  job
            when  'MANAGER'   then SAL*1.1 
            when  'SALESMAN'  then SAL*1.05 
            when  'ANALYST'   then SAL
            else  SAL*1.03  
        end   upsal
from    emp;

-- Q049
--기준데이터 없이 조건식으로만 CASE 사용가능    case when  then   else  end)
--COMM 값이 NULL 이면 해당사항 없음
--0 이면 수당없음
--0 초과시 초과한 수당을 출력
select  empno, ename, comm
        , case   
            when   comm is null  then   '해당사항 없음'
            when   comm = 0      then   '수당없음'           
            when   comm > 0      then   '수당 : ' || comm
          end   comm_text
from    emp;


-------------------------------------------------------------------------------------
-- ##1. 문자열 연습문제   (19~44)
-- https://sally03915.github.io/stackventure_250825/004_oracle/oracle004_select_fn#14






-- ex1
-- EMP 테이블에서 ENAME이 다섯글자 이상이며 여섯글자 미만인 사원을 조회하시오.
-- MASKING_EMPNO 는 EMPNO 앞두자리외 뒷자리를 *로 출력
-- MASKING_ENAME 는 사원이름의 첫글자만 보여주고 나머지는 *로 출력 SUBSTR(문자열, 어디에서, 몇개) RPAD - RPAD( 문자열, 몇자리, 채울값)
select empno, rpad(substr(empno,1,2),4,'*') as masking_empno, ename,rpad(substr(ename,1,1),length(ename),'*') as masking_ename  
from emp
where length(ename) in (5,5.99) ;


-- ex2 
-- EMP 테이블에서 사원들의 월 평균 근무일 수는 21.5일
-- 2 하루 근무시간을 8시간으로 보았을때 사원들의 하루급여(DAY_PAY) 와 시급(TIME_PAY)을 계산하여 결과를 조회하시오.
-- ※ 하루급여는 소수점 세번째 자리에서 버리고(TRUNC), 시급은 두번째 소수점에서 반올림(ROUND)하시오
select empno, ename, sal,TRUNC(sal/21.5,2)as day_pay ,round(sal/21.5/8,1)as time_pay 
from emp;

---- ex3
--EMP테이블에서 사원들은 입사일(HIREDATE)을 기준으로 3개월이 지난 후 첫 월요일에 정직원이 됨  next_day(sysdate,'월요일') add_month
--사원들이 정직원이 되는 날짜(R_JOB)를 YYYY-MM-DD 형식으로 오른쪽과 같이 출력하시오.  to_char(sysdate,'YYYY-MM-DD'   보통 (1)이 일요일
--추가 수당(COMM)이 없는 사원들의 추가수당은 N/A로 출력하시오.   
select empno,ename,HIREDATE,to_char(next_day(add_months(HIREDATE,3),'월요일'),'YYYY-MM-DD') as r_job,
case 
            when comm is null then  'N/A'  
            else          to_char(comm)
       end
from emp;


select empno,ename,HIREDATE,to_char(next_day(add_months(HIREDATE,3),'월요일'),'YYYY-MM-DD') as r_job, nvl(to_char(comm),'N/A') comm
from emp;


-- ex4
--직속상관의 사원번호(MGR)를 다음과 같은 조건을 기준으로 변환해서 CHG_MGR열에 출력하시오
--직속상관의 사원번호가 존재하지 않을경우 : 00000
--직속상관의 사원번호 앞 두자리가 75일 경우 : 5555
--직속상관의 사원번호 앞 두자리가 76일 경우 : 6666
--직속상관의 사원번호 앞 두자리가 77일 경우 : 7777
--직속상관의 사원번호 앞 두자리가 78일 경우 : 8888
--그 외 직속상관 사원번호의 경우 : 본래 직속상관의 사원번호 그대로 출력
select empno, ename, mgr,
case 
    when mgr is null then  '0000'
    when  mgr like '75%' then  '5555'
    when mgr like '76%' then   '6666'
    when mgr like '77%' then   '7777'
    when mgr like '78%' then   '8888'
    else to_char(mgr)
end as chg_mgr
from emp;

select   empno, ename, mgr, 
        case
            when  mgr is null  then  '0000'
            when  substr(  mgr  , 1, 2 )  = '78' then  '8888'
            when  substr(  mgr  , 1, 2 )  = '77' then  '7777'
            when  substr(  mgr  , 1, 2 )  = '76' then  '6666'
            when  substr(  mgr  , 1, 2 )  = '75' then  '5555'
            else  to_char(mgr)
        end chg_mgr    
from    emp

```