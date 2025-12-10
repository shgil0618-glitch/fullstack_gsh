commit;
CREATE SEQUENCE recipes_seq
    START WITH 1          -- 시작 값 (보통 1 또는 현재 테이블의 최대 ID + 1)
    INCREMENT BY 1        -- 증가 값 (1씩 증가)
    NOMAXVALUE            -- 최대값 제한 없음
    NOCYCLE;               -- 끝까지 도달해도 순환하지 않음

CREATE TABLE BUG (
    APPUSERID   NUMBER          PRIMARY KEY,         
    PASSWORD    VARCHAR2(100)   NOT NULL,           
    NICKNAME    VARCHAR2(50)    UNIQUE,              
    EMAIL       VARCHAR2(100)   UNIQUE,              
    MOBILE      VARCHAR2(20)    UNIQUE,              
    BFILE       VARCHAR2(225),                      
    JOINDATE    DATE DEFAULT SYSDATE                
);


CREATE TABLE CATEGORY (
   CATEGORY      NUMBER PRIMARY KEY,
   CATEGORY_NAME VARCHAR2(100)
);


-- RECIPES 테이블
CREATE TABLE recipes (
    RECIPE_ID    NUMBER PRIMARY KEY,
    APPUSERID    NUMBER NOT NULL,
    TITLE        VARCHAR2(255) NOT NULL,
    CATEGORY     NUMBER, 
    IMAGE        VARCHAR2(255) DEFAULT 'user.png',
    COOK_TIME    NUMBER DEFAULT 0,
    DIFFICULTY   VARCHAR2(50),
    SERVINGS     NUMBER DEFAULT 1,
    DESCRIPTION  VARCHAR2(4000),
    INSTRUCTIONS VARCHAR2(4000),
    CREATED_AT   DATE DEFAULT SYSDATE,
    UPDATED_AT   DATE,
    VIEWS        NUMBER DEFAULT 0,

    FOREIGN KEY (APPUSERID) REFERENCES BUG(APPUSERID),
    FOREIGN KEY (CATEGORY)  REFERENCES CATEGORY(CATEGORY)
);


-- 테이블 최대값 + 1부터 시작하도록 재생성
CREATE SEQUENCE recipes_seq
START WITH 20
INCREMENT BY 1
NOCACHE;

-- 테이블 최대값 + 1부터 시작하도록 재생성
CREATE SEQUENCE recipes_ingre_map_seq
START WITH 20
INCREMENT BY 1
NOCACHE;

-- 이미지 테이블 (CASCADE 적용)
CREATE TABLE recipes_img (
    RECIPE_ID NUMBER,
    RURL      VARCHAR2(250),
    FOREIGN KEY (RECIPE_ID) REFERENCES recipes(RECIPE_ID) ON DELETE CASCADE
);

-- 재료 매핑 테이블 (CASCADE 적용)
CREATE TABLE recipes_ingre_map (
    RECIPE_ID    NUMBER,
    INGRE_MAP_ID NUMBER PRIMARY KEY,
    FOREIGN KEY (RECIPE_ID) REFERENCES recipes(RECIPE_ID) ON DELETE CASCADE
);

create table authorities(
    email varchar2(100),
    auth   varchar2(100)
);

-- 재료 상세 테이블 (CASCADE 적용)
CREATE TABLE recipes_ingre (
    INGRE_MAP_ID NUMBER,
    INGRE_NAME   VARCHAR2(100),
    INGRE_NUM    VARCHAR2(50),
    FOREIGN KEY (INGRE_MAP_ID) REFERENCES recipes_ingre_map(INGRE_MAP_ID) ON DELETE CASCADE
);


create table material (
    materialid          NUMBER(6)        PRIMARY KEY,           -- 재료 고유번호 (PK)
    title                  VARCHAR2(200)    NOT NULL,           -- 재료명
    imageurl            VARCHAR2(300)   default  'defult.png',  -- 이미지 경로 또는 URL
    season               VARCHAR2(100),                         -- 제철 정보
    temperature      VARCHAR2(50),                              -- 보관 온도
    calories100g      NUMBER(6),                                -- 100g당 열량
    efficacy             VARCHAR2(1000),
    buyguide            VARCHAR2(1000),                         -- 구입요령
    trimguide           VARCHAR2(1000),                         -- 손질법
    storeguide          VARCHAR2(1000)                         -- 보관법
);

select * from CATEGORY;
INSERT INTO CATEGORY VALUES (1, '전체');
INSERT INTO CATEGORY VALUES (2, '한식');
INSERT INTO CATEGORY VALUES (3, '양식');
INSERT INTO CATEGORY VALUES (4, '중식');
INSERT INTO CATEGORY VALUES (5, '일식');
INSERT INTO CATEGORY VALUES (6, '디저트');
INSERT INTO CATEGORY VALUES (7, '건강식');
INSERT INTO CATEGORY VALUES (8, '기타');

commit;
----------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------
-- 1. 레시피 재료 매핑의 세부 재료 테이블 (가장 깊은 자식)
DROP TABLE recipes_ingre CASCADE CONSTRAINTS;

-- 2. 레시피 재료 매핑 테이블
DROP TABLE recipes_ingre_map CASCADE CONSTRAINTS;

-- 3. 레시피 이미지 테이블
DROP TABLE recipes_img CASCADE CONSTRAINTS;

-- 4. 메인 레시피 테이블
DROP TABLE recipes CASCADE CONSTRAINTS;

-- 5. 권한 테이블 (BUG 참조)
DROP TABLE authorities CASCADE CONSTRAINTS; 

-- 6. 기타 상위 테이블 (BUG와 관련이 적거나 없다고 가정)
DROP TABLE CATEGORY CASCADE CONSTRAINTS;

-- 7. 사용자 정보 테이블 (최상위 부모)
-- 이 테이블을 참조하던 모든 제약 조건이 위에서 삭제되었거나, 이 명령으로 강제 삭제됩니다.
DROP TABLE BUG CASCADE CONSTRAINTS;

-- 1. 레시피 재료 상세
TRUNCATE TABLE recipes_ingre;

-- 2. 레시피 이미지
TRUNCATE TABLE recipes_img;

-- 3. 레시피 재료 매핑 !
TRUNCATE TABLE recipes_ingre_map;

-- 4. 메인 레시피 !
TRUNCATE TABLE recipes;

-- 7. 사용자 정보 !
TRUNCATE TABLE BUG;

-- 5. 재료 상세 정보
TRUNCATE TABLE material;

-- 6. 사용자 권한 (authorities 테이블이 있다면)
TRUNCATE TABLE authorities;


-- 8. 카테고리 정보
TRUNCATE TABLE CATEGORY;

-- 1. 시퀀스 삭제
DROP SEQUENCE recipes_seq;
DROP SEQUENCE recipes_ingre_map_seq;

-- 2. 시퀀스 재생성 (START WITH 1로 초기화)

-- RECIPES 테이블용 시퀀스 재생성
CREATE SEQUENCE recipes_seq
START WITH 1
INCREMENT BY 1
NOCACHE;

commit;
-- RECIPES_INGRE_MAP 테이블용 시퀀스 재생성
CREATE SEQUENCE recipes_ingre_map_seq
START WITH 1
INCREMENT BY 1
NOCACHE;

-- 1. 가장 깊은 자식 테이블 (recipes_ingre_map 참조)
TRUNCATE TABLE recipes_ingre;

-- 2. RECIPES 테이블의 자식 테이블 (RECIPES 참조)
TRUNCATE TABLE recipes_img;
TRUNCATE TABLE recipes_ingre_map; -- BUG와 RECIPES 사이의 RECIPES를 먼저 삭제

-- 3. RECIPES 테이블 (BUG 및 CATEGORY 참조)
TRUNCATE TABLE recipes;

-- 4. BUG와 CATEGORY를 참조하는 또 다른 테이블 (이전에 언급된 authorities 테이블)
TRUNCATE TABLE authorities;

-- 5. 부모 테이블
TRUNCATE TABLE BUG;
TRUNCATE TABLE CATEGORY;

-- 6. 재료 테이블 (독립적)
TRUNCATE TABLE material;

CREATE SEQUENCE recipes_ingre_map_seq
START WITH 1
INCREMENT BY 1
NOCACHE;

-- 레시피 PK용 시퀀스
CREATE SEQUENCE recipes_seq
START WITH 1
INCREMENT BY 1
NOCACHE;


INSERT INTO BUG (APPUSERID, PASSWORD, NICKNAME, EMAIL, MOBILE, BFILE)
VALUES (1, '1234', '홍길동', 'hong@test.com', '010-1234-5678', 'profile1.png');



select * from recipes;
select * from bug;
select * from recipes_ingre_map;

select * from recipes_img;
select * from recipes_ingre;




CREATE TABLE recipes (
    RECIPE_ID   NUMBER PRIMARY KEY,
    APPUSERID   NUMBER NOT NULL,
    TITLE       VARCHAR2(255) NOT NULL,
    CATEGORY    NUMBER, 
    IMAGE       VARCHAR2(255) DEFAULT 'user.png',
    COOK_TIME   NUMBER DEFAULT 0,
    DIFFICULTY  VARCHAR2(50),
    SERVINGS    NUMBER DEFAULT 1,
    DESCRIPTION VARCHAR2(4000),
    INSTRUCTIONS VARCHAR2(4000),
    CREATED_AT  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT  TIMESTAMP,
    VIEWS       NUMBER DEFAULT 0,

    FOREIGN KEY (APPUSERID) REFERENCES BUG(APPUSERID),
    FOREIGN KEY (CATEGORY)  REFERENCES CATEGORY(CATEGORY)
);


INSERT INTO recipes (
    RECIPE_ID, APPUSERID, TITLE, CATEGORY, IMAGE, 
    COOK_TIME, DIFFICULTY, SERVINGS, DESCRIPTION, INSTRUCTIONS
) VALUES (
    1,
    1,
    '비빔밥',
    2,
    'main_bibimbap.jpg',
    10,
    '쉬움',
    2,
    '한국 전통 대표 음식입니다.',
    '1. 재료 준비\n2. 비비기\n3. 맛있게 먹기'
);



CREATE TABLE recipes_img (
    RECIPE_ID NUMBER,
    RURL      VARCHAR2(250),
    FOREIGN KEY (RECIPE_ID) REFERENCES recipes(RECIPE_ID)
);

INSERT INTO recipes_img (RECIPE_ID, RURL) VALUES (1, 'bibim_01.png');
INSERT INTO recipes_img (RECIPE_ID, RURL) VALUES (1, 'bibim_02.png');
INSERT INTO recipes_img (RECIPE_ID, RURL) VALUES (1, 'bibim_03.png');

CREATE TABLE recipes_ingre_map (
    RECIPE_ID    NUMBER,
    INGRE_MAP_ID NUMBER PRIMARY KEY,
    FOREIGN KEY (RECIPE_ID) REFERENCES recipes(RECIPE_ID)
);



INSERT INTO recipes_ingre_map (RECIPE_ID, INGRE_MAP_ID)
VALUES (1, 100);


CREATE TABLE recipes_ingre (
    INGRE_MAP_ID NUMBER,
    INGRE_NAME   VARCHAR2(100),
    INGRE_NUM    VARCHAR2(50),

    FOREIGN KEY (INGRE_MAP_ID) REFERENCES recipes_ingre_map(INGRE_MAP_ID)
);

INSERT INTO recipes_ingre VALUES (100, '양파', '1개');
INSERT INTO recipes_ingre VALUES (100, '계란', '2개');
INSERT INTO recipes_ingre VALUES (100, '고추장', '1스푼');



SELECT NVL(MAX(RECIPE_ID), 0) + 1 AS NEW_ID FROM recipes;


INSERT INTO recipes (
    RECIPE_ID, APPUSERID, TITLE, CATEGORY, IMAGE,
    COOK_TIME, DIFFICULTY, SERVINGS, DESCRIPTION, INSTRUCTIONS
) VALUES (
    :recipe_id, :appuserid, :title, :category,
    NVL(:image, 'user.png'),
    :cook_time, :difficulty, :servings,
    :description, :instructions
);


INSERT INTO recipes_img (RECIPE_ID, RURL) VALUES (:recipe_id, :rurl);


INSERT INTO recipes_ingre_map (RECIPE_ID, INGRE_MAP_ID)
VALUES (:recipe_id, :ingre_map_id);

INSERT INTO recipes_ingre (INGRE_MAP_ID, INGRE_NAME, INGRE_NUM)
VALUES (:ingre_map_id, :name, :num);



SELECT 
    R.*,
    U.NICKNAME,
    U.BFILE AS USER_IMAGE
FROM recipes R
JOIN BUG U ON R.APPUSERID = U.APPUSERID
WHERE R.RECIPE_ID = :recipe_id;




SELECT RURL FROM recipes_img WHERE RECIPE_ID = :recipe_id;



SELECT ING.INGRE_NAME, ING.INGRE_NUM
FROM recipes_ingre_map MAP
JOIN recipes_ingre ING
    ON MAP.INGRE_MAP_ID = ING.INGRE_MAP_ID
WHERE MAP.RECIPE_ID = :recipe_id;



SELECT 
    R.RECIPE_ID, R.TITLE, R.CATEGORY, R.IMAGE,
    R.CREATED_AT, R.UPDATED_AT, R.VIEWS,
    U.NICKNAME
FROM recipes R
JOIN BUG U ON R.APPUSERID = U.APPUSERID
ORDER BY GREATEST(R.CREATED_AT, NVL(R.UPDATED_AT, R.CREATED_AT)) DESC;



SELECT *
FROM (
    SELECT 
        ROW_NUMBER() OVER (
            ORDER BY GREATEST(R.CREATED_AT, NVL(R.UPDATED_AT, R.CREATED_AT)) DESC
        ) AS RNUM,
        R.RECIPE_ID, R.TITLE, R.IMAGE, R.CATEGORY,
        R.CREATED_AT, R.UPDATED_AT, R.VIEWS,
        U.NICKNAME
    FROM recipes R
    JOIN BUG U ON R.APPUSERID = U.APPUSERID
) A
WHERE A.RNUM BETWEEN :start AND :end;




UPDATE recipes
SET 
    TITLE = :title,
    CATEGORY = :category,
    IMAGE = NVL(:image, 'user.png'),
    COOK_TIME = :cook_time,
    DIFFICULTY = :difficulty,
    SERVINGS = :servings,
    DESCRIPTION = :description,
    INSTRUCTIONS = :instructions,
    UPDATED_AT = CURRENT_TIMESTAMP
WHERE RECIPE_ID = :recipe_id;




UPDATE recipes
SET VIEWS = VIEWS + 1
WHERE RECIPE_ID = :recipe_id;





DELETE FROM recipes_img WHERE RECIPE_ID = :recipe_id;

DELETE FROM recipes_ingre 
WHERE INGRE_MAP_ID IN (
    SELECT INGRE_MAP_ID FROM recipes_ingre_map WHERE RECIPE_ID = :recipe_id
);

DELETE FROM recipes_ingre_map WHERE RECIPE_ID = :recipe_id;

DELETE FROM recipes WHERE RECIPE_ID = :recipe_id;









