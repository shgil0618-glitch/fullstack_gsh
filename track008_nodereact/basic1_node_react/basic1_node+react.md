## 1. node+react

### 1. node.js
 - javascript 런타임환경
 - 비동기 이벤트 기반


#### (2) 프로젝트 만들기
```js
npm init
```

[실습]
[project]
ㄴ back     #node
ㄴ front    #react
```js
mkdir back
cd back
npm init
```

■ 구조확인
back/
├── config/
│   └── db.js          #    oracle db 설정
├── middlewares/
│   └── isAuthenticated.js      # 로그인 인증 미들웨어
├── models/
│   └── users.js               #사용자 db 모델 및 쿼리함수
├── passport/
│   ├── index.js             # password 초기화 
│   └── local.js             # local 전략 설정
├── routes/
│   └── user.js              # 사용자관련 api 라우터
├── node_modules/       # npm 패키지         
├── .env                # 환경변수
├── app.js              # 서버 진입점     
├── package.json        # 프로젝트 설정 및 스크립트      
├── package-lock.json   # 패키지 버전 고정
├── test1_model_testUsers.js  # 테스트 스크립트


```js
사용하고자하는 모듈설정이 들어간 package.json 폴더에 넣기
npm install
```

#### (3) 서버 진입점
1. app.js 작성
2. 실행
```js
npx nodemon app.js
```

### 1. model
### 2. 개발
```js
SQL> desc appuser2;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 APP_USER_ID                               NOT NULL NUMBER(5)
 EMAIL                                     NOT NULL VARCHAR2(100)
 PASSWORD                                           VARCHAR2(255)
 MBTI_TYPE_ID                                       NUMBER(5)
 CREATED_AT                                         DATE
 UFILE                                              VARCHAR2(255)
 MOBILE                                             VARCHAR2(50)
 NICKNAME                                           VARCHAR2(50)
```
(2) db설정 
back/
├── config/
│   └── db.js              #     Oracle Db 설정        
├── .env                   #     환경변수  

2-1. .env  
```js
```

2-2. [config] - db.js
```js
``` 

(3) [models] - [users.js]
(4) 모델함수 테스트
