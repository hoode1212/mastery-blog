package com.wcciproject.masteryblog.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wcciproject.masteryblog.models.Genre;

public interface GenreRepository extends CrudRepository <Genre, Long> {

}
