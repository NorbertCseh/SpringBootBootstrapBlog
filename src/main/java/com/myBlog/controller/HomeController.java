package com.myBlog.controller;

import javax.servlet.http.HttpServletRequest;

import com.myBlog.service.StoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//Annotáció ami egy template-et ad vissza a templates mappábol
//RestController lehetne helyette, de az a return értékét adja vissza
@Controller
public class HomeController {

	// Service ami a kommunikál a StoryRepository-val és a BloggerRepository-val
	private StoryService storyService;

	/**
	 * @param storyService the storyService to set
	 */

	// Dependency Injecton miatt kell a setterbe tenni, mehetne a konstruktorba is,
	// de itt egyszerübb tesztelni
	@Autowired
	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
	}

	// Ha a "/" oldalt tölti be valaki, akkor melyik templatet adja vissza
	// Model segítségével adatokat pumpálhatunk a template-ünkbe,
	@RequestMapping("/")
	public String blog(Model model) {
		model.addAttribute("pageTitle", "NrbrtCsh's Blog");
		model.addAttribute("stories", storyService.getStories());
		return "blog";
	}

	// User keresése, de még nincs egy se, viszon cuki cicás képet ad vissza
	// PathVariable böngésző sávból huzhatunk be adatokat, hozzá is kell rendelni
	// egy változohoz egyből.
	@RequestMapping("/user/{id}")
	public String searchForUser(@PathVariable(value = "id") String id) throws Exception {
		if (id == null) {
			// ha nincs ilyen nevű felhasználó, kivételt dob, jelenleg még user.html
			// template sincs kész
			// ezért template error-t dob
			throw new Exception("Nincs ilyen felhasználó!");
		}
		return "user";
	}

	// Kivételek kezelése, lementjük egy, najó, ezt még át kell nézni.
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(HttpServletRequest rA, Exception ex, Model model) {
		return "exceptionHandler";
	}

	// StoryService-ben létrehoztuk ugyan ezt, a storyRepoval, ami kibővíti a crud
	// repot.
	/*
	 * private List<Story> getStories() { List<Story> stories = storyRepo.findAll();
	 * 
	 * Story story1 = new Story(); story1.setTitle("Első Story");
	 * story1.setPosted(new Date()); story1.setBlogger("Norbi");
	 * story1.setContent("Első Storym");
	 * 
	 * Story story2 = new Story(); story2.setTitle("Második Story");
	 * story2.setPosted(new Date()); story2.setBlogger("Gyula");
	 * story2.setContent("Második Storym");
	 * 
	 * stories.add(story1); stories.add(story2);
	 * 
	 * return stories;
	 * 
	 * }
	 */
}
