package com.example.els.service;

import org.springframework.stereotype.Service;
import com.example.els.global.Product;
import com.example.els.global.ProductDto;
import com.example.els.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public Product insert(ProductDto dto) {
        return repository.save(Product.builder().name(dto.getName()).category(dto.getCategory())
                .description(dto.getDescription()).price(dto.getPrice()).build());
    }

    // public Product findBykeyword(String keyword) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method 'findById'");
    // }

}
