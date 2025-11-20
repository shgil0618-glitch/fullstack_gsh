CREATE TABLE users (
    APPUSERID    NUMBER  primary key  ,           
    PASSWORD    VARCHAR2(100)    NOT NULL,              
    NICKNAME    VARCHAR2(50)     NOT NULL,               
    EMAIL         VARCHAR2(100)  ,                  
    MOBILE      VARCHAR2(20)   ,                   
    JOINDATE   DATE            DEFAULT SYSDATE              
);
ALTER TABLE users
ADD CONSTRAINT uq_users_email UNIQUE (EMAIL);
commit;
select * from users;

    
    CREATE TABLE COMMUNITY_TB (
    postId       NUMBER PRIMARY KEY,      -- 게시글 ID
    id           NUMBER NOT NULL,      -- 작성자
    title        VARCHAR2(200) NOT NULL,    -- 제목
    content      CLOB NOT NULL,             -- 본문
    categoryId  NUMBER(3) NOT NULL,           -- 카테고리 번호
    views        NUMBER(6) DEFAULT 0,       -- 조회수
    createdAt   DATE DEFAULT SYSDATE,       -- 작성일
    updatedAt   DATE,                       -- 수정일
    FOREIGN KEY (id) REFERENCES users(APPUSERID),
    FOREIGN KEY (categoryId) REFERENCES CATEGORY_TB(categoryId)
);

select * from COMMUNITY_TB;
insert into users values (1000,'123','123','asd@123','0106666555','');
create sequence USERS_SEQ;


CREATE TABLE CATEGORY_TB (
    categoryId   NUMBER(3)       PRIMARY KEY,   -- 카테고리 ID
    categoryName VARCHAR2(50)    NOT NULL       -- 카테고리명 (예: 한식, 양식, 중식, 일식)
);
create sequence COMMUNITY_TB_seq;
select * from CATEGORY_TB;

drop table users;
drop table COMMUNITY_TB_seq;
drop table COMMUNITY_TB;
select * from users;
select * from COMMUNITY_TB;
select * from COMMUNITY_TB_seq;
commit;




--------------------------------------------------
CREATE TABLE RECOMMEND_TB (
    recId NUMBER(8) PRIMARY KEY,        -- 추천 고유번호  
    id NUMBER NOT NULL,       -- 사용자 ID
    foodId NUMBER(6) ,          -- 추천된 음식, 아직 확정되지않아 NULL가능으로 만듦.
    type VARCHAR2(30) NOT NULL,         -- 추천 유형 (선호식단, AI, 재료기반)
    feedback VARCHAR2(200),             -- AI 피드백 (예: 단백질 부족)   
    createdAt DATE DEFAULT SYSDATE,      -- 추천 일시  
    FOREIGN KEY (id) REFERENCES users(APPUSERID),
    FOREIGN KEY (foodId) REFERENCES FOOD_TB(foodId)        
);

select * from RECOMMEND_TB;
create sequence RECOMMEND_TB_SEQ;


-----------------------------------------------
사용된 데이터베이스 입니다
CREATE TABLE CATEGORYTB (
    categoryId   NUMBER(3)       PRIMARY KEY,   -- 카테고리 ID
    categoryName VARCHAR2(50)    NOT NULL       -- 카테고리명 (예: 한식, 양식, 중식, 일식)
);

INSERT INTO CATEGORYTB (categoryId, categoryName) VALUES (1, '한식');
INSERT INTO CATEGORYTB (categoryId, categoryName) VALUES (2, '양식');
INSERT INTO CATEGORYTB (categoryId, categoryName) VALUES (3, '중식');
INSERT INTO CATEGORYTB (categoryId, categoryName) VALUES (4, '일식');

COMMIT;
select * from users;

 SELECT f.foodId, f.name, f.categoryId, c.categoryName, f.kcal, f.protein, f.carb, f.fat,
                        f.recipe, f.imageUrl, f.regDate FROM FOODTB f JOIN CATEGORYTB c ON f.categoryId = c.categoryId
                         order by id desc;

CREATE TABLE FOODTB (
    foodId      NUMBER(6)        PRIMARY KEY,       -- 음식 고유번호 (PK)
    name        VARCHAR2(100)    NOT NULL,          -- 음식명
    categoryId  NUMBER(3),                          -- 음식 카테고리 (1,2,3,4,5)
    kcal        NUMBER(5),                          -- 칼로리
    protein     NUMBER(5,1),                         -- 단백질(g)
    carb        NUMBER(5,1),                         -- 탄수화물(g)
    fat         NUMBER(5,1),                         -- 지방(g)
    recipe      CLOB,                                -- 음식 설명 (긴 텍스트)
    imageUrl    VARCHAR2(200),                       -- 음식 이미지 경로 
    regDate     DATE DEFAULT SYSDATE,                -- 등록일


    CONSTRAINT FKFOOD FOREIGN KEY (categoryId) REFERENCES CATEGORYTB (categoryId)
);


-- 🔹 SEQUENCE 생성: 음식 ID 자동 증가 시퀀스
CREATE SEQUENCE FOODSEQ
    START WITH 1          -- 시작값
    INCREMENT BY 1        -- 1씩 증가
    NOCACHE               -- 캐시 미사용 (테스트/학습용에 적합)
    NOCYCLE;              -- 순환하지 않음
  


-- 🔹 샘플 데이터 삽입 (테스트용)
INSERT INTO FOODTB (
    foodId, name, categoryId, kcal, protein, carb, fat, recipe, imageUrl
) VALUES (
    FOODSEQ.NEXTVAL, '된장찌개', 1, 350, 18.5, 22.3, 10.2, '된장을 풀고 두부, 버섯, 애호박 등을 넣어 끓이는 전통 한식 요리입니다.', 'images/soybean_stew.jpg' );

INSERT INTO FOODTB (
    foodId, name, categoryId, kcal, protein, carb, fat, recipe, imageUrl
) VALUES (
    FOODSEQ.NEXTVAL, '제육볶음', 1, 390, 24.3, 9.5, 28.4, '빨간 고추장 양념에 고기를 볶아서 만드는 남성들의 소울 푸드입니다.', 'images/soybean_stew.jpg' );

INSERT INTO FOODTB (
    foodId, name, categoryId, kcal, protein, carb, fat, recipe, imageUrl
) VALUES (
    FOODSEQ.NEXTVAL, '초밥', 4, 50, 1.85, 9, 0.36, '하얀 쌀밥 위에 생선의 회를 떠서 올려서 같이 먹는 일본의 전통 요리입니다.', 'images/soybean_stew.jpg' );
    
INSERT INTO FOODTB (
    foodId, name, categoryId, kcal, protein, carb, fat, recipe, imageUrl
) VALUES (
    FOODSEQ.NEXTVAL, '알리오 올리오 파스타', 2, 400, 12, 65, 10, '알리오 올리오 파스타는 마늘과 올리브 오일을 핵심 재료로 사용하여 만든  이탈리아 남부 나폴리 지방에서 유래한 전통적인 파스타 요리입니다.', 'images/soybean_stew.jpg' );    

INSERT INTO FOODTB (
    foodId, name, categoryId, kcal, protein, carb, fat, recipe, imageUrl
) VALUES (
    FOODSEQ.NEXTVAL, '토마토 파스타', 2, 348, 12, 55, 10, '토마토를 주재료로 만든 소스에 파스타 면을 버무려 먹는 이탈리아 요리입니다.', 'images/soybean_stew.jpg' );    
    
INSERT INTO FOODTB (
    foodId, name, categoryId, kcal, protein, carb, fat, recipe, imageUrl
) VALUES (
    FOODSEQ.NEXTVAL, '규동', 4, 526, 12, 69, 19, '쇠고기에 양파와 함께 달게 끓인 재료를 그릇에 담은 밥위에 올려 먹는 일본의 덮밥 요리입니다.', 'images/soybean_stew.jpg' );        
    
INSERT INTO FOODTB (
    foodId, name, categoryId, kcal, protein, carb, fat, recipe, imageUrl
) VALUES (
    FOODSEQ.NEXTVAL, '짜장면', 3, 800, 20, 133, 20, '양파, 양배추 등 채소와 돼지고기에 기름으로 튀긴 춘장을 넣어 굵은 국수에 비벼서 먹는 한국식 중국 요리입니다.', 'images/soybean_stew.jpg' );            
    
INSERT INTO FOODTB (
    foodId, name, categoryId, kcal, protein, carb, fat, recipe, imageUrl
) VALUES (
    FOODSEQ.NEXTVAL, '짬뽕', 3, 700, 30, 100, 20, '해산물 혹은 고기를 비롯한 다양한 채소를 기름에 볶고 난 후, 닭뼈나 돼지뼈로 만든 육수를 넣어 끓이고 삶은 국수를 넣어 먹는 한국식 중국 요리입니다.', 'images/soybean_stew.jpg' );                

COMMIT;
-- 일반 출력 (카테고리가 숫자로 출력)
select * from FOODTB;

--출력 구문 (카테고리가 문자로 출력)
SELECT 
    f.foodId,
    f.name AS foodName,
    c.categoryName AS categoryName,
    f.kcal,
    f.protein,
    f.carb,
    f.fat,
    f.recipe,
    f.imageUrl,
    f.regDate
FROM FOODTB f
JOIN CATEGORYTB c
ON f.categoryId = c.categoryId;
    
DELETE FROM FOODTB;

--선택적 사항
--DROP TABLE FOODTB CASCADE CONSTRAINTS;  --삭제 코드
--DROP SEQUENCE FOODSEQ; --삭제 코드





-----------------------------------------------


CREATE TABLE FOOD_TB (
    foodId          NUMBER(6)        PRIMARY KEY,       -- 음식 고유번호 (PK)
    name            VARCHAR2(100)    NOT NULL,          -- 음식명
    categoryId      NUMBER(3),                          -- 음식 카테고리 (1,2,3,4,5)
    kcal            NUMBER(5),                          -- 칼로리
    protein         NUMBER(5,1),                        -- 단백질(g)
    carb            NUMBER(5,1),                        -- 탄수화물(g)
    fat             NUMBER(5,1),                        -- 지방(g)
    recipe          CLOB,                               -- 음식 설명 (긴 텍스트)
    imageUrl        VARCHAR2(200),                      -- 음식 이미지 경로 
    regDate         DATE             DEFAULT SYSDATE,    -- 등록일 
    FOREIGN KEY (categoryId) REFERENCES CATEGORY_TB(categoryId)
);
CREATE SEQUENCE FOOD_TB_SEQ;


drop table FOOD_TB;

CREATE TABLE RECOMMEND_TB (
    recId NUMBER(8) PRIMARY KEY,        -- 추천 고유번호  
    id VARCHAR2(30) NOT NULL,       -- 사용자 ID
    foodId NUMBER(6) ,          -- 추천된 음식, 아직 확정되지않아 NULL가능으로 만듦.
    type VARCHAR2(30) NOT NULL,         -- 추천 유형 (선호식단, AI, 재료기반)
    feedback VARCHAR2(200),             -- AI 피드백 (예: 단백질 부족)   
    createdAt DATE DEFAULT SYSDATE,      -- 추천 일시  
    FOREIGN KEY (id) REFERENCES users(id),
    FOREIGN KEY (foodId) REFERENCES FOOD_TB(foodId)        
);

drop table RECOMMEND_TB;


drop table COMMUNITY_TB;
select * from COMMUNITY_TB;
delete COMMUNITY_TB;

CREATE TABLE COMMUNITY_TB (
    postId      NUMBER(8) PRIMARY KEY,      -- 게시글 ID
    id           NUMBER(30) NOT NULL,      -- 작성자
    title        VARCHAR2(200) NOT NULL,    -- 제목
    content      CLOB NOT NULL,             -- 본문
    categoryId  NUMBER(3) NOT NULL,           -- 카테고리 번호
    views        NUMBER(6) DEFAULT 0,       -- 조회수
    createdAt   DATE DEFAULT SYSDATE,       -- 작성일
    updatedAt   DATE DEFAULT SYSDATE,                       -- 수정일
    FOREIGN KEY (id) REFERENCES users(APPUSERID),
    FOREIGN KEY (categoryId) REFERENCES CATEGORY_TB(categoryId)
);

delete  COMMUNITY_TB;
select * from COMMUNITY_TB;
commit;





INSERT INTO COMMUNITY_TB (
    postId,
    id,
    title,
    content,
    categoryId,
    views,
    createdAt,
    updatedAt
) VALUES (
    1,               -- postId (NUMBER)
    1,               -- id (NUMBER, users.id 외래키)
    '테스트 제목',    -- title (VARCHAR2)
    '테스트 내용',    -- content (CLOB)
    1,               -- categoryId (NUMBER, CATEGORY_TB 외래키)
    0,               -- views (NUMBER)
    SYSDATE,         -- createdAt (DATE)
    SYSDATE          -- updatedAt (DATE)
);

INSERT INTO users (id, password, nickname, email, mobile)
VALUES (1, '1234', '테스트유저', 'test@example.com', '010-1234-5678');

INSERT INTO users (id, password, nickname, email, mobile)
VALUES (2, '1111', '테스트유저2', 'test2@example.com', '010-1234-8765');

INSERT INTO users (id, password, nickname, email, mobile)
VALUES (3, '3333', '테스트유저3', 'test3@example.com', '010-1234-8763');

INSERT INTO users (id, password, nickname, email, mobile)
VALUES (4, '4444', '테스트유저4', 'test4@example.com', '010-1234-8764');

INSERT INTO users (id, password, nickname, email, mobile)
VALUES (5, '5555', '테스트유저5', 'test5@example.com', '010-1234-8766');

commit;

SELECT postId, id, title, content, categoryId, views, createdAt FROM COMMUNITY_TB;
select * from users;
select * from COMMUNITY_TB;

CREATE TABLE CATEGORY_TB (
    categoryId   NUMBER(3)       PRIMARY KEY,   -- 카테고리 ID
    categoryName VARCHAR2(50)    NOT NULL       -- 카테고리명 (예: 한식, 양식, 중식, 일식)
);


-- 카테고리
INSERT INTO CATEGORY_TB VALUES (1, '한식');
INSERT INTO CATEGORY_TB VALUES (2, '양식');
INSERT INTO CATEGORY_TB VALUES (3, '중식');
INSERT INTO CATEGORY_TB VALUES (4, '일식');
INSERT INTO CATEGORY_TB VALUES (5, '기타');
select * from CATEGORY_TB;

-- 사용자
INSERT INTO USERS VALUES ('user1', 'pass1234', '닉네임1', 'user1@test.com', '010-1111-1111', SYSDATE);
INSERT INTO USERS VALUES ('user2', 'pass5678', '닉네임2', 'user2@test.com', '010-2222-2222', SYSDATE);


INSERT INTO COMMUNITY_TB 
(postId, id, title, content, categoryId, views, createdAt, updatedAt)
VALUES 
(1, 'user1', '첫 게시글', '내용1입니다.', 1, 0, SYSDATE, NULL);

INSERT INTO COMMUNITY_TB 
(postId, id, title, content, categoryId)
VALUES 
(2, 'user2', '두번째 게시글', '내용2입니다.', 2);

ALTER TABLE users RENAME COLUMN ID TO APPUSERID ;
select * from users;
select * from food_tb;
select * from RECOMMEND_TB;


---------------------------------------

CREATE TABLE CATEGORYTB (
    categoryId   NUMBER(3)       PRIMARY KEY,   -- 카테고리 ID
    categoryName VARCHAR2(50)    NOT NULL       -- 카테고리명 (예: 한식, 양식, 중식, 일식)
);

INSERT INTO CATEGORYTB (categoryId, categoryName) VALUES (1, '한식');
INSERT INTO CATEGORYTB (categoryId, categoryName) VALUES (2, '양식');
INSERT INTO CATEGORYTB (categoryId, categoryName) VALUES (3, '중식');
INSERT INTO CATEGORYTB (categoryId, categoryName) VALUES (4, '일식');

COMMIT;

CREATE TABLE FOODTB (
    foodId      NUMBER(6)        PRIMARY KEY,       -- 음식 고유번호 (PK)
    name        VARCHAR2(100)    NOT NULL,          -- 음식명
    categoryId  NUMBER(3),                          -- 음식 카테고리 (1,2,3,4,5)
    kcal        NUMBER(5),                          -- 칼로리
    protein     NUMBER(5,1),                         -- 단백질(g)
    carb        NUMBER(5,1),                         -- 탄수화물(g)
    fat         NUMBER(5,1),                         -- 지방(g)
    recipe      CLOB,                                -- 음식 설명 (긴 텍스트)
    imageUrl    VARCHAR2(200),                       -- 음식 이미지 경로 
    regDate     DATE DEFAULT SYSDATE,                -- 등록일


    CONSTRAINT FKFOOD FOREIGN KEY (categoryId) REFERENCES CATEGORYTB (categoryId)
);


-- 🔹 SEQUENCE 생성: 음식 ID 자동 증가 시퀀스
CREATE SEQUENCE FOODSEQ
    START WITH 1          -- 시작값
    INCREMENT BY 1        -- 1씩 증가
    NOCACHE               -- 캐시 미사용 (테스트/학습용에 적합)
    NOCYCLE;              -- 순환하지 않음


-- 🔹 샘플 데이터 삽입 (테스트용)
INSERT INTO FOODTB (
    foodId, name, categoryId, kcal, protein, carb, fat, recipe, imageUrl
) VALUES (
    FOODSEQ.NEXTVAL, '된장찌개', 1, 350, 18.5, 22.3, 10.2, '된장을 풀고 두부, 버섯, 애호박 등을 넣어 끓이는 전통 한식 요리입니다.', 'images/soybean_stew.jpg' );

INSERT INTO FOODTB (
    foodId, name, categoryId, kcal, protein, carb, fat, recipe, imageUrl
) VALUES (
    FOODSEQ.NEXTVAL, '제육볶음', 1, 390, 24.3, 9.5, 28.4, '빨간 고추장 양념에 고기를 볶아서 만드는 남성들의 소울 푸드입니다.', 'images/soybean_stew.jpg' );

INSERT INTO FOODTB (
    foodId, name, categoryId, kcal, protein, carb, fat, recipe, imageUrl
) VALUES (
    FOODSEQ.NEXTVAL, '초밥', 4, 50, 1.85, 9, 0.36, '하얀 쌀밥 위에 생선의 회를 떠서 올려서 같이 먹는 일본의 전통 요리입니다.', 'images/soybean_stew.jpg' );
    
INSERT INTO FOODTB (
    foodId, name, categoryId, kcal, protein, carb, fat, recipe, imageUrl
) VALUES (
    FOODSEQ.NEXTVAL, '알리오 올리오 파스타', 2, 400, 12, 65, 10, '알리오 올리오 파스타는 마늘과 올리브 오일을 핵심 재료로 사용하여 만든  이탈리아 남부 나폴리 지방에서 유래한 전통적인 파스타 요리입니다.', 'images/soybean_stew.jpg' );    

INSERT INTO FOODTB (
    foodId, name, categoryId, kcal, protein, carb, fat, recipe, imageUrl
) VALUES (
    FOODSEQ.NEXTVAL, '토마토 파스타', 2, 348, 12, 55, 10, '토마토를 주재료로 만든 소스에 파스타 면을 버무려 먹는 이탈리아 요리입니다.', 'images/soybean_stew.jpg' );    
    
INSERT INTO FOODTB (
    foodId, name, categoryId, kcal, protein, carb, fat, recipe, imageUrl
) VALUES (
    FOODSEQ.NEXTVAL, '규동', 4, 526, 12, 69, 19, '쇠고기에 양파와 함께 달게 끓인 재료를 그릇에 담은 밥위에 올려 먹는 일본의 덮밥 요리입니다.', 'images/soybean_stew.jpg' );        
    
INSERT INTO FOODTB (
    foodId, name, categoryId, kcal, protein, carb, fat, recipe, imageUrl
) VALUES (
    FOODSEQ.NEXTVAL, '짜장면', 3, 800, 20, 133, 20, '양파, 양배추 등 채소와 돼지고기에 기름으로 튀긴 춘장을 넣어 굵은 국수에 비벼서 먹는 한국식 중국 요리입니다.', 'images/soybean_stew.jpg' );            
    
INSERT INTO FOODTB (
    foodId, name, categoryId, kcal, protein, carb, fat, recipe, imageUrl
) VALUES (
    FOODSEQ.NEXTVAL, '짬뽕', 3, 700, 30, 100, 20, '해산물 혹은 고기를 비롯한 다양한 채소를 기름에 볶고 난 후, 닭뼈나 돼지뼈로 만든 육수를 넣어 끓이고 삶은 국수를 넣어 먹는 한국식 중국 요리입니다.', 'images/soybean_stew.jpg' );                

COMMIT;
-- 일반 출력 (카테고리가 숫자로 출력)
select * from FOODTB;

--출력 구문 (카테고리가 문자로 출력)
SELECT 
    f.foodId,
    f.name AS foodName,
    c.categoryName AS categoryName,
    f.kcal,
    f.protein,
    f.carb,
    f.fat,
    f.recipe,
    f.imageUrl,
    f.regDate
FROM FOODTB f
JOIN CATEGORYTB c
ON f.categoryId = c.categoryId;



