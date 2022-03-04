package com.zensar.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.zensar.blog.dto.PostDto;
import com.zensar.blog.entity.Post;
import com.zensar.blog.exception.ResourceNotFoundException;
import com.zensar.blog.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public PostDto createPost(PostDto postdto) {
		
		Post postEntity = mapToEntity(postdto);
		
		Post post2 = postRepository.save(postEntity);
		PostDto postDtoNew = new PostDto(post2.getId(), post2.getTitle(), post2.getDescription(), post2.getContent());
		
		return postDtoNew;
		
	}

	@Override
	public List<Post> getAllPost() {
		return postRepository.findAll();
	}
	
	@Override
	public List<Post> getAllPost (int pageNumber, int pageSize, String sortBy) {
		Pageable pageable = PageRequest.of(pageNumber,pageSize, Sort.by(sortBy).descending());
		Page<Post> page= postRepository.findAll(pageable);
		List<Post> listOfPost = page.getContent();
		//Stream.iterate(listOfPost).ma <- convert from entity to dto using stream api
		return listOfPost;
	}
	@Override
	public PostDto getPostById(Long postId) {
		//return postRepository.getById(postId);  // this works but also throws an exception - InvalidDefinitionException: No serializer found for class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor
	//	return postRepository.findById(postId).get();
		
		//with exception -->
		Post post  = postRepository.findById(postId).orElseThrow(()->{throw new ResourceNotFoundException("Post", "Id", postId);});
		return mapToDto(post);
	}

	@Override
	public void deletePostById(Long postId) {
		 postRepository.deleteById(postId);
	}

	@Override
	public PostDto updatePost(PostDto postdto, Long postId) {
		PostDto availablePost = getPostById(postId);
		availablePost.setTitle(postdto.getTitle());
		availablePost.setDescription(postdto.getDescription());
		availablePost.setContent(postdto.getContent());
		
		Post updatedPost = postRepository.save(mapToEntity(availablePost)); //save will update if post is there, will create if post is NOT there
		return mapToDto(updatedPost);
	}

		
	private PostDto mapToDto(Post post) {
		return new PostDto(post.getId(), post.getTitle(), post.getDescription(), post.getContent());
	}
	
	private Post mapToEntity(PostDto postdto) {
		Post postEntity = new Post();
		postEntity.setId(postdto.getId());
		postEntity.setTitle(postdto.getTitle());
		postEntity.setDescription(postdto.getDescription());
		postEntity.setContent(postdto.getContent());
		return postEntity;
	}
}
