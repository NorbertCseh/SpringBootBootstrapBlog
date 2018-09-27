package com.myBlog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myBlog.domain.Story;
import com.myBlog.service.StoryService;

@RestController
public class ApiController {
	
	private StoryService storyService;

	/**
	 * @param storyService the storyService to set
	 */

	// Dependency Injecton, setterbe jobb tenni, mehetne a konstruktorba is,
	// de itt egyszerübb tesztelni
	@Autowired
	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
	}


//	@RequestMapping("/story")
//	public Story story() {
//		return storyService.getStory();
//	}
//	@RequestMapping("/title/{title}")
//	public Story searchForUser(@PathVariable(value = "title") String title) throws Exception {
//		return storyService.getSpecificStory(title);
//	}
//	
//	@RequestMapping("/stories/{name}")
//	public List<Story> searchForStoriesByBloggerName(@PathVariable(value = "name") String name) throws Exception {
//		return storyService.getStoriesByBloggerName(name);
//	}
}
