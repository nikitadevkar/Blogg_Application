package com.bikkadIT.blog.service.mpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikkadIT.blog.entity.Comment;
import com.bikkadIT.blog.entity.Post;
import com.bikkadIT.blog.exception.ResourceNotFoundException;
import com.bikkadIT.blog.payloads.CommentDto;
import com.bikkadIT.blog.repo.CommentRepo;
import com.bikkadIT.blog.repo.PostRepo;

import com.bikkadIT.blog.service.CommentService;

import springfox.documentation.swagger2.mappers.ModelMapper;

@Service
	public class CommentServiceImpl implements CommentService {

		@Autowired
		private PostRepo postRepo;

		@Autowired
		private CommentRepo commentRepo;

		@Autowired
		private ModelMapper modelMapper;

		@Override
		public CommentDto createComment(CommentDto commentDto, Integer postId) {

			Post post = this.postRepo.findById(postId)
					.orElseThrow(() -> new ResourceNotFoundException("Post", "post id ", postId));

			Comment comment = this.modelMapper.map(commentDto, Comment.class);

			comment.setPost(post);

			Comment savedComment = this.commentRepo.save(comment);

			return this.modelMapper.map(savedComment, CommentDto.class);
		}


		@Override
		public void deleteComment(Integer commentId) {
			Comment com = this.commentRepo.findById(commentId)
					.orElseThrow(() -> new ResourceNotFoundException("Comment", "CommentId", commentId));
			this.commentRepo.delete(com);
		}


		}

		