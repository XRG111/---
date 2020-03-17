package com.eurekamember.demo;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
@Component
@ConditionalOnProperty(
        name = {"spring.redis.host"}
)
public class RedisUtils {
    @Autowired
    private RedisTemplate redisTemplate;
    @Resource(
            name = "redisTemplate"
    )
    private ValueOperations<String, String> valueOperations;
    @Resource(
            name = "redisTemplate"
    )
    private HashOperations<String, String, Object> hashOperations;
    @Resource(
            name = "redisTemplate"
    )
    private ListOperations<String, Object> listOperations;
    @Resource(
            name = "redisTemplate"
    )
    private SetOperations<String, Object> setOperations;
    @Resource(
            name = "redisTemplate"
    )
    private ZSetOperations<String, Object> zSetOperations;
    public static final long DEFAULT_EXPIRE = 86400L;
    public static final long NOT_EXPIRE = -1L;

    public RedisUtils() {
    }

    public void set(String key, Object value, long expire) {
        this.valueOperations.set(key, this.toJson(value));
        if (expire != -1L) {
            this.redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }

    }

    public void set(String key, Object value) {
        this.set(key, value, 86400L);
    }

    public <T> T get(String key, Class<T> clazz, long expire) {
        String value = (String)this.valueOperations.get(key);
        if (expire != -1L) {
            this.redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }

        return value == null ? null : this.fromJson(value, clazz);
    }

    public <T> T get(String key, Class<T> clazz) {
        return this.get(key, clazz, -1L);
    }

    public String get(String key, long expire) {
        String value = (String)this.valueOperations.get(key);
        if (expire != -1L) {
            this.redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }

        return value;
    }

    public String get(String key) {
        return this.get(key, -1L);
    }

    public void delete(String key) {
        this.redisTemplate.delete(key);
    }

    private String toJson(Object object) {
        return !(object instanceof Integer) && !(object instanceof Long) && !(object instanceof Float) && !(object instanceof Double) && !(object instanceof Boolean) && !(object instanceof String) ? JSON.toJSONString(object) : String.valueOf(object);
    }

    private <T> T fromJson(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }
}
