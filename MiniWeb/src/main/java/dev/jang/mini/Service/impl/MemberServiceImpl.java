package dev.jang.mini.Service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

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
	@Override
	public Map<String, String> validateHandling(Errors errors) {
		Map<String, String> validatorResult = new HashMap<>();

		for (FieldError error : errors.getFieldErrors()) {
			String validKeyName = String.format("valid_%s", error.getField());
			validatorResult.put(validKeyName, error.getDefaultMessage());
		}

		return validatorResult;
	}
}
