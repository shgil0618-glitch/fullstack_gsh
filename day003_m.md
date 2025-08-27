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
 
===

# ✅ WebBasic
### 3. Tag
   1. 웹 페이지의 구성요소를 알려주는 표시언어
   2. h1~h6 제목
      - h1 : 로고, 상호명
      - h2 : 주메뉴
      - h3~h6 : 중요도 상세메뉴 (소제목)
   3. p, pre : 문단
      - p : 일반문단
      - pre : 줄바꿈과 공백을 유지하는 서식 텍스트
   4. img : 이미지
      - src : 경로,  alt : 대체용어
   5. a : 링크
      - href : 다른페이지 or 파일로 연결, target = "_blank" : 새창열기
   6. 리스트 태그 : ul, ol, dl
      - ul : 순서없는 리스트
      - ol : 순서있는 리스트
      - dl : 설명 리스트 
   7. 그룹핑 : div

   `web002_basic.html`

웹 접근성 연구소 : `https://www.wa.or.kr/`
웹 접근성 확인 사이트 : `https://validator.w3.org/`
ctrl + a : 전체 선택

# ✅ Java 
### 4. 