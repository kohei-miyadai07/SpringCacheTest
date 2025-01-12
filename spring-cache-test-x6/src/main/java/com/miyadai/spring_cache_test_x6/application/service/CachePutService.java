package com.miyadai.spring_cache_test_x6.application.service;

import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CachePutService {

	private final HeavyTaskLogic heavyTaskLogic;

	@CachePut(cacheNames = "cache-controll", key = "#str")
	public String put(String str, String newStr) {
		heavyTaskLogic.heavyTask();

		return "Arg:" + newStr;
	}

}
