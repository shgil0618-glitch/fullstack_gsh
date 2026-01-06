// express - node.js 프레임워크 (웹서버를 쉽게 만들기)
const express = require('express');

// express 애플리케이션 인스턴스 생성
const app = express();

// GET 메서드로 루트경로('/') 요청이 들어오면 실행될 라우터 핸들러 등록
app.get('/' , (req,res) => {
    // 클라이언트에서 'hello express' 문자열응답
    res.send('hello express');
});

// port 설정

// 지정포트 실행, 실행되면 콘솔에 접근해 url 출력
app.listen(3065,()=>{
    console.log(`서버 실행중! http://localhost:3065`);
});

// 실행 : npx nodemon app.js

