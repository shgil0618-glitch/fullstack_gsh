#Track001 -  github

---
1. git  vs  github
- git - 로컬에 파일의 변경이력 ( 내컴퓨터에 타임머신)
- github - 클라우드올려서 협업 (친구들과 공유작업공간)

---
2. 기본명령어
   `git init`  저장소 생성   (빈 상자 만들기 )
   `git add .`  변경된 파일추가 ( 상자에 그림넣기)
   `git commit -m "설명" `  저장 ( 그림에 이름붙여저장)

---
3. [실습1] github 회원가입 및 로그인
 -  https://github.com/

---
4. [실습2] github 저장소
-  오른쪽상단 - [+] - [New Repository]

---
5. [실습3] git
- git-scm.com
- 다운로드 - [설치] 
   - ■ (New!) Add a Git Bash Profile to Windows Termial

---
6. [실습4] git 
6-1.  Gitbash   이름, 이메일 설정정보 
```bash
git  config  --global  user.name  "Sally An"
git  config  --global user.email   "sally03915@gmail.com"
git  config  --list
```
6-2.  git init    로컬상자만들기 ★
```bash
vs code - https://code.visualstudio.com/
본인폴더 - [workspace] 폴더만들기
폴더로이동 - 터미널열기  ( ctrl + ` )
git init 
```
6-3.  git add .  파일만들고 / 상자에 파일넣기  ★
6-4.  git status  상태확인
6-5.  git commit  -m "first commit"  
   뭘저장했는지 이름붙이고 저장  ★
6-6.  git  remote  add  origin   `깃허브주소(원격저장소-공유작업)`
```bash
git remote add origin https://github.com/shgil0618-glitch/fullstack_gsh.git 
```
6-7.  git  remote  -v  연결확인
6-8.  git  push origin master   원격저장소에 올리기

---
7. [실습7] git 수정 후(ctrl+s) 다시 올리기
```bash
파일수정
git add .
git commit -m "git 수정후 다시올리기"
git push origin master
```

---
8. 트러블 슈팅
8-1 문제코드
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

8-2 해결방안
```bash
 트러블 슈팅 해결 내용 작성 (컨트롤+s 이후 commit 해야되는이유 이미 add .으로 저장한거 아니야?)
```



















