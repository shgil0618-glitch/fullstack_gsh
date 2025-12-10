commit;

create table sboard2(
    ID              NUMBER NOT NULL PRIMARY KEY,
    APP_USER_ID     NUMBER NOT NULL,
    BTITLE          VARCHAR2(1000) NOT NULL,
    BCONTENT        CLOB NOT NULL,
    BPASS           VARCHAR2(255) NOT NULL,
    BFILE            VARCHAR2(255) ,
    BHIT            NUMBER DEFAULT 0,
    BIP             VARCHAR2(255) NOT NULL,
    CREATED_AT       DATE DEFAULT SYSDATE
);

CREATE SEQUENCE sboard2_seq;