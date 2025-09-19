## Track001 -  github
---
### 1. git  vs  github
- git - 로컬에 파일의 변경이력 ( 내컴퓨터에 타임머신)
- github - 클라우드올려서 협업 (친구들과 공유작업공간)

---
### 2. 기본명령어
   `git init`  저장소 생성   (빈 상자 만들기 )
   `git add .`  변경된 파일추가 ( 상자에 그림넣기)
   `git commit -m "설명" `  저장 ( 그림에 이름붙여저장)
---
### 3. [실습1] github 회원가입 및 로그인
 -  https://github.com/

---
### 4. [실습2] github 저장소
-  오른쪽상단 - [+] - [New Repository]

---
### 5. [실습3] git
- git-scm.com
- 다운로드 - [설치] 
   - ■ (New!) Add a Git Bash Profile to Windows Termial

---
### 6. [실습4] git 
#### 6-1.  Gitbash   이름, 이메일 설정정보 
```bash
git  config  --global  user.name  "Sally An"
git  config  --global user.email   "sally03915@gmail.com"
git  config  --list
```
#### 6-2.  git init    로컬상자만들기 ★
```bash
vs code - https://code.visualstudio.com/
본인폴더 - [workspace] 폴더만들기
폴더로이동 - 터미널열기  ( ctrl + ` )
git init 
```
#### 6-3.  git add .  파일만들고 / 상자에 파일넣기  ★
#### 6-4.  git status  상태확인
#### 6-5.  git commit  -m "first commit"  
   뭘저장했는지 이름붙이고 저장  ★
#### 6-6.  git  remote  add  origin   `깃허브주소(원격저장소-공유작업)`
```bash
git  remote  add  origin  https://github.com/sally03915/fullstack_20250825.git
```
#### 6-7.  git  remote  -v  연결확인
#### 6-8.  git  push origin master   원격저장소에 올리기

---
###  7. [실습5] git 수정후 (ctrl + s) 다시 올리기
```bash
파일수정
git  add  .
git commit -m "git 수정후 다시올리기"
git push origin master
```
### 8. 트러블슈팅
##### 8-1. 문제코드
```bash
TJ-BU-703-P03@DESKTOP-5CVIKGS MINGW64 /c/KIMYOUNGMIN/workspace (master)
$ git commit -m "git 수정 후 다시올리기"
On branch master
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)       
        modified:   day001.md

no changes added to commit (use "git add" and/or "git commit -a")
```
##### 8-2. 🔧 해결 방법
- 아래방법을 했는데도 처리안됨.
- 너무나도 단순한 이유였음!  **저장안함**......

✅ 방법 1: 특정 파일만 추가
```bash
git add day001.md
git commit -m "git 수정 후 다시올리기"
```

✅ 방법 2: 모든 변경된 파일 추가
```bash
git add .
git commit -m "git 수정 후 다시올리기"
```

✅ 방법 3: 변경된 파일 자동 추가 후 커밋
```bash
git commit -am "git 수정 후 다시올리기"
```
> Q.현재수정된 파일 올리기



### 9. 위에 수정된파일을 github에 올리시오!

### 10. 내일 복습문제 - ✅ 주관식 & 빈칸 채우기 복습문제

1. Git과 GitHub의 차이를 설명하세요.  
   - Git은 __________에 파일의 변경 이력을 저장하고, GitHub는 __________에서 협업을 위한 공유 작업 공간을 제공합니다.

2. 저장소를 생성하는 명령어는 무엇인가요?  
   - 명령어: `__________`

3. 변경된 파일을 스테이지에 추가하는 명령어는?  
   - 명령어: `__________`

4. 커밋을 할 때 사용하는 명령어는 무엇인가요?  
   - 명령어: `__________`

5. Git 사용자 이름과 이메일을 설정하는 명령어를 작성하세요.  
   - 이름 설정: `git config --global user.name "__________"`  
   - 이메일 설정: `git config --global user.email "__________"`

6. Git 저장소를 로컬에 생성하려면 어떤 명령어를 사용하나요?  
   - 명령어: `__________`

7. Git 상태를 확인하는 명령어는 무엇인가요?  
   - 명령어: `__________`

8. GitHub에 원격 저장소를 연결하는 명령어를 작성하세요.  
   - 명령어: `git remote add origin __________`

9. 원격 저장소 연결을 확인하는 명령어는 무엇인가요?  
   - 명령어: `__________`

10. 로컬 커밋을 GitHub 원격 저장소에 업로드하는 명령어는?  
    - 명령어: `__________`

11. GitHub 저장소를 생성하려면 웹사이트에서 어떤 경로를 클릭해야 하나요?  
    - 경로: 오른쪽 상단의 `[+]` → `__________`

12. Git을 설치할 수 있는 공식 웹사이트 주소는?  
    - 주소: `__________`

13. Git 수정 후 다시 커밋하고 푸시하는 전체 명령어 흐름을 작성하세요.  
    - 1) 파일 수정 후 저장  
    - 2) `git add .`  
    - 3) `git commit -m "__________"`  
    - 4) `git push origin master`

14. Git 명령어를 입력하기 위해 사용하는 터미널 프로그램 이름은?  
    - 프로그램: `__________`

15. Git 설정 정보를 확인하는 명령어는 무엇인가요?  
    - 명령어: `__________`
 

### 10-1. answer
---

### ✅ 주관식 & 빈칸 채우기 복습문제 — 정답 포함

1. Git과 GitHub의 차이를 설명하세요.  
   - Git은 **로컬**에 파일의 변경 이력을 저장하고, GitHub는 **클라우드**에서 협업을 위한 공유 작업 공간을 제공합니다.

2. 저장소를 생성하는 명령어는 무엇인가요?  
   - 명령어: `git init`

3. 변경된 파일을 스테이지에 추가하는 명령어는?  
   - 명령어: `git add .`

4. 커밋을 할 때 사용하는 명령어는 무엇인가요?  
   - 명령어: `git commit -m "설명"`

5. Git 사용자 이름과 이메일을 설정하는 명령어를 작성하세요.  
   - 이름 설정: `git config --global user.name "Sally An"`  
   - 이메일 설정: `git config --global user.email "sally03915@gmail.com"`

6. Git 저장소를 로컬에 생성하려면 어떤 명령어를 사용하나요?  
   - 명령어: `git init`

7. Git 상태를 확인하는 명령어는 무엇인가요?  
   - 명령어: `git status`

8. GitHub에 원격 저장소를 연결하는 명령어를 작성하세요.  
   - 명령어: `git remote add origin https://github.com/sally03915/fullstack_20250825.git`

9. 원격 저장소 연결을 확인하는 명령어는 무엇인가요?  
   - 명령어: `git remote -v`

10. 로컬 커밋을 GitHub 원격 저장소에 업로드하는 명령어는?  
    - 명령어: `git push origin master`

11. GitHub 저장소를 생성하려면 웹사이트에서 어떤 경로를 클릭해야 하나요?  
    - 경로: 오른쪽 상단의 `[+]` → `New Repository`

12. Git을 설치할 수 있는 공식 웹사이트 주소는?  
    - 주소: `https://git-scm.com`

13. Git 수정 후 다시 커밋하고 푸시하는 전체 명령어 흐름을 작성하세요.  
    - 1) 파일 수정 후 저장  
    - 2) `git add .`  
    - 3) `git commit -m "git 수정후 다시올리기"`  
    - 4) `git push origin master`

14. Git 명령어를 입력하기 위해 사용하는 터미널 프로그램 이름은?  
    - 프로그램: `Git Bash`

15. Git 설정 정보를 확인하는 명령어는 무엇인가요?  
    - 명령어: `git config --list`
 












