package com.tienda.categoria_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.tienda.categoria_service")
public class CategoriaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CategoriaServiceApplication.class, args);
    }
}
