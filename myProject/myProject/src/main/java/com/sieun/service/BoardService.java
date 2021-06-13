package com.sieun.service;

import java.util.List;

import com.sieun.domain.BoardVO;
import com.sieun.domain.Criteria;

public interface BoardService {
	
	public List<BoardVO> getList();
	//게시물리스트
	public List<BoardVO> getList(Criteria cri);
	
	//특정게시물 가져오기
	public BoardVO get(Long boardNum);
	
	//게시글 작성
	public void register(BoardVO board);
	
	//게시글 수정
	public boolean modify(BoardVO board);
	
	//게시글 삭제
	public boolean remove(Long boardNum);
	
	
	//전체 게시물 갯수
	public int getTotal(Criteria cri);
	
}
