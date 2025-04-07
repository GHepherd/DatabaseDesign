package com.scau;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.scau.mapper")
public class DatabaseDesignApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseDesignApplication.class, args);
    }


}
