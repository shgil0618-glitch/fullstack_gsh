
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
<img src="./userimage.png" alt="프로필" width = "100">

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

## 📌 Golds – 실무 중심의 개발 역량 강화 목표

* **GitHub 핵심 기능을 직접 실습하며**, 버전 관리와 협업에 필요한 기초를 탄탄히 다졌습니다.
* **Markdown을 활용한 개발 문서화** 역량을 키워, 누구나 이해할 수 있는 기록을 남기는 습관을 길렀습니다.
* **GitHub Workflow를 실전 프로젝트에 적용**, 팀원과의 효율적인 협업을 경험하며 CI/CD 개념의 기초도 익혔습니다.
* **AI 도구(GitHub Copilot 등)를 활용한 개발 환경을 체험**, 생산성과 학습 효율을 높이는 방법을 적극적으로 탐구했습니다.


-->
<br/>
<br/>


---

## 📌 기술스택 기반 CS역량

| 기술스택                         | CS 기반 이해                   | 활용 능력                                                                                                                                                                  |
| ---------------------------- | -------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Git & GitHub**             | 분산 버전 관리 시스템(DVCS), 브랜치 전략 | 협업 과정에서 <b style="color:#f39c12">브랜치 전략(Git Flow, Trunk-based)</b> 적용, 충돌 해결 및 코드 리뷰를 통한 <b style="color:#27ae60">소프트웨어 공학적 협업 역량</b> 확보                               |
| **Markdown**                 | 문서 구조화, 개발 지식 전달           | <b style="color:#3498db">가독성 높은 문서화</b> 및 README, API 문서, 위키 작성 → <b style="color:#27ae60">기술 커뮤니케이션 역량</b> 강화, 명확한 표현으로 <b style="color:#9b59b6">팀 생산성 극대화</b>        |
| **VS Code**                  | IDE 동작 원리, 코드 품질 관리        | 확장 플러그인 기반 <b style="color:#f39c12">개발 환경 최적화</b>, <b style="color:#27ae60">디버깅 · Linting · Formatter</b> 적용을 통한 코드 품질 관리                                              |
| **HTML5**                    | 웹 표준, DOM 구조, 시맨틱 태그       | 시맨틱 태그 활용으로 <b style="color:#27ae60">정보 구조화 및 접근성 개선</b>, DOM 및 웹 표준 이해로 <b style="color:#3498db">크로스 플랫폼 호환성 보장</b>                                                   |
| **CSS3**                     | 렌더링 엔진, 박스 모델, 레이아웃 알고리즘   | Flexbox · Grid 시스템을 통한 <b style="color:#f39c12">효율적 레이아웃 설계</b>, 애니메이션 및 반응형 디자인 적용으로 <b style="color:#27ae60">사용자 경험(UX) 최적화</b>                                      |
| **AI 도구 (Copilot, ChatGPT)** | NLP 모델 구조, AI 기반 자동화 활용    | 자연어 입력 구조 최적화로 <b style="color:#f39c12">문제 정의 및 요구사항 추출</b>, 프롬프트 최적화를 통한 <b style="color:#27ae60">자동화 · 생산성 증대</b>, AI 협업으로 <b style="color:#9b59b6">문제 해결 능력 가속화</b> |


<br/>
<br/>

---

## 📌 트러블 슈팅 (github에서 발생)
<br/>

### ▶트러블 슈팅(1)

```bash
$ git commit -m "git 수정 후 다시올리기"
On branch master
Changes not staged for commit:
        modified:   day001.md
no changes added to commit (use "git add" and/or "git commit -a")
```

1. **문제점**

   * 파일을 수정했지만 `git add` 단계 없이 커밋을 시도
   * 실제 원인은 수정한 파일을 **저장하지 않고 커밋**하려 한 것

2. **해결방안**

   * 저장 후 다시 `git add` 및 `git commit` 진행


3. **느낀점**

   * 너무 기본적인 부분에서 문제가 발생할 수 있음을 깨달음
   * 사소한 습관(파일 저장)을 소홀히 하면 불필요하게 시간을 낭비하게 됨
   * 앞으로는 **커밋 전 저장 확인 → ctrl+s 혹은 git status 확인** 습관을 들여야 함

<br/>

### ▶트러블 슈팅(2)

```bash
$ git push origin master
! [rejected]        master -> master (fetch first)
error: failed to push some refs to '...'
hint: Updates were rejected because the remote contains work that you do not
hint: have locally. ...
```

1. **문제점**

   * 로컬 브랜치가 GitHub 최신 상태보다 뒤처져 있었음
   * 협업 상황에서 최신 내용을 가져오지 않고 곧바로 `push` 시도

2. **해결방안**

   1. `git add .`
   2. `git commit -m "메시지"`
   3. `git pull origin master` (원격 변경사항 병합)
   4. `git push origin master`

3. **느낀점**

   * 협업 환경에서는 언제든 원격 상태가 바뀔 수 있다는 사실을 명심해야 함
   * `push` 전에 **반드시 pull → 상태 확인 → 병합** 과정을 거쳐야 충돌을 줄일 수 있음
   * 습관적으로 **git pull → 코드 확인 → push** 루틴을 가져야 함

<br/>

### ▶트러블 슈팅(3)

```bash
$ git pull origin master
...
CONFLICT (content): Merge conflict in day002.md
Automatic merge failed; fix conflicts and then commit the result.
```

1. **문제점**

   * 원격 저장소와 로컬 저장소의 동일 파일(day002.md)이 서로 다르게 수정됨
   * 자동 병합 불가능 → **merge conflict 발생**

2. **해결방안**

   * 충돌 난 로컬파일(`day002.md`)을 열어 수동으로 수정
   * 수정 후 `git add day002.md` → `git commit` 으로 병합 완료
   * 이후 정상적으로 `git push`

3. **느낀점**

   * 충돌은 협업 개발에서 자연스러운 과정이라는 점을 이해
   * 무조건 에러로 인식하기보다, **내용 비교 & 합의된 기준으로 수정**하는 습관 필요
   * 충돌 상황은 **커뮤니케이션 역량 + 코드 이해력**이 함께 요구된다는 점을 배움

<br/>
<br/>


### ▶트러블 슈팅(4)

```bash
$ git push origin master
To https://github.com/shgil0618-glitch/fullstack_gsh.git
 ! [rejected]        master -> master (fetch first)
error: failed to push some refs to 'https://github.com/shgil0618-glitch/fullstack_gsh.git'
hint: Updates were rejected because the remote contains work that you do not
hint: have locally. This is usually caused by another repository pushing to
the same ref. If you want to integrate the remote changes, use
'git pull' before pushing again.
```

1. **문제점**

   * 로컬 브랜치(master)와 원격 브랜치(origin/master)의 커밋 히스토리가 서로 달라 발생
   * 원격 저장소에 추가된 커밋을 로컬이 반영하지 못한 상태에서 push를 시도했기 때문에 거절됨
   * 단순 `git pull`을 하면 자동으로 merge commit이 생성되어, 커밋 히스토리가 지저분해질 수 있음

2. **해결방안**

   * `--rebase` 옵션을 사용하여 원격 브랜치의 커밋을 먼저 가져온 뒤, 로컬 커밋을 그 위에 재적용

   ```bash
   git pull origin master --rebase
   ```

   * rebase 도중 충돌(conflict) 발생 시 → 해당 파일을 수정하고 `git add` 후 진행
   ```bash
   git rebase --continue
   ```

   * 불필요한 merge commit 없이, 선형적인 커밋 히스토리 유지 가능
   
   * 모든 충돌 해결 및 rebase 종료 후 정상적으로 push
   ```bash
   git push origin master
   ```

3. **느낀점**

   * 단순히 충돌을 피하는 것보다, **프로젝트 히스토리를 깔끔하게 관리하는 방법**이 더 중요하다는 걸 깨달음
   * `git pull --rebase`는 협업 시 발생할 수 있는 "불필요한 merge commit" 문제를 줄여주어, 로그 가독성을 크게 높임
   * 단순 문제 해결을 넘어서, 왜 특정 전략(rebase)을 선택해야 하는지를 이해하고 설명할 수 있게 됨

<br/>
<br/>

### ▶트러블 슈팅(5)

```bash
PS D:\gilsanghyun\teacher> git push origin dev-gsh
Enumerating objects: 7, done.
Counting objects: 100% (7/7), done.
Delta compression using up to 4 threads
Compressing objects: 100% (4/4), done.
Writing objects: 100% (6/6), 505 bytes | 505.00 KiB/s, done.
Total 6 (delta 2), reused 0 (delta 0), pack-reused 0 (from 0)
remote: Resolving deltas: 100% (2/2), completed with 1 local object.
To https://github.com/tkasid00/fullstack_20250825.git/
 ! [remote rejected] dev-gsh -> dev-gsh (permission denied)
error: failed to push some refs to 'https://github.com/tkasid00/fullstack_20250825.git/'
```

1. **문제점**

   * 푸시를 시도한 **`dev-gsh`** 브랜치에 대해 **`permission denied`** 에러가 발생
   * **원격 리포지토리의 URL**이 **잘못 지정**되어 있어 푸시할 권한이 없는 다른 리포지토리로 푸시하려고 시도한 경우

     * 에러 메시지에서 `https://github.com/tkasid00/fullstack_20250825.git/`와 같은 URL이 출력되는데, 이는 **원하는 리포지토리가 아닌 다른 리포지토리**에 푸시를 시도한 것
   * 이 문제는 리모트 URL 설정을 꼼꼼히 확인하지 않았기 때문에 발생함

2. **해결방안**

   * **리모트 URL 확인**: 먼저, 현재 리모트 저장소 URL이 올바른지 확인

     ```bash
     git remote -v
     ```

     * 위 명령어로 출력된 리모트 URL이 **내 리포지토리**로 지정되어 있는지 점검

   * **리모트 URL 수정**: 잘못된 URL이 설정된 경우, 올바른 리모트 URL로 수정

     ```bash
     git remote set-url origin https://github.com/내_사용자명/내_리포지토리.git
     ```

   * **다시 푸시 시도**: 리모트 URL을 수정한 후, 푸시 명령어를 다시 실행

     ```bash
     git push origin dev-gsh
     ```

3. **느낀점**

   * Git을 사용할 때 **리모트 URL** 설정이 얼마나 중요한지 다시 한 번 깨달음. URL 설정이 잘못되면 푸시할 권한이 없는 리포지토리로 데이터를 보내는 상황이 발생할 수 있음
   * **리모트 URL**은 **협업 환경**에서 특히 중요한 요소이므로, 작업을 시작하기 전에 항상 확인하는 습관을 들여야겠다고 생각함
   * 문제를 해결하는 과정에서 **Git의 리모트 설정**을 보다 깊이 이해할 수 있었고, 앞으로는 꼼꼼히 점검할 필요성을 느꼈음


<br/>
<br/>

### ▶트러블 슈팅(6)


```bash
PS D:\HYUNJU\workspace\fullstack_20250825> git push origin dev-tkasid00
remote: Permission to tkasid00/fullstack_20250825.git denied to HSH703.
fatal: unable to access 'https://github.com/tkasid00/fullstack_20250825.git/': The requested URL returned error: 403
```


1. **문제점**

   * 현재 GitHub에 로그인된 계정(HSH703)은 `tkasid00` 저장소에 푸쉬 권한이 없음.
   * 권한 부족으로 인해 푸쉬 작업이 실패.

2. **해결방안**

   * `tkasid00` 계정에서 HSH703 계정에게 **Collaborator** 권한을 부여해야 함.
   * 권한 부여 방법:

     1. GitHub에서 `tkasid00` 계정으로 로그인
     2. 해당 저장소로 이동하여 **Settings** 메뉴 클릭
     3. **Collaborators** 메뉴로 이동
     4. HSH703 계정을 초대하여 권한 부여

3. **느낀점**

   * 협업 시 **권한 관리**의 중요성을 실감함.
   * 푸쉬 권한이 없을 경우 발생하는 **권한 에러**를 해결하는 방법을 배움.
   * GitHub에서의 **접근 권한 설정**은 협업의 기본이고, 이를 제대로 관리하는 것이 매우 중요하다는 점을 깨달음.


<br/>
<br/>

---

## 참고문헌

- [Git 공식 문서](https://git-scm.com/doc)  
- [Markdown 가이드](https://www.markdownguide.org/basic-syntax/)  
- [VS Code 공식 사이트](https://code.visualstudio.com/)  
- [AI 프롬프트 작성 팁](https://learn.microsoft.com/en-us/azure/ai-foundry/openai/concepts/prompt-engineering?tabs=chat)

<br/>
<br/>

---
