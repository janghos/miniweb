package dev.jang.mini.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.jang.mini.DAO.MemberDAO;
import dev.jang.mini.Service.MemberService;
import dev.jang.mini.VO.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDAO memberDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public List<MemberVO> memberList() {
		return memberDao.memberList();	
	}
	@Override
	public void insertMember(MemberVO vo) {
		vo.setMe_pw(passwordEncoder.encode(vo.getMe_pw()));
		memberDao.insertMember(vo);
		// TODO Auto-generated method stub	
	}
	@Override
	public int checkId(String id) {
		int result = 0;
		
		result = memberDao.checkId(id);
		return result;
	}
	@Override
	public int checkEmail(String email) {
		int result = 0;
		
		result = memberDao.checkEmail(email);
		return result;
	}
}
