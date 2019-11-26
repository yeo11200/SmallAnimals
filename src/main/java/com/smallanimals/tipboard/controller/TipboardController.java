package com.smallanimals.tipboard.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smallanimals.tipboard.service.TipboardService;
import com.smallanimals.tipboard.vo.TipLikeVO;
import com.smallanimals.tipboard.vo.TipReplyVO;
import com.smallanimals.tipboard.vo.TipboardVO;

@Controller
@RequestMapping(value = "/tipboard")
public class TipboardController {
	private static final Logger logger = LoggerFactory.getLogger(TipboardController.class);

	@Autowired
	private TipboardService tipboardService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) {
		List<TipboardVO> list = tipboardService.read();
		model.addAttribute("Tip", list);
		logger.info("Controller : list 호출");
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public void detail(int board_id, Model model) {
		TipboardVO vo = tipboardService.read(board_id);
		tipboardService.viewUp(vo);
		model.addAttribute("vo", vo);
		logger.info("Controller : detail");
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerpage() {
		logger.info("Controller : register");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(TipboardVO vo, RedirectAttributes reAttr) {
		int result = tipboardService.create(vo);
		if (result == 1) {
			reAttr.addFlashAttribute("rst_reg", "success");
		} else {
			reAttr.addFlashAttribute("rst_reg", "failed");
		}
		logger.info("Controller : register post");
		return "redirect:list";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void updatepage(int board_id, Model model) {
		TipboardVO vo = tipboardService.read(board_id);
		model.addAttribute("vo", vo);
		logger.info("Controller : update");
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(TipboardVO vo, RedirectAttributes reAttr) {
		int result = tipboardService.update(vo);
		if (result == 1) {
			reAttr.addFlashAttribute("result_up", "success");
		} else {
			reAttr.addFlashAttribute("result_up", "failed");
		}
		
		logger.info("Controller : update");
		return "redirect:detail?board_id=" + vo.getBoard_id();
	}
	
	@RequestMapping(value = "/delete")
	public String delete(int board_id, RedirectAttributes reAttr) {
		int result = tipboardService.delete(board_id);
		if (result == 1) {
			reAttr.addFlashAttribute("result_del", "success");
		} else {
			reAttr.addFlashAttribute("result_del", "failed");
		}
		logger.info("Controller : delete");
		return "redirect:list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/reply/all/{no}", method = RequestMethod.GET)
	public ResponseEntity<List<TipReplyVO>> readFreplies(@PathVariable("no") int board_id) {
		List<TipReplyVO> list = tipboardService.replyRead(board_id);
		ResponseEntity<List<TipReplyVO>> entity = new ResponseEntity<List<TipReplyVO>>(list, HttpStatus.OK);
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	public ResponseEntity<Integer> createFreply(@RequestBody TipReplyVO vo) {
		int result = tipboardService.replyCreate(vo);
		ResponseEntity<Integer> entity = new ResponseEntity<Integer>(result, HttpStatus.OK);
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value = "/reply/{no}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteFreply(@PathVariable("no") int reply_id) {
		
		int result = tipboardService.replyDelete(reply_id);
		ResponseEntity<String> entity = null;
		if (result == 1) {
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			entity = new ResponseEntity<String>("fail", HttpStatus.OK);
		}
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value = "/like", method = RequestMethod.POST)
	public ResponseEntity<String> likeTip(@RequestBody TipLikeVO vo) {
		int result = 0;
		ResponseEntity<String> entity = null;
		if (tipboardService.read_like(vo) == null) {
			result = tipboardService.create_like(vo); // 추천 입력
			if (result == 1) {
				entity = new ResponseEntity<String>("insert_like", HttpStatus.OK);
			} else {
				entity = new ResponseEntity<String>("error", HttpStatus.OK);
			}
		} else { // 이미 추천된 상태이면
			result = tipboardService.delete_like(vo); // 추천 삭제
			if (result == 1) {
				entity = new ResponseEntity<String>("delete_like", HttpStatus.OK);
			} else {
				entity = new ResponseEntity<String>("error", HttpStatus.OK);
			}
		}
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value = "/dislike", method = RequestMethod.POST)
	public ResponseEntity<String> dislikeTip(@RequestBody TipLikeVO vo) {
		int result = 0;
		ResponseEntity<String> entity = null;
		if (tipboardService.read_dislike(vo) == null) {
			result = tipboardService.create_dislike(vo); 
			if (result == 1) {
				entity = new ResponseEntity<String>("insert_dislike", HttpStatus.OK);
			} else {
				entity = new ResponseEntity<String>("error", HttpStatus.OK);
			}
		} else { 
			result = tipboardService.delete_dislike(vo); 
			if (result == 1) {
				entity = new ResponseEntity<String>("delete_dislike", HttpStatus.OK);
			} else {
				entity = new ResponseEntity<String>("error", HttpStatus.OK);
			}
		}
		return entity;
	}
}
