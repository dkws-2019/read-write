package com.liuchao.readwrite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.liuchao.readwrite.mapper"})
public class ReadWriteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadWriteApplication.class, args);
    }

}
