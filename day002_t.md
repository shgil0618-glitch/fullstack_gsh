## Track001 -  github

# 다른친구가 수정하고 올림!
### 9  pull & push  - 최신상황 반영하고 올리기
나도 수정했거든?
**[개념설명]**
- [git:로컬] - push - [github:클라우드]
- [github:클라우드] - pull - [git:로컬]

1. [git-로컬]day002.md 파일만들기 - 제목쓰기
2. [git-로컬]day002.md 파일 올리기 (github)
```bash
git add .     
git commit  -m  "day002.md"
git push origin master
```
3. [github]  github에서 day002.md 파일 수정 (깃허브에서바꾸고싶은내용)
4. [git-로컬] day002.md 파일수정 후 commit (로컬에서 바꿔서 서로 다르게 만들기)
```bash
git add .
git commit -m "day002.md local 파일수정"
```
5. [git-로컬] `git pull origin master` 충돌
```bash
git pull origin master
```
6. 두개 파일중 원하는 파일을 선택해서 파일 수정한다.   
7. 오류수정후 파일상태저장해서 다시 올리기
```bash
git add .
git commit -m "day002.md 오류해결완료"
git pull  origin master
git push  origin master
```


### 트러블슈팅 (1)
```bash
TJ-BU-703-강사PC@DESKTOP-2Q95R1R MINGW64 /d/hyojung/workspace (master)
$ git pull  origin master 
remote: Enumerating objects: 5, done.
remote: Counting objects: 100% (5/5), done.
remote: Compressing objects: 100% (3/3), done.
remote: Total 3 (delta 1), reused 0 (delta 0), pack-reused 0 (from 0)     
Unpacking objects: 100% (3/3), 1.03 KiB | 15.00 KiB/s, done.
From https://github.com/sally03915/fullstack_20250825
 * branch            master     -> FETCH_HEAD
   031d931..5ac68d8  master     -> origin/master
Auto-merging day002.md
CONFLICT (content): Merge conflict in day002.md
t the result.
```
 
- 해결방안: 
1) 두개파일비교해서 local파일수정
2) git add .     
3) git commit  -m "test"  
4) git pull origin master
5) git push orign  master
 

### 트러블슈팅 (2)
```bash
TJ-BU-703-강사PC@DESKTOP-2Q95R1R MINGW64 /d/hyojung/workspace (master|MERGING) $ git pull origin master error: You have not concluded your merge (MERGE_HEAD exists). hint: Please, commit your changes before merging. fatal: Exiting because of unfinished merge.
```
git에서 merge 안된상태에서 git pull 시도
> 병합을 시작했지만 아직완료되지 않음.

- 해결방안: 
1) 두개파일비교해서 local파일수정
2) git add .     
3) git commit  -m "test"  
4) git pull origin master
5) git push orign  master


### .gitignore
```bash
PS D:\hyojung\workspace> git add . warning: in the working copy of 'track003_java/.gitignore', LF will be replaced by CRLF the next time Git touches it warning: in the working copy of 'track003_java/java2025/.gitignore', LF will be replaced by CRLF the next time Git touches it PS D:\hyojung\workspace>
```
> 단순한 줄바꿈(Line Ending) 관련 안내. 
> Git이 .gitignore 파일을 처리할 때 줄바꿈 형식을 자동으로 바꾼다는 뜻

### 1. 복습문제 - ✅ 주관식 & 빈칸 채우기 복습문제 (ANSWER)
[~09:40]
1. Git과 GitHub의 차이를 설명하세요.  
   - Git은 __________에 파일의 변경 이력을 저장하고, 
     GitHub는 __________에서 협업을 위한 공유 작업 공간을 제공합니다.

   1) 로컬    2) 클라우드

2. 저장소를 생성하는 명령어는 무엇인가요?  
   - 명령어: `__________`
    git init 

3. 변경된 파일을 스테이지에 추가하는 명령어는?  
   - 명령어: `__________`
    git  add .

4. 커밋을 할 때 사용하는 명령어는 무엇인가요?  
   - 명령어: `__________`
   git  commit  -m  "설명"

5. Git 사용자 이름과 이메일을 설정하는 명령어를 작성하세요.  
   - 이름 설정: `git config --global user.name "__________"`  본인이름
   - 이메일 설정: `git config --global user.email "__________"` sally@gmail.com

6. Git 저장소를 로컬에 생성하려면 어떤 명령어를 사용하나요?  
   - 명령어: `__________`
   git init

7. Git 상태를 확인하는 명령어는 무엇인가요?  
   - 명령어: `__________`
   git status


8. GitHub에 원격 저장소를 연결하는 명령어를 작성하세요.  
   - 명령어: `git remote add origin __________`
                                   깃허브주소

9. 원격 저장소 연결을 확인하는 명령어는 무엇인가요?  
   - 명령어: `__________`
   gir remote  -v

10. 로컬 커밋을 GitHub 원격 저장소에 업로드하는 명령어는?  
    - 명령어: `__________`
   git push origin master

11. GitHub 저장소를 생성하려면 웹사이트에서 어떤 경로를 클릭해야 하나요?  
    - 경로: 오른쪽 상단의 `[+]` → `__________`
    New Repository

12. Git을 설치할 수 있는 공식 웹사이트 주소는?  
    - 주소: `__________`
    git-scm.com

13. Git 수정 후 다시 커밋하고 푸시하는 전체 명령어 흐름을 작성하세요.  
    - 1) 파일 수정 후 저장 (ctrl + s)  
    - 2) `git add .`  
    - 3) `git commit -m "설명"`    
    - 4) `git push origin master`

14. Git 명령어를 입력하기 위해 사용하는 터미널 프로그램 이름은?  
    - 프로그램: `git bash`

15. Git 설정 정보를 확인하는 명령어는 무엇인가요?  
    - 명령어: `git config --list`
 

 
## Track002 - html + css + js/jquery (WEB BASIC) 
1. 웹의 작업순서
   1) html 구조
   2) css 꾸미기
   3) js/jquery / react 동작
   4) jsp + oracle  서버전송 + 데이터저장

2. html 파일템플릿
- ! + enter
- html : 문서의 시작과 끝
- head : 문서 정보
- body : 사용자에게 보이는 내용
- 다소문자 / 시작태그와~ 끝나는태그

```bash
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>web basic001</title>
</head>
<body>
   안녕 Html 
</body>
</html>
```



## Track003 - JAVA
1. java?
- 한 번 작성하면 어디서든 실행된다.
- JDK 설치 -> 작성 -> 컴파일 -> 실행
- JVM 운영체제의 다른차이점을 처리해줘 
  개발자는 프로그램 작성만 집중
- 객체지향언어

2. java setting  (1) 자바다운로드 및 설치
1) java.sun.com    
2) https://www.oracle.com/java/technologies/?er=221886
3) 설치
4) C:\Program Files\Java  폴더찾기
   C:\Program Files\Java\jdk-11

3. java setting  (2) 환경설정
1) 내컴퓨터 - [속성] - 시스템속성 - 환경변수 - 시스템변수
   JAVA_HOME      
   C:\Program Files\Java\jdk-11

   Path           
   %JAVA_HOME%\bin

2) cmd
   java  -version   

4. java setting  (3) ECLIPSE 설치
1) eclipse.org
2) [download] - Eclipse IDE for Java EE Developers

5. java setting  (4) ECLIPSE 셋팅
1) perspective : 개발에 유용한 view들 만 묶어놓은 작업창
   window - perspective - open perspective - [java]
2) utf-8
   window - preferences - 검색 [enc] 
3) 이클립스 단축키
  - 명령어 불러오기  ctrl + space
  - 주석           ctrl + shift + /     (\)
  - import        ctrl + shift + o
  - 정렬           crtl + shift + f
  - 한줄정렬       ctrl + alt + j

6. 처음으로 작성해본 자바
```bash
package com.company.java001;  // 1.부품의 위치

// 주석 , 설명
public class A000 { // 2. 어디에서든지 접근 , 부품객체 , 부품이름(클래스이름)
      public          static          void main(String[] args) { 
// 3. 어디에서든지 접근 , 바로사용가능 메모리 , void main(String[] args) 전원버튼이름 
    	  System.out.println("Hello Java");
    	//4.운영체제부품객체. 출력(cmd) . println("하고싶은말") 출력
      }
} // end class   

// ctrl + f11 ( 실행 )
```

> Q) 패키지명 : com.company.java001_ex
>    클래스명 : A000_ex.java
>    "한 번 작성하면 어디서든 실행된다."  출력
```bash
package com.company.java001_ex;  //경로위치

public class A000_ex {// 아무데서나 접근가능 , 부품객체
	public static void main(String [] args) {
		System.out.println("한 번 작성하면 어디서든 실행된다.");
	}
}
//> Q) 패키지명 : com.company.java001_ex
//>    클래스명 : A000_ex.java
//>    "한 번 작성하면 어디서든 실행된다."  출력
```

### ✅ 복습문제 (주관식 & 빈칸 채우기)

1. Git에서 변경된 파일을 스테이지에 올리는 명령어는?  
   → `__________`

2. Git에서 커밋 메시지를 작성하여 변경사항을 저장하는 명령어는?  
   → `__________`

3. GitHub에 로컬 변경사항을 업로드하는 명령어는?  
   → `__________`

4. GitHub에서 최신 변경사항을 로컬로 가져오는 명령어는?  
   → `__________`

5. Git과 GitHub의 관계를 설명하세요.  
   → Git은 __________에 저장되고, GitHub는 __________에서 협업한다.

6. Git에서 충돌이 발생했을 때 나타나는 메시지는 무엇인가요?  
   → `__________` (예: CONFLICT)

7. 충돌 해결 후 변경사항을 저장하는 명령어는?  
   → `__________`

8. 병합이 완료되지 않은 상태에서 `git pull`을 실행하면 어떤 오류가 발생하나요?  
   → `__________` (힌트: MERGE_HEAD exists)

9. `.gitignore` 파일의 역할은 무엇인가요?  
   → 특정 파일이나 폴더를 __________에서 제외시킨다.

10. `.gitignore`에 추가하면 Git이 추적하지 않는 파일 확장자 두 가지를 쓰세요.  
   → `__________`, `__________` (예: *.log, *.DS_Store)

11. Git에서 로컬 파일을 수정한 후 커밋하는 명령어를 순서대로 쓰세요.  
   → `git add .` → `__________`

12. GitHub에서 파일을 수정한 후 로컬에서 pull을 하면 발생할 수 있는 문제는?  
   → `__________` (힌트: 충돌)

13. 충돌 해결 후 push까지 완료하는 전체 명령어 흐름을 쓰세요.  
   → `git add .` → `git commit -m "__________"` → `git pull origin master` → `git push origin master`

 
### ✅ 금일 복습문제 (주관식 & 빈칸 채우기)  -- ANSWER
1. Git에서 변경된 파일을 스테이지에 올리는 명령어는?  
   → `git add .`

2. Git에서 커밋 메시지를 작성하여 변경사항을 저장하는 명령어는?  
   → `git commit -m "설명"`

3. GitHub에 로컬 변경사항을 업로드하는 명령어는?  
   → `git push origin master`

4. GitHub에서 최신 변경사항을 로컬로 가져오는 명령어는?  
   → `git pull origin master`

5. Git과 GitHub의 관계를 설명하세요.  
   → Git은 **로컬**에 저장되고, GitHub는 **클라우드**에서 협업한다.

6. Git에서 충돌이 발생했을 때 나타나는 메시지는 무엇인가요?  
   → `CONFLICT (content): Merge conflict in 파일명`

7. 충돌 해결 후 변경사항을 저장하는 명령어는?  
   → `git add .` → `git commit -m "충돌 해결"`

8. 병합이 완료되지 않은 상태에서 `git pull`을 실행하면 어떤 오류가 발생하나요?  
   → `MERGE_HEAD exists` 오류

9. `.gitignore` 파일의 역할은 무엇인가요?  
   → 특정 파일이나 폴더를 **버전관리(Git 추적)**에서 제외시킨다.

10. `.gitignore`에 추가하면 Git이 추적하지 않는 파일 확장자 두 가지를 쓰세요.  
   → `*.log`, `*.DS_Store`

11. Git에서 로컬 파일을 수정한 후 커밋하는 명령어를 순서대로 쓰세요.  
   → `git add .` → `git commit -m "수정 내용"`

12. GitHub에서 파일을 수정한 후 로컬에서 pull을 하면 발생할 수 있는 문제는?  
   → **충돌(conflict)** 발생

13. 충돌 해결 후 push까지 완료하는 전체 명령어 흐름을 쓰세요.  
   → `git add .` → `git commit -m "충돌 해결"` → `git pull origin master` → `git push origin master`
 
