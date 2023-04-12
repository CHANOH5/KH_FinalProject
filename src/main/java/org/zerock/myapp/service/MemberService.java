package org.zerock.myapp.service;

import org.zerock.myapp.domain.LoginDTO;
import org.zerock.myapp.domain.MemberVO;
import org.zerock.myapp.exception.ServiceException;

public interface MemberService {
	
	// 회원가입 혁규
	public void memberSignup(MemberVO memberVO) throws Exception;
	
	// 로그인 셍나
    public LoginDTO memberLogin(LoginDTO loginDTO) throws ServiceException;
	
} // end class
