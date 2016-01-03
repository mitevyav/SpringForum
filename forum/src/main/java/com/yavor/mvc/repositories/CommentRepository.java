package com.yavor.mvc.repositories;

import java.util.List;

import com.yavor.mvc.entities.Comment;

public interface CommentRepository extends Repo<Comment> {
	
	public List<Comment> getCommentsForTopic (String id);

}
