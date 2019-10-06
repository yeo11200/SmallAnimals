package com.smallanimals.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@GetMapping(value="/")
	public String main() {
		return "redirect:/main/main";
	}
	
	@GetMapping(value="/main/main")
	public ModelAndView main1() {
		return new ModelAndView("/main/main");
	}
}
