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

//Service-ünk, ami íránytja a repokat, ezt pedig a controllerek,
//a getStories() függvényt ott hívjuk meg pl.
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

    // Kiszedi az összes Story-t az adatbázisból.
    public List<Story> getStories() {
        return storyRepo.findAll();
    }

    // Uj post létrehozásához ezt kell modosítani majd
    // Ez az annotáció egyszer lefut amikor elindul az alkalmazás Singleton Scope
    // Feltölti egy teszt bejegyzéssel az adatbázisunkat
    // Létrehoz egy Bloggert és egy story-t, Storyban meghívja a létrejött
    // bloggerünket.
    // .save();-el mentheted el az adatbázisban
    @PostConstruct
    public void init() {
        Blogger blogger = new Blogger("Belső Gyula", 25);
        bloggerRepo.save(blogger);

        Story story = new Story("Belső cím", "Belső Tartalom", new Date(), blogger);
        storyRepo.save(story);
    }
}