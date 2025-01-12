package com.miyadai.spring_cache_test_x5.application.service.fractal;

import java.awt.image.BufferedImage;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.miyadai.spring_cache_test_x5.domain.model.fractal.Size;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@CacheConfig(
		cacheNames = "fractal-cahe",
		keyGenerator = "fractalKeyGenerater",
		cacheResolver = "fractalCacheResolver")
public class CacheFractalService {

	@Cacheable(sync = true)
	public BufferedImage cacheCreateFractal(Size size) {
		GenerateFractal fractal = new GenerateFractal();

		log.info("キャッシュありのフラクタル画像生成です。size: {}", size.toString());
		return fractal.generateFractal(size);
	}

	@CachePut
	public BufferedImage updateCacheFractal(Size size) {
		Size updateSize = Size.of(size.getWidth()-200, size.getHeight()-200);
		GenerateFractal fractal = new GenerateFractal();

		log.info("フラクタル画像を更新しました。size: {}", size.toString());
		return fractal.generateFractal(updateSize);
	}

	@CacheEvict
	public void deleteCacheFractal(Size size) {
		log.info("フラクタル画像を削除しました。size: {}", size.toString());
	}

}
