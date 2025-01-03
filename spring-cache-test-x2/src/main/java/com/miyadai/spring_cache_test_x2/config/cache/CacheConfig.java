package com.miyadai.spring_cache_test_x2.config.cache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.miyadai.spring_cache_test_x2.config.cache.fractal.FractalCacheResolver;

@Configuration
@EnableCaching
public class CacheConfig {

	@Bean
	CacheResolver settingFractalCacheResolver(CacheManager cacheManager) {
		return new FractalCacheResolver(cacheManager);
	}

}
