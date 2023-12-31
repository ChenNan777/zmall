package com.cn.zmall.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan("com.cn.zmall.coupon.dao")
@SpringBootApplication
public class ZmallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZmallCouponApplication.class, args);
    }

}
