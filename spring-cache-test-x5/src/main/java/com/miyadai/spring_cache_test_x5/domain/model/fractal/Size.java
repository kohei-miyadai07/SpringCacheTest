package com.miyadai.spring_cache_test_x5.domain.model.fractal;

import lombok.Value;

@Value(staticConstructor = "of")
public class Size {
	int width;
	int height;

}
