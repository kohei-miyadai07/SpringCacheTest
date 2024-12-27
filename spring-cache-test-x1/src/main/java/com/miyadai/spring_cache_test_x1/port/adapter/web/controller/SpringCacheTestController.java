package com.miyadai.spring_cache_test_x1.port.adapter.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringCacheTestController {

	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("message", "Spring Cacheの世界へようこそ!!");

		return "/index";
	}

}
