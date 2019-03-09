package com.wcciproject.masteryblog;

import static org.junit.Assert.assertThat;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wcciproject.masteryblog.models.Author;
import com.wcciproject.masteryblog.repositories.AuthorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MasteryBlogApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Resource
	private TestEntityManager entityManager;
	 
	@Resource
	private AuthorRepository authorRepo;
}
@Test
public void shouldSaveAndLoadEmployee() {
    Author author = authorRepo.save(new Author("name"));
    Long employeeId = author.getId();

    entityManager.persist(author);
    entityManager.flush();
    entityManager.clear();

    Optional<Author> authorToFind = authorRepo.findById(authorId);
    author = authorToFind.get();

    assertThat(author.getAuthorName(), is("name"));
}
private void assertThat(String authorName, Object object) {
	// TODO Auto-generated method stub
	
}
private Object is(String string) {
	// TODO Auto-generated method stub
	return null;
}









