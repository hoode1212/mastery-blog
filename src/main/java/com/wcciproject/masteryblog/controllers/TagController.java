package com.wcciproject.masteryblog.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wcciproject.masteryblog.repositories.AuthorRepository;
import com.wcciproject.masteryblog.repositories.GenreRepository;
import com.wcciproject.masteryblog.repositories.PostRepository;
import com.wcciproject.masteryblog.repositories.TagRepository;

@Controller

public class TagController {
	@Resource
	AuthorRepository authorRepo;
	@Resource
	GenreRepository genreRepo;
	@Resource
	PostRepository postRepo;
	@Resource
	TagRepository tagRepo;
	
	@GetMapping ("/tag/{id}")
	public String singleTag(@PathVariable Long id, Model model) {
		model.addAttribute("genre",genreRepo.findAll());
		model.addAttribute("tagRepo", tagRepo.findById(id).get());
		return "tag";
	}
	
}
