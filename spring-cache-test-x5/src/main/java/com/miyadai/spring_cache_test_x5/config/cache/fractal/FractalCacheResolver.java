package com.miyadai.spring_cache_test_x5.config.cache.fractal;

import java.util.Collection;
import java.util.Collections;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FractalCacheResolver implements CacheResolver {

	private final CacheManager cacheManager;

	@Override
	public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> context) {
		return Collections.singleton(cacheManager.getCache("fractal-crate-cache"));
	}

}
