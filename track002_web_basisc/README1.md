# 🚀 실행력과 협업에 강한 풀스택 개발자 – 길상현의 개발 여정

> 완벽에 머무르기보다, **끝까지 완성해내는 개발자**
> 기획부터 배포까지 전 과정을 주도하며, **사용자 흐름을 설계하고 문제를 끝까지 해결**해왔습니다.

단순한 기능 구현을 넘어,
**CS 기반의 구조적 문제 해결 능력**과
**팀 프로젝트에서의 실전 협업 경험**으로 
현장에서 바로 통하는 역량을 증명해왔습니다.

<br/>
<br/>

---
<!-- 이미지 (조절하는 법) -->
<!-- 이름, 이메일, 깃허브주소, 포트폴리오  2*4의 테이블 형식으로 -->
## Contact & Link

<!-- ![프로필](./userimage.png) -->
<img src="./img/userimage.png" style="width: 20%;" alt="프로필" >

| | |
|-|-|
|이름|길상현|
|이메일|shgil0618@gmail.com|
|깃허브주소|https://github.com/shgil0618-glitch/fullstack_gsh.git|
<!--
|포트폴리오|**추후 추가예정**|
-->

<br/>
<br/>

---
# ■ Web Part
---
---
## day001

- web 관련 다운로드 및 셋팅
- 타이틀 작성 및 바디에 내용 추가
```
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>web basic001</title>
</head>
<body>
    안녕 HTML 
</body>
</html>
```
---
## day002

```
    <div><!-- 영역(폴더)을 만들게 -->
        <h3>제목 : h1~h6</h3>
        <p>제목태그 - h1(로고), h2(주메뉴)</p>
    </div>
```


```
    <div>
        <h3>문단</h3>
        <p>
        일반 문단
        공백 줄바꿈 인식 안됨
        </p>
        <pre>
        코드, 미리보기 무단
        공백 줄바꿈 인식됨
        </pre>  
    </div>
```


```
    <div>
        <h3>IMG</h3>
        <p>hello gil</p>
        <p><img src = "./img/userimage.png" 
            style="width: 20%;" alt = "userimage"/></p> 
        <!-- 끝에 /를 넣는 이유는 나중에 리엑트에서 /를 넣지않으면 오류가 나는 경우가 있어서 습관화 -->
         <br/>
         <br/>

        <h3>Q1. two.png 이미지 넣기</h3>
        <P><img src="./img/two.png" 
            style="width: 20%;" alt="two"/></P>
        <br/>
        <br/>

        <h3>Q2. friends 폴더안의 jack.png 화면에 나오게 만들기</h3>
        <P><img src="./img/friends/jack.png"
            style="width: 20%;" alt="jack"/></P>
    </div>
```


```
    <div>
        <h3>링크</h3>
        <p>
            <a href="https://github.com/shgil0618-glitch/fullstack_gsh.git"
            target = "_blank"> <!-- target = "_blank" 는 새창으로 열기 -->
            MY GITHUB(1)</a>
        </p>   
    <br/>
    <br/>
    </div>
```


```
    <div>
        <h3>이미지 클릭시 본인 깃허브 링크로 넘어가기</h3>
        <p>MY GITHUB(2)</p>
        <P>  
             <a href = "https://github.com/shgil0618-glitch/fullstack_gsh.git" target = "_blank">
                <img src="./img/userimage.png"
                style="width: 20%;" alt="userimage"/>  
            </a>
        </P>
    <br/>
    <br/>
    </div>

</body>
</html>
```