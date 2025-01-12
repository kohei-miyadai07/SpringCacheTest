package com.miyadai.spring_cache_test_x6.application.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.miyadai.spring_cache_test_x6.util.TimeMeasure;

@SpringBootTest
class CacheEvictServiceTest {

	@Autowired
	private CacheService cacheService;

	@Autowired
	private CacheEvictService cacheEvictService;

	@Test
	void test() throws Exception {
		TimeMeasure.time(() -> cacheService.getStringWithArg("aaa"));
		TimeMeasure.time(() -> cacheService.getStringWithArg("bbb"));
		Thread.sleep(3000L);

		cacheEvictService.evict("aaa");
		Thread.sleep(3000L);

		TimeMeasure.time(() -> cacheService.getStringWithArg("aaa"));
		TimeMeasure.time(() -> cacheService.getStringWithArg("bbb"));
	}

}
