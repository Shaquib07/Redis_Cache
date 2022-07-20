package com.shaquib.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;

/**
 * @SpringBootApplication same as @Configuration @EnableAutoConfiguration @ComponentScan
 * @EnableAutoConfiguration: enable Spring Boot’s auto-configuration mechanism
 * @ComponentScan: enable @Component scan on the package where the application is located (see the best practices)
 * @Configuration: allow to register extra beans in the context or import additional configuration classes
 * enable the caching feature simply by adding the @EnableCaching annotation.
 */
@SpringBootApplication
@EnableCaching
public class CrudApplication {

	public static void main(String[] args) {
		/*
		You need to run Application.run() because this method starts whole Spring Framework.
		 */
		SpringApplication.run(CrudApplication.class, args);
	}
}
