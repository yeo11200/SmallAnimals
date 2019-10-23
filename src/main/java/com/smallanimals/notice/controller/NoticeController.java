package com.smallanimals.notice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.smallanimals.notice.dao.NoticeDAO;
import com.smallanimals.notice.service.NoticeService;
import com.smallanimals.notice.vo.NoticeVO;
import com.smallanimals.notice.vo.PreVO;


@Controller
public class NoticeController {

	private NoticeService service;
	private NoticeDAO dao;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	public NoticeController(NoticeService service, NoticeDAO dao) {
		// TODO Auto-generated constructor stub
		this.service = service;
		this.dao = dao;
	}
	
	@RequestMapping(value="/notice/list", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView list(PreVO vo) {
		logger.info("date????"+ vo.getDate());
		ModelAndView mv = new ModelAndView();
		System.out.println(service.list(vo));
		mv.addObject("list", service.list(vo));
		mv.addObject("count", dao.count());
		mv.setViewName("notice/list");
		return mv;
	}
	
	@RequestMapping(value="/notice/lists", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> lists(PreVO vo) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<NoticeVO> list = service.list(vo);
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
		System.out.println(service.view(no).getStartDate());
		mv.addObject("views", service.view(no));
		mv.setViewName("notice/view");
		return mv;
	}
	
	@RequestMapping(value="/notice/insert", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView insert(NoticeVO vo) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("notice/insert");
		logger.info("insert!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(vo.getTitle());
		if(vo.getTitle() != null) {
			System.out.println(vo);
			int a = service.insert(vo);
			 if(a != 0) {
				 mv.setViewName("redirect:/notice/list");
			 } else {
				 mv.setViewName("redirect:/error/error");
			 }
		}
		return mv;
	}
	
//	@RequestMapping(value="/notice/insertApi", method= RequestMethod.POST)
//	@ResponseBody
//	public ModelAndView insertApi(NoticeVO vo) {
//		ModelAndView mv = new ModelAndView();
//		int success = service.insert(vo);
//		if(success == 1) {
//			mv.setViewName("redirect:/notice/list");
//		} else {
//			mv.setViewName("redirect:/error/error");
//		}
//		return mv;
//	}
	
	@RequestMapping(value="/notice/update/{no}", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView update(@PathVariable int no, NoticeVO vo) {
		ModelAndView mv = new ModelAndView();
		try {
			mv.addObject("update", service.view(no));
			if(vo.getTitle() != null) {
				mv.setViewName("redirect:/notice/views/"+no);
			}else {
				mv.setViewName("redirect:/error/error");
			}
			mv.setViewName("notice/update");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			mv.setViewName("redirect:/error/error");
		}
		return mv;
	}
	
	@RequestMapping(value="/notice/updateApi", method=RequestMethod.POST)
	public ModelAndView updateApi(NoticeVO vo) {
		System.out.println("들어와!!!!!!!!!!!!!!!!!!!!");
		ModelAndView mv = new ModelAndView();
		int success = service.update(vo);
		if(success == 1) {
			mv.setViewName("redirect:/notice/list");
		} else {
			mv.setViewName("redirect:/error/error");
		}
		return mv;
	}
	@RequestMapping(value="/notice/delete/{no}", method=RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable int no ) throws Exception{
		logger.info("info//////////"+no);
		System.out.println(no);
		
		int a = service.delete(no);
		System.out.println(a);
		if(a == 1) {
			return "/notice/list";
		}else {
			return "/error/error";
		}
	}
	
	@GetMapping(value="/notice/idcheck", produces = "application/text; charset=utf8")
	@ResponseBody
	public String idCheck(String id) {
		System.out.println(id);
		if(id == "1234") {
			return "불가능";
		}else {
			return "사용가능";
		}
	}
}