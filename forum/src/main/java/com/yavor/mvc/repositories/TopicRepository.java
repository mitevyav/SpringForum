package com.yavor.mvc.repositories;

import java.util.List;

import com.yavor.mvc.entities.Topic;

public interface TopicRepository extends Repo<Topic> {
	
	public List<Topic> getTopicsForCategory (String id);

	public String getCommentsCount(String id);
	
	

}
