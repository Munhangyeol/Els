package com.example.els.service;

import java.nio.charset.StandardCharsets;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessageService {

    private final RedisTemplate template;


    public void publishMessage(String keyword) {
        template.convertAndSend("keyword-update", keyword);
        log.info("Redis 메시지 발신: " + keyword);

    }


}
