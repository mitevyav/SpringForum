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

import com.yavor.mvc.entities.Topic;
import com.yavor.mvc.services.TopicService;


@Controller
@RequestMapping("/topic")
public class TopicsController {
	
	
	@Autowired
	TopicService service;
	
	
	@RequestMapping(value="/{categoryId}", method=RequestMethod.GET)
	public String viewTopics(Model model, @PathVariable("categoryId") String categoryId) {
		List<Topic> topics = service.getTopicsForCategory(categoryId);
		model.addAttribute("topics", topics);
		return "view_topics";
	}
	
	
	
	@RequestMapping(value="/{categoryId}", method=RequestMethod.POST)
	public String submitTopics(@ModelAttribute Topic topic, @PathVariable("categoryId") String categoryId) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		topic.setUser(username);
		topic.setCategory(categoryId);
		service.insertTopic(topic);
		return "redirect:/topic/"+categoryId;
	}

}
