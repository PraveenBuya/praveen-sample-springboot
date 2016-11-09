package com.infy.avon.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

///connection factory and a RedisTemplate bean for Spring to communicate with  Redis database
@Configuration
public class RedisConfiguration extends CachingConfigurerSupport {

	// To connect to Redis using Jedis, you need to create an instance of
	// org.springframework.data.redis.connection.jedis.JedisConnectionFactory.
	/* Jedis ConnectionFactory */
	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		jedisConnectionFactory.setHostName("localhost");
		jedisConnectionFactory.setPort(6379);
		return jedisConnectionFactory;
	}

	/* redis template definition */
	@Bean
	public RedisTemplate<Object, Object> redisTemplate() {
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<Object, Object>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		redisTemplate.setExposeConnection(true);
		/*
		 * redisTemplate.setKeySerializer( new StringRedisSerializer() );
		 * redisTemplate.setHashValueSerializer( new GenericToStringSerializer<
		 * Book >( Book.class ) ); redisTemplate.setValueSerializer( new
		 * GenericToStringSerializer< Book >( Book.class ) );
		 */
		return redisTemplate;
	}

	/* declare Redis Cache Manager */
	@Bean
	public RedisCacheManager cacheManager() {
		RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate());
		redisCacheManager.setTransactionAware(true);
		redisCacheManager.setLoadRemoteCachesOnStartup(true);
		// redisCacheManager.setDefaultExpiration(10); /*Enabled for Testing
		// Purposes*/
		redisCacheManager.setUsePrefix(true);
		return redisCacheManager;
	}

}
