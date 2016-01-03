package com.yavor.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yavor.mvc.entities.CustomUser;
import com.yavor.mvc.services.CustomUserService;

@Controller
@RequestMapping("/sign")
public class LogController {
	
	@Autowired
	CustomUserService service;
	
	@RequestMapping(value="/sign_in", method=RequestMethod.GET)
	public String SignInPage() {
		return "sign_in";
	}
	
	
	
	@RequestMapping(value="/sign_up", method=RequestMethod.GET)
	public String addUser() {
		return "create_user";
	}
	
	@RequestMapping(value="/sign_up", method=RequestMethod.POST)
	public String saveUser(@ModelAttribute CustomUser user) {
		if(service.isExist(user.getUsername())) return "redirect:/sign/sign_up?exist=true";
		service.insertUser(user);
		return "redirect:/sign/sign_in";
	}
	
}
