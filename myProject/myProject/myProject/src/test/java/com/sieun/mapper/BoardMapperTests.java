package com.sieun.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sieun.domain.BoardDTO;
import com.sieun.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {
	
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
	
	@Test
	public void testGetList() {
		Criteria cri=new Criteria(1,10);
		mapper.boardList(cri).forEach(board -> log.info(board));
	}

/*	@Test
	public void testInsert() {
		BoardDTO board= new  BoardDTO();
		
		board.setBoardTitle("새로운 제목");
		board.setBoardContent("새로운 내용");
		board.setMemberId("sie");
		mapper.insertSeleteKey(board);
		
		log.info(board);
	}*/
	
/*	@Test
	public void testGet() {
		Long boardNum=8L;
		log.info(boardNum);
		
	}*/
	
	/*@Test
	public void testDelte() {
		Long boardNum =8L;
		log.info(mapper.delete(boardNum));
	}*/
/*	
	@Test
	public void testUpdate() {
		BoardDTO board= new BoardDTO();
		
		board.setBoardTitle("수정하는 제목");
		board.setBoardContent("수정하는 게시글 내용");
		board.setBoardNum(7L);
		
		log.info(mapper.update(board));
	}*/
}
