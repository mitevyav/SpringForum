package com.yavor.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yavor.mvc.entities.Comment;
import com.yavor.mvc.entities.Topic;
import com.yavor.mvc.services.CommentService;
import com.yavor.mvc.services.TopicService;

@Controller
@RequestMapping("/comments")
public class CommentsController {
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	TopicService topicService;
	
	@RequestMapping(value="/{topicId}", method=RequestMethod.GET)
	public String viewPost(@PathVariable("topicId") String topicId, Model model) {
		
		List<Comment> comments = commentService.getCommentsForTopic(topicId);
		Topic commentsTopic = topicService.getTopicbyId(topicId);
		
		model.addAttribute("comments", comments);
		model.addAttribute("topic", commentsTopic);
		
		return "comments";
	}
	
	@RequestMapping(value="/{topicId}", method=RequestMethod.POST)
	public String savePost(@PathVariable("topicId") String topicId, @ModelAttribute Comment comment) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		comment.setUser(username);
		comment.setTopic(topicId);
		commentService.insertComment(comment);
		return "redirect:/comments/"+topicId;
	}
	
	
}
