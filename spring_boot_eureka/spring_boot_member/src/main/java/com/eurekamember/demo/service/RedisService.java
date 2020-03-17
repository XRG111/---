package com.eurekamember.demo.service;

import com.eurekamember.demo.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
public class RedisService {
    @Resource
    RedisUtils redisUtils;

    public String getString1(String key){

            String token = "YS2324GH136SAG7874238EGDSIS.3248YDHSUDH74839WUDDFHS2442433432.523525223211122144";
            log.info("mysql中的数据："+token);
            //redisTemplate.opsForValue().set(key,val);
        long userTokenExpire = 36L;
        redisUtils.set(key,token,userTokenExpire);
            redisUtils.set(key+11,token,userTokenExpire);
            log.info("把查询出的数据存到Redis中++++++++++++++++++++++++++++++++++++++++++=");
            return token;
    }

}
