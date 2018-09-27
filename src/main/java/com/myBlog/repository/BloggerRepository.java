package com.myBlog.repository;

import java.util.List;

import com.myBlog.domain.Blogger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//BloggerRepo adatbázis blogger tábláját irányítja, a repot pedig a service.
@Repository
public class BloggerRepository /* extends CrudRepository<Blogger, Long>*/ {
    // Iterable-t ad vissza alapbol a findAll() függvény, de így belepumpáljuk egy
    // listába.
//    List<Blogger> findAll();
	
	
	//JDBC miatt class kell, nem pedig interface
	
	private JdbcTemplate jdbc;
	
	//Konsotruktor alapu Dependenc
	@Autowired
	public BloggerRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
		
	}
	
	
	
}