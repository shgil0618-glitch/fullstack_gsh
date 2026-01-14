package com.thejoa703.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.Image;
import com.thejoa703.entity.Post;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {	//Entity, PK

	// 게시글에 포함된 이미지 목록 조회
	Optional<Image> findByPost(Post post);
	Optional<Image> findByPostId(Long postId);
	
	// 게시글 이미지 개수 조회
	long countByPost(Post post);
	default boolean existsByPost(Post post) {
		return countByPost(post) > 0;
	}
	
	// 게시글 이미지 전체 삭제
	void deleteByPost(Post post);
}

/*
create : save - insert into images (컬럼1,컬럼2,,,) value (?,?,,,)
read   : findAll - select * from images
         findById
         findByPost
update : save - update images set 컬럼1=?, 컬럼2=? where id=?
delete : deleteById - delete from images where id=?
         deleteByPost - delete from images where post_id=?

           사용자        관리자
create     이미지업로드    이미지업로드
read       게시글조회      게시글조회
update     이미지수정      이미지수정
delete     이미지삭제      이미지삭제
*/
