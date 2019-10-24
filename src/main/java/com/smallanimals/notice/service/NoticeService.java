package com.smallanimals.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smallanimals.notice.dao.NoticeDAO;
import com.smallanimals.notice.vo.NoticeVO;
import com.smallanimals.notice.vo.PreVO;

@Service
public class NoticeService implements NoticeServiceImpl {
	
	private NoticeDAO dao;
	
	@Autowired
	public NoticeService(NoticeDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public List<NoticeVO> list(PreVO vo) {
		// TODO Auto-generated method stub
		if(vo.getDate() == null) {
			vo.setDate("0");
		}
		System.out.println(vo.getDate());
		return dao.list(vo);
	}

	@Override
	public NoticeVO view(int no) {
		// TODO Auto-generated method stub
		return dao.view(no);
	}

	@Override
	public int insert(NoticeVO vo) {
		// TODO Auto-generated method stub
		if(vo.getEmp() == null) {
			vo.setEmp("off");
		}
		return dao.insert(vo);
	}

	@Override
	public int update(NoticeVO vo) {
		// TODO Auto-generated method stub
		return dao.update(vo);
	}

	@Override
	public int delete(int no) {
		// TODO Auto-generated method stub
		return dao.delete(no);
	}

	
}
