package com.zensar.blog.service;

import java.util.List;

import com.zensar.blog.dto.PostDto;
import com.zensar.blog.entity.Post;

public interface PostService {

	public PostDto createPost( PostDto postdto) ;
	public List<Post> getAllPost();
	public PostDto getPostById( Long postId) ;
	public void deletePostById( Long postId) ;
	public PostDto updatePost(PostDto postdto, Long postId);
	public List<Post> getAllPost(int pageNumber, int PageSize, String sortBy);
}
