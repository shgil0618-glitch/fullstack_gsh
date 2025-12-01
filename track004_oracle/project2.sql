commit;

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
    CREATED_AT  DATE DEFAULT SYSDATE,
    UPDATED_AT  DATE ,
    VIEWS       NUMBER DEFAULT 0,

    FOREIGN KEY (APPUSERID) REFERENCES BUG(APPUSERID),
    FOREIGN KEY (CATEGORY)  REFERENCES CATEGORY(CATEGORY)
);


CREATE TABLE recipes_img (
    RECIPE_ID NUMBER,
    RURL      VARCHAR2(250),
    FOREIGN KEY (RECIPE_ID) REFERENCES recipes(RECIPE_ID)
);

CREATE TABLE recipes_ingre_map (
    RECIPE_ID    NUMBER,
    INGRE_MAP_ID NUMBER PRIMARY KEY,
    FOREIGN KEY (RECIPE_ID) REFERENCES recipes(RECIPE_ID)
);

CREATE TABLE recipes_ingre (
    INGRE_MAP_ID NUMBER,
    INGRE_NAME   VARCHAR2(100),
    INGRE_NUM    VARCHAR2(50),

    FOREIGN KEY (INGRE_MAP_ID) REFERENCES recipes_ingre_map(INGRE_MAP_ID)
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

commit;
----------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------


INSERT INTO BUG (APPUSERID, PASSWORD, NICKNAME, EMAIL, MOBILE, BFILE)
VALUES (1, '1234', '홍길동', 'hong@test.com', '010-1234-5678', 'profile1.png');






INSERT INTO CATEGORY VALUES (1, '전체');
INSERT INTO CATEGORY VALUES (2, '한식');
INSERT INTO CATEGORY VALUES (3, '양식');
INSERT INTO CATEGORY VALUES (4, '중식');
INSERT INTO CATEGORY VALUES (5, '일식');
INSERT INTO CATEGORY VALUES (6, '디저트');
INSERT INTO CATEGORY VALUES (7, '건강식');
INSERT INTO CATEGORY VALUES (8, '기타');




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









