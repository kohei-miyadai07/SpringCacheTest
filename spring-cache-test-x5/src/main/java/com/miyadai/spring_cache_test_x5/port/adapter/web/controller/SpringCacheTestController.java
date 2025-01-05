package com.miyadai.spring_cache_test_x5.port.adapter.web.controller;

import java.awt.image.BufferedImage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.miyadai.spring_cache_test_x5.application.usecase.fractal.CreateFractalUseCase;
import com.miyadai.spring_cache_test_x5.application.usecase.fractal.DeleteFractalUseCase;
import com.miyadai.spring_cache_test_x5.application.usecase.fractal.UpdateFractalUseCase;
import com.miyadai.spring_cache_test_x5.util.ImageUtil;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SpringCacheTestController {

	private final CreateFractalUseCase createFractalUseCase;

	private final UpdateFractalUseCase updateFractalUseCase;

	private final DeleteFractalUseCase deleteFractalUseCase;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("message", "Spring Cacheの世界へようこそ!!");

		return "/index";
	}

	@GetMapping("/Fractal/new")
	public String createFractal(Model model) {
		long noCacheStart = System.currentTimeMillis();
		createFractalUseCase.executeNoCache(800, 800);
		long noCacheEnd = System.currentTimeMillis();

		long cacheStart = System.currentTimeMillis();
		BufferedImage fractal = createFractalUseCase.executeCache(800, 800);
		long cacheEnd = System.currentTimeMillis();

		String base64Image = "data:image/png;base64," + ImageUtil.encodeToBase64(fractal, "png");
		model.addAttribute("fractalImage", base64Image);

		String noCacheTime = "キャッシュなし処理時間: [" + (noCacheEnd - noCacheStart) + "msec]";
		String cacheTime = "キャッシュあり処理時間: [" + (cacheEnd - cacheStart) + "msec]";
		model.addAttribute("noCacheTime", noCacheTime);
		model.addAttribute("cacheTime", cacheTime);

		return "/Fractal/fractal";
	}

	@GetMapping("/Fractal/update")
	public String updateFractal(Model model) {
		long noCacheStart = System.currentTimeMillis();
		createFractalUseCase.executeNoCache(800, 800);
		long noCacheEnd = System.currentTimeMillis();

		updateFractalUseCase.execute(800, 800);

		long cacheStart = System.currentTimeMillis();
		BufferedImage fractal = createFractalUseCase.executeCache(800, 800);
		long cacheEnd = System.currentTimeMillis();

		String base64Image = "data:image/png;base64," + ImageUtil.encodeToBase64(fractal, "png");
		model.addAttribute("fractalImage", base64Image);

		String noCacheTime = "キャッシュなし処理時間: [" + (noCacheEnd - noCacheStart) + "msec]";
		String cacheTime = "キャッシュあり処理時間: [" + (cacheEnd - cacheStart) + "msec]";
		model.addAttribute("noCacheTime", noCacheTime);
		model.addAttribute("cacheTime", cacheTime);

		return "/Fractal/fractal";
	}

	@GetMapping("/Fractal/delete")
	public String deleteFractal(Model model) {
		long noCacheStart = System.currentTimeMillis();
		createFractalUseCase.executeNoCache(800, 800);
		long noCacheEnd = System.currentTimeMillis();

		deleteFractalUseCase.execute(800, 800);

		long cacheStart = System.currentTimeMillis();
		BufferedImage fractal = createFractalUseCase.executeCache(800, 800);
		long cacheEnd = System.currentTimeMillis();

		String base64Image = "data:image/png;base64," + ImageUtil.encodeToBase64(fractal, "png");
		model.addAttribute("fractalImage", base64Image);

		String noCacheTime = "キャッシュなし処理時間: [" + (noCacheEnd - noCacheStart) + "msec]";
		String cacheTime = "キャッシュあり処理時間: [" + (cacheEnd - cacheStart) + "msec]";
		model.addAttribute("noCacheTime", noCacheTime);
		model.addAttribute("cacheTime", cacheTime);

		return "/Fractal/fractal";
	}

}
