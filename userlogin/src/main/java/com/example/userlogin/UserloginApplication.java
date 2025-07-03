package com.example.userlogin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.userlogin.dao")
public class UserloginApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserloginApplication.class, args);
    }

}
