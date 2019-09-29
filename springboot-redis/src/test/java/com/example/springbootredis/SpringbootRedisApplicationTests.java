package com.example.springbootredis;

import com.example.springbootredis.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void contextLoads() {

        ValueOperations<String,Object> ops = redisTemplate.opsForValue();
        ops.set("k1", "v1");
        System.out.println(ops.get("k1"));

        User user = new User();
        user.setId(1L);
        user.setName("aaa");
        user.setAge(10);
        ops.set("k2",user);
        System.out.println(ops.get("k2"));

        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        ops.set("k3",l);
        System.out.println(ops.get("k3"));


    }

    @Test
    public void testRedis(){

        ValueOperations<String,Object> ops = redisTemplate.opsForValue();

        System.out.println(ops.get("saas_auth_session:LpRtS6oMwLsXFkczHKK2wAuYReJgxwFvIOuR9DDP"));
    }



}
