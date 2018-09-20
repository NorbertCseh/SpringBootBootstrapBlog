package com.myBlog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String blog(Model model) {
		model.addAttribute("pageTitle", "NrbrtCsh's Blog");
		model.addAttribute("paginationTitle", "My blog with Botstrap and Spring Boot");
		return "blog";
	}
}
