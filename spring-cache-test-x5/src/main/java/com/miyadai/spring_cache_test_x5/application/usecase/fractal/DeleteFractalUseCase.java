package com.miyadai.spring_cache_test_x5.application.usecase.fractal;

import org.springframework.stereotype.Service;

import com.miyadai.spring_cache_test_x5.application.service.fractal.CacheFractalService;
import com.miyadai.spring_cache_test_x5.domain.model.fractal.Size;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteFractalUseCase {

	private final CacheFractalService cacheFractalService;

	public void execute(int width, int height) {
		Size size = Size.of(width, height);

		cacheFractalService.deleteCacheFractal(size);
	}

}
