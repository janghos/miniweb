package dev.jang.mini.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.jang.mini.Service.TestService;
import dev.jang.mini.VO.TestVO;

@Controller
public class TestController {
	//MemberService의 인스턴스 주입
	@Autowired
	TestService testService;
	
	@RequestMapping("/list")
	public String testList(Model model) {		
		List<TestVO> list = testService.testList();
		model.addAttribute("list", list);
		
		return "list_test";
	}
	
}
