package com.myBlog.domain;

import java.lang.reflect.Constructor;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Story {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String title;
    private String content;
    private Date posted;
    @ManyToOne
    private Blogger blogger;

    private Story() {

    }

    public Story(String title, String content, Date posted, Blogger blogger) {
        this.title = title;
        this.content = content;
        this.posted = posted;
        this.blogger = blogger;
    }

    @Override
    public String toString() {
        return "Stroy: {title" + title + "}";
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the author
     */
    public Blogger getBlogger() {
        return blogger;
    }

    /**
     * @param author the author to set
     */
    public void setBlogger(Blogger blogger) {
        this.blogger = blogger;
    }

    /**
     * @return the posted
     */
    public Date getPosted() {
        return posted;
    }

    /**
     * @param posted the posted to set
     */
    public void setPosted(Date posted) {
        this.posted = posted;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
}