## Ubuntu 24.04 컨테이너 실행 방법
1. **이미지 다운로드**
   ```bash
   docker pull ubuntu:24.04
   ```

2. **컨테이너 실행**
   ```bash 
   docker run -it --name myubuntu ubuntu:24.04 bash
   ```
   → 실행하면 컨테이너 내부의 쉘(`bash`) 
   - -it : i(표준입력), t(터미널)
   - --name mybuntu 컨테이너 이름
   - ubuntu:24.04 버전
   - bash 

3. **컨테이너 내부에서 패키지 업데이트**
   ```bash
   apt update && apt upgrade -y
   ```

4. **컨테이너 종료 후 다시 실행하기**
   - 실행 중인 컨테이너 확인:
     ```bash
     docker ps -a
     ```
   - 컨테이너 재실행:
     ```bash
     docker start -al <컨테이너_ID>
     docker start -al myubuntu 
     ```
    - 실행 중인 컨테이너에 접속:
     ```bash
    docker exec -it myubuntu bash
    ```


## 2. linux 사용자
1. # root 사용자
2. $ 일반사용자

## 3. 기본명령어
```bash
# 날짜
date
# 출력
echo hello
# 명령어 위치 확인
which date
# 명령어 설명서
man date
```

```bash
apt update
apt install man-db
unminimize
```
빠져나오기 q
```bash
help echo -> 쉘 내장명령어
man date -> 실행파일
type echo 
type date
```

Q1. HI 출력
Q2. DATE 사용방법 확인


### 파일 및 디렉토리 생성
- touch 파일명 : 빈 파일 생성
- mkdir 디렉토리명 : 새 디렉토리 생성
- mkdir -p 경로/하위디렉토리 : 중첩 디렉토리 생성

### 파일 확인 및 경로 이동
- ls : 현재 디렉토리 목록 보기
- ls -l : 상세 정보 포함 목록
- pwd : 현재 경로 출력
- cd 디렉토리명 : 디렉토리 이동
- cd .. : 상위 디렉토리로 이동

### 삭제 및 복사
- rm 파일명 : 파일 삭제
- rm -r 디렉토리명 : 디렉토리 삭제
- cp 원본 대상 : 파일 복사
- mv 원본 대상 : 파일 이동 또는 이름 변경

Q1. testdir 폴더 만들기
Q2. 폴더안에 FILE1.TXT파일 만들기
```bash
root@6f83a55d1d94:/home/ubuntu# mkdir testdir
root@6f83a55d1d94:/home/ubuntu# cd testdir
root@6f83a55d1d94:/home/ubuntu/testdir# touch file1.txt
```
Q3. 디렉토리인지, 폴더인지까지 구분
d붙었으면 폴더/ 없으면 그냥 파일
```bash
root@6f83a55d1d94:/home/ubuntu# ls -al
total 32
drwxr-x--- 1 ubuntu ubuntu 4096 Feb  3 02:02 .
drwxr-xr-x 1 root   root   4096 Jan 13 02:11 ..
-rw-r--r-- 1 ubuntu ubuntu  220 Mar 31  2024 .bash_logout
-rw-r--r-- 1 ubuntu ubuntu 3771 Mar 31  2024 .bashrc
-rw-r--r-- 1 ubuntu ubuntu  807 Mar 31  2024 .profile
drwxr-xr-x 2 root   root   4096 Feb  3 01:54 myfolder
drwxr-xr-x 2 root   root   4096 Feb  3 02:02 testdir
```
### 파일에 적기
- echo "하고싶은 말" > file1.txt // file1.txt안에 글쓰기 (기존꺼 지우고 쓰기)
- echo "하고싶은 말" >> file1.txt // file1.txt안에 글쓰기 (이어쓰기)
- cat file1.txt // 안에 파일 확인 

### 파일에 적기(2) 여러줄쓰기, 파일편집
### 여러줄
cat > file2.txt 
첫 번째 줄 
두 번째 줄 
Ctrl+D # 입력 종료

### vi 에디터
1. sudo vi file1.txt (파일명) 실행  
2. vi 안에서 Esc 눌러 명령 모드로 전환   
3. i 눌러 입력 모드로 전환 → 새 설정 붙여넣기  
4. Esc → :wq → 저장 후 종료   
```
apt update
apt install vim
y
5
68
```

Q1. 파일만들기   mylinux.txt
Q2. 파일안에 답채우기
-    출력
-    사용서
-    파일생성
-    디렉토리만들기
-    목록보기
-    상위이동
-    파일,폴더삭제
-    file1.txt 을 back.txt으로 파일복사
-    back.txt를 test.txt로 이름변경
Q3. vi이용해서 맨위에 작성자본인이름 추가
Q5. mylinux.txt 백업해서 ubuntu에 backup.txt로 
Q6. 상위로 이동 testdir 삭제

```
apt update
apt install locales
locale-gen ko_KR.UTF-8
update-locale LANG=ko_KR.UTF-8
```

# 사용자 정보 확인
whoami
id
who
users
groups

# 사용자 추가 및 삭제
sudo adduser sally
sudo passwd sally
sudo deluser sally

# 권한 구조 및 변경
ls -l
sudo chown sally:sally hello.txt
chmod 755 hello.txt
umask


Q1. 
Q2. alpha로 로그인 / alpha home 디렉토리 찾아가기
Q3. alpha로 접속해서 /home/gsh 접속 가능한지 > 못함
```
chmod 755 /home/gsh
```

Q4. 
Q5. /home/gsh 다른사람 권한주기

## 6. 쉘스크립트
1. 프로세스 상태 확인
```
ps -ef
```
-e : 모든 프로세스
-f : 출력정보 자세히

2. 실시간 모니터링
```
top
```

3. ip주소 확인
```
ifconfig
```
```
apt update
apt install net-tools
```
# : root
$ : 개인

4. hello world 쉘스크립트 작성
```
vi hello.sh

#!/bin/bash
echo "hello world"
```
```
ls -al
chmod +x hello.sh
```

5. 쉘스크립트 실행
```
./hello.sh 
```

## part002. aws
> aws 회원가입


## part003. ci/cd