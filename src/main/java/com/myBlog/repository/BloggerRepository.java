package com.myBlog.repository;

import java.util.List;

import com.myBlog.domain.Blogger;

import org.springframework.data.repository.CrudRepository;

public interface BloggerRepository extends CrudRepository<Blogger, Long> {
    List<Blogger> findAll();
}