package com.myBlog.service;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import com.myBlog.domain.Blogger;
import com.myBlog.domain.Story;
import com.myBlog.repository.BloggerRepository;
import com.myBlog.repository.StoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoryService {
    private StoryRepository storyRepo;
    private BloggerRepository bloggerRepo;

    /**
     * @param bloggerRepo the bloggerRepo to set
     */
    @Autowired
    public void setBloggerRepo(BloggerRepository bloggerRepo) {
        this.bloggerRepo = bloggerRepo;
    }

    /**
     * @param storyRepo the storyRepo to set
     */
    @Autowired
    public void setStoryRepo(StoryRepository storyRepo) {
        this.storyRepo = storyRepo;
    }

    public List<Story> getStories() {
        init();
        return storyRepo.findAll();
    }

    @PostConstruct
    public void init() {
        Blogger blogger = new Blogger("Belső Gyula", 25);
        bloggerRepo.save(blogger);

        Story story = new Story("Belső cím", "Belső Tartalom", new Date(), blogger);
        storyRepo.save(story);
    }
}