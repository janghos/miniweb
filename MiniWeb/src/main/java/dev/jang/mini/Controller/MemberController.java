package dev.jang.mini.Controller;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping("/join")
	public String join() {
		return "/member/join";
	}

	@RequestMapping(value = "/joingo", method = RequestMethod.POST)
	public String insert(@ModelAttribute @Valid MemberVO vo, Errors errors, Model model) {
		List<MemberVO> memberNo;
		char ch = 'F';
		String meNo;
		int i = 0;
		String zero = null;
		String formatGap = null;
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int date = cal.get(Calendar.DATE);
		
		//날짜
		String today = year +""+"0"+month+""+date;
		
		int lastIndex = memberService.memberList().size();
		//번호 
			
		if(lastIndex + 1 < 100000) {
			ch = 'A';
			i = lastIndex;
		}
		else if(lastIndex + 1 < 200000) {
			ch = 'B';
			i = lastIndex - 199999 ;
		}
		
		String setMeno = "CU" + today + ch +  String.format("%05d", i); 
		vo.setMe_no(setMeno);
		
		
	
		
		if (errors.hasErrors()) {
			model.addAttribute("vo", vo);
			Map<String, String> validatorResult = memberService.validateHandling(errors);
			for (String key : validatorResult.keySet()) {
				model.addAttribute(key, validatorResult.get(key));
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