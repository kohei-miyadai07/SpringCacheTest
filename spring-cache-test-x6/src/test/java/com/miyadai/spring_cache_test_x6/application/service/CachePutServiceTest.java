package com.miyadai.spring_cache_test_x6.application.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.miyadai.spring_cache_test_x6.util.TimeMeasure;

@SpringBootTest
class CachePutServiceTest {

	@Autowired
	private CacheService cacheService;

	@Autowired
	private CachePutService cachePutService;

	@Test
	void test() throws Exception {
		TimeMeasure.time(() -> cacheService.getStringWithArg("aaa"));

		TimeMeasure.time(() -> cachePutService.put("aaa", "newVal"));
		Thread.sleep(3000L);

		TimeMeasure.time(() -> cacheService.getStringWithArg("aaa"));
	}

}
