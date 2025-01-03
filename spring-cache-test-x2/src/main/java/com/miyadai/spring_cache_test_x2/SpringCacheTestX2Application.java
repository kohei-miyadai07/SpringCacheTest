package com.miyadai.spring_cache_test_x2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringCacheTestX2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCacheTestX2Application.class, args);
	}

}
