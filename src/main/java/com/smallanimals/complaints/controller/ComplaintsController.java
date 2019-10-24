package com.smallanimals.complaints.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.smallanimals.complaints.vo.ComplaintsVO;

@Controller
@RequestMapping(value="/complaints")
public class ComplaintsController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@GetMapping(value="/list")
	public ModelAndView list() {
		return new ModelAndView("complaints/list");
	}
	
	@GetMapping(value="/views/{no}")
	public ModelAndView view(int no) {
		return new ModelAndView("complaints/views");
	}
	
	@GetMapping(value="/insert")
	public ModelAndView insert() {
		return new ModelAndView("complaints/insert");
	}
	
	@PostMapping(value="/insert")
	public void insertApi(ComplaintsVO vo) {
		logger.info("insert!!!!"+vo.getTitle());
	}
	
	@GetMapping(value="/update")
	public ModelAndView update(int no) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("", "");
		mv.setViewName("");
		return new ModelAndView("complaints/update");
	}
	
	@PutMapping(value="/update")
	public void updateApi() {
		
	}
	
	@DeleteMapping(value="/delete")
	public void delete(int no) {
		
	}
}
