package com.smallanimals.notice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.smallanimals.notice.dao.NoticeDAO;
import com.smallanimals.notice.service.NoticeService;
import com.smallanimals.notice.vo.NoticeVO;


@Controller
public class NoticeController {

	private NoticeService service;
	private NoticeDAO dao;
	
	@Autowired
	public NoticeController(NoticeService service, NoticeDAO dao) {
		// TODO Auto-generated constructor stub
		this.service = service;
		this.dao = dao;
	}
	
	@RequestMapping(value="/notice/list", method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		System.out.println(service.list());
		mv.addObject("list", service.list());
		mv.addObject("count", dao.count());
		mv.setViewName("notice/list");
		return mv;
	}
	
	
	@RequestMapping(value="/notice/lists", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> lists() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<NoticeVO> list = service.list();
		int count = dao.count();
		map.put("list", list);
		map.put("count", count);
		
		Map<String, Object> map2 = new HashMap<String, Object>() ;
		map2.put("list", map);
		return new ResponseEntity<Map<String, Object>>(map2, HttpStatus.OK);
	}
	
	@RequestMapping(value="/notice/views/{no}", method=RequestMethod.GET)
	public ModelAndView view(@PathVariable int no) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("views", service.view(no));
		mv.setViewName("notice/view");
		return mv;
	}
	
	@RequestMapping(value="/notice/insert", method= RequestMethod.GET)
	public ModelAndView insert(NoticeVO vo) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("notice/insert");
		return mv;
	}
	
	@RequestMapping(value="/notice/insertApi", method= RequestMethod.POST)
	@ResponseBody
	public ModelAndView insertApi(NoticeVO vo) {
		ModelAndView mv = new ModelAndView();
		int success = service.insert(vo);
		if(success == 1) {
			mv.setViewName("redirect:/notice/list");
		} else {
			mv.setViewName("redirect:/error/error");
		}
		return mv;
	}
	
	@RequestMapping(value="/notice/update/{no}", method=RequestMethod.GET)
	public ModelAndView update(@PathVariable int no) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("update", service.view(no));
		mv.setViewName("notice/update");
		return mv;
	}
	
	@RequestMapping(value="/notice/updateApi", method=RequestMethod.PUT)
	@ResponseBody
	public ModelAndView updateApi(NoticeVO vo) {
		ModelAndView mv = new ModelAndView();
		int success = service.update(vo);
		if(success == 1) {
			mv.setViewName("redirect:/notice/list");
		} else {
			mv.setViewName("redirect:/error/error");
		}
		mv.setViewName("notice/update");
		return mv;
	}
	
	@RequestMapping(value="/notice/delete/{no}", method=RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable int no) {
		ModelAndView mv = new ModelAndView();
		int success = service.delete(no);
		if(success == 1) {
			mv.setViewName("redirect:/notice/list");
		} else {
			mv.setViewName("redirect:/error/error");
		}
		return mv;
	}
}
