
create sequence post_seq;
create table post (
			ID                                        NOT NULL NUMBER primary key,
			APP_USER_ID                               NOT NULL NUMBER,
			TITLE                                     NOT NULL VARCHAR2(200),
			CONTENT                                   NOT NULL CLOB,
			PASS                                      VARCHAR2(100),
			CREATED_AT                                date default sysdate,
			HIT                                       NUMBER default 0
);