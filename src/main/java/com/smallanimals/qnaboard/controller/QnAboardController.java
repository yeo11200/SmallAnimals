package com.smallanimals.qnaboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smallanimals.qnaboard.service.QnAboardService;
import com.smallanimals.qnaboard.vo.QnAboardVO;

@Controller
@RequestMapping(value = "/qnaboard")
public class QnAboardController {
	private static final Logger logger = LoggerFactory.getLogger(QnAboardController.class);
	
	@Autowired
	private QnAboardService qnaboardService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET	)
	public void list() {
		logger.info("list 호출");
		
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerpage() {
		logger.info("register 호출");
		
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(QnAboardVO vo, RedirectAttributes reAttr) {
		logger.info("register post");
		logger.info(vo.getTitle());
		int result = qnaboardService.create(vo);
		if (result == 1) {
			reAttr.addFlashAttribute("result_reg", "success");
			
		} else {
			reAttr.addFlashAttribute("result_reg", "failed");
		}
		return "redirect:list";
	}
}
