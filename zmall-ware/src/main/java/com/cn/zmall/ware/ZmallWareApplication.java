package com.cn.zmall.ware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan("com.cn.zmall.ware.dao")
@SpringBootApplication
public class ZmallWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZmallWareApplication.class, args);
    }

}
