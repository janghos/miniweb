package dev.jang.mini.Controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.jang.mini.Service.MemberService;
import dev.jang.mini.VO.MemberVO;

@Controller // 스프링에서 관리하는 컨트롤러 빈으로 등록
@RequestMapping("/member")
public class MemberController {
	// MemberService 인스턴스를 주입시킴
	@Inject
	MemberService memberService;

	@RequestMapping("/list") // url mapping
	public String memberList(Model model) {
		List<MemberVO> list = memberService.memberList();
		model.addAttribute("list", list);
		// WEB-INF/views/member/member_list.jsp로 포워딩
		return "member/memberListPage";
	}

	@RequestMapping("join")
	public String join() {
		return "/member/join";
	}

	@PostMapping("/joingo")
	public String insert(@ModelAttribute @Valid MemberVO vo , BindingResult result) {

		if(result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError error : list) {
			System.out.println(error);
			}
			return "/member/join";
		}
		
		memberService.insertMember(vo);
		
		
		return "redirect:/member/list";
	}

	@RequestMapping("/checkId")
	@ResponseBody
	public String checkId(@RequestParam("me_id") String id) {
		String result = "N";

		int flag = memberService.checkId(id);

		if (flag == 1)
			result = "Y";
		// 아이디가 있을시 Y 없으시 N jsp view로 보냄
		return result;
	}

	@RequestMapping("/checkEmail")
	@ResponseBody
	public String checkEmail(@RequestParam("me_email") String email) {
		String result = "N";

		int flag = memberService.checkEmail(email);

		if (flag == 1)
			result = "Y";
		// 아이디가 있을시 Y 없으시 N jsp view로 보냄
		return result;
	}
}