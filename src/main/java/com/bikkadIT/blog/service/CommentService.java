package com.bikkadIT.blog.service;

import com.bikkadIT.blog.payloads.CommentDto;

public interface CommentService {
	CommentDto createComment(CommentDto commentDto, Integer postId);

	void deleteComment(Integer commentId);


}
