package com.myBlog.domain;

import java.util.Date;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;

////Adatbázisban ezt a táblát stories néven fogja hívni, amire átírod                 Annotáciok a JPA-hoz kellettek
////Entity egy tábla az adatbázisban
//@Entity // (name = "stories")
public class Story {

    private static final String lenght = null;
    // Automatikusan generált érték legyen a value
    // Meg kell adni hogy ID is
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
    private long id;
//    @Column // (name = "cim")
    private String title;
    // @Column(length = 1000) 1000 karakter lehet beleirni az alap 255 helyett,
    // ha nem állitod át, levágja a végét
//    @Column(columnDefinition = "TEXT") // varchar helyett textfield lesz az adatbázisban
    private String content;
    private Date posted;
    // Sok az egyhez kapcsolat, mert egy bloggernek több posztja is lehet
//    @ManyToOne
    private Blogger blogger;

    public Story() {

    }

    public Story(String title, String content, Date posted, Blogger blogger ) {
        this.title = title;
        this.content = content;
        this.posted = posted;
        
        this.blogger = blogger;
    }
    public Story(Long id, String title, String content, Date posted,Long bloggerId) {
    	this.id = id;
        this.title = title;
        this.content = content;
        this.posted = posted;
        this.blogger = new Blogger(bloggerId, "Krisz",21);
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