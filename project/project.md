[설계]

view
    1. list.jsp
    2. write.jsp
    3. detail.jsp
    4. deit.jsp
    5. delete.jsp

controller
          1. frontcontroller
         1-1. @WebServlet 개발용     *.do   , *.member , *.hj
         1-2. web.xml     배포용
         [com.thejoa703.controller] - MbtiController
         ㄴ index.jsp
            ㄴ [전체글보기] /list.do        ■  MbtiList          /          mbtiBoard/list.jsp
            ㄴ [글쓰기폼  ] /writeView.do   □                    /         mbtiBoard/write.jsp
            ㄴ [글쓰기기능]  /write.do      ■  MbtiInsert        / 알림창 +  list.do
            ㄴ [상세보기 ]   /detail.do     ■  MbtiDetail       /          mbtiBoard/detail.jsp 
            ㄴ [글수정폼  ]  /editView.do   ■  MbtiUpdateView   /          mbtiBoard/edit.jsp  
            ㄴ [글수정기능]   /edit.do        ■  MbtiUpdate      /  알림창 +  mbtiBoard/detail.jsp 
            ㄴ [글삭제폼  ]  /deleteView.do □                    /         mbtiBoard/delete.jsp   
            ㄴ [글삭제기능]   /delete.do      ■  MbtiDelete      /  알림창 +  list.do
      2. service 
         [com.thejoa703.service] 
         MbtiService <<interface>>
            △....  MbtiList         데이터 x / selectAll()
            △....  MbtiInsert       데이터 o / insert( PostDto dto )
            △....  MbtiDetail       데이터 o / select(int id) , update_hit( int id )
            △....  MbtiUpdateView   데이터 o / select(int id)
            △....  MbtiUpdate       데이터 o /  update( PostDto dto )
            △....  MbtiDelete       데이터 o /  update( PostDto dto )
             




-----------------------------------------------------------------
■ 전체컨셉 : MBTI 기반 성향 맞춤 플렛폼
- 단계별 기술 확장

기획의도 
- MBTI Universe는 성향기반으로 컨텐츠를 추천하고, 감정을 제어하며, 커뮤니티와
일정을 연결하는 통합 라이프스타일 플랫폼입니다. 다양한 기술 스택을 활용해 모듈화된 구조로
개발되었으며, 실무에서 요구되는 API 설계, 보안, UX데이터 분석까지 모두 담았습니다. 

2. 연결구조
 ```
 [1. JSP] → [2. SPRING MVC 관리자 시스템]
                ↓ 컨텐츠 등록
 [3. SPRING BOOT + Thymeleaf] ← 사용자테스트 / 추천
 [4. NODE + React] ← 커뮤니티 기능 
 [5. SPRING BOOT + JWT ] ← 중앙서버
            ↑
 [6. Flutter 모바일 앱] ← 모바일앱
 ```

※주제 : MBTI 테스트 + 결과보기
 1. jsp + oracle
 > 기초 CRUD 
 - ※기능 : MBTI 질문 / 보기등록

아이디어 
- MBTI 질문/보기 등록 (성향파악)
- 컨텐츠 미리보기 (ENTP는 뭐시기)
- 유형별 컨텐츠 통계 (음악, 책 , ...)
- 유형별 컨텐츠 통계 (간단한 그래프)
- 사용자 응답저장.

※주제 : 추천컨텐츠 등록 및 관리 담당
 2. SPRING MVC + ★Mybatis + JSTL
 > 관리자용 Spring Mvc 확장 되기전에 초기 관리자 시스템 역활 (나중에 전자정부 + 프로젝트)
 - 컨텐츠 담당
 - 질문보기 담당
 - 일정 알람 예약 담당
 - ,,,,,,,

※주제 : MBTI 성향 기반 컨텐츠 추천 웹앱 
 3. SPRING BOOT + JPA + Thymeleaf (Spring)
 - 유형별 인기컨텐츠 랭킹
 - 동적 필터링 / 검색기능 담당
 - CSV 업로드 질문 일괄등록


※주제 : MBTI 커뮤니티 + 취향 공유 플랫폼
 4. Node + React
> sns형

------------------------------------------------------
※주제 : MBTI 기반 라이프스타일 통합 앱
 5. SPRING BOOT + JPA + Jwp + Redis + React
 - 


※주제 : 모바일 UX
 6. Flutter
 > 모바일용



