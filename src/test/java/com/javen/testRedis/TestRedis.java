package com.javen.testRedis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 杜云章
 * @description:
 * @Date: 2019-06-11 9:30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestRedis {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void redisTemplateTest(){
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("123", "hello");
        properties.put("abc", 456);

        redisTemplate.opsForHash().putAll("hash", properties);

        Map<Object, Object> ans = redisTemplate.opsForHash().entries("hash");
        System.out.println("ans: " + ans);

    }
}
