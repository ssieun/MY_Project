package com.sieun.service;

import com.sieun.domain.MemberDTO;

public interface MemberService {

	//회원가입
	public void sieunUp(MemberDTO member);
	
	//아이디 중복체크 
	public boolean checkId(String memberId);
	
	//이메일 중복 체크
	public boolean checkEmail(String memberEmail);
	
	//로그인
	public boolean login(String memberId, String memberPw);
	
	//아이디 찾기
	public String findId(MemberDTO member);
	
	//비밀번호 찾기-임시비밀번호로 수정까지
	public boolean findPw(MemberDTO member);
	
	//임시비밀번호 발급시 비밀번호 업데이트
	public void newPw(String memberId, String memberPw);
	
}
