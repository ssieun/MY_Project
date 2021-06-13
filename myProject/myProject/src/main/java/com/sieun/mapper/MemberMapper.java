package com.sieun.mapper;

import org.apache.ibatis.annotations.Param;

import com.sieun.domain.MemberVO;

public interface MemberMapper {
	
	
	//ȸ������
	public void signUp(MemberVO member);
	
	//���̵� �ߺ�üũ 
	public int checkId(String memberId);
	
	//�̸��� �ߺ� üũ
	public int checkEmail(String memberEmail);
	
	//�α���
	public int login(MemberVO member);
	
	//���̵� ã��
	public String findId(MemberVO member);
	
	//��й�ȣ ã��-�ӽú�й�ȣ�� ��������
	public int findPw(MemberVO member);
	
	//�ӽú�й�ȣ �߱޽� ��й�ȣ ������Ʈ
	public void newPw(@Param("memberId")String memberId,@Param("memberPw") String memberPw );
	
	//īī������ �α������� Ȯ��
	public int kakaoLogin(String kakaoId);

	//īī�� ȸ������
	public void kakao(MemberVO member);

}
