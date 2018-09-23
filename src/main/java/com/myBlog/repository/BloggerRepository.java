package com.myBlog.repository;

import java.util.List;

import com.myBlog.domain.Blogger;

import org.springframework.data.repository.CrudRepository;

//BloggerRepo adatbázis blogger tábláját irányítja, a repot pedig a service.
public interface BloggerRepository extends CrudRepository<Blogger, Long> {
    // Iterable-t ad vissza alapbol a findAll() függvény, de így belepumpáljuk egy
    // listába.
    List<Blogger> findAll();
}