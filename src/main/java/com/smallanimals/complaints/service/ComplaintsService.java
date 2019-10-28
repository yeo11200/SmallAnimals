package com.smallanimals.complaints.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smallanimals.complaints.dao.ComplaintsDAO;
import com.smallanimals.complaints.service.ComplaintsImfo;
import com.smallanimals.complaints.vo.ComplaintsVO;

@Service
@Transactional
public class ComplaintsService implements ComplaintsImfo{

	private ComplaintsDAO dao;
	
	public ComplaintsService(ComplaintsDAO dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	@Override
	public List<ComplaintsVO> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	public ComplaintsVO view(int no) {
		// TODO Auto-generated method stub
		return dao.view(no);
	}

	@Override
	public int insert(ComplaintsVO vo) {
		// TODO Auto-generated method stub
		return dao.insert(vo);
	}

	@Override
	public int update(ComplaintsVO vo) {
		// TODO Auto-generated method stub
		return dao.update(vo);
	}

	@Override
	public int delete(int no) {
		// TODO Auto-generated method stub
		return dao.delete(no);
	}

}
