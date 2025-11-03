
-- COMMUNITY_TB (레시피 공유 게시판)
CREATE TABLE COMMUNITY_TB (
    post_id       NUMBER(8)       PRIMARY KEY,
    user_id       VARCHAR2(30)    NOT NULL,
    title         VARCHAR2(200)   NOT NULL,
    content       CLOB            NOT NULL,
    category      VARCHAR2(50),
    views         NUMBER(6)       DEFAULT 0,
    likes         NUMBER(6)       DEFAULT 0,
    created_at    DATE            DEFAULT SYSDATE,
    updated_at    DATE,
    is_deleted    CHAR(1)         DEFAULT 'N' CHECK (is_deleted IN ('Y','N')),
    CONSTRAINT fk_community_user FOREIGN KEY (user_id) REFERENCES USER_TB(user_id)
);

-- COMMUNITY_IMAGE_TB (게시글 이미지)
CREATE TABLE COMMUNITY_IMAGE_TB (
    image_id      NUMBER(8)       PRIMARY KEY,
    post_id       NUMBER(8)       NOT NULL,
    image_url     VARCHAR2(300)   NOT NULL,
    created_at    DATE            DEFAULT SYSDATE,
    CONSTRAINT fk_image_post FOREIGN KEY (post_id) REFERENCES COMMUNITY_TB(post_id)
);

-- REVIEW_TB (음식 리뷰)
CREATE TABLE REVIEW_TB (
    review_id     NUMBER(8)       PRIMARY KEY,
    user_id       VARCHAR2(30)    NOT NULL,
    food_id       NUMBER(6)       NOT NULL,
    rating        NUMBER(2,1)     CHECK (rating BETWEEN 0 AND 5),
    comment       VARCHAR2(500),
    like_count    NUMBER(6)       DEFAULT 0,
    created_at    DATE            DEFAULT SYSDATE,
    updated_at    DATE,
    is_deleted    CHAR(1)         DEFAULT 'N' CHECK (is_deleted IN ('Y','N')),
    CONSTRAINT fk_review_user FOREIGN KEY (user_id) REFERENCES USER_TB(user_id),
    CONSTRAINT fk_review_food FOREIGN KEY (food_id) REFERENCES FOOD_TB(food_id)
);

