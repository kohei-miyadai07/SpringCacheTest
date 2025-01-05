package com.miyadai.spring_cache_test_x5.application.usecase.fractal;

import java.awt.image.BufferedImage;

import org.springframework.stereotype.Service;

import com.miyadai.spring_cache_test_x5.application.service.fractal.CacheFractalService;
import com.miyadai.spring_cache_test_x5.domain.model.fractal.Size;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateFractalUseCase {

	private final CacheFractalService cacheFractalService;

	public BufferedImage execute(int width, int height) {
		Size size = Size.of(width, height);

		return cacheFractalService.updateCacheFractal(size);
	}

}
