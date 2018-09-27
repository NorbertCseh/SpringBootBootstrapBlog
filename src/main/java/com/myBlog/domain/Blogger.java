package com.myBlog.domain;

import java.util.List;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

//Entity -> egy tábla az adatbázisban, Azért kell, hogy a spring felismerje
//@Entity
public class Blogger {
    // Automatikusan generált érték az adatbázisban
    // Meg kell adni azt is hogy ID
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
    private long id;
    private String name;
    private int age;
    // Egy a sokhoz kapcsolat, egy bejegyzésnek csak egy szerzője lehet, de egy
    // bloggernek több posztja is lehet
   @JsonBackReference
//    @OneToMany(mappedBy = "blogger")
    private List<Story> stories;

    private Blogger() {
    }

    public Blogger(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Blogger(Long id,String name, int age) {
    	this.id =id;
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