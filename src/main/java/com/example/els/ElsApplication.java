package com.example.els;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// @EnableAspectJAutoProxy
// @ServletComponentScan
@SpringBootApplication
public class ElsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElsApplication.class, args);
    }



}

