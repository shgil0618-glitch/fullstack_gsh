package com.thejoa703.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.Follow;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {

    // -------------------------------------------------
    // 팔로우 관계 단건 조회
    // test: findByFollower_IdAndFollowee_Id
    // -------------------------------------------------
    @Query("""
        SELECT f
        FROM Follow f
        WHERE f.followerId.id = :followerId
          AND f.followeeId.id = :followeeId
    """)
    Optional<Follow> findByFollower_IdAndFollowee_Id(
            @Param("followerId") Long followerId,
            @Param("followeeId") Long followeeId
    );

    // -------------------------------------------------
    // 팔로잉 목록 조회 (EntityGraph로 followee 조인)
    // test: findByFollower_Id
    // -------------------------------------------------
    @EntityGraph(attributePaths = "followeeId")
    @Query("""
        SELECT f
        FROM Follow f
        WHERE f.followerId.id = :followerId
    """)
    List<Follow> findByFollower_Id(@Param("followerId") Long followerId);

    // -------------------------------------------------
    // 팔로워 목록 조회 (EntityGraph로 follower 조인)
    // test: findByFollowee_Id
    // -------------------------------------------------
    @EntityGraph(attributePaths = "followerId")
    @Query("""
        SELECT f
        FROM Follow f
        WHERE f.followeeId.id = :followeeId
    """)
    List<Follow> findByFollowee_Id(@Param("followeeId") Long followeeId);

    // -------------------------------------------------
    // 팔로잉 수 집계
    // test: countByFollower_Id
    // -------------------------------------------------
    @Query("""
        SELECT COUNT(f)
        FROM Follow f
        WHERE f.followerId.id = :followerId
    """)
    long countByFollower_Id(@Param("followerId") Long followerId);

    // -------------------------------------------------
    // 팔로워 수 집계
    // test: countByFollowee_Id
    // -------------------------------------------------
    @Query("""
        SELECT COUNT(f)
        FROM Follow f
        WHERE f.followeeId.id = :followeeId
    """)
    long countByFollowee_Id(@Param("followeeId") Long followeeId);
}
