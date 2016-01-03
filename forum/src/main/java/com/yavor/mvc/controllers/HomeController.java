package com.yavor.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
		
		@RequestMapping("/")
		public String goHome(Model model) {
			model.addAttribute("commentId", new Integer(4));
			return "home";
		}
		

}
