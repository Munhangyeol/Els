package com.example.els.controller;

import com.example.els.global.entity.Product;
import com.example.els.global.ProductDto;
import com.example.els.stream.MessageServiceByStream;
import com.example.els.stream.ProductServiceByStream;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/product/stream")
public class StreamController {
    private final ProductServiceByStream productService;
    private final MessageServiceByStream messageService;

    @PostMapping("/insert")
    public String insertProduct(@RequestBody ProductDto dto) {
        Product product = productService.insert(dto);
        messageService.publishMessage(product.getId(), "insert");
        return product.getName();

    }

    @GetMapping("/findByKeyword")
    public List<Product> getProductByKeyword(@RequestParam("keyword") String keyword) {
        return productService.findBykeyword(keyword);
    }



}
