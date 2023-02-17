package com.dilidili.filter.service.entity.cache;

import com.dilidili.cache.RedisUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTemplateTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisTemplate stringRedisTemplate;

    @Autowired
    private RedisUtils redisUtils;

    public RedisTemplateTest() {
    }

    @Test
    public void testString() {
        // 此时redis中存的是world
        stringRedisTemplate.opsForValue().set("hello", "world");
        // get
        String v = (String) stringRedisTemplate.opsForValue().get("hello");
        System.out.println(v);

        // 此时redis中存的是"value"
        redisTemplate.opsForValue().set("test", "value");
    }

    @Test
    public void testList() {
        List<Student> list = new ArrayList<>();
        Student student1 = new Student("小红", 12);
        Student student2 = new Student("小王", 13);
        list.add(student1);
        list.add(student2);

        redisTemplate.opsForValue().set("测试对象列表", list);
    }

    @Test
    public void testExists() {
        boolean exist = redisUtils.exists("xxx");
        Assert.assertSame(false, exist);
        redisUtils.setWithExpire("你好", "java", 1);
    }

    @Test
    public void testHash() {
        Student student1 = new Student("小红", 12);
        Student student2 = new Student("小王", 13);
        redisUtils.hset("Key", "HashKey", student1);
        redisUtils.hset("Key", "HashKey2", student2);

        Map<Object, Object> res = redisUtils.hmget("Key");
        System.out.println(res);
    }

}
