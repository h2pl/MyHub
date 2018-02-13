package com.cat.util;

/**
 * Created by 周杰伦 on 2018/2/13.
 */
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by tl on 17/2/16.
 */
@Component("redisTemplateUtil")
public class RedisTemplateUtil {

    @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;

    public RedisTemplateUtil(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    public void set(String key, Object value) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value);

        //BoundValueOperations的理解对保存的值做一些细微的操作
//        BoundValueOperations boundValueOperations = redisTemplate.boundValueOps(key);
    }

    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void setList(String key, List<?> value) {
        ListOperations listOperations = redisTemplate.opsForList();
        listOperations.leftPush(key, value);
    }

    public Object getList(String key) {
        return redisTemplate.opsForList().leftPop(key);
    }

    public void setSet(String key, Set<?> value) {
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add(key, value);
    }

    public Object getSet(String key) {
        return redisTemplate.opsForSet().members(key);
    }


    public void setHash(String key, Map<String, ?> value) {
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.putAll(key, value);
    }

    public Object getHash(String key) {
        return redisTemplate.opsForHash().entries(key);
    }


    public void delete(String key) {
        redisTemplate.delete(key);
    }
}

//    public void clearAll(){
//        redisTemplate.multi();
//    }
