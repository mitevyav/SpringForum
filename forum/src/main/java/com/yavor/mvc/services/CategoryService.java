package com.yavor.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yavor.mvc.entities.Category;
import com.yavor.mvc.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository repository;
	
	public List<Category> getCategories () {
		List<Category> categories = this.repository.findAllCategories();
		for(Category category: categories) {
			category.setTopicsCount(repository.numberOfTopics(category.getId()));
			category.setCommentsCount(repository.numberOfComments(category.getId()));
		}
		return categories;
	}
	
	
}
