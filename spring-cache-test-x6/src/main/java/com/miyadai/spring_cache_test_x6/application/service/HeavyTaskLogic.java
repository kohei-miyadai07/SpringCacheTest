package com.miyadai.spring_cache_test_x6.application.service;

import org.springframework.stereotype.Component;

@Component
public class HeavyTaskLogic {

	public void heavyTask() {
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
