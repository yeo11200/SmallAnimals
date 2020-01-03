package com.smallanimals.member.controller;


import java.security.Principal;


import java.net.URLDecoder;


import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.mariadb.jdbc.internal.logging.Logger;
import org.mariadb.jdbc.internal.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smallanimals.member.service.MemberService;
import com.smallanimals.member.vo.MemberVO;

@Controller
public class LoginController {
	@Autowired 
	private MemberService memberService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	
//	public Account delete(Account account,String role,String type) {
//			account.setPassword(passwordEncoder.encode(account.getPassword()));
//			account.setAccountNonExpired(true);
//			account.setAccountNonLocked(true);
//			account.setCredentialsNonExpired(true);
//			account.setEnabled(true);
//			account.setType(type);
//			
//			return accounts.delete(account, role);
//		}
	
	

	Logger logger = LoggerFactory.getLogger(getClass());



	
	@RequestMapping(value = "../main")
	public String main() throws Exception {
		return "../main";
	}
	
	@RequestMapping("/memberInfo/login/loginPage")
	 public String page() throws Exception {
		 return "memberInfo/login/loginPage";
	 
	 }
	 
	 @RequestMapping(value="/access_denied_page")
	    public String accessDeniedPage() throws Exception {
	        return "/access_denied_page";
	 }

	 @RequestMapping(value = "/memberInfo/join/register1")

		public String register1(Locale locale, Model model) {
			logger.info("Welcome home! The client locale is {}.", locale);
			
			
			
			return "memberInfo/join/register1";
		}
	@RequestMapping(value = "/memberInfo/join/register2")
		public String register2(Locale locale, Model model) {
			logger.info("Welcome home! The client locale is {}.", locale);
			
			
			return "memberInfo/join/register2";
		}

	//회원가입 기능
	@RequestMapping(value="/registerMember", method = RequestMethod.POST)
	public String insertMember(MemberVO vo) {
		
		System.out.println("vo:" + vo);	
		memberService.registerMember(vo);
		return "redirect:/";
	}
	//회원가입 성공시 이동 page.
	@RequestMapping(value = "/memberInfo/join/successlogin", method = RequestMethod.POST )
	public String successlogin(Model model) {
		return "memberInfo/join/successlogin";
	}
	
	//아이디 중복체크
	@ResponseBody
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	public int idCheck(@RequestBody String userId) throws Exception {
		String user_id = URLDecoder.decode(userId, "UTF-8");
		logger.info("post idCheck");
		System.out.println("아이디 중복체크 입니다 확인 해 주세요" +user_id);
		
		MemberVO idCheck = memberService.idCheck(user_id);
		
		int result = 0;
		 if(idCheck !=null) {
			 result =1;
		 }
		return result;
	}
	//회원 수정 창 이동
	@RequestMapping(value = "/memberInfo/modify/Member_Modify")
	public String Member_Modify(Principal principal, Model model) {
		String user_id = currentUserName(principal);
		System.out.println("아이디 " + user_id);
		MemberVO membervo = memberService.memberInfo(user_id);
		System.out.println(membervo.getUserId());
		
		model.addAttribute("memberInfo",membervo);
		System.out.println("memberInfo.userNickname"+membervo.getUserNickname());
		return "memberInfo/modify/Member_Modify";
	}
	//회원 비밀번호 창 이동
	@RequestMapping(value = "/memberInfo/modify/changepwd")
	public String changepwd(Principal principal, Model model) {
		String userId = currentUserName(principal);
		MemberVO membervo = memberService.memberInfo(userId);
		System.out.println(membervo.getUserId());
		
		model.addAttribute("memberInfo",membervo);

		return "memberInfo/modify/changepwd";
	}
	//회원 정보 수정
	@RequestMapping(value = "/memberUpdate",method=RequestMethod.POST)
	public String memberUpdate(@ModelAttribute MemberVO vo) {
		
		memberService.memberUpdate(vo);
		System.out.println("LoginController 구간" + vo);
		return "redirect:/main/main";
	}
	
		//회원탈퇴 페이지 이동
		@RequestMapping(value = "/memberInfo/withdrawal/WithDrawal")
		public String WithDrawal(Principal principal, Model model) {
			String user_id = currentUserName(principal);
			System.out.println("아이디 " + user_id);
			MemberVO membervo = memberService.memberInfo(user_id);
			System.out.println(membervo.getUserId());
			
			model.addAttribute("memberInfo",membervo);
			System.out.println("memberInfo.userNickname"+membervo.getUserNickname());
			return "memberInfo/withdrawal/WithDrawal";
		}
		//회원탈퇴
		@RequestMapping(value = "/memberDelete" , method = RequestMethod.POST)
		public String memberDelete(MemberVO vo, RedirectAttributes rttr) throws Exception {
			
			logger.info("post withdrawal");
			
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
			String oldPass = ((UserDetails) principal).getPassword();
			System.out.println(oldPass);
			 
			String newPass = vo.getUserPwd();
			//String newPass2 = passwordEncoder.encode(newPass);
			boolean test = passwordEncoder.matches(newPass, oldPass);
			
			if(test == false) {
				rttr.addFlashAttribute("msg", false);
				return "/memberInfo/withdrawal/WithDrawal";
			
			}else {
				memberService.memberDelete(vo);
				
				return "redirect:/logout";
			}
		}
		
		
	@GetMapping("/username")
	@ResponseBody
	public String currentUserName(Principal principal) {
		return principal.getName();
	}
}

