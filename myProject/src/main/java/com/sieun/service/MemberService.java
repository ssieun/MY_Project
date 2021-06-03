package com.sieun.service;

import com.sieun.domain.MemberDTO;

public interface MemberService {

	//ȸ������
	public void sieunUp(MemberDTO member);
	
	//���̵� �ߺ�üũ 
	public boolean checkId(String memberId);
	
	//�̸��� �ߺ� üũ
	public boolean checkEmail(String memberEmail);
	
	//�α���
	public boolean login(String memberId, String memberPw);
	
	//���̵� ã��
	public String findId(MemberDTO member);
	
	//��й�ȣ ã��-�ӽú�й�ȣ�� ��������
	public boolean findPw(MemberDTO member);
	
	//�ӽú�й�ȣ �߱޽� ��й�ȣ ������Ʈ
	public void newPw(String memberId, String memberPw);
	
}
