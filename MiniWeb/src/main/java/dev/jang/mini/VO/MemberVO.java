package dev.jang.mini.VO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class MemberVO {
	private int me_no;
	
	@NotBlank(message = "이름은 필수 입력 값입니다.")
    @Length(min=2, max=5)
	private String me_name;
	
	@NotEmpty
	private String me_id;
	
	@NotEmpty
	@Pattern(regexp="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}")
	private String me_pw;
	
	@NotEmpty
	private String me_phone;
	private String me_email;
	private String me_adnum;
	private String me_ad;
	private String me_addt;
	private String me_delyn;
	private String regdate;
}
