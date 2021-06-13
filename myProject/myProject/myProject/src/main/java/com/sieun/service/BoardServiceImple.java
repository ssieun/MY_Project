package com.sieun.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sieun.domain.BoardDTO;
import com.sieun.domain.Criteria;
import com.sieun.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImple implements BoardService{
	
	private BoardMapper mapper;

	@Override
	public List<BoardDTO> getList(Criteria cri) {
		log.info("getList...!");
		return mapper.boardList(cri);
	}

	@Override
	public BoardDTO get(Long boardNum) {
		log.info("get...");
		return mapper.get(boardNum);
	}

	@Override
	public void register(BoardDTO board) {
		log.info("register...");
		mapper.insertSeleteKey(board);
			
	}

	@Override
	public boolean modify(BoardDTO board) {
		log.info("modify...");
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long boardNum) {
		log.info("remove..");
		return mapper.delete(boardNum)==1;
	}

	@Override
	public int getTotal(Criteria cri) {
		log.info("getTotal...");
		return mapper.getTotal(cri);
	}

	@Override
	public List<BoardDTO> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

}
