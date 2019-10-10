package com.smallanimals.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	
	 @RequestMapping("/memberInfo/login/loginPage") 
	 public String page() throws Exception {
	 System.out.println("들어옴");
	 return "memberInfo/login/loginPage"; }

	 
}
