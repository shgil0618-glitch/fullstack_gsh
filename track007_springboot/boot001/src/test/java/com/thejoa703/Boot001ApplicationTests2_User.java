package com.thejoa703;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.thejoa703.dao.AppUserDao;
import com.thejoa703.dto.AppUserAuthDto;
import com.thejoa703.dto.AppUserDto;
import com.thejoa703.dto.AuthDto;


@SpringBootTest
@Transactional	//테스트 실행중 발생 db변경 자동 롤백!
class Boot001ApplicationTests2_User { 
	
	@Autowired AppUserDao dao;
	
	@Test
	public void testCrudAppUserAuth() {
		//1. 회원가입 - 사용자 입력
		AppUserDto user = new AppUserDto();
		user.setEmail("qw@qw");
		user.setPassword("1");
		user.setMbtiTypeId(1);
		user.setUfile("1.png");
		user.setMobile("01012345678");
		user.setNickname("한승현");
		user.setProvider("local");
		user.setProviderId("local_001");
		int result = dao.insertAppUser(user);
		System.out.println(".........1. " + result );
		
		//2. 		- 권한 입력
		AuthDto auth = new AuthDto();
		auth.setAppUserId(1);
		auth.setEmail("qw@qw");
		auth.setAuth("ROLE_USER");
		int result_auth = dao.insertAuth(auth);
		System.out.println("..........2. " + result_auth);		
		
		//3. 로그인
		AppUserDto login = new AppUserDto();
		login.setEmail("qw@qw");
		login.setProvider("local");
		System.out.println("..........3. " + dao.readAuthByEmail(login));
		
		//4. 아이디 중복
		AppUserDto iddouble = new AppUserDto();
		iddouble.setEmail("qw@qw");
		iddouble.setProvider("local");
		System.out.println("..........4. " + dao.iddoubleByEmail(iddouble));
		
		//5. 마이페이지
		AppUserDto mypage = new AppUserDto();
		mypage.setEmail("qw@qw");
		mypage.setProvider("local");
		AppUserDto findUser = dao.findByEmail(mypage);
		int id = findUser.getAppUserId();
		System.out.println("..........5. " + findUser);
		
		//6. 수정
		AppUserDto update = new AppUserDto();
		update.setMbtiTypeId(3);
		update.setEmail("qwqw@qwqw");
		update.setAppUserId(1);
		System.out.println("..........6. " + dao.updateAppUser(update));
		
		//7. 사용자 삭제
		
		AppUserDto delete = new AppUserDto();
		delete.setAppUserId(84);
		System.out.println("..........7. " + dao.deleteAppUser(delete));
		
		
		//8. 권한 삭제
		AuthDto dauth = new AuthDto();
		dauth.setEmail("qw@qw");
		System.out.println("..........8. " + dao.deleteAuth(dauth));
		
		
	}
 
	
}

