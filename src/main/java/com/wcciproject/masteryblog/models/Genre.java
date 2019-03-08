package com.wcciproject.masteryblog.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genre {
	@Id
	@GeneratedValue
	private Long id;
	private String genreType;

	@OneToMany(mappedBy = "genre")
	private Collection<Post> posts;
	
	public Genre() {}

	public Long getId() {
		return id;
	}

	public String getGenreType() {
		return genreType;
	}

	public Collection<Post> getPosts() {
		return posts;
	}

	@Override
	public String toString() {
		return "Genre [id=" + id + ", genreType=" + genreType + ", posts=" + posts + "]";
	}


}
