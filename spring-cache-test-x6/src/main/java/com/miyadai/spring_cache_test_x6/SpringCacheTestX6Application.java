package com.miyadai.spring_cache_test_x6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringCacheTestX6Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCacheTestX6Application.class, args);
	}

}
