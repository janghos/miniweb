package dev.jang.mini.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dev.jang.mini.VO.TestVO;

@Repository
public class TestDAO {

	// mybatis의 SqlSession 객체를 스프링에서 주입
	// 의존관계 주입 느슨한 결합, 제어의 역전
	// @Inject 어노테이션이 있어 SqlSession 은 null 상태가아닌 외부에서 객체 주입 받는 형태

	@Autowired
	SqlSession sqlSession;
	
	public List<TestVO> testList() {
		return sqlSession.selectList("test.testList");
	}

}
