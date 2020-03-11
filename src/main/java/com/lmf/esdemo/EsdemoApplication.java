package com.lmf.esdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.lmf.esdemo.mapper")
public class EsdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsdemoApplication.class, args);
    }

}
