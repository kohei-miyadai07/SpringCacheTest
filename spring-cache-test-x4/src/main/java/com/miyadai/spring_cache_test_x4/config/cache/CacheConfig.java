package com.miyadai.spring_cache_test_x4.config.cache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.miyadai.spring_cache_test_x4.config.cache.fractal.FractalKeyGenerater;

@Configuration
@EnableCaching
public class CacheConfig {

	@Bean
	KeyGenerator settingFractalKeyGenerater() {
		return new FractalKeyGenerater();
	}

}
