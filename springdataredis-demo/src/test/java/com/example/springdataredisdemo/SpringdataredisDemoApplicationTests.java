package com.example.springdataredisdemo;

import com.example.springdataredisdemo.redis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringdataredisDemoApplicationTests {
    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Test
    void testString() {
        redisTemplate.opsForValue().set("username", "cpy");
        Object username = redisTemplate.opsForValue().get("username");
        System.out.println("username = " + username);
    }

    @Test
    void testsaveuser() {
        redisTemplate.opsForValue().set("user:100", new User("cpy","12345678"));
        User o = (User)redisTemplate.opsForValue().get("user:100");
        System.out.println("o = " + o);
    }

}
