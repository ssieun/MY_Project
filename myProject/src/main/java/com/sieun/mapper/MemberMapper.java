package com.sieun.mapper;

import org.apache.ibatis.annotations.Param;

import com.sieun.domain.MemberDTO;

public interface MemberMapper {
	
	
	//회원가입
	public void signUp(MemberDTO member);
	
	//아이디 중복체크 
	public int checkId(String memberId);
	
	//이메일 중복 체크
	public int checkEmail(String memberEmail);
	
	//로그인
	public int login(String memberId, String memberPw);
	
	//아이디 찾기
	public String findId(MemberDTO member);
	
	//비밀번호 찾기-임시비밀번호로 수정까지
	public int findPw(MemberDTO member);
	
	//임시비밀번호 발급시 비밀번호 업데이트
	public void newPw(@Param("memberId")String memberId,@Param("memberPw") String memberPw );
}
