package com.smallanimals.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


	@Controller
	public class MemberController {
		@RequestMapping(value="/page")
		public String page() throws Exception {
			return "/memberInfo/page";
		}
		
		@RequestMapping(value="/user/page")
		public String userPage() throws Exception {
			return "/memberInfo/user/page";
		}
		
		@RequestMapping(value="/member/page")
		public String memberPage() throws Exception {
			return "/memberInfo/member/page";
		}
		
		@RequestMapping(value="/admin/page")
		public String adminPage() throws Exception {
			return "/memberInfo/admin/page";
		}
}
