[실습]

 Git으로 설치:
git clone https://github.com/flutter/flutter.git -b stable C:\flutter
 환경 변수 설정:
시스템 환경 변수 편집 → Path → C:\flutter\bin 추가
 실행 테스트:
flutter doctor


**[실습]**
- [x] VS Code 설치 ([공식 사이트](https://code.visualstudio.com/))  
- [x] 확장 프로그램 설치 (Ctrl+Shift+X):
  - Flutter  
  - Dart  



#### (A) Android Studio + 에뮬레이터
**[실습]**
- [x] Android Studio 설치 ([공식 사이트](https://developer.android.com/studio))  
- [x] SDK Manager 설정  
  - SDK Platforms → 최신 API 레벨 설치 (예: **Android 14**)  
  - SDK Tools → Command-line Tools, Emulator, Platform-Tools, Build-Tools 체크  
- [x] New Project  → hello1 (java)  
- [x] AVD Manager → **Pixel 6** 가상 디바이스 생성  
- [x] 디바이스 실행 - 무겁다....
- [x] 설치완료확인:  


**[실습]** 
- [x] 실행:
  ```bash
  flutter create hello2
  cd hello2
  ```
  ```bash
  flutter devices
  flutter run -d emulator-5554
  flutter run -d chrome
  ```



  **[실습]**
- [x] `pubspec.yaml` 수정:
  ```yaml
  dependencies:
    flutter:
      sdk: flutter
    http: ^1.1.0
    provider: ^6.1.1
    shared_preferences: ^2.2.2
    go_router: ^12.1.3
  ```
- [x] 패키지 설치:
  ```bash
  flutter pub get
  flutter pub add http
  flutter pub add provider
  ```


  # ■ FLUTTER

## 1단계 : 프로젝트 생성
  ```bash
  flutter create mobile
  cd mobile
  flutter run
  ```

## 2단계 : 프로젝트 구성

- back :  spring boot + security + jwt + redis
- front(1) - homepage :  node + react + next 
- front(2) - mobile   :  flutter

```
mobile/                # 프로젝트 루트
    lib/
    ├── core/                  # 앱 전역에서 공통으로 쓰이는 부분   ("공용상자")
    │    ├── constants/        # 상수 정의 (API URL, 키 값, 색상 등 : 주소)
    │    ├── error/            # 에러 핸들링, 예외 클래스 정의 (잘못됐을때 "경고표시")
    │    ├── network/          # 인터넷연결("전화선")
    │    └── utils/            # 유틸 함수 모음 (날짜 포맷, 토큰 관리 등  "도구상자")
    │
    ├── features/              # 기능 단위로 모듈화 (DDD + Clean Architecture )
    │    ├── user/             # 사용자 인증/관리 관련 기능
    │    │    ├── data/        
    │    │    │    ├── models/         # DTO, API 응답/요청 모델
    │    │    │    ├── repositories/   # Repository 구현체 (API 호출, DB 접근)
    │    │    │    └── sources/        # 데이터 소스 (Remote API, Local DB)
    │    │    ├── domain/      
    │    │    │    ├── entities/       # 핵심 엔티티 (User, Token 등)
    │    │    │    ├── repositories/   # Repository 인터페이스 (추상화)
    │    │    │    └── usecases/       # 유스케이스 (Login, Logout, RefreshToken)
    │    │    └── presentation/  
    │    │         ├── pages/          # 화면 단위 (LoginPage, HomePage)
    │    │         ├── widgets/        # UI 컴포넌트 (LoginForm, UserCard)
    │    │         └── state/          # 상태 관리 (Provider, Bloc, Riverpod 등)
    │    │
    │    └── post/              # 게시글 관련 기능
    │         ├── data/         
    │         │    ├── models/           # DTO, API 응답/요청 모델
    │         │    │    └── post_model.dart
    │         │    ├── sources/          # 데이터 소스 (Remote API, Local DB)
    │         │    │    └── post_remote_source.dart
    │         │    └── repositories/     # Repository 구현체
    │         │         └── post_repository_impl.dart
    │         │
    │         ├── domain/                
    │         │    ├── entities/         # 핵심 엔티티 (Post 등)
    │         │    │    └── post.dart
    │         │    ├── repositories/     # Repository 인터페이스 (추상화)
    │         │    │    └── post_repository.dart
    │         │    └── usecases/         # 유스케이스 (비즈니스 규칙)
    │         │         ├── get_posts_usecase.dart
    │         │         └── like_post_usecase.dart
    │         │
    │         └── presentation/          
    │              ├── pages/            # 화면 단위
    │              │    └── liked_post_grid_page.dart
    │              ├── widgets/          # UI 컴포넌트
    │              │    └── post_card.dart
    │              └── state/            # 상태 관리 (Provider, Bloc, Riverpod 등)
    │                   └── liked_post_provider.dart
    │
    ├── app.dart               # 앱 진입점, MaterialApp, 라우팅, 테마 정의 
    └── main.dart              # 실행 entrypoint, runApp(App())

    test/                      # 테스트 코드 디렉토리
    └── token_manager_test.dart

    
```



## 3단계 : 필요한 패키지 설정
  ```bash
  flutter pub add http
  flutter pub add flutter_secure_storage
  flutter pub add flutter_riverpod 
  ```

   - `http`  또는  `dio`       → rest api 호출
   - `flutter_secure_storage` → jwt 토큰 안전저장
   - `flutter_riverpod`       → 상태관리 (타입안정성 및 유지보수성)
    `provider`(가장많이 쓰임, 입문자/중소규모) / `riverpod`(■provider보다 더 많이 선택됨) / `bloc`(대규모 서비스)

## 4단계
1. 각영역 설명
```
    ├── core/                  # 앱 전역에서 공통으로 쓰이는 부분   ("공용상자")
    │    ├── constants/        # 상수 정의 (API URL, 키 값, 색상 등 : 주소)
    │    ├── error/            # 에러 핸들링, 예외 클래스 정의 (잘못됐을때 "경고표시")
    │    ├── network/          # 인터넷연결("전화선")
    │    └── utils/            # 유틸 함수 모음 (날짜 포맷, 토큰 관리 등  "도구상자")
```
- core/constants/api.dart  → `BASE_URL`  정의 (`http://localhost:8080/api`) 
                              서버엔드포인트(`/auth` , `/api/posts`)
- core/utils/token_manager.dart   → JWT ACCESS/REFRESH TOKEN 저장/읽기/삭제
- core/error/app_exception.dart   → 공통에러처리 (401:로그인안했어, 403:권한없어 , 400:입력틀렸어)
- core/network/dio_client.dart   → 인터넷연결 
              (DioClient -ACCESS token 자동으로 붙여서 인증된사람, 열쇠가 낡았으면 refresh token으로 새열쇠받기)


2. 계층 동작 순서
1) 주소록 `api.dart` 서버주소찾기
2) 열쇠상자 `token_manager.dart` 토큰꺼냄
3) 전화기 `dio_client.dart` 로 서버요청
4) 문제 생기면  `app_exception.dart` 알려줌
5) 토큰이 낡으면 새토큰 받아서 다시 시도

```
[사용자 요청]
      │
      ▼
[api.dart: 주소록 확인]   
  서버에 전화하려면 "주소"가 필요해요.
  - 로그인? → login 주소
  - 게시글? → posts 주소
      │
      ▼
[token_manager.dart: 열쇠 상자]  
  - Access Token 꺼내기     → 잠깐 쓰는 열쇠
  - Refresh Token 준비하기  → 새 열쇠를 받을 수 있는 비밀 열쇠
      │
      ▼
[dio_client.dart: 전화기]
  - 서버에 전화 걸기 
  - 헤더에 "Bearer <Access Token>" 붙이기 
      │
      ├── 성공 → 서버 응답 받아서 화면에 보여줌
      │
      └── 실패 (401 Unauthorized)
            │
            ▼
     [token_manager: 새 열쇠 꺼내기]  
       - Refresh Token으로 새 Access Token 요청   
       - 새 토큰 저장
            │
            ▼
     [dio_client: 다시 전화 걸기]
            │
            ├── 성공 → 응답 받아서 화면에 보여줌
            └── 실패 → clearTokens()  
      
      │
      ▼
[app_exception.dart: 신호등 켜기]  
  - 401 → "로그인 안 했어!"
  - 403 → "권한 없어!"
  - 400 → "입력 틀렸어!"   
```             

## 5단계  테스트
```dart
// test/test_manager_test.dart

import 'package:flutter_test/flutter_test.dart';
import 'package:mocktail/mocktail.dart';
import 'package:flutter_secure_storage/flutter_secure_storage.dart';
import 'package:mobile/core/utils/token_manager.dart';

class MockSecureStorage extends Mock implements FlutterSecureStorage {}

void main() {
  late MockSecureStorage mockStorage;
  late TokenManager manager;

  setUp(() {
    mockStorage = MockSecureStorage();
    manager = TokenManager(storage: mockStorage);
  });

  test('TokenManager saves tokens correctly', () async {
    when(() => mockStorage.write(
      key: any(named: "key"),
      value: any(named: "value"),
    )).thenAnswer((_) async => null);

    await manager.saveTokens("access123", "refresh456");

    verify(() => mockStorage.write(key: "accessToken", value: "access123")).called(1);
    verify(() => mockStorage.write(key: "refreshToken", value: "refresh456")).called(1);
  });

  test('TokenManager retrieves tokens correctly', () async {
    when(() => mockStorage.read(key: "accessToken")).thenAnswer((_) async => "access123");
    when(() => mockStorage.read(key: "refreshToken")).thenAnswer((_) async => "refresh456");

    final access = await manager.getAccessToken();
    final refresh = await manager.getRefreshToken();

    expect(access, "access123");
    expect(refresh, "refresh456");
  });

  test('TokenManager clears tokens correctly', () async {
    when(() => mockStorage.delete(key: any(named: "key"))).thenAnswer((_) async => null);

    await manager.clearTokens();

    verify(() => mockStorage.delete(key: "accessToken")).called(1);
    verify(() => mockStorage.delete(key: "refreshToken")).called(1);
  });
}

```

2. 실행방법
mobile/ 루트디렉토리에서 실행
```
flutter test
```
```
flutter test  test/test_manager_test.dart
```

Q1. TEST1 : AWS에서 혹은 도메인이 바뀌었다면,,,,  `api.dart` 
Q2. TEST1 : FLUTTER에서 CORE 계층동작순서 
    주소록 - 서버주소찾기 (`api.dart`)  
      →  열쇠상자 - JWT(`token_manager.dart`) 
          → 전화기 - 서버요청(`dio_client.dart`) ■