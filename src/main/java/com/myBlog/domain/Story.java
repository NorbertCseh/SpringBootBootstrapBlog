package com.myBlog.domain;

import java.util.Date;

public class Story {
    private String title;
    private String content;
    private Date posted;
    private String author;

    public Story() {

    }

    @Override
    public String toString() {
        return "Stroy: {title" + title + "}";
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
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
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