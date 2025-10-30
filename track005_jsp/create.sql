       
create sequence post_seq;
create table post (
			ID                                       NUMBER  NOT NULL ,
			APP_USER_ID                                NUMBER NOT NULL,
			TITLE                                      VARCHAR2(200) NOT NULL,
			CONTENT                                    CLOB NOT NULL,
			PASS                                      VARCHAR2(100),
			CREATED_AT                                date default sysdate,
			HIT                                       NUMBER default 0,
            primary key(ID)
);

desc post;


 -- 1. [글쓰기] sql : 
insert into post (id, app_user_id, title, content, pass) 
values(post_seq.nextval, ?,?,?,?);

insert into post (id, app_user_id, title, content, pass) 
values(post_seq.nextval, 1,'title','content','1111');
        
--2. [전체보기]전체 글 가져오기  , appuser테이블에서 email도 같이 가져오기 sql :
select 	p.*,u.email
from post p join appuser u on p.app_user_id = u.app_user_id;

select * from appuser;

        
--3. [상세보기]글번호 해당하는 글가져오기 sql :   
update post set hit = hit+1 where id=?
select * from post where id=?;

update post set hit = hit+1 where id=1
select * from post where id=1;
        
--4. 글수정하기 sql
update post set title=?, cotent=? where id=? and pass=?;

update post set title='new-title', cotent='new-content' where id=1 and pass='1111'
        
--5. 글번호 해당하는 삭제
delete from post where id=? and pass =?;

delete from post where id=1 and pass ='1111';




1.create sequence appuser_seq;
2. join.jsp 실행해서 회원가입
select * from post;

desc post;
