package com.thejoa703.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "POST_LIKES",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "UK_POST_LIKE",
            columnNames = {"APP_USER_ID", "POST_ID"}
        )
    }
)
@Getter @Setter
public class PostLike {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_like_seq")
    @SequenceGenerator(name = "post_like_seq", sequenceName = "POST_LIKE_SEQ", allocationSize = 1)
    private Long id;

    @Column(nullable = false, name = "CREATED_AT")
    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
    

    public PostLike(AppUser user, Post post) {
		super();
		this.user = user;
		this.post = post;
	}
	// 좋아요 누른 유저
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APP_USER_ID", nullable = false)
    private AppUser user;

    // 좋아요 대상 게시글
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID", nullable = false)
    private Post post;
}
