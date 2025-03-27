package com.example.els.global.entity;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDocument {

    @Id
    private String id;

    @Field(type = FieldType.Text) // 분석기 적용: matchQuery, like 검색 가능
    private String name;

    @Field(type = FieldType.Text)
    private String description;

    @Field(type = FieldType.Integer)
    private int price;

    @Field(type = FieldType.Integer)
    private int stock;

    @Field(type = FieldType.Keyword)
    private String category;
}
