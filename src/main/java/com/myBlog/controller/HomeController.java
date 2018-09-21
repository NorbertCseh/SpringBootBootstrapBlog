package com.myBlog.controller;

import java.util.ArrayList;
import java.util.Date;

import com.myBlog.domain.Story;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String blog(Model model) {
		model.addAttribute("pageTitle", "NrbrtCsh's Blog");
		model.addAttribute("paginationTitle", "My blog with Botstrap and Spring Boot");
		model.addAttribute("stories", getStories());
		return "blog";
	}

	private ArrayList<Story> getStories() {
		ArrayList<Story> stories = new ArrayList<>();

		Story story1 = new Story();
		story1.setTitle("Első Story");
		story1.setPosted(new Date());
		story1.setAuthor("Norbi");
		story1.setContent("Első Storym");

		Story story2 = new Story();
		story2.setTitle("Második Story");
		story2.setPosted(new Date());
		story2.setAuthor("Gyula");
		story2.setContent("Második Storym");

		stories.add(story1);
		stories.add(story2);

		return stories;

	}
}
