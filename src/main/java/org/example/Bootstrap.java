package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.example.mapper")
public class Bootstrap {
    public static void main(String[] args) {
        // System.setProperty("fetch.type", "DB");
        SpringApplication.run(Bootstrap.class, args);
    }
}
