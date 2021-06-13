package com.sieun.service;

import com.sieun.domain.MemberVO;

public interface MemberService {

	//회원가입
	public void sieunUp(MemberVO member);
	
	//아이디 중복체크 
	public boolean checkId(String memberId);
	
	//이메일 중복 체크
	public boolean checkEmail(String memberEmail);
	
	//로그인
	public boolean login(MemberVO member);
	
	//아이디 찾기
	public String findId(MemberVO member);
	
	//비밀번호 찾기-임시비밀번호로 수정까지
	public boolean findPw(MemberVO member);
	
	//임시비밀번호 발급시 비밀번호 업데이트
	public void newPw(String memberId, String memberPw);
	
	//카카오최초 로그인인지 확인
	public boolean kakaoLogin(String kakaoId);

	//카카오 회원가입
	public void kakao(MemberVO member);


}
