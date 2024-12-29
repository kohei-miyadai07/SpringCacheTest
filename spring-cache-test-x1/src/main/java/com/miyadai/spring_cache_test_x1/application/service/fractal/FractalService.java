package com.miyadai.spring_cache_test_x1.application.service.fractal;

import java.awt.image.BufferedImage;

import org.springframework.stereotype.Component;

import com.miyadai.spring_cache_test_x1.domain.model.fractal.Size;

@Component
public class FractalService {

	public BufferedImage noCacheCreateFractal(Size size) {
		GenerateFractal fractal = new GenerateFractal();

		return fractal.generateFractal(size);
	}

}
