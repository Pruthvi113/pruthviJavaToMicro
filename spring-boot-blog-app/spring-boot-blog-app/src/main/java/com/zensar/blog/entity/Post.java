package com.zensar.blog.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity // this annotation will map it with a database table
public class Post {
	
	@Id
	private Long id;
	private String title;
	private String description;
	private String content;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL) //"post" defined in Comment, cascade = if post is deleted, its comments shud also get deleted
	private Set<Comment> comments = new HashSet<>();
}
