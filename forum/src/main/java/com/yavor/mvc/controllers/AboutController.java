package com.yavor.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller		
@RequestMapping("/about")
public class AboutController {
	
	
	@RequestMapping()
	public String viewAboutPage() {
		return "about";
	}

}
