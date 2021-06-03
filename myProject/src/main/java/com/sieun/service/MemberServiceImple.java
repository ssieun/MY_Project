package com.sieun.service;

import org.springframework.stereotype.Service;

import com.sieun.domain.MemberDTO;
import com.sieun.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class MemberServiceImple implements MemberService {

	private MemberMapper mapper;

	public String encry(String memberPw) {
		String en_pw="";
		for (int i = 0; i < memberPw.length(); i++) {
			en_pw+=(char)memberPw.charAt(i)*3;
		}
		return en_pw;
	}

	@Override
	public void sieunUp(MemberDTO member) {
		log.info("sign up...");
		member.setMemberPw(encry(member.getMemberPw()));
		 mapper.signUp(member);
	}

	@Override
	public boolean checkId(String memberId) {
		log.info("check Id");
		//1 : 중복  0: 가능
		return mapper.checkId(memberId) == 1;
	}

	@Override
	public boolean checkEmail(String memberEmail) {
		log.info("checkEmail....");
		//1 : 중복  0: 가능
		return mapper.checkEmail(memberEmail)==1; 
	}

	@Override
	public boolean login(String memberId, String memberPw) {
		log.info("login...");
		//1:로그인 가능     0: 로그인 불가능
		//member.setMemberPw(encry(member.getMemberPw()));
		return mapper.login(memberId, memberPw)==1;
	}

	@Override
	public String findId(MemberDTO member) {
		log.info("find Id...");
		return mapper.findId(member);
	}

	@Override
	public boolean findPw(MemberDTO member) {
		log.info("find pw.....");
		return mapper.findPw(member)==1;
	}

	@Override
	public void newPw(String memberId, String memberPw) {
		log.info("new pw...");
		mapper.newPw(memberId, memberPw);
		
	}

}
