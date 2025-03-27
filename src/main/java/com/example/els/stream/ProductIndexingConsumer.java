package com.example.els.stream;

import com.example.els.global.entity.ProductDocument;
import com.example.els.global.ProductDto;
import com.example.els.repository.ProductELSRepository;
import com.example.els.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.stream.*;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductIndexingConsumer {

    private final RedisTemplate redisTemplate;
    private final ProductRepository productRepository;
    private final ElsService elsService;


    private static final String STREAM_KEY = "product-update-stream";
    private static final String GROUP = "product-group";
    private static final String CONSUMER = "consumer-1";

    @PostConstruct
    public void init() {
        try {
            redisTemplate.opsForStream().createGroup(STREAM_KEY, GROUP);
        } catch (Exception ignored) {
        }

        new Thread(this::consume).start();
    }

    public void consume() {
        while (true) {
            List<MapRecord<String, Object, Object>> records = serializeByStream();

            for (MapRecord<String, Object, Object> record : records) {
                Map<Object, Object> data = record.getValue();
                String productIdStr = data.get("productId").toString();
                log.info("Redis Stream 수신: " + productIdStr);

                String action = data.get("action").toString();
                Long productId = Long.valueOf(productIdStr);

                // 메시지에 따라 ELS 처리
                updateELS(action, productId);

                // ack
                redisTemplate.opsForStream().acknowledge(STREAM_KEY, GROUP, record.getId());
            }
        }
    }





    //util로 빼도 됨.
    private List<MapRecord<String, Object, Object>> serializeByStream() {
        List<MapRecord<String, Object, Object>> records =
                redisTemplate.opsForStream().read(Consumer.from(GROUP, CONSUMER),
                        StreamReadOptions.empty().block(Duration.ofSeconds(2)),
                        StreamOffset.create(STREAM_KEY, ReadOffset.lastConsumed()));
        return records;
    }

    private void updateELS(String action, Long productId) {
        switch (action) {
            case "insert":
            case "update":
                productRepository.findById(productId).ifPresent(product -> {
                  elsService.saveByProduct(product);
                });
                break;
            case "delete":

                break;
        }
    }
}
