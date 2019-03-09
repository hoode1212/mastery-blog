package com.wcciproject.masteryblog;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.wcciproject.masteryblog.models.Author;
import com.wcciproject.masteryblog.models.Genre;
import com.wcciproject.masteryblog.models.Post;
import com.wcciproject.masteryblog.repositories.AuthorRepository;
import com.wcciproject.masteryblog.repositories.GenreRepository;
import com.wcciproject.masteryblog.repositories.PostRepository;
import com.wcciproject.masteryblog.repositories.TagRepository;

@Service
public class Initializer implements CommandLineRunner{

		@Resource
		PostRepository postRepo;
		@Resource
		AuthorRepository authorRepo;
		@Resource
		GenreRepository genreRepo;
		@Resource
		TagRepository tagRepo;
		

		@Override
		public void run(String... args) throws Exception {
			Author bob = authorRepo.save(new Author("Bob"));
			Genre horror = genreRepo.save(new Genre("Horror"));
			
			Post post1 = postRepo.save(new Post("BODY, this is going to be filled with a bunch of text", "DATE 3/8/2019", "TITLE title of the post", bob, horror));
		}
}
