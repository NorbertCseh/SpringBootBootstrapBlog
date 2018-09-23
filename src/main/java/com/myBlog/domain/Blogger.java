package com.myBlog.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Blogger {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String name;
    private int age;
    @OneToMany(mappedBy = "blogger")
    private List<Story> stories;

    private Blogger() {
    }

    public Blogger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the stories
     */
    public List<Story> getStories() {
        return stories;
    }

    /**
     * @param stories the stories to set
     */
    public void setStories(List<Story> stories) {
        this.stories = stories;
    }
}