package com.zensar.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zensar.blog.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> { //Long is the primary key type of Post. 
	
	//DAY 15) 2/03 - SPRING BOOT - Custom Queries
	//way 1 - custom query
	List<Comment> findByName(String name);
	
	
	//way 2 - using jpql/sql. see @NamedQuery/@NamedNativeQuery in Comment entity
	List<Comment> commentByAuthorEmail (String email); 
	
	
	//way 3 - using jpql/sql. but Query is here instead of entity.
	//@Query(value="FROM Comment c WHERE c.email=?1") //JPQL
	//@Query(value="Select * FROM Comment  WHERE email=?1", nativeQuery = true) //SQL
	@Query(value="Select * FROM Comment  WHERE email=:email", nativeQuery = true) // ?1 replaced with :email
	List<Comment> commentByAuthorEmail2 (String email); 
	
	@Query(value="Select * FROM Comment  WHERE email=:myemail", nativeQuery = true) // ?1 replaced with custom :myemail / Using Named Parameters
	List<Comment> commentByAuthorEmail3 (@Param("myemail") String email); 
	
	List<Comment> getCommentByPostId(long postId);
}
