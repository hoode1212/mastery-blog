package com.wcciproject.masteryblog.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wcciproject.masteryblog.models.Author;
import com.wcciproject.masteryblog.models.Genre;
import com.wcciproject.masteryblog.models.Post;
import com.wcciproject.masteryblog.models.Tag;
import com.wcciproject.masteryblog.repositories.AuthorRepository;
import com.wcciproject.masteryblog.repositories.GenreRepository;
import com.wcciproject.masteryblog.repositories.PostRepository;
import com.wcciproject.masteryblog.repositories.TagRepository;

@Controller
@RequestMapping("/post")
public class PostController {

	@Resource
	AuthorRepository authorRepo;
	@Resource
	GenreRepository genreRepo;
	@Resource
	PostRepository postRepo;
	@Resource
	TagRepository tagRepo;

	@GetMapping("/submitPost")
	public String postForm() {
		return "submitPost";

	}

	@PostMapping("/submitPost")
	public String postSubmit(String body, String date, String title, Author author, Genre genre, Tag ...tags) {
		postRepo.save(new Post(body, date, title, author, genre, tags));
		return "redirect:/home";
	
	}

}
