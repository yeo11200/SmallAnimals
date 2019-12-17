package com.smallanimals.main.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

 Logger logger = LoggerFactory.getLogger(getClass());
	@GetMapping(value="/")
	public String main() {
		return "redirect:/main/main";
	}
	
	@GetMapping(value="/main/main")
	public ModelAndView main1() {
		return new ModelAndView("/main/main");
	}
	
	@GetMapping(value="/modal/modal")
	public ModelAndView modal() {
		return new ModelAndView("modal/modal");
	}
}
