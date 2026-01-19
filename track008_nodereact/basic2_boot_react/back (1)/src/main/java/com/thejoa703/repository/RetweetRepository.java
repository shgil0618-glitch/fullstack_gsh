package com.thejoa703.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thejoa703.entity.Retweet;

@Repository  //★
public interface RetweetRepository extends JpaRepository<Retweet, Long> {
	//	특정 유저의 특정 게시글 리트윗 조회
    @Query("SELECT r FROM Retweet r WHERE r.user.id = :userId AND r.originalPost.id = :postId")
    Optional<Retweet>  findByUserAndOriginalPost(@Param("userId") Long userId, @Param("postId") Long postId );
 
    //	중복 리트윗 방지
    @Query("SELECT COUNT(r) FROM Retweet r WHERE r.user.id = :userId AND r.originalPost.id = :postId") 
    long countByUserAndOriginalPost( @Param("userId") Long userId, @Param("postId") Long postId ); 
    
	//	특정 게시글의 리트윗 수 집계
    long countByOriginalPostId( Long postId );
     
    //	특정 유저가 리트윗한 글 목록 조회
    @Query("SELECT r.originalPost.id FROM Retweet r WHERE r.user.id = :userId") 
    List<Long>  findOriginalPostPostIdAndUserId( @Param("userId") Long userId );
     
	//	리트윗 취소
    @Modifying
    @Transactional
    @Query("DELETE FROM Retweet r WHERE r.user.id = :userId AND r.originalPost.id = :postId") 
    void  deleteByUserAndOriginalPost( @Param("userId") Long userId, @Param("postId") Long postId );
    
}

/*
CREATE : save     -   INSERT INTO  테이블명 (컬럼1,컬럼2,,) values (?,?,,)
READ   : findAll  -   SELECT  * from 테이블명  
         findById -   SELECT  * from 테이블명   where id=? 
UPDATE : save     -   update  테이블명   set 컬럼1=? ,컬럼2=?  where   id=? 
DELETE : deleteById - delete from 테이블명   where id=?
*/	
	

	
