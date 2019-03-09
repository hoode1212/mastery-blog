package com.wcciproject.masteryblog.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wcciproject.masteryblog.models.Tag;

public interface TagRepository extends CrudRepository <Tag, Long> {
	
	
	Tag findByTagName(String tagName);


}
