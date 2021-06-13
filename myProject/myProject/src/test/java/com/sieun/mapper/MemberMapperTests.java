package com.sieun.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sieun.domain.MemberVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberMapperTests {
	
	@Setter(onMethod_=@Autowired)
	private MemberMapper mapper;
	
	/*@Test
	public void testSignUp() {
		MemberDTO member= new MemberDTO();
		member.setMemberName("시은");
		member.setMemberId("siee");
		member.setMemberPw("1234");
		member.setMemberEmail("eeee");
		mapper.signUp(member);
		log.info("signup:");
		log.info(member);
	
	}*/
	
	/*@Test
	public void testCheckId() {
		mapper.checkId("si");
		log.info("checkId..");
	}*/
	
/*	@Test
	public void testcheckEmail() {
		mapper.checkEmail("eeee");
		log.info("checkEmail..");
	}*/
	
	/*@Test
	public void testLogin() {
		MemberDTO member= new  MemberDTO();
		member.setMemberId("siee");
		member.setMemberPw("1234");
		mapper.login(member);
		log.info("sign Up...");
	}
*/
	
/*	@Test
	public void testFindId() {
		MemberDTO member= new  MemberDTO();
		member.setMemberName("시은");
		member.setMemberEmail("eeee");
		mapper.findId(member);
		log.info("FindId...");
	}
	*/
	
	/*@Test
	public void testFindpw() {
		MemberDTO member= new  MemberDTO();
		member.setMemberName("시은");
		member.setMemberEmail("eeee");
		member.setMemberId("siee");
		mapper.findId(member);
		log.info("FindPw...");
	}*/
	
	@Test
	public void testnewPw() {
		String memberId="siee";
		String memberPw="1234";
		mapper.newPw(memberId, memberPw);
		log.info("newPw");
	}
	
	
}
