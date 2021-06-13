package com.sieun.controller;

		



import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.sieun.domain.MemberVO;
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
	
	//ȸ������ �޴��� ���� 
	@GetMapping("/signup")
	public void signUp() {}
	
	
	//ȸ������ �Ϸ�� 
	@PostMapping("/signup")
	public String signUp(MemberVO member){
		log.info("signup....");
		service.sieunUp(member);
		
		return "redirect:/member/login";
				
	}
	
	//���̵� �ߺ� �˻�
	@ResponseBody
	@GetMapping(value="/checkId/{memberId}", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> checkId(@PathVariable("memberId")String memberId) {
		log.info("checkId.....");
		String result="";
		if(service.checkId(memberId)) {
			//�ߺ��� ���̵�
			result="ok";
		}else {
			//��밡���� 
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
			//�̸��� �ߺ�
			result="no"; 
		}else {
			//��밡��
			code=sender.mailSendWithUserKey(memberEmail);
			result=code;
		}
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	

	@GetMapping("/login") 
	public void login() {}
	
	//�α���
	@ResponseBody
	@PostMapping(value="/login", consumes="application/json")
	public String login(@RequestBody MemberVO member) {
		log.info("login controller");
		log.info(member.getMemberId());
		log.info(member.getMemberPw());
		String result="";
		if(service.login(member)) {
			log.info("����?");
			result= "redirect:/index";
		}else {
			result= "no";
		}
		return result;
	}
	

	
	@ResponseBody
	@GetMapping(value="/kakaoCheck/{kakaoId}",produces= {MediaType.TEXT_PLAIN_VALUE})
	public String kakaoCheck(@PathVariable("kakaoId")String kakaoId) {
		log.info("kakaoLogin ,,,,check");
		
		//īī���α������� ȸ������  ��������
		if(service.kakaoLogin(kakaoId)) {
			log.info("�������� ����");
			return "redirect:/index";
		}else {
			return "no";
		}
		
	}	
	
	//īī�� ȸ������
	@GetMapping("/kakao")
	public String kakao(@RequestParam("kakaoId")String kakaoId, @RequestParam("kakaoName")String kakaoName, Model model) {
		log.info("īī���α���");
		model.addAttribute("kakaoId",kakaoId);
		model.addAttribute("kakaoName",kakaoName);
		log.info(kakaoId);
		log.info(kakaoName);
	
		return "redirect:/member/kakaoSignup";
	}
	
	@GetMapping("kakaoSignup")
	public void kakaoSignUp() {}
	
	@PostMapping("/kakaoSignup")
	public String kakaoSignUp(MemberVO member) {
		service.kakao(member);
		
		return "redirect:/member/login";
	}
	
	
	@GetMapping("/find")
	public void find() {}
	
	
	
}
