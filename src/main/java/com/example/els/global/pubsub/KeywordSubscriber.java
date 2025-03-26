package com.example.els.global.pubsub;

import java.nio.charset.StandardCharsets;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KeywordSubscriber implements MessageListener {

    /**
     * @param message
     * @param pattern
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        String keyword = new String(message.getBody(), StandardCharsets.UTF_8);

        log.info("Redis 메시지 수신: " + keyword);
        // 이곳에서 Elasticsearch 검색 등 원하는 작업 수행
    }



}
