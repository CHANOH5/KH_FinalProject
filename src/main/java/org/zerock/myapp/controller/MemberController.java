package org.zerock.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

//import org.apache.maven.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.myapp.mapper.MemberMapper;
import org.zerock.myapp.service.MailSendService;
import org.zerock.myapp.service.MemberService;
import org.zerock.myapp.service.MsgSendService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RequestMapping("/login/*") 
@Controller
public class MemberController {
	// 아이디 찾기, 비밀번호 변경을 위한 컨트롤러
	// 각각 인증 방식으로는 휴대폰 인증과 이메일 인증이 존재함
	
	// 아이디 찾기 - 이름이랑 전화번호로 회원 정보가 존재하는지 확인
	@Setter(onMethod_=@Autowired)
	private MemberService memberService;
	
	// 아이디 찾기 - 휴대폰 인증 번호!
	@Setter(onMethod_ = { @Autowired })
	MsgSendService msgSendService;
	
	// 아이디 찾기 - 결과 반환
	@Autowired
	private MemberMapper memberMapper;
	
	// 이메일 인증
	@Inject
	MailSendService mailSendService;
	
//	---------------------- 휴대폰 인증 ----------------------------------------------------------------------------------------------
	
	// [핸드폰] 아이디 찾기 - DB에 회원 정보(이름, 전화번호) 존재하는 지 확인
	@PostMapping("/findid/idCheck")
	public @ResponseBody int idCheck(@RequestParam("name") String name, @RequestParam("tel") String tel) throws Exception {
		log.trace("사용자가 입력한 값: idCheck({}, {}) activated.", name, tel);
		
		int cntIdCheck = memberService.idCheck(name, tel);
		
		log.trace("아이디 중복 확인: cntIdCheck : ({})" , cntIdCheck);
		
		return cntIdCheck;
		
	} // idCheck()
	
	
	// [핸드폰] 아이디 찾기 - 핸드폰 번호 인증
	@GetMapping("/findid/telCheck")
	public @ResponseBody String sendSMS(@RequestParam("tel") String userPhoneNumber) {				// 문자 보내기
		int randomNumber = (int)((Math.random() * 8999 ) + 1000 );									// 난수 1000 ~ 9999 생성
		
		msgSendService.msgSend(userPhoneNumber, randomNumber);
		
		log.trace("userPhoneNumber : {} , ramdomNumber : {}  " , userPhoneNumber, randomNumber );
		
		return Integer.toString(randomNumber);
		
	} // msgSend()
	
	
	// [핸드폰] 아이디 찾기 인증 결과 반환
	@PostMapping("/findid/result")
	@ResponseBody
	public String findIdResult(@RequestParam("name") String name, @RequestParam("tel") String tel) {

	    String foundId = memberMapper.findIdResult(name, tel);
	    
	    return foundId;
	
	} // findIdResult()
	
//	---------------------- 이메일 인증 ----------------------------------------------------------------------------------------------
	
	// [이메일] 아이디 찾기 - DB에 회원 정보(이름, 이메일) 존재하는 지 확인
	@PostMapping("/findid/idCheck_e")
	public @ResponseBody int idCheck_e(@RequestParam("name") String name, @RequestParam("email") String email) throws Exception {
		log.trace("사용자가 입력한 값: idCheck_e({}, {}) activated.", name, email);
		
		int cntIdCheck_e = memberService.idCheck_e(name, email);
		
		log.trace("아이디 중복 확인: cntIdCheck_e : ({})" , cntIdCheck_e);
		
		return cntIdCheck_e;
		
	} // idCheck_e()
	
	
	// [이메일] 이메일 인증
	@RequestMapping("/login/mailAuth")
	@ResponseBody
	public String mailAuth(String mail, HttpServletResponse resp) throws Exception {
	    
		// 사용자의 이메일 주소로 메일 보냄!
		String authKey = mailSendService.sendAuthMail(mail);
	    
		// 인증키
	    return authKey;
	    
	} // mailAuth()
	
} // end class