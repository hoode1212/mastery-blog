package com.wcciproject.masteryblog.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping("")
	public String author(Model model) {
		model.addAttribute("postList", postRepo.findAll());
		return "/post";
	}
	
	@GetMapping("/{id}")
	public String singlePost(@PathVariable Long id, Model model) {
		model.addAttribute("singlePost", postRepo.findById(id));
		return "singlePost";
	}


	@GetMapping("/submitPost")
	public String postForm() {
		return "submitPost";

	}

	@PostMapping("/submitPost")
	public String postSubmit(String body, String date, String title, String authorName, String genreType,
			String tagName, Tag tags) {
		Genre genreToMake = genreRepo.findByGenreType(genreType);
		if (genreToMake == null) {
			genreToMake = genreRepo.save(new Genre(genreType));
		}
		genreToMake = genreRepo.save(genreToMake);

		Author authorToMake = authorRepo.findByAuthorName(authorName);
		if (authorToMake == null) {
			authorToMake = authorRepo.save(new Author(authorName));
		}
		authorToMake = authorRepo.save(authorToMake);
		Tag tagToMake = tagRepo.findByTagName(tagName);
		if (tagToMake == null) {
			tagToMake = tagRepo.save(new Tag(tagName));
		}
		tagToMake = tagRepo.save(tagToMake);

		postRepo.save(new Post(body, date, title, authorToMake, genreToMake, tagToMake));

		return "redirect:/";

	}

}
