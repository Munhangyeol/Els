package com.example.els.stream;

import com.example.els.global.entity.Product;
import com.example.els.global.entity.ProductDocument;
import com.example.els.global.ProductDto;
import com.example.els.repository.ProductELSRepository;
import com.example.els.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductServiceByStream {
    private final ProductRepository repository;
    private final ProductELSRepository elsRepository;

    private static final String STREAM_KEY = "product-update-stream";

    public Product insert(ProductDto dto) {
        Product product = repository.save(Product.builder().name(dto.getName())
                .category(dto.getCategory()).description(dto.getDescription()).price(dto.getPrice())
                .stock(dto.getStock()).build());

        return product;
    }

    public List<Product> findBykeyword(String keyword) {
        // TODO Auto-generated method stub
        List<ProductDocument> nameContains = elsRepository.findByNameContaining(keyword);
        List<Product> list = nameContains.stream()
                .map(doc -> Product.builder().category(doc.getCategory())
                        .description(doc.getDescription()).name(doc.getName()).price(doc.getPrice())
                        .stock(doc.getStock()).build())
                .toList();
        return list;
    }
}
