package com.yavor.mvc.services;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yavor.mvc.entities.Topic;
import com.yavor.mvc.repositories.TopicRepository;

@Service
public class TopicService {
	
	@Autowired
	TopicRepository repository;
	
	public List<Topic> getTopicsForCategory (String id) {
		List<Topic> topics = this.repository.getTopicsForCategory(id);
		for(Topic topic: topics) {
			topic.setCommentsCount(repository.getCommentsCount(topic.getId()));
		}
		return topics;
	}
	
	public Topic getTopicbyId (String id) {
		return this.repository.findById(id);
	}
	
	public void insertTopic(Topic topic) {
		Date date = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		topic.setDate(df.format(date));
		
		this.repository.insert(topic);
	}
	
}
