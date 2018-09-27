package com.myBlog.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.myBlog.domain.Blogger;
import com.myBlog.domain.Story;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//Story Repo, ami az adatbázis stories tábláját írányítja, a repot pedig a service
//extends CrudRepository<Story, Long>
@Repository
public class StoryRepository /* extends CrudRepository<Story, Long> */ {
//    // Iterable-t ad vissza alapbol a findAll() függvény, de így belepumpáljuk egy
//    // listába.
//    // SELECT * FROM Story
//    List<Story> findAll();
//    
//
//    // SELECT * FROM Story WHERE posted IN (SELECT max(posted) FROM Story) LIMIT1
//    Story findFirstByOrderByPostedDesc();
//
//    //Saját lekérdezés Objektumot ad vissza,  nativeQuery=true sima sql sorokat ad vissza, ?után hanyadik bejövő adatot töltse be
//    //@Query(value ="SELECT * FROM story WHERE title = ?1 limit 1", nativeQuery=true)
//    //@Query(value ="SELECT * FROM story WHERE title = :title limit 1", nativeQuery=true)
//    @Query(value ="SELECT s FROM Story s WHERE s.title = :title")
//    Story findByTitle(@Param("title") String title);
//    
//    List<Story> findAllByBloggerNameIgnoreCaseOrderByPostedDesc(String name);ű

	// JDBC miatt class kell, nem pedig interface

	private JdbcTemplate jdbc;

	// Konsotruktor alapu Dependenc
	@Autowired
	public StoryRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;

	}

	public List<Story> findAll() {
		String sql = "SELECT * FROM Story ORDER BY posted desc";
		return jdbc.query(sql, (rs, i) -> new Story( // rs=ResultSet i=sorok száma
				rs.getLong("id"), rs.getString("title"), rs.getString("content"), rs.getDate("posted"),
				rs.getLong("blogger_id"))); // Objektumot ad vissza, meg kell adni neki, hogyan állítsa össze az
											// objektumot a vissza érkező értékek alapján

	}

	public Story findByTitle(String title) {
		String sql = "select * from story where title = ? order by posted";
		return jdbc.queryForObject(
				sql,
				new Object[]{title},
				new RowMapper<Story>() {
					public Story mapRow(ResultSet rs, int rowNums) throws SQLException{
						Story story = new Story();
						story.setId(rs.getLong("id"));
						story.setTitle(rs.getString("title"));
						story.setContent(rs.getString("content"));
						story.setPosted(rs.getDate("posted"));
						story.setBlogger(new Blogger(rs.getLong("blogger_id"), "Krisz",25) );
						return story;
					}
				}
				);
	}
}