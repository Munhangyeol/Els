package com.example.els.global.stream;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageServiceByStream {
    private final RedisTemplate<String, String> redisTemplate;
    private static final String STREAM_KEY = "product-update-stream";

    public void publishMessage(Long productId, String action) {
        Map<String, String> message = Map.of(
            "productId", productId.toString(),
            "action", action // "update", "delete" 등
        );

        log.info("Redis Stream Message 발행 "+productId);
        redisTemplate.opsForStream().add(STREAM_KEY, message);
    }
}
