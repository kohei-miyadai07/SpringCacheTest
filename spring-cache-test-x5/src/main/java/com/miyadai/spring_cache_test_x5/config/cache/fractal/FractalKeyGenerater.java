package com.miyadai.spring_cache_test_x5.config.cache.fractal;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

@Component
public class FractalKeyGenerater implements KeyGenerator {

	@Override
	public Object generate(Object target, Method method, Object... params) {
		String key = method.getName() + "_" + Arrays.toString(params);

		return key;
	}

}
