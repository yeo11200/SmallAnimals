package com.smallanimals.complaints.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
		try {
			mv.setViewName("complaints/list");
			mv.addObject("list", service.list());
			mv.addObject("count", service.count());
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
				mv.setViewName("redirect:/complaints/list");
			}else {
				mv.setViewName("error/error500");
			}
		}catch(Exception e) {
			mv.setViewName("error/error");
		}
		return mv;
	}
	
	@GetMapping(value="/update/{no}")
	public ModelAndView update(@PathVariable int no, HttpSession session) {
		ModelAndView mv = new ModelAndView();	
		mv.addObject("update", service.view(no));
		mv.setViewName("complaints/update");
		return mv;
	}
	
	@PutMapping(value= {"/update", "/updateApi"})
	public void updateApi(ComplaintsVO vo) {
		ModelAndView mv = new ModelAndView();
		try {
			if(service.update(vo) == 1) {
				mv.setViewName("redirect:/complaints/views/"+vo.getNo());
			}else {
				mv.setViewName("redirect:/error/error500");
			}
		}catch(Exception e) {
			mv.setViewName("redirect:/error/error");
		}
	}
	
	@DeleteMapping(value="/delete/{no}", produces = "application/text; charset=utf-8")
	@ResponseBody
	public String delete(@PathVariable int no) {
		logger.info("deleteteltetlete", no);
		int result = service.delete(no);
		if(result == 1) {
			return "/complaints/list";
		}else {
			return "/error/error500";
		}
	}
	
	// fetch api를 가지고 올떄 produces="application/text; charset=utf-8"을 사용했는데 406에러가 발생했다 
	// 이 부분은 ajax로 가지고 올때 한글로 가지고 오는 건 줄 알았는데, 조금 더 알아봐야한다.
	@GetMapping(value="/viewlist")
	public ResponseEntity<Map<String, Object>> viewList() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", service.list());
		
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		
	}
}