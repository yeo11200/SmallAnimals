package com.smallanimals.member.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import nl.captcha.Captcha;
import nl.captcha.servlet.CaptchaServletUtil;

@Controller
@RequestMapping("/captcha")
public class CaptchaController {
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
		public void index(HttpServletResponse response, HttpSession session) {
		Captcha captcha = new Captcha.Builder(148, 48)
                .addText() // default: 5개의 숫자+문자
                .addNoise().addNoise().addNoise() // 시야 방해 라인 3개
                .addBackground() // 기본 하얀색 배경
                .build();
 
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Max-Age", 0);
        response.setContentType("image/png");
        CaptchaServletUtil.writeImage(response, captcha.getImage()); // 이미지 그리기
        session.setAttribute("captcha", captcha.getAnswer()); // 값 저장
	}
	@ResponseBody
	@RequestMapping(value="/isRight", method=RequestMethod.GET)
	public Integer isRight(@RequestParam("captcha") String captcha, HttpSession session) {
		String answer = (String)session.getAttribute("captcha");
		if(captcha.equals(answer)) {
			return 1;
		}
		return 0;
	}
}