package com.wcciproject.masteryblog.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wcciproject.masteryblog.models.Author;
import com.wcciproject.masteryblog.models.Tag;
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
	
	
	@RequestMapping("")
	public String tag(Model model) {
		model.addAttribute("tagList", tagRepo.findAll());
		model.addAttribute("postList", postRepo.findAll());
		model.addAttribute("authorList", authorRepo.findAll());
		model.addAttribute("genreList", genreRepo.findAll());
		return "/tag";
	}
	
	
	@PostMapping("/submit")
	public String tagSubmit(String tagName) {
		tagRepo.save(new Tag(tagName));
		return "redirect:/tag";
		
	}

	@GetMapping("/{id}")
	public String singleTag(@PathVariable Long id, Model model) {
		model.addAttribute("tag", tagRepo.findById(id).get());
		model.addAttribute("posts", postRepo.findAll());
		model.addAttribute("authorList", authorRepo.findAll());
		model.addAttribute("genreList", genreRepo.findAll());
		model.addAttribute("tagList", tagRepo.findAll());
		return "singleTag";
	}


}


