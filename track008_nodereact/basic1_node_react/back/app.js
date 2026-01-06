// express - node.js 프레임워크 (웹서버를 쉽게 만들기)
const  express = require('express');

// 환경변수(.env) 사용을 위해 dotenv불러오기
const dotenv = require('dotenv');

// 로그 기록용 미들웨어(개발시 요청/응답 확인)
const morgan = require('morgan');

// CORS(다른 도메인에서 API 호출 허용) 미들웨어
const cors = require('cors');

// Swagger UI와 Swagger-jsdoc 불러오기(API문서 자동화)
const  swaggerUi    = require('swagger-ui-express'); 
const  swaggerJsdoc = require('swagger-jsdoc');

//   /user경로에 사용자 라우터 연결
const  userRouter = require('./routes/user');  //##
//const  postRouter = require('./routes/post'); 예시
//////////////////////////////////////////////////////////
// .env 파일 로드 (환경변수 사용 가능하게 함)
dotenv.config();
// express 애플리케이션 인스턴스 생성
const  app = express();
// json 파싱 미들웨어 (POST요청  body를 JSON으로 읽기)
app.use(express.json());

// URL-encoded 파싱 미들웨어 ( form 데이터 처리)
app.use(express.urlencoded({extended: true}));

// 모든 도메인에 api호출 허용
app.use(cors());

// 개발모드에서 요청로그출력
app.use( morgan('dev'));

const swaggerOptions = {
  definition: {
    openapi: '3.0.0',  //Swagger
    info: {
      title: 'User API',   // 문서정보
      version: '1.0.0',     // 문서버젼
      description: '회원가입, 로그인, 사용자 조회/수정/삭제 API 문서', //설명
    },
  },
  apis: ['./routes/*.js'],  // swagger주석이 들어간 라우터 파일경로
};
// Swagger 문서 생성
const swaggerSpecs = swaggerJsdoc(swaggerOptions);

//////////////////////////////////////////////////////////
// Swagger UI 엔드포인트 등록
app.use('/api-docs', swaggerUi.serve, swaggerUi.setup(swaggerSpecs));

// /user 경로에 사용자라우터연결
app.use('/user' , userRouter)  //##
// GET 메서드로 루트경로('/') 요청이 오면 실행될 라우터 핸들러 등록

app.get('/' , (req, res)=>{
    // 클라이언트에서 'hello express' 문자열응답
    res.send('hello express');
});
//지정포트 [실행], 실행되면 콘솔에 접근해 url 출력
const PORT = process.env.PORT || 3065;
app.listen(  3065 , ()=>{
    console.log(`✅ 서버 실행중!   http://localhost:${PORT}`);
    console.log(`✅ Swagger UI :  http://localhost:${PORT}/api-docs`);
}); 

//실행 :  npx  nodemon  app.js  