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
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		
		return "register";
	}
	@RequestMapping(value = "/naver", method = RequestMethod.GET)
	public String naver(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		
		return "naver";
}
	@RequestMapping(value = "/sample", method = RequestMethod.GET)
	public String sample(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		
		return "sample";
}
	@RequestMapping(value = "/jusoPopup", method = RequestMethod.GET)
	public String jusoPopup(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		
		return "jusoPopup";
}
	
}
