package com.sieun.service;

import java.util.List;

import com.sieun.domain.BoardVO;
import com.sieun.domain.Criteria;

public interface BoardService {
	
	public List<BoardVO> getList();
	//�Խù�����Ʈ
	public List<BoardVO> getList(Criteria cri);
	
	//Ư���Խù� ��������
	public BoardVO get(Long boardNum);
	
	//�Խñ� �ۼ�
	public void register(BoardVO board);
	
	//�Խñ� ����
	public boolean modify(BoardVO board);
	
	//�Խñ� ����
	public boolean remove(Long boardNum);
	
	
	//��ü �Խù� ����
	public int getTotal(Criteria cri);
	
}
