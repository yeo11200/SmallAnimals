package com.smallanimals.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smallanimals.member.dao.MemberDAO;
import com.smallanimals.member.vo.MemberVO;



@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	private PasswordEncoder passwordEncoder;
		
	//회원 가입
	@Override
	public void registerMember(MemberVO vo) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		
		vo.setUserPhone(vo.getUserPhone()+vo.getUserPhone1()+vo.getUserPhone2());
		vo.setUserRegdate(vo.getYy()+vo.getMm()+vo.getDd());
		System.out.println("비밀번호와 날짜 더해진 값  : " + vo);
		
		System.out.println("들어와진 값의 비밀번호 : " + vo.getUserPwd());
		
		vo.setUserPwd(passwordEncoder.encode(vo.getUserPwd()));
		System.out.println("인코딩 이후의 비밀번호 내용 : "+ passwordEncoder.encode(vo.getUserPwd()));
		
		
		//권한부여
		if(vo.getUserRole()==null) {
			vo.setUserRole("ROLE_USER");
			}
			memberDAO.registerMember(vo);
	}

	//회원정보 수정시 정보 값 불러오기
	@Override
	public MemberVO memberInfo(String userId) {
		return memberDAO.memberInfo(userId);
	}
	
	//아이디 체크
	@Override
	public MemberVO idCheck(String userId) throws Exception {
		System.out.println("MemberServiceImpl 실행합니다~~~~~~~~~~~~~~~~~~~~~~~"+userId);
		return memberDAO.idCheck(userId);
	}
	//멤버 정보 수정
	@Override
	public void memberUpdate(MemberVO vo) {
		System.out.println("MemberServiceImpl 구간" + vo);
		 memberDAO.memberUpdate(vo);
	}
	//회원 탈퇴
	@Override
	public void memberDelete(MemberVO vo) throws Exception {
		System.out.println("MemberServiceImpl 구간" + vo);
		 memberDAO.memberDelete(vo);
	}
}