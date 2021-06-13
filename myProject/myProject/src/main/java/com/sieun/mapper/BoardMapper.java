package com.sieun.mapper;

import java.util.List;

import com.sieun.domain.BoardVO;
import com.sieun.domain.Criteria;

public interface BoardMapper {
	
	//전제 리스트 개숫 
	public List<BoardVO> getList();

	//전페리스트 (페이징 처리)
	public List<BoardVO> boardList(Criteria cri);
	
	//게시물 등록
	public void insertSeleteKey(BoardVO board);
	
	//특정 게시글 가져오기 
	public BoardVO get(Long boardNum);
	
	//게시글 삭제 
	public int delete(Long boardNum);
	
	//게시글 수정
	public int update(BoardVO board);
	
	//게시굴 총 갯수 ->cri에 있는 keyword와 type가 null이면 그냥 게시물 전체 갯수가 나온다
	public int getTotal(Criteria cri);
	
}
