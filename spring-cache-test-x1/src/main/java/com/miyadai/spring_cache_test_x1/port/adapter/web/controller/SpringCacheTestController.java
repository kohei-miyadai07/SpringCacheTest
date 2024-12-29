package com.miyadai.spring_cache_test_x1.port.adapter.web.controller;

import java.awt.image.BufferedImage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.miyadai.spring_cache_test_x1.application.usecase.fractal.CreateFractalUseCase;
import com.miyadai.spring_cache_test_x1.util.ImageUtil;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SpringCacheTestController {

	private final CreateFractalUseCase createFractalUseCase;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("message", "Spring Cacheの世界へようこそ!!");

		return "/index";
	}

	@GetMapping("/Fractal/new")
	public String createFractal(Model model) {
		long start = System.currentTimeMillis();
		BufferedImage fractal = createFractalUseCase.executeNoCache(800, 800);
		long end = System.currentTimeMillis();

		String base64Image = "data:image/png;base64," + ImageUtil.encodeToBase64(fractal, "png");
		model.addAttribute("fractalImage", base64Image);

		String time = " [" + (end - start) + "msec]";
		model.addAttribute("time", time);

		return "/Fractal/fractal";
	}

}
