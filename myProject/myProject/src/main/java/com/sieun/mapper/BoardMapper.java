package com.sieun.mapper;

import java.util.List;

import com.sieun.domain.BoardDTO;
import com.sieun.domain.Criteria;

public interface BoardMapper {
	
	//���� ����Ʈ ���� 
	public List<BoardDTO> getList();

	//���丮��Ʈ (����¡ ó��)
	public List<BoardDTO> boardList(Criteria cri);
	
	//�Խù� ���
	public void insertSeleteKey(BoardDTO board);
	
	//Ư�� �Խñ� �������� 
	public BoardDTO get(Long boardNum);
	
	//�Խñ� ���� 
	public int delete(Long boardNum);
	
	//�Խñ� ����
	public int update(BoardDTO board);
	
	//�Խñ� �� ���� ->cri�� �ִ� keyword�� type�� null�̸� �׳� �Խù� ��ü ������ ���´�
	public int getTotal(Criteria cri);
	
}
