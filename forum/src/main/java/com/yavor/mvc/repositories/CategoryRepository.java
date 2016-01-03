package com.yavor.mvc.repositories;

import java.util.List;

import com.yavor.mvc.entities.Category;

public interface CategoryRepository extends Repo<Category> {
	
	public List<Category> findAllCategories();
	
	public String numberOfTopics(String id);
	
	public String numberOfComments(String id);

}
