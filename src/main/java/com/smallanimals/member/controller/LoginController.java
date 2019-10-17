package com.smallanimals.member.controller;

import java.util.Locale;

import org.mariadb.jdbc.internal.logging.Logger;
import org.mariadb.jdbc.internal.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smallanimals.member.service.MemberService;
import com.smallanimals.member.vo.MemberVO;

@Controller
public class LoginController {
	
	@Autowired
	private MemberService memberService;
	
	 Logger logger = LoggerFactory.getLogger(getClass());
	
	 
	 
	 @RequestMapping("/memberInfo/login/loginPage") 
	 public String page() throws Exception {
	 
	 return "memberInfo/login/loginPage"; 
	 
	 }
	 
	 @RequestMapping(value="/access_denied_page")
	    public String accessDeniedPage() throws Exception {
	        return "/access_denied_page";
	 }

	 @RequestMapping(value = "/memberInfo/join/register1", method = {RequestMethod.GET, RequestMethod.POST})

		public String register1(Locale locale, Model model) {
			logger.info("Welcome home! The client locale is {}.", locale);
			
			
			
			return "memberInfo/join/register1";
		}
	@RequestMapping(value = "/memberInfo/join/register2", method = {RequestMethod.GET, RequestMethod.POST})
		public String register2(Locale locale, Model model) {
			logger.info("Welcome home! The client locale is {}.", locale);
			
			
			return "memberInfo/join/register2";
		}
	
	@RequestMapping("/registerMember")
	public String insertMaember(MemberVO vo) {
		System.out.println("vo:"+vo);
		memberService.registerMember(vo);
		return "redirect:/";
	
	}
}
