package com.sieun.mapper;

import java.util.List;

import com.sieun.domain.BoardVO;
import com.sieun.domain.Criteria;

public interface BoardMapper {
	
	//���� ����Ʈ ���� 
	public List<BoardVO> getList();

	//���丮��Ʈ (����¡ ó��)
	public List<BoardVO> boardList(Criteria cri);
	
	//�Խù� ���
	public void insertSeleteKey(BoardVO board);
	
	//Ư�� �Խñ� �������� 
	public BoardVO get(Long boardNum);
	
	//�Խñ� ���� 
	public int delete(Long boardNum);
	
	//�Խñ� ����
	public int update(BoardVO board);
	
	//�Խñ� �� ���� ->cri�� �ִ� keyword�� type�� null�̸� �׳� �Խù� ��ü ������ ���´�
	public int getTotal(Criteria cri);
	
}
