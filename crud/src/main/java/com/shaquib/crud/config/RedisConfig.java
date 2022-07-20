//package com.shaquib.crud.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
//import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import org.springframework.stereotype.Component;
//
//@Configuration
//@EnableRedisRepositories
//public class RedisConfig {
//
//    /**
//     * Connection factory jedis connection factory.
//     *
//     * @return the jedis connection factory
//     */
//    @Bean
//    public JedisConnectionFactory connectionFactory(){
//        RedisStandaloneConfiguration configuration=new RedisStandaloneConfiguration();
//        configuration.setHostName("172.19.120.9");
//        configuration.setPort(6379);
//        return new JedisConnectionFactory(configuration);
//    }
//
//    @Bean
//    public RedisTemplate<String,Object> redisTemplate(){
//        RedisTemplate<String,Object> redisTemplate=new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(connectionFactory());
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashKeySerializer(new JdkSerializationRedisSerializer());
//        redisTemplate.setKeySerializer(new JdkSerializationRedisSerializer());
//        redisTemplate.setExposeConnection(true);
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }
//}
