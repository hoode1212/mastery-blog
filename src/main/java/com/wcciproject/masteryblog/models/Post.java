package com.wcciproject.masteryblog.models;

import java.util.Collection;
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
	private String date;
	private String title;
	@ManyToOne
	private Author author;

	@ManyToOne
	private Genre genre;

	@ManyToMany
	private Collection<Tag> tags;
	
	public Post () {}

	public Post(String body, String date, String title, Author author, Genre genre, Tag ...tags) {
		
		this.body = body;
		this.date = date;
		this.title = title;
		this.author = author;
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
		return "Post [id=" + id + ", body=" + body + ", date=" + date + ", title=" + title + ", author=" + author
				+ ", genre=" + genre + ", tags=" + tags + "]";
	}

	public String getBody() {
		return body;
	}

	public String getDate() {
		return date;
	}

	public Author getAuthor() {
		return author;
	}

	public Genre getGenre() {
		return genre;
	}

	public Collection<Tag> getTags() {
		return tags;
	}
	public void addTagToTags(Tag tag) {
		tags.add(tag);
	}
}
