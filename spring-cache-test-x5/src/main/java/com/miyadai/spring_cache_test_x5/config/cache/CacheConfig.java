package com.miyadai.spring_cache_test_x5.config.cache;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.miyadai.spring_cache_test_x5.config.cache.fractal.FractalCacheResolver;
import com.miyadai.spring_cache_test_x5.config.cache.fractal.FractalKeyGenerater;

@Configuration
public class CacheConfig {

	@Bean
	KeyGenerator settingFractalKeyGenerater() {
		return new FractalKeyGenerater();
	}

	@Bean
	CacheManager caffeineCacheManager() {
		CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
		caffeineCacheManager.setCaffeine(
				Caffeine.newBuilder()
				.maximumSize(500L)
				.expireAfterAccess(3, TimeUnit.MINUTES));
		
		return caffeineCacheManager;
	}

	@Bean
	CacheResolver settingFractalCacheResolver(CacheManager cacheManager) {
		return new FractalCacheResolver(cacheManager);
	}

}
