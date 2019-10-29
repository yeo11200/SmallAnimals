package com.smallanimals.qnaboard.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public void list(Model model) {
		List<QnAboardVO> list = qnaboardService.read();
		System.out.println(list.get(0).getTitle());
		model.addAttribute("QnA", list);
		logger.info("list 호출");
		
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public void detail(int board_id, Model model) {
		QnAboardVO vo = qnaboardService.read(board_id);
		qnaboardService.viewUp(vo);
		model.addAttribute("vo", vo);
		logger.info("detail");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerpage() {
		logger.info("register 호출");
		
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(QnAboardVO vo, RedirectAttributes reAttr) {
		int result = qnaboardService.create(vo);
		if (result == 1) {
			reAttr.addFlashAttribute("result_reg", "success");
			
		} else {
			reAttr.addFlashAttribute("result_reg", "failed");
		}
		logger.info("register post");
		return "redirect:list";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void updatepage(int board_id, Model model) {
		QnAboardVO vo = qnaboardService.read(board_id);
		model.addAttribute("vo", vo);
		logger.info("update");
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(QnAboardVO vo, RedirectAttributes reAttr) {
		int result = qnaboardService.update(vo);
		if (result == 1) {
			reAttr.addFlashAttribute("result_up", "success");
		} else {
			reAttr.addFlashAttribute("result_up", "failed");
		}
		
		logger.info("update");
		return "redirect:detail?board_id=" + vo.getBoard_id();
	}
	
	@RequestMapping(value = "/delete")
	public String delete(int board_id, RedirectAttributes reAttr) {
		int result = qnaboardService.delete(board_id);
		if (result == 1) {
			reAttr.addFlashAttribute("result_del", "success");
		} else {
			reAttr.addFlashAttribute("result_del", "failed");
		}
		logger.info("delete");
		return "redirect:list";
	}
}
