package com.bikkadIT.blog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikkadIT.blog.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment	, Integer> {
 

}
