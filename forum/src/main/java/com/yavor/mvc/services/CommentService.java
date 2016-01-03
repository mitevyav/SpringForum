package com.yavor.mvc.services;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yavor.mvc.entities.Comment;
import com.yavor.mvc.repositories.CommentRepository;


@Service
public class CommentService {
	
	@Autowired
	CommentRepository repository;	
	
	
	public List<Comment> getCommentsForTopic (String id) {
		return this.repository.getCommentsForTopic(id);
	}


	public void insertComment(Comment comment) {

		Date date = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		comment.setDate(df.format(date));
		
		this.repository.insert(comment);
		
	}
	
}
