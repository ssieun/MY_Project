package com.sieun.mapper;

import org.apache.ibatis.annotations.Param;

import com.sieun.domain.MemberDTO;

public interface MemberMapper {
	
	
	//ȸ������
	public void signUp(MemberDTO member);
	
	//���̵� �ߺ�üũ 
	public int checkId(String memberId);
	
	//�̸��� �ߺ� üũ
	public int checkEmail(String memberEmail);
	
	//�α���
	public int login(MemberDTO member);
	
	//���̵� ã��
	public String findId(MemberDTO member);
	
	//��й�ȣ ã��-�ӽú�й�ȣ�� ��������
	public int findPw(MemberDTO member);
	
	//�ӽú�й�ȣ �߱޽� ��й�ȣ ������Ʈ
	public void newPw(@Param("memberId")String memberId,@Param("memberPw") String memberPw );
	
	//īī������ �α������� Ȯ��
	public int kakaoLogin(String kakaoId);

	//īī�� ȸ������
	public void kakao(MemberDTO member);

}
