package com.miyadai.spring_cache_test_x3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringCacheTestX3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCacheTestX3Application.class, args);
	}

}
