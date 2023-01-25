package dev.jang.mini.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.jang.mini.DAO.TestDAO;
import dev.jang.mini.Service.TestService;
import dev.jang.mini.VO.TestVO;
@Service
public class TestServiceImpl implements TestService {
	//dao 인스턴스 주입
	@Autowired
	TestDAO testDao;
	//회원 목록
	@Override
	public List<TestVO> testList(){
		return testDao.testList();
	}
}
