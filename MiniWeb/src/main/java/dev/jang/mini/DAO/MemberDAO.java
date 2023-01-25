package dev.jang.mini.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dev.jang.mini.VO.MemberVO;
@Repository
public class MemberDAO {

	
	@Autowired
	SqlSession sqlSession;
	
	public List<MemberVO> memberList(){
		return sqlSession.selectList("member.memberList");
	}
	
	public void insertMember(MemberVO vo) {
		sqlSession.insert("member.insertMember",vo);
	}
	
	public int checkId(String id) {
		return sqlSession.selectOne("member.checkId",id);
	}
	public int checkEmail(String email) {
		return sqlSession.selectOne("member.checkEmail",email);
	}
}
