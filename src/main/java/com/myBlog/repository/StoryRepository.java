package com.myBlog.repository;

import java.util.List;

import com.myBlog.domain.Story;

import org.springframework.data.repository.CrudRepository;

public interface StoryRepository extends CrudRepository<Story, Long> {
    List<Story> findAll();
}