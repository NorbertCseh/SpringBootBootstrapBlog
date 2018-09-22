package com.myBlog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.myBlog.domain.Story;
import com.myBlog.repository.StoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@Autowired
	StoryRepository storyRepo;

	@RequestMapping("/")
	public String blog(Model model) {
		model.addAttribute("pageTitle", "NrbrtCsh's Blog");
		model.addAttribute("paginationTitle", "My blog with Botstrap and Spring Boot");
		model.addAttribute("stories", getStories());
		return "blog";
	}

	@RequestMapping("/user/{id}")
	public String searchForUser(@PathVariable(value = "id") String id) throws Exception {
		if (id == null) {
			throw new Exception("Nincs ilyen felhasználó!");
		}
		return "user";
	}

	@ExceptionHandler(Exception.class)
	public String exceptionHandler(HttpServletRequest rA, Exception ex, Model model) {
		return "exceptionHandler";
	}

	private List<Story> getStories() {
		List<Story> stories = storyRepo.findAll();
		/*
		 * Story story1 = new Story(); story1.setTitle("Első Story");
		 * story1.setPosted(new Date()); story1.setBlogger("Norbi");
		 * story1.setContent("Első Storym");
		 * 
		 * Story story2 = new Story(); story2.setTitle("Második Story");
		 * story2.setPosted(new Date()); story2.setBlogger("Gyula");
		 * story2.setContent("Második Storym");
		 * 
		 * stories.add(story1); stories.add(story2);
		 */
		return stories;

	}

}
