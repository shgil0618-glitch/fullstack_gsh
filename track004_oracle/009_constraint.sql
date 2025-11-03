

-- 제약조건
1. not null null 입력 금지
2. unique        중복금지, null 금지
3. primary key   고유식별자, 중복/null 금지
4. foreign key   다른테이블 참조
5. check         조건검사


-- rdb
-- 테이블 관계 속성
-- foreign key
-- 1. 다른테이블 참조
-- 2. 부모 테이블의 값만 입력 가능
-- 3. 참조 무결성 유지





-- 부서(DEPT_FK)는 많은 사원(EMP_FK)을 가진다.
-- 부서테이블(DEPT_FK)이 먼저 존재해야한다.

CREATE  TABLE  DEPT_FK(
    DEPTNO  NUMBER        PRIMARY KEY,   
    DNAME   VARCHAR2(50)
);



CREATE  TABLE  EMP_FK(
    EMPNO  NUMBER        PRIMARY KEY, 
    ENAME  VARCHAR2(50)  NOT NULL,
    DEPTNO NUMBER(2),
    CONSTRAINT FK_DEPT  FOREIGN KEY(DEPTNO)  REFERENCES  DEPT_FK(DEPTNO) ON DELETE CASCADE
);                    --  내테이블의 DEPTNO              부모테이블(DPETNO)


-- 1. INSERT : dept_fk (부서테이블 삽입)
insert into dept_fk values (10, 'bug_hunter');
insert into dept_fk values (20, 'pawject');
insert into dept_fk values (30, 'test');

-- 2. 사원테이블에는 dept_fk에 존재하는 값만 삽입가능
insert into emp_fk (empno, ename, deptno) values (1,'first',30);
insert into emp_fk (empno, ename, deptno) values (2,'second',40); -- parent key not found 부모에 없는값은 못넣음.


select * from dept_fk;


-- 2. on delete cascade
delete from dept_fk where deptno=30; -- 부모를 삭제했더니
select * from emp_fk;                -- 자식도 자동삭제 확인


-- Q1. jsp + oracle 왜래키
desc appuser;
이름           널?       유형            
------------ -------- ------------- 
APP_USER_ID  NOT NULL NUMBER(5)     
EMAIL        NOT NULL VARCHAR2(100) 
PASSWORD              VARCHAR2(255) 
MBTI_TYPE_ID          NUMBER(5)     
CREATED_AT            DATE          
;

desc post;
이름          널?       유형            
----------- -------- ------------- 
ID          NOT NULL NUMBER        
APP_USER_ID NOT NULL NUMBER        
TITLE       NOT NULL VARCHAR2(200) 
CONTENT     NOT NULL CLOB          
PASS                 VARCHAR2(100) 
CREATED_AT           DATE          
HIT                  NUMBER    
;

--2.부모와 자식테이블 관계
--유저는 많은 글을 가질 수 있다.
alter table post add constraint fk_post_appuser foreign key(APP_USER_ID) references appuser(APP_USER_ID);  --요즘은 cascade잘 안걸고 탈퇴회원을 따로 모아놓음

select APP_USER_ID FROM POST WHERE APP_USER_ID NOT IN (SELECT APP_USER_ID FROM APPUSER); --APPUSER 확인

SELECT CONSTRAINT_NAME, TABLE_NAME, COLUMN_NAME
FROM USER_CONS_COLUMNS
WHERE TABLE_NAME='POST';

DELETE FROM APPUSER;
DELETE FROM POST;
COMMIT;



COMMIT;

-- 포트폴리오 상담
-- 프로젝트 올리기







