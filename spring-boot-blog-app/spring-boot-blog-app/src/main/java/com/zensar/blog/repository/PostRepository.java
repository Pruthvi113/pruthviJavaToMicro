package com.zensar.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.blog.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> { //Long is the primary key type of Post. 

}
