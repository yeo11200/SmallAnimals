package com.smallanimals.member.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mariadb.jdbc.internal.logging.Logger;
import org.mariadb.jdbc.internal.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
//	 @RequestMapping(value = "/main/main", method = {RequestMethod.GET, RequestMethod.POST})
//		public String main(Locale locale, Model model) {
//			logger.info("Welcome home! The client locale is {}.", locale);
//			
//			
//			return "main/main";
//	 }
	 
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
	public String insertMember(MemberVO vo) {
		System.out.println("vo:"+vo);
		memberService.registerMember(vo);
		return "redirect:/";
	
	}
	@RequestMapping(value = "/memberInfo/modify/Member_Modify", method = {RequestMethod.GET, RequestMethod.POST})
	public String Member_Modify(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		return "memberInfo/modify/Member_Modify";
	}
	@RequestMapping(value = "/memberInfo/modify/changepwd", method = {RequestMethod.GET, RequestMethod.POST})
	public String changepwd(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		return "memberInfo/modify/changepwd";
	
}

}
