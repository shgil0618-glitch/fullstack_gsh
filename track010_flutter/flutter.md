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