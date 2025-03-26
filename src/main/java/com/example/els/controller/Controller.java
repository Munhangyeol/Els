package com.example.els.controller;

import org.springframework.web.bind.annotation.*;
import com.example.els.global.ProductDto;
import com.example.els.service.ProductService;
import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class Controller {
    private final ProductService service;

    @PostMapping("/insert")
    public String requestMethodName(@RequestBody ProductDto dto) {
        return service.insert(dto).getName();
    }

    // @GetMapping("/findById")
    // public Product getProductByKeyword(@RequestParam("keyword") String keyword) {
    // return service.findBykeyword(keyword);
    // }



}
