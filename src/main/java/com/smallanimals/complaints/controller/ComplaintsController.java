package com.smallanimals.complaints.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	@PostMapping(value="/insert")
	public ModelAndView insert(ComplaintsVO vo) {
		logger.debug("insertTTTTTT"+vo);
		return new ModelAndView("complaints/insert");
	}
}
