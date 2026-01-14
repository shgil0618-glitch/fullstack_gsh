package com.thejoa703.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.thejoa703.entity.AppUser;
import java.util.Optional;
import java.util.List;



@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {	//Entity, PK
	// email + provider로 사용자 조회
	Optional<AppUser> findByEmailAndProvider(String email, String provider);
	Optional<AppUser> findByEmail(String email);
	
	// 닉네임 중복 체크
	long countByNickname(String nickname);
	default boolean existsByNickname(String nickname) {
		return countByNickname(nickname) >0;
	}
	
	// 이메일 중복 체크
	long countByEmail(String email);
	default boolean existsByEmail(String email) {
		return countByEmail(email) >0;
	}
	
	
}

/*
create : save - insert into appuser (컬럼1,컬럼2,,,) value (?,?,,,)
read : findAll - select * from appuser
        findById
update : save - update appuser set 컬럼1=?, 컬럼2=? where id=?
delete : deleteById - delete from appuser where id=? 

          사용자        관리자
create  회원가입        회원가입
read    로그인, 이메일중복, 닉네임중복
update  닉네임수정, 이미지수정
delete  회원탈퇴

*/