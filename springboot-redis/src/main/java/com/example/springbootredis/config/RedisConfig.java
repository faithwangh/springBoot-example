package com.example.springbootredis.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

  /**
   * 定义 StringRedisTemplate ，指定序列化和反序列化的处理类
   *
   * @param factory
   * @return
   */
  @Bean
  public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
    RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
    template.setConnectionFactory(factory);

    Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer =
        new Jackson2JsonRedisSerializer<>(Object.class);

    // ObjectMapper 将Json反序列化成Java对象,当java客户端调用当时候，会在直接转化成对象当java对象，
    // 可以去掉
    ObjectMapper om = new ObjectMapper();
    om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
    jackson2JsonRedisSerializer.setObjectMapper(om);

    // 序列化 值时使用此序列化方法
    template.setKeySerializer(new StringRedisSerializer());
    template.setValueSerializer(jackson2JsonRedisSerializer);
    template.setHashKeySerializer(new StringRedisSerializer());
    template.setHashValueSerializer(jackson2JsonRedisSerializer);
    template.afterPropertiesSet();
    return template;
  }

  //    @Bean
  //    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
  //        RedisTemplate redisTemplate = new RedisTemplate();
  //        redisTemplate.setConnectionFactory(redisConnectionFactory);
  //
  //        GenericFastJsonRedisSerializer fastJsonRedisSerializer = new
  // GenericFastJsonRedisSerializer();
  //
  //        //设置默认的Serialize，包含 keySerializer & valueSerializer
  //        redisTemplate.setDefaultSerializer(fastJsonRedisSerializer);
  //
  //        //redisTemplate.setKeySerializer(fastJsonRedisSerializer);//单独设置keySerializer
  //        //redisTemplate.setValueSerializer(fastJsonRedisSerializer);//单独设置valueSerializer
  //        return redisTemplate;
  //    }

}
