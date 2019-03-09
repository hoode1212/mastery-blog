package com.wcciproject.masteryblog.controllers;

import javax.annotation.Resource;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.wcciproject.masteryblog.models.Genre;
import com.wcciproject.masteryblog.models.Post;

import com.wcciproject.masteryblog.models.Author;
import com.wcciproject.masteryblog.repositories.AuthorRepository;
import com.wcciproject.masteryblog.repositories.GenreRepository;
import com.wcciproject.masteryblog.repositories.PostRepository;
import com.wcciproject.masteryblog.repositories.TagRepository;

@Controller

public class AuthorController {
	@Id
	@GeneratedValue
	private Long id;
	
	
	@Resource
	AuthorRepository authorRepo;
	@Resource
	GenreRepository genreRepo;
	@Resource
	PostRepository postRepo;
	@Resource
	TagRepository tagRepo;
	
	@GetMapping("/author/{authorId}")
	public String getAuthor(@PathVariable Long authorId, Model model) {
		model.addAttribute("author", authorRepo.findById(authorId).get());
		return "/author/individualAuthor";
	}
	
	@GetMapping("/")
	public String getAllAuthors(Model model) {
		model.addAttribute("authors", authorRepo.findAll());
		return "authors/allAuthors";
	}
	
	
	
	@PostMapping("/author/{authorId}")
	public String addAuthor(@PathVariable Long authorId ,Author author
			) {
		Author review1 = authorRepo.findById(authorId).get();
		authorRepo.save(new ());
		return "redirect:/authors/" + authorId;
	
}

