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

select * from appuser;
ALTER TABLE authorities
ADD CONSTRAINT fk_authorities_appuser
FOREIGN KEY (app_user_id)
REFERENCES appuser (app_user_id);



CREATE SEQUENCE sboard2_seq;


ALTER TABLE APPUSER
  MODIFY (provider_id VARCHAR2(100));
  
 ALTER TABLE APPUSER 
 MODIFY (provider VARCHAR2(100) not null);
 
 
  ALTER TABLE appuser ADD provider_id VARCHAR2(100);

ALTER TABLE appuser ADD provider VARCHAR2(100);


UPDATE appuser
SET provider = 'UNKNOWN'
WHERE provider IS NULL;



ALTER TABLE appuser MODIFY (provider VARCHAR2(100) NOT NULL);


  CREATE SEQUENCE authorities_seq;
  
  ALTER TABLE authorities
  ADD (
    auth_id    number(5),
    app_user_id number(5)
  );
  

  