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
	   

	// ȸ������ �߼� �̸���(����Ű �߼�)
	public String mailSendWithUserKey(String memberEmail) {
		  //���� ��ȣ ������
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

			messageHelper.setFrom("we0014@naver.com"); // �����»�� �����ϸ� �����۵��� ����
			messageHelper.setTo(memberEmail+".com"); // �޴»�� �̸���
			messageHelper.setSubject("[������ȣ]sieun����Ʈ ���������Դϴ�."); // ���������� ������ �����ϴ�
			messageHelper.setText("������ȣ�� [" +temp+ "] �Դϴ�. ��Ȯ�� �Է����ּ���."); // ���� ����

			mailSender.send(message);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return temp;
		
	}
	
}
