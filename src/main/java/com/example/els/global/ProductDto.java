package com.example.els.global;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;



@Data
@Builder
@AllArgsConstructor
public class ProductDto {

    private String name; // 상품명

    private String description; // 상품 설명
    private int price; // 가격

    private int stock; // 재고 수량

    private String category; // 카테고리명
}
