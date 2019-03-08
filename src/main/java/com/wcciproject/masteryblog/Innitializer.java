package com.wcciproject.masteryblog;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.wcciproject.masteryblog.repositories.AuthorRepository;
import com.wcciproject.masteryblog.repositories.GenreRepository;
import com.wcciproject.masteryblog.repositories.PostRepository;
import com.wcciproject.masteryblog.repositories.TagRepository;

@Service
public class Innitializer implements CommandLineRunner{

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
			// TODO Auto-generated method stub
			
		}
}
