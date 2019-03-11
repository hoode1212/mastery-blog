package com.wcciproject.masteryblog.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wcciproject.masteryblog.models.Genre;
import com.wcciproject.masteryblog.repositories.AuthorRepository;
import com.wcciproject.masteryblog.repositories.GenreRepository;
import com.wcciproject.masteryblog.repositories.PostRepository;
import com.wcciproject.masteryblog.repositories.TagRepository;

@Controller
@RequestMapping("/genre")
public class GenreController {

	@Resource
	AuthorRepository authorRepo;
	@Resource
	GenreRepository genreRepo;
	@Resource
	PostRepository postRepo;
	@Resource
	TagRepository tagRepo;
	
	@RequestMapping("")
	public String genre(Model model) {
		model.addAttribute("genreList", genreRepo.findAll());
		return "/genre";
	}	
	
	@PostMapping("/submit")
	public String genreSubmit(String genreType) {
		genreRepo.save(new Genre(genreType));
		return "redirect:/genre";
	}
	
	@GetMapping("/{id}")
	public String singleGenre(@PathVariable Long id, Model model) {
		model.addAttribute("genre", genreRepo.findById(id).get());
		model.addAttribute("posts", postRepo.findAll());
		return "singleGenre";
	}
}
