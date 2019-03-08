package com.wcciproject.masteryblog.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wcciproject.masteryblog.models.Post;

public interface PostRepository extends CrudRepository <Post, Long> {

}
