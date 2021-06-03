package com.sieun.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@WebAppConfiguration //webApplication을 직접 만들기 위해서 쓴다 Servlet의 ServletContext를 이용하기 위함
@ContextConfiguration({
	   "file:src/main/webapp/WEB-INF/spring/root-context.xml",
	   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" 
	   //WebAppConfiguration를 추가했을  servlet-context.xml도 따로 추가해주어야 한다.
	})
public class BoardControllerTest {
	
	@Setter(onMethod_=@Autowired)
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	
	@Before //모든 테스트전에 실행된다
	public void setup() {
		this.mockMvc=MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
/*	@Test
	public void testgetList() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")
				.param("pageNum", "1")
				.param("amount", "10"))
				.andReturn() //응답된 결과값을 통해
				.getModelAndView() //model에 어떤 데이터가 담겨있는지를
				.getModelMap()); //map형식으로 확인 
	}*/
	
	/*
	@Test
	public void testGet() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
				.param("boardNum", "7"))
				.andReturn().getModelAndView().getModelMap());
	}*/

	//게시글 작성
	@Test
	public void testInsert() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/insert")
				.param("memberId", "sie")
				.param("boardTitle", "자바 배열")
				.param("boardContent", "배열은 인덱스가 있습니당")
				.param("category","java"))
				.andReturn().getModelAndView().getModelMap());
	}
	
	
	/*//게시글 삭제 
	@Test
	public void testDelte() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/remove")
					.param("boardNum", "20"))
				.andReturn().getModelAndView().getModelMap());
	}*/
	
	//게시글 수정 
	/*@Test
	public void testModify() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
				.param("boardTitle", "수정하는 제목")
				.param("boardContent", "수정하는 내용")
				.param("boardNum", "9"))
				.andReturn().getModelAndView().getModelMap());
	}*/
}	
