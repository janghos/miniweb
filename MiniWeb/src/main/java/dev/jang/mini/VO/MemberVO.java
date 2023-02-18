package dev.jang.mini.VO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class MemberVO {
	private String me_no;
	
	@NotBlank(message = "이름은 필수 입력 값입니다.")
    @Length(min=2, max=5, 
    message ="2~5글자입력해라")
	private String me_name;
	
	@NotBlank(message = "아이디는 필수 입력 값입니다.")
	private String me_id;
	
	@NotBlank(message = "비밀번호는 필수 입력 값입니다.")
	@Pattern(regexp="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}",
			message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.")
	private String me_pw;
	
	private String me_phone;
	
	@NotBlank(message = "이메일은 필수 입력 값입니다.")
	@Email(message = "이메일 형식에 맞지 않습니다.")
	private String me_email;
	
	private String me_adnum;
	private String me_ad;
	private String me_addt;
	private String me_delyn;
	private String regdate;
}
