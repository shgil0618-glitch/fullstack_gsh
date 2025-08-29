## Track001 -  github

# ■ Github   
### 12. 깃허브 협업 
>**복습문제로 정리** 🚀실습
- Q1. 금일정리파일 day005.me 깃허브에 올리기
- Q2. github 에서 day005.md 수정
- Q3. git에서 day005.md 수정
      클라우드와 수정한 다른부분 수정 
- Q4. Q3 발생하는 오류 수정 - 트러블 슈팅
```bash
$ git push origin master
To https://github.com/shgil0618-glitch/fullstack_gsh.git
 ! [rejected]        master -> master (fetch first)
error: failed to push some refs to 'https://github.com/shgil0618-glitch/fullstack_gsh.git'
hint: Updates were rejected because the remote contains work that you do not
hint: have locally. This is usually caused by another repository pushing to
hint: the same ref. If you want to integrate the remote changes, use
hint: 'git pull' before pushing again.
hint: See the 'Note about fast-forwards' in 'git push --help' for details.
```
발생문제 : 로컬 master 와 원격브랜치 (origin/master) 차이 발생
해결방안 : 
```bash
git add .
git commit -m "day005"
git pull origin master
git push origin master
```

```bash
git pull origin master --rebase
git rebase --continue
```
</br>

--rebase : 로컬변경사항을 원격변경사항위에 덮기
rebase를 열었으면 반드시 닫아줘야함
```bash
$ git commit -m "day5"
interactive rebase in progress; onto bca6145
Last command done (1 command done):
   pick e48ba56 # day005
No commands remaining.
You are currently editing a commit while rebasing branch 'master' on 'bca6145'.
  (use "git commit --amend" to amend the current commit)
  (use "git rebase --continue" once you are satisfied with your changes)

nothing to commit, working tree clean
```

 ---

## 📚 day004 복습  
■ WebBasic 주관식 빈칸 채우기 문제
1. HTML 태그 관련
1-1. 웹페이지의 구성요소를 알려주는 표시 언어는 (① HTML)이다.  
1-2. 제목 태그 중 로고나 상호명을 나타낼 때 사용하는 태그는 (② h1)이다.
1-3. 일반 문단을 작성할 때 사용하는 태그는 (③ p)이고, 줄바꿈과 공백을 유지하는 서식 텍스트는 (④ pre)이다.
1-4. 이미지를 삽입할 때 사용하는 태그는 (⑤ img)이며, 경로를 지정하는 속성은 (⑥ src), 대체 텍스트를 지정하는 속성은 (⑦ alt)이다.
1-5. 링크를 연결할 때 사용하는 태그는 (⑧ a)이며, 새 창으로 열기 위한 속성은 (⑨ target="_blank")이다.
1-6. 순서 없는 리스트를 만들 때 사용하는 태그는 (⑩ ul)이고, 순서 있는 리스트는 (⑪ ol), 설명 리스트는 (⑫ dl)이다.
1-7. 웹페이지에서 그룹핑을 위해 사용하는 태그는 (⑬div)이다.

■ CSS 주관식 빈칸 채우기 문제
2. 여백과 글자 스타일
2-1. 요소의 바깥쪽 여백을 설정하는 속성은(①margin)이고, 안쪽 여백은 (②padding)이다.
2-2. 글자 색상을 빨간색으로 지정하려면 (③ color:red )를 사용한다.
2-3. 글자 크기를 16px로 지정하려면 (④ font-size:16px)를 사용한다.
2-4. 문단을 중앙 정렬하려면 (⑤ text-align) 속성에 (⑥ center) 값을 사용한다.
2-5. 밑줄을 제거하려면 (⑦ text-decoration) 속성에 (⑧ none) 값을 사용한다.
2-6. 글꼴을 지정할 때 사용하는 속성은 (⑨ font-family)이며, 예시로는 (⑩sans-serif)이 있다.
2-7. 글자를 굵게 만들기 위한 속성은 (⑪ font-weight:bold)이다.

3. 배경 꾸미기
3-1. 배경색을 금색으로 지정하려면 (①background-color): gold; 를 사용한다.
3-3. 배경에 이미지를 삽입하고 반복하며 중앙에 배치하려면 (②background) 속성을 사용하며, 구성 요소는 (③색상), (④경로), (⑤반복여부), (⑥배치), (⑦가로사이즈/세로사이즈)이다.
 

4. 박스 디자인
4-1. 박스의 가로 길이를 300px로 지정하려면 (① width): 300px;
4-2. 빨간색 실선 테두리를 만들려면 (② border): 3px solid red;
4-3. 둥근 모서리를 만들기 위한 속성은 (③ border-radius)이다.
4-4. 그림자 효과를 주기 위한 속성은 (④ box-shadow)이다.

■ Java 주관식 빈칸 채우기 문제
5. 출력 방식
5-1. 줄바꿈이 포함된 출력은 (①)을 사용하고, 줄바꿈 없이 출력하려면 (②)을 사용한다.
5-2. 서식 있는 출력은 (③)을 사용하며, 정수는 (④), 문자열은 (⑤), 실수는 (⑥)을 사용한다.
5-3. System.out.println("A\nAB\nABC");에서 \n은 (⑦)을 의미한다.

6. + 연산자 의미
6-1. 숫자 + 숫자는 (①) 연산이며, 숫자 + 문자열은 (②)로 처리된다.
6-2. System.out.println("" + 1 + 2);의 결과는 (③)이다.

■ 변수 관련 주관식 문제
7. 변수 개념
7-1. 변하는 값을 저장하는 공간은 (①)이고, 변하지 않는 값은 (②)이다.
7-2. 변수 이름 규칙 중 하나는 (③)로 시작할 수 있다는 것이다.
7-3. 정수형 데이터를 저장하기 위한 자료형은 (④)이고, 실수형은 (⑤)이다.  


# ■ WebBasic
### 3. Tag  (연습문제 - a태그까지 정리)
1. 웹페이지의 구성요소를 알려주는 표시언어
2. h1~h6  제목
   - h1 : 로고, 상호명
   - h2 : 주메뉴
   - h3~h6 : 중요도 상세메뉴 (소제목)
3. p, pre : 문단
   - p : 일반문단
   - pre : 줄바꿈과 공백을 유지하는 서식텍스트
4. img  : 이미지
   - src : 경로  , alt : 대체용어 
5. a : 링크
   - href : 다른페이지나 파일로 연결 , target="_blank" 새창열기
6. 리스트태그 : ul , ol, dl
   - ul  : 순서없는리스트
   - ol  : 순서있는리스트
   - dl  : 설명리스트  
7. 그룹핑 : div

`web002_basic.html`      

### 4. CSS
1. 여백 - margin / padding
   1. margin : 바깥쪽여백
   2. padding : 안쪽여백

2. 글자스타일
   1.글자색상
      color:red
   2.글자크기
      font-size:16px
   3.정렬
      text-align:center /left /right/justify 문단의 정렬을 체크해주는 부분인데 left(왼쪽정렬) , right(오른쪽정렬) , center(중앙) , justify(수평정렬)
   4.밑줄
      text-decoration:none; 깃허브
   5. 글꼴
      font-family:sans-serif;
   6. 굵게
      font-weight:bold;

3. 배경꾸미기
      background-color: gold;
      background:black;
      background:linear-gradient(to right, pink, orange) background:linear-gradient(45deg, pink, orange)
      background: red url(./img/five.png) repeat center / 20px 20px
                  색상 경로 반복여부 중앙배치 가로사이즈 세로사이즈  

4. 박스디자인
   1. 가로 : width:300px
   2. 선 : border:3px solid red
   3. 둥근모서리 : borer-radius : 20px
   4. 그림자효과 : box-shadow: 0 4px 12px rgba(0,0,0,0.5)



# ■ Java
 

#### ■7. 출력 (1)   println, print, printf
 1)  System.out.println("문자열-하고싶은말");  // \n줄바꿈
 2)  System.out.print("문자열-하고싶은말");   //줄바꿈처리안됨
 3)  System.out.printf("내나이%d ,  내이름%s , 좋아하는 숫자  파이 %f" , 10 , "ab" , 1.23 );
     %d 숫자정수 : 10,20,30  ( 소수점 안붙음)
     %s  문자열   :  "abc"
     %f 숫자실수 :  1.23 , 1.5, 3.14
     
   System.out.println("A");   
   System.out.println("AB");   
   System.out.println("ABC");   

   System.out.println("A\nAB\nABC");   

#### ■7. 출력 (2)   + 의미 , ()
System.out.println( 1+ 2 );    //3
System.out.println( 1+ 2 + "+" + 3 +4);  // 3 + 34    ?
System.out.println( "" + 1+ 2);  // 12

1)     +    연산(더하기)
2)     숫자 + 숫자  - 더하기연산
3)     숫자 + 문자열 ,   문자열 + 숫자 - 출력
 

연습문제1)  
패키지명 : com.company.java002_ex
클래스명 : PrintEx001
출력내용 : 
   %s를 이용해서  다음과 같이 출력
   
    좋아하는 색상은 RED입니다.
```java
package com.company.java002_ex;

public class PrintEx001 {
	public static void main(String[] args) {
		System.out.println("좋아하는 색상은 RED입니다.");
		System.out.print("좋아하는 색상은 RED입니다.\n");
		System.out.printf("좋아하는 색상은 %s입니다.","RED");
	}
}
```

연습문제2)  
패키지명 : com.company.java002_ex
클래스명 : PrintEx002
출력내용 : 
   다음의 코드를 10+3=13  나오게 도전!
   System.out.println(  10+3=10+3  );   
```java
package com.company.java002_ex;

public class PrintEx002 {
	public static void main(String[] args) {
		System.out.println(10 + "+" + 3 + "=" + 1+3);
		System.out.printf("%d+%d=%d",10,3,13);

      System.out.println(10 + 2 + 5 + "=" + 1 + 3);
	}
}
```

### 8.  변수
1. 값?
- 토큰 : 특정의미를 가진문자
- 리터럴, 키워드, 식별자, 연산자,구분자

  System.out.println("hello");

2. 값의 보관
- 값의 보관 == 메모리확보
- 변수 : 변하는 수 (오픈박스) ,  한개의 값
- 상수 : 변하지 않는(상) 수  (밀봉박스)
- 변수이름규칙 :   $_소문자7

3. 변수사용법
   자료형  변수명   

   int       a;         -       int  정수 1,2,3             a[ ]
   double b;         - double  실수 1.23              b[ ]
   
   a=10;                                                      a[10]
   a=20;                                                      a[20]

※ 상수    final   int    JAVA_HOME ;   - 수정못해!


기본문제1)  Var001


연습문제1)  
패키지명 : com.company.java002_ex
클래스명 : VarEx001
출력내용 : 
   1-1.  apple라는 변수만들기
   1-2.  1-1.에서 만든 변수에 1000이라는 데이터 대입하시오.  ( 자료형 int )
   1-3.  1-1.에서 만든 변수이용해서 
           사과가격은 1000원입니다 출력
   1-4.  1-1.에서 만든 변수에 2000이라는 데이터 대입하시오.  
   1-5.  1-1.에서 만든 변수이용해서 
           사과가격은 2000원입니다 출력

```bash
package com.company.java002_ex;

public class VarEx001 {
	public static void main(String[] args) {
		int apple;
		apple = 1000;
		System.out.println("어제 사과의 가격 : " + apple);
		apple = 2000;
		System.out.printf("오늘 사과의 가격 : %d",apple);
	}

}

```

연습문제2)  
패키지명 : com.company.java002_ex
클래스명 : VarEx002
출력내용 : 
   1-1.  정수형데이터를 담을수 있는 변수 a 만들고   
   1-2.  a에 10대입하시오
   1-3.  정수형데이터를 담을수 있는 변수 b 만들고   
   1-4.  b에 3대입하시오
   1-5.  System.out.println 을 4번사용해서 
     10 + 3 = 13
     10  - 3 = 7
     10  * 3 = 30
     10  / 3 = 3

```bash
package com.company.java002_ex;

public class VarEx002 {
	public static void main(String[] args) {
		int a;
		a = 10;
		int b;
		b = 3;
		float c;
		c = (float)a/b;
		System.out.println(a + "+" + b + "=" + (a+b) );
		System.out.println("10 + 3 = "+(a+b));
		System.out.println("10 - 3 = "+(a-b));
		System.out.println("10 * 3 = "+(a*b));
		System.out.println("10 / 3 =" +(a/b));
		System.out.println("10 / 3 = "+c);
		System.out.println("10 / 3 = "+((float)a/b));	
		System.out.printf("%d / %d = %.3f\n",a,b,c);
		System.out.printf("%d / %d = %.2f\n",a,b,c);
		System.out.printf("%d / %d = %.1f\n",a,b,c);
		System.out.printf("%d / %d = %f\n",a,b,c);
	}

}

```


#### ■9. 자료형
 


