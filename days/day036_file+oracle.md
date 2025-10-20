## Track001 -  github
 
# ■ 자바
# ■ 깃허브(협업)
# ■ oracle
# ■ 네트워크관리사 - 이론(2) / 실기
 
1. --------------- 
# ■ 자바
# ■ file
# ■ network

2. ---------------
# ■  Github - revert / reset
1. revert - 안전한 취소      - 깃허브 [공용] 
2. reset  - 아예 지워버리기   - [혼자] 브랜치에서

실습(1) revert
1.  본인  브랜치에서 파일작성 - test브랜치에서 새작업하고 원격저장소에 푸쉬
```bash
git branch
git checkout -b test(테스트브랜치명)
파일작성   revert.md
git  add .
git commit -m "revert"
git push origin  test(테스트브랜치명)
```
2.  main 브랜치에서 병합 - test브랜치작업을 main 병합하고 푸시
```bash
git checkout master
git pull origin master
git merge   테스트브랜치명
git push  origin master
```
3.  main 브랜치에서 되돌리기
```bash
git checkout master
git log
git revert -m 1 <commit_hash>
git push origin master
```

Q1.  팀장- test3.md   revert vs reset
     main - commit1 - merge
     main - commit2 - merge
     main - commit3 - merge     -merge 3번

     
Q2.  팀원 -  예)  idol.md  본인소개 / commit  /  main에서 merge  -  revert 해서 본인이 남긴지 지우기






3. ---------------
# ■ oracle - select
# ■ group



4. ---------------
-- 자격증 및 정리







 