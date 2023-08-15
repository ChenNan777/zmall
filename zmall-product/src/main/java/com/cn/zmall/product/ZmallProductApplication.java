package com.cn.zmall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.cn.zmall.product.dao")
@SpringBootApplication
public class ZmallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZmallProductApplication.class, args);
    }

}
