package com.thejoa703.security;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

 
// 보안 냉장고
@Component
@RequiredArgsConstructor
public class TokenStore {

    private final RedisTemplate<String, String> redisTemplate;

 
    public void saveRefreshToken(String userId, String token, long ttlSeconds) {
        String key = buildKey(userId);
        redisTemplate.opsForValue().set(key, token, ttlSeconds, TimeUnit.SECONDS);
    }

 
    public String getRefreshToken(String userId) {
        String key = buildKey(userId);
        return redisTemplate.opsForValue().get(key);
    }

 
    public void deleteRefreshToken(String userId) {
        String key = buildKey(userId);
        redisTemplate.delete(key);
    }

 
    private String buildKey(String userId) {
        return "refresh:" + userId;
    }
}
