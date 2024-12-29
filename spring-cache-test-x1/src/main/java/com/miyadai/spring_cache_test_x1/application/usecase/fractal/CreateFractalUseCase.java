package com.miyadai.spring_cache_test_x1.application.usecase.fractal;

import java.awt.image.BufferedImage;

import org.springframework.stereotype.Service;

import com.miyadai.spring_cache_test_x1.application.service.fractal.FractalService;
import com.miyadai.spring_cache_test_x1.domain.model.fractal.Size;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateFractalUseCase {

	private final FractalService fractalService;

	public BufferedImage executeNoCache(int width, int height) {
		Size size = Size.of(width, height);

		return fractalService.noCacheCreateFractal(size);
	}

}
