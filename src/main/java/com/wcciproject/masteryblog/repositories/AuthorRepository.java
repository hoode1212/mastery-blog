package com.wcciproject.masteryblog.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wcciproject.masteryblog.models.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
