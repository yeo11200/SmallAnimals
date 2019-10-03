package com.smailanymals.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NoticeController {

	@RequestMapping(value="/notice/list", method=RequestMethod.GET)
	public String list() {
		return "notice/list";
	}
}
