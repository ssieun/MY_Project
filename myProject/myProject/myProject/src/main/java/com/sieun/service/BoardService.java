package com.sieun.service;

import java.util.List;

import com.sieun.domain.BoardDTO;
import com.sieun.domain.Criteria;

public interface BoardService {
	
	public List<BoardDTO> getList();
	//�Խù�����Ʈ
	public List<BoardDTO> getList(Criteria cri);
	
	//Ư���Խù� ��������
	public BoardDTO get(Long boardNum);
	
	//�Խñ� �ۼ�
	public void register(BoardDTO board);
	
	//�Խñ� ����
	public boolean modify(BoardDTO board);
	
	//�Խñ� ����
	public boolean remove(Long boardNum);
	
	
	//��ü �Խù� ����
	public int getTotal(Criteria cri);
	
}
