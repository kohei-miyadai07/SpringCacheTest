package com.miyadai.spring_cache_test_x5.application.service.fractal;

import java.awt.image.BufferedImage;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.miyadai.spring_cache_test_x5.domain.model.fractal.Size;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@CacheConfig(
		cacheNames = "fractal-crate-cahe",
		keyGenerator = "fractalKeyGenerater",
		cacheResolver = "fractalCacheResolver")
public class CacheFractalService {

	@Cacheable(sync = true)
	public BufferedImage cacheCreateFractal(Size size) {
		GenerateFractal fractal = new GenerateFractal();

		log.info("キャッシュありのフラクタル画像生成です。size: {}", size.toString());
		return fractal.generateFractal(size);
	}
}
