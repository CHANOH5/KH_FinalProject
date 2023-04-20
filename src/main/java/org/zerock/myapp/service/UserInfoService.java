package org.zerock.myapp.service;

import org.zerock.myapp.domain.MemberDTO;
import org.zerock.myapp.exception.ServiceException;


public interface UserInfoService {
	
	//1.회원 상세 조회 (매퍼에서, SELECT)
	public abstract MemberDTO userDetail(String id) throws ServiceException;
	
	//2.회원 정보 수정 (UPDATE) (비밀번호 제외)
	public abstract Boolean updateUser(MemberDTO dto) throws ServiceException;
	
	//3.회원 삭제 (DELETE)
//	public abstract MemberDTO deleteUser(MemberDTO dto) throws ServiceException;
//	public abstract MemberDTO deleteUser(String id) throws ServiceException;
	public abstract Boolean deleteUser(String id) throws ServiceException;

}
