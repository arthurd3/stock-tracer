package com.arthur.stocktracer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class StockTracerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockTracerApplication.class, args);
    }

}
