package com.cn.zmall.thirdparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ZmallThirdPartyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZmallThirdPartyApplication.class, args);
    }

}
