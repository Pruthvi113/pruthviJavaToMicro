package com.zensar.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.blog.dto.CommentDto;
import com.zensar.blog.service.CommentService;

@RestController
@RequestMapping(path="/api")
public class CommentController {

	@Autowired
	private CommentService  commentService;
	
	@PostMapping(path="/posts/{postId}/comments",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_VALUE}) //Common URIs part for all methods below,  can be moved at top of class with @RequestMapping("/api/posts")
	public ResponseEntity<CommentDto> createComment(@PathVariable("postId") Long postId,@RequestBody CommentDto commentdto) { //using DTO
		return new ResponseEntity<CommentDto>(commentService.createComment(postId, commentdto), HttpStatus.CREATED); // returning posts with CORRECT HTTP status codes.
	}
	
	@DeleteMapping("/posts/{postId}/comments/{commentId}")
	public ResponseEntity<String> deleteCommentById(@PathVariable("postId") Long postId,@PathVariable("commentId") Long commentId) {
		commentService.deleteCommentById(postId,commentId);
		return new ResponseEntity<String>("Comment Deleted Successfully!", HttpStatus.OK);
	}
	
	@GetMapping(path="/posts/{postId}/comments/{commentId}",produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CommentDto>  getCommentById(@PathVariable("postId") Long postId, @PathVariable("commentId") Long commentId) {
		return new ResponseEntity<CommentDto>(commentService.getCommentById(postId,commentId),HttpStatus.OK);
	} 
	
	@GetMapping(path="/posts/comments/{commentName}",produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CommentDto>>  getCommentByName(@PathVariable("commentName") String commentName) {
		return new ResponseEntity<List<CommentDto>>(commentService.getCommentByName(commentName),HttpStatus.OK);
	} 
	
	@GetMapping(path="/posts/comments/email/{commentEmail}",produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CommentDto>>  getCommentByEmail(@PathVariable("commentEmail") String commentEmail) {
		return new ResponseEntity<List<CommentDto>>(commentService.getCommentByEmail(commentEmail),HttpStatus.OK);
	} 
	
	@PutMapping("/posts/{postId}/comments/{commentId}")
	public ResponseEntity<CommentDto> updatePost(@PathVariable("postId") Long postId,@PathVariable("commentId") Long commentId,@RequestBody CommentDto commentdto) {
		return new ResponseEntity<CommentDto>(commentService.updateComment(postId,commentId,commentdto), HttpStatus.CREATED); 
	
	}
	
	@GetMapping(path="/posts/{postId}/comments",produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CommentDto>>  getCommentByPostId(@PathVariable("postId") Long postId) {
		return new ResponseEntity<List<CommentDto>>(commentService.getCommentByPostId(postId),HttpStatus.OK);
	} 
	
}
