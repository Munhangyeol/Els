package com.example.els.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.els.global.ProductDto;
import com.example.els.global.entity.Product;
import com.example.els.pubsub.MessageServiceByPub;
import com.example.els.pubsub.ProductServiceByPub;
import com.example.els.service.ProductService;
import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class Controller {
    private final ProductServiceByPub productService;
    private final MessageServiceByPub messageService;

    @PostMapping("/insert")
    public String insertProduct(@RequestBody ProductDto dto) {
        String keyword = productService.insert(dto).getName();
        messageService.publishMessage(keyword);
        return keyword;

    }

    @GetMapping("/findByKeyword")
    public List<Product> getProductByKeyword(@RequestParam("keyword") String keyword) {
        return productService.findBykeyword(keyword);
    }



}
