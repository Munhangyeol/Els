package com.example.els.stream;

import com.example.els.global.Product;
import com.example.els.global.ProductDto;
import com.example.els.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductServiceByStream {
    private final ProductRepository repository;
    private final RedisTemplate redisTemplate;

    private static final String STREAM_KEY = "product-update-stream";

    public Product insert(ProductDto dto) {
        Product product = repository.save(Product.builder()
                .name(dto.getName())
                .category(dto.getCategory())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .build());

        return product;
    }
}
