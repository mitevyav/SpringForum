package com.yavor.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yavor.mvc.entities.Category;
import com.yavor.mvc.services.CategoryService;

@Controller
@RequestMapping("/categories")
public class CatergoriesController {
	
	@Autowired
	CategoryService service;
	
	@RequestMapping()
	public String viewCategories(Model model) {
		List<Category> categories = service.getCategories();
		
		for(Category category: categories) {
			model.addAttribute(category.getName().replaceAll("[^A-Za-z]+", ""), category);
		}
		return "categories";
	}

}
