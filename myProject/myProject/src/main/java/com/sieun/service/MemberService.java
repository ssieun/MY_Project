package com.sieun.service;

import com.sieun.domain.MemberVO;

public interface MemberService {

	//ȸ������
	public void sieunUp(MemberVO member);
	
	//���̵� �ߺ�üũ 
	public boolean checkId(String memberId);
	
	//�̸��� �ߺ� üũ
	public boolean checkEmail(String memberEmail);
	
	//�α���
	public boolean login(MemberVO member);
	
	//���̵� ã��
	public String findId(MemberVO member);
	
	//��й�ȣ ã��-�ӽú�й�ȣ�� ��������
	public boolean findPw(MemberVO member);
	
	//�ӽú�й�ȣ �߱޽� ��й�ȣ ������Ʈ
	public void newPw(String memberId, String memberPw);
	
	//īī������ �α������� Ȯ��
	public boolean kakaoLogin(String kakaoId);

	//īī�� ȸ������
	public void kakao(MemberVO member);


}
