package com.smallanimals.complaints.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.smallanimals.complaints.service.ComplaintsService;
import com.smallanimals.complaints.vo.ComplaintsVO;

@Controller
@RequestMapping(value="/complaints")
public class ComplaintsController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	private ComplaintsService service;
	
	public ComplaintsController(ComplaintsService service) {
		this.service = service;
	}
	
	@GetMapping(value="/list")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("complaints/list");
		mv.addObject("list", service.list());
		
		try {
			mv.setViewName("complaints/list");
			mv.addObject("list", service.list());		
		}catch(Exception e) {
			System.out.println(e);
			mv.setViewName("error/error500");
		}
		return mv;
	}
	
	@GetMapping(value="/views/{no}")
	public ModelAndView view(@PathVariable int no) {
		ModelAndView mv = new ModelAndView();
		
		if(service.view(no).getNo() != 0) {
			mv.addObject("view", service.view(no));
			mv.setViewName("complaints/view");
		}else {
			mv.setViewName("error/error500");
		}
		return mv;
	}
	
	@GetMapping(value="/insert")
	public ModelAndView insert() {
		return new ModelAndView("complaints/insert");
	}
	
	@PostMapping(value="/insert")
	public ModelAndView insertApi(ComplaintsVO vo) {
		logger.info("insert!!!!"+vo.getTitle());
		ModelAndView mv = new ModelAndView();
		
		try {
			if(service.insert(vo) == 1) {
				mv.setViewName("complaints/list");
			}else {
				mv.setViewName("error/error500");
			}
		}catch(Exception e) {
			mv.setViewName("error/error");
		}
		return mv;
	}
	
	@GetMapping(value="/update")
	public ModelAndView update(int no) {
		ModelAndView mv = new ModelAndView();	
		mv.addObject("update", service.view(no));
		mv.setViewName("complaints/update");
		return mv;
	}
	
	@PutMapping(value="/update")
	public void updateApi(ComplaintsVO vo) {
		ModelAndView mv = new ModelAndView();
		
		try {
			if(service.update(vo) == 1) {
				
			}
		}catch(Exception e) {
			
		}
	}
	
	@DeleteMapping(value="/delete", produces = "application/text; charset=utf-8")
	public String delete(int no) {
		return "";
	}
}
