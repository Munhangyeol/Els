package com.example.els.global;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
<<<<<<< HEAD:src/main/java/com/example/els/Product.java
import lombok.NoArgsConstructor;
=======
import lombok.Data;
>>>>>>> 8d13d31235d0c7dc9bf164833102aaa0a5465fd0:src/main/java/com/example/els/global/Product.java


@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
