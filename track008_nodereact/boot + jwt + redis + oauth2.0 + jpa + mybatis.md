##  PROJECT
[project]
    ㄴback  : boot+jwt+redis+oauth2.0+jpa+mybatis
    ㄴfront : react+next+antd

    
###1. [BACK] boot+security+jwt+redis+oauth2.0+jpa+mybatis

1. JAVA 17
2. SPRING BOOT (gradle)
3. boot+security+jwt+redis+oauth2.0+jpa+mybatis 

- SPRING boot (애플리케이션 기반의 프레임워크/ 내장 tomcat / 자동설정 )
- SPRING security (인증,인가/필터체인의 요청보호/oauth2.0 같은 인증방식으로 쉽게 연동)
- jwt( json web token : 토큰기반의 인증방식 / 토큰안에 사용자 정보와 권한을 담아 전달 ,
       서버가 세션을 직접 관리하지 않고, 클라이언트가 토큰을 보관)
- redis( 캐시/세션을 관리 , refresh token을 저장, 캐싱처리에 활용, 분산환경에서 세션공유 가능 )
- oauth2.0 (외부인증 연동, 구글, 네이버, 카카오로그인)
- jpa(  orm기반의 데이터베이스 접근 , 엔티티클리스와 db테이블 매핑, sql작성없이 객체중심의 데이터 처리)
- mybatis ( 복잡한 쿼리 작성 )

1.  SPRING boot  → 애플리케이션 실행기반
2.  SPRING security + jwt/oauth2.0   → 인증/인가 처리
3.  redis   →  토큰/세션/캐시관리
4.  jpa + mybatis  → 데이터베이스 접근 (orm + sql mapper 병행)

<br/>

##### [실습]  1. 스프링부트 프로젝트 
- [x] 1. 개발개요안내
- [x] 2. java.sun.com - JAVA 17 다운로드 - 설치
- [x] 3. SPRING BOOT   - https://spring.io/ - 다운로드 - 설치
  > 이전버젼
  https://github.com/spring-projects/spring-tools/wiki/Previous-Versions
- [x] 4. SPRING BOOT 프로젝트 만들기
- [x] 5. lombok


<br/>

##### [실습] 2. model  (엔티티 → 레파지토리 → 서비스)
1. 엔티티 관계도
2. 엔티티 작성

사람( AppUser ) → 글(Post) → 댓글(Comment)
사람( AppUser ) → 글(Post) → 좋아요(PostLike)
사람( AppUser ) → 글(Post) → 리트위(Retweet)
사람( AppUser ) → 다람 사람( AppUser ) → 팔로우 (Follow)
글(Post) → 해시태그(Hashtag)
글(Post) → 사진(Image)

```
👤 User(AppUser)
   ├── 📝 Post(글)
   │     ├── 💬 Comment(댓글)
   │     ├── ❤️ PostLike(좋아요)
   │     ├── 🏷️ Hashtag(해시태그)
   │     ├── 🖼️ Image(사진)
   │     └── 🔄 Retweet(리트윗)
   │
   ├── 👣 Follow(팔로우) → 다른 User
   └── 🚫 Block(차단) → 다른 User
```

1. AppUser
2. Post
3. Image
4. Hashtag
5. Comment
6. Follow
7. Retweet
8. PostLike


AppUser 관계매핑
###1. 사람 → 글
- 내가 쓴 게시글
- 한 사람이 여러글을 쓸수 있다. (OneToMany)
- 글(Post) 쪽에서는 누가썼는지 기억 (ManyToOne)


Post 관계매핑
###1. 글(Post.java : 테이블명 Posts) → 이미지(Image.java : 테이블명 Images)
- 글은 많은 이미지를 갖는다.   (OneToMany)
- 이미지는 글 하나에만 속한다.   (ManyToOne)
```
Long id, String content,  AppUser user;  boolean deleted = false;
LocalDateTime createdAt;  LocalDateTime updatedAt;
```

Image
```
Long id, String src, Post post;
```


@Repository
public interface AppUserReopository extends JpaRepository<AppUser,Long>{

}

create : save - insert into appuser (컬럼1,컬럼2,,,) value (?,?,,,)
read : findAll - select * from appuser
        findById
update : save - update appuser set 컬럼1=?, 컬럼2=? where id=?
delete : deleteById - delete from appuser where id=? 

- [x] 1. AppUserRepositoy
- [ ] 2. PostRepositoy
- [ ] 3. ImageRepositoy
- [ ] 4. HashtagRepositoy
- [ ] 5. CommentRepositoy
- [ ] 6. FollowRepositoy
- [ ] 7. RetweetRepositoy
- [ ] 8. PostLikeRepositoy


          사용자        관리자
create  회원가입        회원가입
read    로그인, 이메일중복, 닉네임중복
update  닉네임수정, 이미지수정
delete  회원탈퇴





