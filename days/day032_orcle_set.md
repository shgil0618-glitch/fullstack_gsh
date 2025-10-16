#1. 저장단위
변수 < 배열 < 클래스 < 콜렉션프레임워크 < file < DB
※ DB (mysql, oracle, mssql)

> java : jdbc -> dbcp -> orm (★ mybatis, jpa)

#2. RDB (Relationship DataBase) ★
-   관계형 데이타 베이스
-   테이블 관계
1. 엔티티(Entity)      - 테이블  - 관리할대상       (고객,주문,상품)
2. 속성(Attribute)    - 컬럼(열)     - 대상의 특징      (주민번호,이름,나이,주문번호)
3. 관계(Relationship) - 외래키   - 대상간의 연결 - 고객은 주문을 한다.

#3.  데이터베이스 언어  ★
1. (DDL) - CREATE(생성), ALTER(수정), DROP(삭제) --- CAD
2. 조작어(DML) - INSERT(삽입), SELECT(조회), UPDATE(수정), DELETE(지우기) --- CRUD
3. 제어어(DCL) - GRANT, REVOKE

<<사원>>
SQL> desc emp;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 EMPNO                                     NOT NULL NUMBER(4)
 ENAME                                              VARCHAR2(10)
 JOB                                                VARCHAR2(9)
 MGR                                                NUMBER(4)
 HIREDATE                                           DATE
 SAL                                                NUMBER(7,2)
 COMM                                               NUMBER(7,2)
 DEPTNO                                             NUMBER(2)

<<부서>>
SQL> desc dept;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 DEPTNO                                    NOT NULL NUMBER(2)
 DNAME                                              VARCHAR2(14)
 LOC                                                VARCHAR2(13)

>부서는 많은 사원을 가질수 있다.
관리대상(table) : dept      emp
속성(Attribute): deptno     empno,deptno,,,
연결(Relationship) : deptno (관리대상의 공통점)

#4. SELECT

[실습]
1. 테이블 구조확인 
    desc emp;
    desc dept;
2. 테이블 전체정보확인 
    select * from emp;

```dml
-- #1. 테이블구조확인
desc emp;
desc dept;

show user;      -- 실행) 현재줄 선택하고 ctrl+enter
select table_name from user_tables; -- 사용할수 있는 테이블 확인

-- #2. 전체테이블 조회
SELECT * FROM emp;

-- #3. 열조회 
select empno, ename from emp;
select ename, job from emp;

-- #4. 중복제거 (distinct)
select distinct job from emp;
select all      job from emp;

-- #5. 연산 및 별칭
desc emp;
-- as 생략가능 / "이름" 붙여줘야함
select ename "유저", sal as "월급", sal+sal+sal as "3달치 월급" from emp;

-- #6. 정렬 (오름/내림)
select ename, sal 
from emp 
order by sal asc;   -- asc) 오름차순

select ename, sal 
from emp 
order by sal desc;  -- desc) 내림차순

-- ## step3 연습문제

-- Q001 EMP 테이블 구성을 살펴보시오
desc emp;

-- Q002 DEPT 테이블 구성을 살펴보시오
desc dept;

-- Q003 SALGRADE 테이블 구성을 살펴보시오
desc salgrade;

-- Q004 EMP 테이블 전체열을 조회하시오
select * from emp;

-- Q005 EMP 테이블의 EMPNO, ENAME, DEPTNO 열을 조회하시오
select empno,ename,deptno from emp;

-- Q006 EMP 테이블의 DEPTNO 열의 중복을 제거하고 조회하시오
select distinct deptno from emp;

-- Q007 EMP 테이블의 JOB, DEPTNO열의 중복을 제거 조회하시오
select distinct job ,deptno from emp; 

-- Q008 EMP 테이블의 JOB, DEPTNO열의 중복을 제거하지 않고 그대로 모두 조회하시오
select all job, deptno from emp;
select     job, deptno from emp;

-- Q009 EMP 테이블의열에에 연산식을 이용하여 '연간총수입'을 조회하시오. 
select ename, sal, sal*12+comm , comm from emp;

-- Q010 EMP 테이블의 열열 더하기 연산식을이용하여 '연간총수입'을 조회하시오.
select ename, sal, sal+sal+sal+sal+sal+sal+sal+sal+sal+sal*comm ,comm from emp;

-- Q011 EMP 테이블의 열 별칭을 사용하여 '연간총수입'을 조회하시오.
select ename, sal, sal*12*comm as annsal, comm from emp;

-- Q012 EMP 테이블의 모든 열을 급여기준으로 오름차순 정렬하시오.
select * from emp order by sal asc;
select * from emp order by sal;     -- asc는 기본속성으로 생략 가능.

-- Q013 EMP 테이블의 모든 열을 급여기준으로 내림차순순 정렬하시오.
select * from emp order by sal desc;

-- Q014 EMP 테이블의 모든 열을 전체열을 부서번호(오름차순)와 급여(내림차순)으로 정렬하시오.
select * from emp order by empno asc , sal desc;
```

#4. WHERE
-- 조건에 맞는 데이터 조회
-- #1. WHERE
-- #2. 비교연산자 : (같다) =, (다르다) !=, <>, ^=
-- #3. 논리연산자 : AND, OR, NOT / BETWEEN   AND (범위 지정), OR IN
-- #4. LIKE      : 패턴검색
-- #5. NULL처리   : NULL 여부확인
-- #6. 집합연산자  : UNION (중복 제거하고 합집합), UNION ALL (중복 포함하고 합집합), INTERSECT (교집합)

```dml
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



```

# java

### 1. Set
```java
package com.company.java014;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// 1. 콜렉션 프레임워크 - [배열]의 단점을 개선한 [객체]만 저장가능 [동적배열]
// 2. List, Set, Map
//3. List[기차] : 순서 O, 중복 O , 		add, get(순서), size, remove(순서), contains
//4. Set[주머니] : 순서 X, 중복 X , 	add/향상된for, iterator, size, remove(객체), contains
//5. Map[사전] : Key:Value (entry) 	add, get(key) / iterator, size, remove, contains

class Candy {
	String name;
	int price;
	public Candy(String name, int price) { super(); this.name = name; this.price = price; }
	public Candy() { super(); }
	@Override public String toString() { return "Candy [name=" + name + ", price=" + price + "]"; }
	// 1. Candy 클래스확인용도
	@Override public int hashCode() { return Objects.hash(name, price); }
	// 2. 사용자가 넣어준 값을 비교
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candy other = (Candy) obj;
		return Objects.equals(name, other.name) && price == other.price;
	}
	
	
}

public class Set001 {
	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<>();

		set1.add(1);				// Integer e = 1	(객체)
		set1.add(new Integer(1));	// Integer e = new Interger(1) (부품객체) 
		set1.add(1);				// 부품객체 = 기본값 (Integer - wrapper 클래스)
		set1.add(2);				// 기본값을 자동으로 - 객체화 - 부품객체 [wrapper 클래스]
		set1.add(3);				// int -> Integer / float -> Float 오토박싱.
		System.out.println(set1);	// [1,2,3] 종복혀용 x
		
		Set<Candy> set2 = new HashSet<>();
		set2.add(new Candy("츕파츕스",3000));
		set2.add(new Candy("츕파츕스",3000));
		set2.add(new Candy("츕파츕스",3000));
		set2.add(new Candy("청포도 알사탕",4500));
		set2.add(new Candy("멘톨",5500));
		System.out.println(set2);
		System.out.println(set2.size());
		
		
	}
}

```

### 2. Map
```java
package com.company.java014;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

//1. 콜렉션 프레임워크 - [배열]의 단점을 개선한 [객체]만 저장가능 [동적배열]
//2. List, Set, Map
//3. List[기차] : 순서 O, 중복 O , 		add, get(순서), size, remove(순서), contains
//4. Set[주머니] : 순서 X, 중복 X , 	add/향상된for, iterator, size, remove(객체), contains
//5. Map[사전] : Key:Value (entry) 	put/ get(key),향상된 for,  iterator/ size, remove, contains



public class Map001 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		
		System.out.println("1 : "+ map);
		System.out.println("2 : "+ map.get("two"));
		System.out.println("3 : "+ map.size());
		System.out.println("4 : "+ map.remove("two"));
		System.out.println("5 : "+ map.containsKey("one"));
		System.out.println(map.entrySet());		//Key:value 한묶음, 한쌍 - [one=1, three=3]
		
		for(Entry<String,Integer> one:map.entrySet()) {
			System.out.println(one.getKey() + "/" + one.getValue());
			}
		
		Iterator<Entry<String, Integer>> iter = map.entrySet().iterator();	// 1) 줄세우기 iter -> [one=1, three=3]
		while(iter.hasNext()) { // 2) 처리대상 확인 [iter -> one=1, three=3]
			Entry<String, Integer> temp =iter.next();	// [one = 1]
			System.out.println(temp.getKey() + "/" + temp.getValue());
		}
	}
}

```