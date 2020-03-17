package com.eurekamember.demo.controller;

import com.eurekamember.demo.service.RedisService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: xurongguang
 * @Date: 2019/12/24 0024
 */
@RestController
public class TestDemo {
    @Resource
    RedisService service;
    @RequestMapping("/test")
    public String xxxx(String key){
        return service.getString1(key);
    }


}