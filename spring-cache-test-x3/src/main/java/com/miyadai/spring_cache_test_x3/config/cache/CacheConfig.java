package com.miyadai.spring_cache_test_x3.config.cache;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

@Configuration
@EnableCaching
public class CacheConfig {

	@Bean
	CacheManager caffeineCacheManager() {
		CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
		caffeineCacheManager.setCaffeine(Caffeine.newBuilder()
				.maximumSize(500L)
				.expireAfterAccess(3, TimeUnit.MINUTES));

		return caffeineCacheManager;
	}

}
