package com.zensar.blog.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

import lombok.Data;

@Data
@Entity
@NamedQuery(name="Comment.commentByAuthorEmail",query="FROM Comment c WHERE c.email=?1") //JPQL
@NamedNativeQuery(name="Comment.commentByAuthorEmailAndName",query="Select * FROM Comment WHERE email=?1 and name=?2",resultClass = Comment.class) //SQL resultClass because the result will now be explicitly required to be converted into that class object
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String email;
	private String body;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="post_id", nullable = false)//comment and post will be joined with this
	private Post post;
}
