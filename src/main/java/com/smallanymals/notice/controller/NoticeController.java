package com.smallanymals.notice.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.smallanymals.notice.service.NoticeService;


@Controller
public class NoticeController {

	private NoticeService service;
	
	@Autowired
	public NoticeController(NoticeService service) {
		// TODO Auto-generated constructor stub
		this.service = service;
	}
	
	@RequestMapping(value="/notice/list", method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		System.out.println(service.list());
		mv.addObject("list", service.list());
		mv.setViewName("notice/list");
		return mv;
	}
}
