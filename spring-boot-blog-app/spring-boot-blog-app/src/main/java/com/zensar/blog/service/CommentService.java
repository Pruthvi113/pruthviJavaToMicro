package com.zensar.blog.service;

import java.util.List;

import com.zensar.blog.dto.CommentDto;

public interface CommentService {

	public CommentDto createComment(long postId, CommentDto commentdto) ;
	public void deleteCommentById(long postId,long commentId);
	public CommentDto getCommentById( long postId,long commentId) ;
	public CommentDto updateComment(long postId, long commentId, CommentDto commentdto);
	public List<CommentDto> getCommentByName( String name);
	public List<CommentDto> getCommentByEmail(String email);
	public List<CommentDto> getCommentByPostId( long postId);
}
