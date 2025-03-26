package com.example.els;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class Controller {
    private final ProductService service;

    @PostMapping("/insert")
    public String requestMethodName(@RequestBody ProductDto dto) {
        return service.insert(dto).toString();
    }

    @GetMapping("/findById")
    public Product getProductByKeyword(@RequestParam("keyword") String keyword) {
        return service.findBykeyword(keyword);
    }



}
