package com.eurekamember.demo.service;

import com.tets.TmallApplicationTests;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
@SpringBootTest
public class RedisServiceTest extends TmallApplicationTests {
    @Resource
    RedisService service;
    @Test
    public void getString1() {
        String x=service.getString1("RedisStr");
        System.out.println(x);
    }
}