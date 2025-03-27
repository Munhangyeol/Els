package com.example.els.stream;

import com.example.els.global.entity.Product;
import com.example.els.global.entity.ProductDocument;
import com.example.els.repository.ProductELSRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class ElsService {
      private final ProductELSRepository elsRepository;

      public void saveByProduct(Product product){
        elsRepository.save(ProductDocument.builder().name(product.getName())
                            .category(product.getCategory())
                            .description(product.getDescription()).price(product.getPrice())
                            .stock(product.getStock()).build());
      }

}
