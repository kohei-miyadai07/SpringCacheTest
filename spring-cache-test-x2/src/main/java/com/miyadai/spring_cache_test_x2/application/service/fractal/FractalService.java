package com.miyadai.spring_cache_test_x2.application.service.fractal;

import java.awt.image.BufferedImage;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.miyadai.spring_cache_test_x2.domain.model.fractal.Size;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FractalService {

	public BufferedImage noCacheCreateFractal(Size size) {
		GenerateFractal fractal = new GenerateFractal();

		log.info("キャッシュなしのフラクタル画像生成です。size: {}", size.toString());
		return fractal.generateFractal(size);
	}

	@Cacheable(cacheResolver = "fractalCacheResolver" , key = "#size")
	public BufferedImage cacheCreateFractal(Size size) {
		GenerateFractal fractal = new GenerateFractal();

		log.info("キャッシュありのフラクタル画像生成です。size: {}", size.toString());
		return fractal.generateFractal(size);
	}

}