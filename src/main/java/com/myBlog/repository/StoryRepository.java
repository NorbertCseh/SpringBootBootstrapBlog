package com.myBlog.repository;

import java.util.List;

import com.myBlog.domain.Story;

import org.springframework.data.repository.CrudRepository;

//Story Repo, ami az adatbázis stories tábláját írányítja, a repot pedig a service
//extends CrudRepository<Story, Long>
public interface StoryRepository extends CrudRepository<Story, Long> {
    // Iterable-t ad vissza alapbol a findAll() függvény, de így belepumpáljuk egy
    // listába.
    List<Story> findAll();
}