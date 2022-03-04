package com.zensar.blog.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.blog.constant.AppConstants;
import com.zensar.blog.dto.PostDto;
import com.zensar.blog.entity.Post;
import com.zensar.blog.service.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping() // common URI part can be moved here. at class level.
@Tag(name = "Post Resource") //Swagger API
public class PostController {
		
		@Autowired //note - ur using Autowiring with interface. good ptactice. u can also do with Implemenatition class, but interface is good practice, it will automatically wire with class. If there are more than 1 implementation class for this, u can use @Qualifier
		private PostService postService;
		
		
//		@Autowired // autowiting using constructor.
//		private PostService postService2;
//		public PostController(PostService service) {
//			this.postService2 = service;
//		}
		
		
	   //CRUD operations in this class - first using class var - POST array, then using H2 database (JPA starter)
		private List<Post> posts = new ArrayList<Post>();
		
		
		@PostMapping(path="/api/posts",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}) //Common URIs part for all methods below,  can be moved at top of class with @RequestMapping("/api/posts")
		//@RequestMapping(name = "/api/posts",method = RequestMethod.POST) //legacy code will have something like this.
		//public ResponseEntity<Post> createPost(@RequestBody Post post) { // using ENTIYY
		public ResponseEntity<PostDto> createPost(@RequestBody PostDto postdto) { //using DTO
		//	@RequestBody - will automatically convert request into java object
			//return posts.add(post); //using local posts array (no db)
			
			//return postService.createPost(post);//using JPA starter - H2 database
			return new ResponseEntity<PostDto>(postService.createPost(postdto), HttpStatus.CREATED); // returning posts with CORRECT HTTP status codes.
		}
		
//		@GetMapping("/api/posts")
//		public List<Post> getAllPosts() {
//			//return posts;
//			return postService.getAllPost();
//		}
		
		//Get using pagination and sorting
		@GetMapping("/api/posts")
		public List<Post> getAllPosts(@RequestParam(value="pageNo",defaultValue = AppConstants.PAGE_NO,required = false) int pageNumber, 
				@RequestParam(value="pageSize", defaultValue = "5",required = false) int pageSize,
				@RequestParam(value="sortBy", defaultValue = "id",required = false) String sortBy) {
			
			System.out.println("pageNumber : "+pageNumber + " | pageSize : " +pageSize +" | sortBy : "+ sortBy);
			return postService.getAllPost(pageNumber,pageSize,sortBy );
		}
		//@RequestParam vs @PathVariable
		//http://localhost:8080/api/posts1?postId=1001
		@GetMapping("/api/posts1")
		public Post getPostByIdByRequestParam(@RequestParam("postId") Long postId) {
			//@PathVariable("postId") can be replaced with just - @PathVariable, but in that case local var name (Long postId) shud be same as {postId} 
			for(Post post : posts) {
				if(post.getId().equals(postId)) {
					return post;
				}
			}
			return null;
		}
		
		//http://localhost:8080/api/posts/1002
		@GetMapping(path="/api/posts/{postId}",produces =  MediaType.APPLICATION_XML_VALUE)//multiple MediaTypes can be passed using {}
		@Operation(summary = "Get Post by Post ID", description = "Get Post by Post ID - description")
		public @ApiResponse(description = "Post Object") PostDto getPostById(@Parameter(description = "Enter Post ID") @PathVariable("postId") Long postId) {
			//@PathVariable("postId") can be replaced with just - @PathVariable, but in that case local var name (Long postId) shud be same as {postId} 
			
//using local var - post array
//			for(Post post : posts) {
//				if(post.getId().equals(postId)) {
//					return post;
//				}
//			}

//using JPA starter - H2 database
			return postService.getPostById(postId);
			//return null;
		} 
		
		@DeleteMapping("/api/posts/{postId}")
		public ResponseEntity<String> deletePostById(@PathVariable("postId") Long postId) {
//using local var - post array
//			for(Post post : posts) {
//				if(post.getId().equals(postId)) {
//					return posts.remove(post);
//				}
//			}
//			return false;

//using JPA starter - H2 database
			 postService.deletePostById(postId);
			 return new ResponseEntity<String>("Post Deleted Successfully!", HttpStatus.OK);
		}
		
		@PutMapping("/api/posts/{postId}")
		public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postdto,@PathVariable("postId") Long postId) {
//using local var - post array
//			Post postUpdate = getPostById(postId);
//			if(postUpdate != null) {
//			postUpdate.setTitle(post.getTitle());
//			postUpdate.setDescription(post.getDescription());
//			postUpdate.setContent(post.getContent());
//			}
//			return postUpdate;
			
//using JPA starter - H2 database
			//return postService.updatePost(post,postId);
			
			return new ResponseEntity<PostDto>(postService.updatePost(postdto,postId), HttpStatus.CREATED); // returning posts with CORRECT HTTP status codes.

			
		}
}
