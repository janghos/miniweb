package dev.jang.mini.Service;

import java.util.List;
import java.util.Map;

import org.springframework.validation.Errors;

import dev.jang.mini.VO.MemberVO;

public interface MemberService {
	public List<MemberVO> memberList();
	public void insertMember(MemberVO vo);
	public int checkId(String id);
	public int checkEmail(String email);
	public Map<String, String> validateHandling(Errors errors);
}
