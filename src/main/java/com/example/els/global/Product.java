package com.example.els.global;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Entity
@Builder
@AllArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // 상품명

    private String description; // 상품 설명


    @Column(nullable = false)
    private int price; // 가격

    private int stock; // 재고 수량

    private String category; // 카테고리명



}
