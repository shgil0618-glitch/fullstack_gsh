package com.thejoa703;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional   // 테스트 실행 중 DB 변경 자동 롤백
class RecipesServiceTests {

}
