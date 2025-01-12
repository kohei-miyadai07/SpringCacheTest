package com.miyadai.spring_cache_test_x6.application.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
public class CacheEvictService {

	@CacheEvict(cacheNames = "cache-controll", key = "#str")
	public void evict(String str) {
	}

}
