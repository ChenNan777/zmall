package com.cn.zmall.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.cn.zmall.member.dao")
@SpringBootApplication
public class ZmallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZmallMemberApplication.class, args);
    }

}
