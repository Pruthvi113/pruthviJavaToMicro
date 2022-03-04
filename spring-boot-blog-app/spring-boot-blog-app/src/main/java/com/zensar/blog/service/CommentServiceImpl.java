package com.zensar.blog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.blog.dto.CommentDto;
import com.zensar.blog.dto.PostDto;
import com.zensar.blog.entity.Comment;
import com.zensar.blog.entity.Post;
import com.zensar.blog.exception.ResourceNotFoundException;
import com.zensar.blog.repository.CommentRepository;
import com.zensar.blog.repository.PostRepository;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public CommentDto createComment(long postId, CommentDto commentdto) {
		Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));
		
		Comment comment = mapToEntity(commentdto);
		comment.setPost(post);
		Comment commentUpdated = commentRepository.save(comment);
		CommentDto commentDtoUpdated = mapToDto(commentUpdated);
		
		return commentDtoUpdated;
	}

	

	@Override
	public void deleteCommentById(long postId, long commentId) {
		// do validaiton here so that comment.postId = postId 
		Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));
		Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("comment", "id", commentId));

		if(comment.getPost().getId().equals(postId)) {
			commentRepository.deleteById(commentId);
		}else {
			throw new RuntimeException("deleteCommentById -> Post ID does not match, it does not belong to this comment!!");
		}
	}

	@Override
	public CommentDto getCommentById(long postId, long commentId) {
		Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));
		Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("comment", "id", commentId));
		
		if(comment.getPost().getId().equals(postId)) {
			return(mapToDto(comment));
		}else {
			throw new RuntimeException("getCommentById -> Post ID does not match, it does not belong to this comment!!");
		}
	}
	
	@Override
	public CommentDto updateComment(long postId, long commentId, CommentDto commentdto) {
		Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));
		Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("comment", "id", commentId));
		if(comment.getPost().getId().equals(postId)) {

			Comment commentUpdated = mapToEntity(commentdto);
			commentUpdated.setId(comment.getId());
			commentUpdated.setPost(post);
			commentUpdated = commentRepository.save(commentUpdated);

			return (mapToDto(commentUpdated));
		}else {
			throw new RuntimeException("updateComment -> Post ID does not match, it does not belong to this comment!!");
		}
	}
	
	
	@Override
	public List<CommentDto> getCommentByName( String name) {
		//Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));
		
		List<Comment> comments = commentRepository.findByName(name);
//		List<CommentDto> commentDtos = new ArrayList<>();
//		for (Comment c:comments) {
//			commentDtos.add(mapToDto(c));
//		}
		
		//using java 8 ->
		return comments.stream().map((commentvar)->mapToDto(commentvar)).collect(Collectors.toList());
	}
	
	@Override
	public List<CommentDto> getCommentByEmail( String email) {
		//Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));
		
		List<Comment> comments = commentRepository.commentByAuthorEmail(email);
		List<CommentDto> commentDtos = new ArrayList<>();
		for (Comment c:comments) {
			commentDtos.add(mapToDto(c));
		}
		return commentDtos;
	}
	private CommentDto mapToDto(Comment comment) {
		return new CommentDto(comment.getId(), comment.getName(), comment.getEmail(), comment.getBody());
	}
	
	private Comment mapToEntity(CommentDto commentdto) {
		Comment commentEntity = new Comment();
		commentEntity.setName(commentdto.getName());
		commentEntity.setEmail(commentdto.getEmail());
		commentEntity.setBody(commentdto.getBody());
		return commentEntity;
	}



	@Override
	public List<CommentDto> getCommentByPostId(long postId) {
		// TODO Auto-generated method stub
		List<Comment> commentsByPost = commentRepository.getCommentByPostId(postId);
		return commentsByPost.stream().map((commentvar)->mapToDto(commentvar)).collect(Collectors.toList());
	}



	
}
