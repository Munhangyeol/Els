package com.example.els.pubsub;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.els.global.Product;
import com.example.els.global.ProductDocument;
import com.example.els.global.ProductDto;
import com.example.els.repository.ProductELSRepository;
import com.example.els.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceByPub {
    private final ProductRepository repository;
    private final ProductELSRepository elsRepository;

    public Product insert(ProductDto dto) {
        Product product =
                repository.save(Product.builder().name(dto.getName()).category(dto.getCategory())
                        .description(dto.getDescription()).price(dto.getPrice()).build());
        syncAll(dto);
        return product;
    }

    public void syncAll(ProductDto dto) {
        elsRepository.save(ProductDocument.builder().category(dto.getCategory())
                .description(dto.getDescription()).name(dto.getName()).price(dto.getPrice())
                .build());
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
