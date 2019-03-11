package com.wcciproject.masteryblog.models;

import java.util.Collection;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import java.util.Arrays;

@Entity
public class Post {
	@Id
	@GeneratedValue
	private Long id;
	private String body;
	private LocalDateTime time;
	private String date;
	private String title;
	@ManyToMany
	private Collection<Author> author;

	@ManyToOne
	private Genre genre;

	@ManyToMany
	private Collection<Tag> tags;
	
	public Post () {}

	public Post(String body, String date, String title, Author author, Genre genre, Tag tags) {
		
		this.time = LocalDateTime.now(); 
		this.body = body;
		this.date = date;
		this.title = title;
		this.author = Arrays.asList(author);
		this.genre = genre;
		this.tags = Arrays.asList(tags);
	}


	public String getTitle() {
		return title;
	}

	public Long getId() {
		return id;
	}

	

	@Override
	public String toString() {
		return "Post [time=" + time + "id=" + id + ", body=" + body + ", date=" + date + ", title=" + title + ", author=" + author
				+ ", genre=" + genre + ", tags=" + tags + "]";
	}

	public String getBody() {
		return body;
	}

	public String getDate() {
		return date;
	}

	public Collection<Author> getAuthor() {
		return author;
	}

	public Genre getGenre() {
		return genre;
	}
	
	public LocalDateTime getTime() {
		return time;
	}

	public Collection<Tag> getTags() {
		return tags;
	}
	public void addTagToTags(Tag tag) {
		tags.add(tag);
	}
}
