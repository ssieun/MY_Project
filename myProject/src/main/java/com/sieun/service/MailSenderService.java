package com.sieun.service;

import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {

	@Autowired
	private JavaMailSender mailSender;
	   

	// 회원가입 발송 이메일(인증키 발송)
	public String mailSendWithUserKey(String memberEmail) {
		  //인증 번호 생성기
	    String temp ="";
	    Random rnd = new Random();
	    
	    for(int i=0;i<10;i++){
	        int rIndex = rnd.nextInt(3);
	        switch (rIndex) {
	        case 0:
	            // a-z
	            temp+=((char) ((int) (rnd.nextInt(26)) + 97));
	            break;
	        case 1:
	            // A-Z
	            temp+=((char) ((int) (rnd.nextInt(26)) + 65));
	            break;
	        case 2:
	            // 0-9
	            temp+=((rnd.nextInt(10)));
	            break;
	        }
	    }
	    System.out.println(temp);
	    
	    try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,true, "UTF-8");

			messageHelper.setFrom("we0014@naver.com"); // 보내는사람 생략하면 정상작동을 안함
			messageHelper.setTo(memberEmail+".com"); // 받는사람 이메일
			messageHelper.setSubject("[인증번호]sieun사이트 인증메일입니다."); // 메일제목은 생략이 가능하다
			messageHelper.setText("인증번호는 [" +temp+ "] 입니다. 정확히 입력해주세요."); // 메일 내용

			mailSender.send(message);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return temp;
		
	}
	
}
