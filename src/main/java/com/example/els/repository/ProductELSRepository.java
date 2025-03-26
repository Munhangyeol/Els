package com.example.els.repository;

import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.example.els.global.ProductDocument;

public interface ProductELSRepository extends ElasticsearchRepository<ProductDocument, Long> {
    List<ProductDocument> findByNameContaining(String keyword);
}
