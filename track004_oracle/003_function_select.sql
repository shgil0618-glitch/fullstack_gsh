------------------------------------------------------------------
-- 003_select_function.sql
-- 1. 문자열
-- 2. 숫자
-- 3. 날짜
-- 4. 변환
-- 5. 조건
------------------------------------------------------------------
-- 1. 문자열
-- 1-1) upper 대문자 , lower 소문자, initcap 첫글자만 대소문자 변환
-- 1-2) length 문자열 길이 , lengthb 문자열 바이트 수
-- 1-3) substr 부분문자열, instr 위치문자열
-- 1-4) replace 바꾸기, lpad, rpad [123**]채우기
-- 1-5) trim, ltrim, rtrim 공백빼기
-- 1-6) concat 문자열 연결

-- #1. 대소문자
select ename, upper(ename), lower(ename), initcap(ename)
from emp;

-- #2. 문자열 길이
select ename, length(ename), '킹', length('킹'), lengthb('킹')
from emp;

-- #3. substr(문자열,어디서부터,몇개) 부분문자열, instr 위치문자열
select ename, substr(ename, 1,2), substr(ename,1,3), substr(ename,2,2), substr(ename,3,2), substr(ename,-3,2), substr(ename,-2,2) from emp; -- (어느객체,몇번째 부터, 뒤로 몇개 까지) 
select substr('oracle',-1),                         substr('oracle',-3),            substr('oracle',-3,2),substr('oracle',-2) from dual;
--           e 뒤에서 1번째부터 끝까지              cle 뒤에서 3번째부터 끝까지             cl 뒤에서 3번째부터 2개

select instr('oracle','a') from dual;      -- 3 / o(1) r(2) a(3) c(4) l(5) e(6)
select ename, instr(ename, 'A') from emp;   -- 있으면 위치, 없으면 0

-- #4. replace 바꾸기, lpad, rpad [123**]채우기
select replace('010-1234-5678','-',' ') from dual;  -- replace(어떤문자열을, 찾아서, 바꾸기)
select lpad('oracle',10,'#') from dual;             -- l (left 채우기, 남은 공간만큼)
select rpad('oracle',10,'#') from dual;             -- r (right 채우기, 남은 공간만큼)

-- #5. trim, ltrim, rtrim 공백빼기
select trim(' *oracle* '), ltrim(' *oracle* '), rtrim(' *oracle* ') from dual;

-- #6. concat 문자열 연결 - 두개의 문자열만 연결 가능
select concat('hello', 'oracle') from dual;
-- select concat('hello', 'oracle','★') from dual;  --두개의 문자열만 연결 가능
select concat (concat('hello','oracle') , '★') from dual; -- concat 중첩으로는 사용 가능

select 'hello' || 'oracle' || '★' from dual;

------------------------------------------------------------------
-- ##1. 문자열 연습문제 (1~18)

-- 1. EMP 테이블에서 ENAME을 대문자, 소문자, 첫글자만 대문자로 조회하시오.
select ename, upper(ename), lower(ename), initcap(ename) from emp;

-- 2. EMP 테이블에서 UPPER를 이용하여 ENAME이 KING인 데이터를 조회하시오.
select ename from emp where ename = upper('king');

-- 3. EMP 테이블에서 UPPER를 이용하여 ENAME에 KING인 포함된 데이터를 조회하시오.
select ename from emp where upper(ename) like upper('%king%');
select ename from emp where ename = upper('king') or ename = lower('king');

-- 4. EMP 테이블에서 LENGTH를 이용하여 ENAME의 문자열 길이를 조회하시오.
select ename, length(ename) from emp;

-- 5. EMP 테이블에서 ENAME의 문자열 길이가 5이상인 데이터를 조회하시오.
select ename, length(ename) from emp where length(ename)>=5;

-- 6. 문자열길이반환, 문자열 바이트 수 반환환
select length('한글'),lengthb('한글') from dual;

-- 7. 문자열 일부분을 추출
select job, substr(job,1,2),substr(job,3,2),substr(job,5) from emp;

--  8. -의 의미는?
select job, substr(job,-length(job)),substr(job,-length(job),2),substr(job,-3) from emp; -- 뒤에서부터 몇번째

-- 9. 특정문자위치 찾기
select instr('ABCDEFGHIJKLMN','C'),instr('ABCDEFGHIJKLMN','L'),instr('ABCDEFGHIJKLMN','D') from dual;
SELECT INSTR('hello world', 'o', 1, 2) FROM dual;       --어디에서,어떤 문자를, 에서 부터, 몇번째(중복갯수)


-- 10. EMP테이블에서 INSTR 함수로 사원이름에 S가 있는 데이터를 조회하시오
select * from emp where instr(ename,'S') != 0;

-- 11. EMP테이블에서 LIKE를 이용하여 사원이름에 S가 있는 데이터를 조회하시오
select * from emp where ename like '%S%';

-- 12. REPLACE를 이용하여 연락처의 -을 공백으로, -을 뺀데이터로 조회하시오오 
select REPLACE('010-1234-5678','-','-') , replace('010-1234-5678','-',' '), replace('010-1234-5678','-','') from dual;

-- 13. LPAD, RPAD를 이용하여 다음과 같이 데이터를 출력하시오오
select 'oracle', lpad('oracle',10,'#'), rpad('oracle',10,'*'), lpad('oracle',10), rpad('oracle',10) from dual; 

-- 14. RPAD를 이용하여 개인정보뒷자리 *로 출력하시오.
select rpad('911225-',14,'*'),rpad('010-1234-',14,'*')  from dual;

-- 15. EMP 테이블에서 EMPNO와 ENAME 사이에 :을 넣고 문자열을 연결하시오. ?? 하나만 나오는게 맞아?
select concat(empno,ename) ,concat(empno,concat(':',ename)) from emp where ename = 'SCOTT';

-- 16. TRIM을 이용하여 다음과 같이 공백을 제거하고 출력하시오.
select '   [__oracle__]   ',ltrim('   [__oracle__]   '),rtrim('   [__oracle__]   '),trim('   [__oracle__]   ') from dual;
select
'[' || trim(' * *oracle* * ') || ']' as trim       -- 양쪽 공백 제거
, '[' || ltrim(' * *oracle* * ') || ']' as trim    -- 왼쪽 공백 제거
, '[' || rtrim(' * *oracle* * ') || ']' as trim    -- 오른쪽 공백 제거
, '[' || trim(' * *oracle* * ') || ']' as trim     -- 양쪽 공백 제거
from dual;

-- TRIM을 이용하여 다음과 같이 공백을 제거하고 출력하시오.
select
   '[' ||  trim(' * *Oracle* * ') || ']' as trim  -- 양쪽공백제거 (중간에 있는공백은 제거하지 않음)
,  '[' ||  trim( LEADING   FROM   ' * *Oracle* * ') || ']' as trim --  앞쪽공백제거
,  '[' ||  trim( TRAILING  FROM   ' * *Oracle* * ') || ']' as trim   --  뒤쪽공백제거
,  '[' ||  trim( BOTH      FROM   ' * *Oracle* * ') || ']' as trim  -- 양쪽공백제거
from   dual;

-- 17. TRIM을 이용하여 삭제할 문자 삭제후 출력가능능    
select ' [_ _oracle_ _] ',ltrim(replace(' [_ _oracle_ _] ',' ','*')),rtrim(replace(' [_ _oracle_ _] ',' ','*')),trim(replace(' [_ _oracle_ _] ',' ','*')) from dual;

-- ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★ 이게 표쥰이래....
select
'[' ||  trim(' * *Oracle* * ') || ']' as trim1
,  '[' ||  trim( LEADING  '*'  FROM   '* *Oracle* *') || ']' as trim2   -- 원래는 공백을 찾지만 이렇게되면 공백이 아니라 *을 찾아 제거
,  '[' ||  trim( TRAILING '*' FROM   '* *Oracle* *') || ']' as trim3   
,  '[' ||  trim( BOTH   '*'   FROM   '* *Oracle* *') || ']' as trim4  
from   dual;
-- ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★

-- 18 TRIM, LTRIM, RTRIM 사용하여 문자열 출력하기기
select
'[' ||  trim('* *Oracle* *') || ']' as trim0  
,  '[' ||   ltrim(   '* *Oracle* *') || ']' as trim1   
,  '[' ||  ltrim(  '* *Oracle* *', '*') || ']' as trim2  
, '[' || rtrim('* *oracle* *') || ']' as trim1   
, '[' || rtrim('* *oracle* *', '*') || ']' as trim2 
from   dual;



