package com.thejoa703.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "APPUSER",
    uniqueConstraints = @UniqueConstraint(
        name = "UK_APPUSER_EMAIL_PROVIDER",
        columnNames = {"EMAIL", "PROVIDER"}
    )
)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appuser_seq")
    @SequenceGenerator(name = "appuser_seq", sequenceName = "APPUSER_SEQ", allocationSize = 1)
    @Column(name = "APP_USER_ID")
    private Long id;

    @Column(length = 120, nullable = false)
    private String email;

    @Column(length = 200)
    private String password;

    @Column(length = 50, nullable = false)
    private String nickname;

    @Column(name = "MBTI_TYPE_ID")
    private Integer mbtitype;

    @Column(length = 255)
    private String ufile;

    @Column(length = 30)
    private String mobile;

    @Builder.Default
    @Column(nullable = false, length = 50)
    private String provider = "local";

    @Builder.Default
    @Column(name = "PROVIDER_ID", length = 150)
    private String providerId = "local";

    @Column(nullable = false, name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(nullable = false, name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    @Builder.Default
    @Column
    private boolean deleted = false;

    @Builder.Default
    @Column(nullable = false, length = 50)
    private String role = "ROLE_USER";

    @PrePersist
    void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // ============================================================
    // 1. 기존 SNS 파트 (Post, Comment, Follow 등)
    // ============================================================
    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "follower", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Follow> followings = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "followee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Follow> followers = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Retweet> retweets = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostLike> likes = new ArrayList<>();


    // ============================================================
    // 2. 레시피 파트 (내 파트 관련 핵심 수정본)
    // ============================================================
    
    // 유저가 작성한 레시피 목록
    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recipe4> recipes = new ArrayList<>();

    // 유저가 누른 레시피 좋아요 기록
    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecipeLike4> recipeLikes = new ArrayList<>();

    // 유저의 검색 기록
    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SearchHistory4> searchHistories = new ArrayList<>();

    // 유저의 AI 서비스 이용 기록
    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AiUsageHistory4> aiUsageHistories = new ArrayList<>();



}