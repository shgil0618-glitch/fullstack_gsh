package com.thejoa703.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thejoa703.entity.Retweet;
import java.util.List;
import java.util.Optional;


@Repository
public interface RetweetRepository extends JpaRepository<Retweet, Long> {

    // 특정 유저의 특정 게시글 리트윗 조회
    @Query("""
        SELECT r FROM Retweet r
        WHERE r.user.id = :userId
        AND r.originalPost.id = :postId
    """)
    Optional<Retweet> findByUserAndOriginalPost(
        @Param("userId") Long userId,
        @Param("postId") Long postId
    );

    // 중복 리트윗 방지
    @Query("""
        SELECT COUNT(r) FROM Retweet r
        WHERE r.user.id = :userId
        AND r.originalPost.id = :postId
    """)
    long countByUserAndOriginalPost(
        @Param("userId") Long userId,
        @Param("postId") Long postId
    );

    // 특정 게시글의 리트윗 수
    long countByOriginalPostId(Long postId);

    // 특정 유저가 리트윗한 게시글 ID 목록
    @Query("""
        SELECT r.originalPost.id
        FROM Retweet r
        WHERE r.user.id = :userId
    """)
    List<Long> findOriginalPostIdsByUserId(
        @Param("userId") Long userId
    );

    // 리트윗 취소
    @Modifying
    @Transactional
    @Query("""
        DELETE FROM Retweet r
        WHERE r.user.id = :userId
        AND r.originalPost.id = :postId
    """)
    void deleteByUserAndOriginalPost(
        @Param("userId") Long userId,
        @Param("postId") Long postId
    );
}


/*

create : save - insert into appuser (컬럼1,컬럼2,,,) value (?,?,,,)
read : findAll - select * from appuser
        findById
update : save - update appuser set 컬럼1=?, 컬럼2=? where id=?
delete : deleteById - delete from appuser where id=? 
*/