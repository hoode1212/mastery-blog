package com.wcciproject.masteryblog;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.wcciproject.masteryblog.controllers.AuthorController;
import com.wcciproject.masteryblog.models.Author;
import com.wcciproject.masteryblog.repositories.AuthorRepository;




	public class BlogControllersTest {

		@InjectMocks
		private AuthorController underTest;

		@Mock
		private AuthorRepository authorRepo;

		@Mock
		private Author author;

		@Mock
		private Model model;

		@Before
		public void setUp() {
			MockitoAnnotations.initMocks(this);
		}

		@Test
		public void shouldAddAuthorToModel() throws Exception {
			Long blogId = 1L;
			Object authorId;
			when(authorRepo.findById(authorId)).thenReturn(Optional.of(author));

			underTest.getAuthor(authorId, model);

			verify(model).addAttribute("Author", author);
		}

	}
	

