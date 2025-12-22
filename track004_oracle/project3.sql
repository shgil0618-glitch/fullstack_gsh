CREATE TABLE BUG3 (
    APPUSERID   NUMBER          PRIMARY KEY,         
    PASSWORD    VARCHAR2(100)   NOT NULL,           
    NICKNAME    VARCHAR2(50)    UNIQUE,              
    EMAIL       VARCHAR2(100)   UNIQUE,              
    MOBILE      VARCHAR2(20)    UNIQUE,              
    BFILE       VARCHAR2(225),                      
    JOINDATE    DATE DEFAULT SYSDATE                
);


CREATE TABLE CATEGORY3 (
   CATEGORY      NUMBER PRIMARY KEY,
   CATEGORY_NAME VARCHAR2(100)
);


-- RECIPES 테이블
CREATE TABLE recipes3 (
    RECIPE_ID    NUMBER PRIMARY KEY,
    APPUSERID    NUMBER NOT NULL,
    TITLE        VARCHAR2(255) NOT NULL,
    CATEGORY     NUMBER, 
    IMAGE        VARCHAR2(255) DEFAULT 'no.png',
    COOK_TIME    NUMBER DEFAULT 0,
    DIFFICULTY   VARCHAR2(50),
    SERVINGS     NUMBER DEFAULT 1,
    DESCRIPTION  VARCHAR2(4000),
    CREATED_AT   DATE DEFAULT SYSDATE,
    UPDATED_AT   DATE,
    VIEWS        NUMBER DEFAULT 0,
    R_URL        VARCHAR2(255),         -- 유튜브 링크용
    IS_MALICIOUS CHAR(1) DEFAULT 'N' ,  -- 악성 내용 판별 결과 저장하고 싶다면 
    IS_AI_GENERATED CHAR(1) DEFAULT 'N', -- AI 자동 생성 여부 표시

    FOREIGN KEY (APPUSERID) REFERENCES BUG(APPUSERID),
    FOREIGN KEY (CATEGORY)  REFERENCES CATEGORY(CATEGORY)
);

-- 좋아요 / 북마크 테이블
CREATE TABLE RECIPE_LIKES3 (
    LIKE_ID     NUMBER PRIMARY KEY,
    APPUSERID   NUMBER NOT NULL,
    RECIPE_ID   NUMBER NOT NULL,
    CREATED_AT  DATE DEFAULT SYSDATE,

    CONSTRAINT uk_user_recipe_like UNIQUE (APPUSERID, RECIPE_ID),

    FOREIGN KEY (APPUSERID) REFERENCES BUG(APPUSERID) ON DELETE CASCADE,
    FOREIGN KEY (RECIPE_ID) REFERENCES recipes3(RECIPE_ID) ON DELETE CASCADE
);



--비속어 사전 테이블 (BAD_WORDS)
CREATE TABLE BAD_WORDS3 (
    WORD_ID NUMBER PRIMARY KEY,
    WORD    VARCHAR2(250) UNIQUE
);


-- 검색 기록 테이블
CREATE TABLE SEARCH_HISTORY3 (
    SEARCH_ID      NUMBER PRIMARY KEY,
    APPUSERID      NUMBER,
    KEYWORD        VARCHAR2(255),      -- 사용자가 입력한 검색어
    IS_AI_SEARCH   CHAR(1) DEFAULT 'N', -- 자연어 검색 여부
    RESULT_AI   VARCHAR2(255) ,             -- 뭐가 검색됬는지
    CREATED_AT     DATE DEFAULT SYSDATE,

    FOREIGN KEY (APPUSERID) REFERENCES BUG(APPUSERID)
);



-- AI 사용이력
CREATE TABLE AI_USAGE_HISTORY3 (
    AI_HIST_ID  NUMBER PRIMARY KEY, 
    APPUSERID   NUMBER,         -- 누가 썼는지
    TARGET_TYPE VARCHAR2(30),  -- RECIPE / SEARCH / MODERATION AI가 어디에 쓰였는지
    TARGET_ID   NUMBER,        -- RECIPE_ID (없으면 NULL)  연결 대상 ID 
    AI_ACTION   VARCHAR2(30),  -- GENERATE / ANALYZE / SEARCH 어떤 행동을 했는지 
    SUMMARY     VARCHAR2(250), -- 사람이 보는 요약  '줄거리 기반 레시피 자동 생성'
    CREATED_AT  DATE DEFAULT SYSDATE, -- 언제 
    
    FOREIGN KEY (APPUSERID) REFERENCES BUG(APPUSERID)
);

-- AI 사용 이력 조회를 빠르게 해주는 인덱스
CREATE INDEX idx_ai_hist_user_date
ON AI_USAGE_HISTORY3 (APPUSERID, CREATED_AT);

---- STATUS 컬럼에 이상한 값 못 들어오게 막는 안전장치
--ALTER TABLE recipes3 ADD CONSTRAINT chk_recipe_status
--CHECK (STATUS IN ('ACTIVE', 'HIDDEN', 'DELETED'));

--
---- 이미지 테이블 (CASCADE 적용)
--CREATE TABLE recipes_img3 (
--    RECIPE_ID NUMBER,
--    RURL      VARCHAR2(250),
--    FOREIGN KEY (RECIPE_ID) REFERENCES recipes(RECIPE_ID) ON DELETE CASCADE
--);

-- 재료 매핑 테이블 (CASCADE 적용)
CREATE TABLE recipes_ingre_map3 (
    RECIPE_ID    NUMBER,
    INGRE_MAP_ID NUMBER PRIMARY KEY,
    FOREIGN KEY (RECIPE_ID) REFERENCES recipes(RECIPE_ID) ON DELETE CASCADE
);

-- 재료 상세 테이블 (CASCADE 적용)
CREATE TABLE recipes_ingre3 (
    INGRE_MAP_ID NUMBER,
    INGRE_NAME   VARCHAR2(100),
    INGRE_NUM    VARCHAR2(50),
    FOREIGN KEY (INGRE_MAP_ID) REFERENCES recipes_ingre_map(INGRE_MAP_ID) ON DELETE CASCADE
);

CREATE TABLE recipes_step_map3 (
    STEP_MAP_ID NUMBER PRIMARY KEY,
    RECIPE_ID   NUMBER NOT NULL,
    STEP_ORDER  NUMBER NOT NULL,  -- 1,2,3,4...

    FOREIGN KEY (RECIPE_ID)
        REFERENCES recipes3(RECIPE_ID)
        ON DELETE CASCADE
);

CREATE TABLE recipes_step3 (
    STEP_MAP_ID NUMBER PRIMARY KEY,
    STEP_DESC   VARCHAR2(1000) NOT NULL,
    STEP_IMAGE  VARCHAR2(255),

    FOREIGN KEY (STEP_MAP_ID)
        REFERENCES recipes_step_map3(STEP_MAP_ID)
        ON DELETE CASCADE
);


CREATE INDEX idx_recipe_title ON recipes3(TITLE);                    -- 검색용 제목
CREATE INDEX idx_ingre_name ON recipes_ingre3(INGRE_NAME);           -- 검색용 재료명
CREATE INDEX idx_ingre_description ON recipes3(DESCRIPTION);         -- 검색용 간단설명
CREATE INDEX idx_ingre_instruction ON recipes3(INSTRUCTIONS);         -- 검색용 설명

-- 카테고리 시퀀스
CREATE SEQUENCE seq_category3;

-- 레시피 시퀀스
CREATE SEQUENCE seq_recipe3;

-- 좋아요 시퀀스
CREATE SEQUENCE seq_recipe_like3;

-- 비속어 시퀀스
CREATE SEQUENCE seq_bad_word3;

-- 검색 기록 시퀀스
CREATE SEQUENCE seq_search_history3;

-- AI 로그 시퀀스
CREATE SEQUENCE seq_ai_usage_history3;

-- 재료 매핑 시퀀스
CREATE SEQUENCE seq_ingre_map3;


-------------------------------------------------------------------------
SELECT DISTINCT r.*
FROM recipes r
LEFT JOIN recipes_ingre_map rim ON r.RECIPE_ID = rim.RECIPE_ID
LEFT JOIN recipes_ingre ri ON rim.INGRE_MAP_ID = ri.INGRE_MAP_ID
WHERE r.TITLE LIKE '%' || :keyword || '%'
   OR r.DESCRIPTION LIKE '%' || :keyword || '%'
   OR r.INSTRUCTIONS LIKE '%' || :keyword || '%'
   OR ri.INGRE_NAME LIKE '%' || :keyword || '%';
   
   
select * from CATEGORY;
INSERT INTO CATEGORY VALUES (1, '전체');
INSERT INTO CATEGORY VALUES (2, '한식');
INSERT INTO CATEGORY VALUES (3, '양식');
INSERT INTO CATEGORY VALUES (4, '중식');
INSERT INTO CATEGORY VALUES (5, '일식');
INSERT INTO CATEGORY VALUES (6, '디저트');
INSERT INTO CATEGORY VALUES (7, '건강식');
INSERT INTO CATEGORY VALUES (8, '기타');
