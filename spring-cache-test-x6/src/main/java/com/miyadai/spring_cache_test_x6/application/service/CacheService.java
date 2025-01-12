package com.miyadai.spring_cache_test_x6.application.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CacheService {

	private final HeavyTaskLogic heavyTaskLogic;

	@Cacheable(cacheNames = "cache-controll", key = "#str")
	public String getStringWithArg(String str) {
		heavyTaskLogic.heavyTask();

		return "Arg:" + str;
	}

}
