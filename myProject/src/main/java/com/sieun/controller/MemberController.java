package com.sieun.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sieun.domain.MemberDTO;
import com.sieun.service.MailSenderService;
import com.sieun.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/member/*")
public class MemberController {
	
	private MemberService service;
	private MailSenderService sender;
	
	//회원가입 메뉴로 가기 
	@GetMapping("/signup")
	public void signUp() {}
	
	
	//회원가입 완료시 
	@PostMapping("/signup")
	public String signUp(MemberDTO member){
		log.info("signup....");
		service.sieunUp(member);
		
		return "redirect:/member/login";
				
	}
	
	//아이디 중복 검사
	@ResponseBody
	@GetMapping(value="/checkId/{memberId}", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> checkId(@PathVariable("memberId")String memberId) {
		log.info("checkId.....");
		String result="";
		if(service.checkId(memberId)) {
			//중복된 아이디
			result="ok";
		}else {
			//사용가능한 
			result="no";
		}
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	
	@ResponseBody
	@GetMapping(value="/checkEmail/{memberEmail}")
	public ResponseEntity<String>checkEmail(@PathVariable("memberEmail")String memberEmail){
		log.info("checkEmail...");
		String code="";
		String result="";	
		if(service.checkEmail(memberEmail)) {
			//이메일 중복
			result="no"; 
		}else {
			//사용가능
			code=sender.mailSendWithUserKey(memberEmail);
			result=code;
		}
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	

	@GetMapping("login") 
	public void login() {}
	
	//로그인
	@PostMapping("/login")
	public String login(String memberId, String memberPw) {
		log.info("login controller");
		String result="";
		
		return "redirect:/member/login";
				
	}
	
	
	//카카오 로그인
	@RequestMapping("/kakaologin")
	public String kakao(@RequestParam(value="code", required=false) String code)throws Exception {
		log.info("kakaoCode : " + code);
		return "signup";
	}
	
	
	
	
}
