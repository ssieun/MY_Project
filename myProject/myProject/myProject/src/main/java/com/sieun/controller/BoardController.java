package com.sieun.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sieun.domain.BoardDTO;
import com.sieun.domain.Criteria;
import com.sieun.domain.PageDTO;
import com.sieun.mapper.BoardMapper;
import com.sieun.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
	
		private BoardService service;
	
		//전체 게시물 가져오기 
		@GetMapping("/list")
		public void list(Criteria cri,Model model) {
			log.info("getlist......");
			model.addAttribute("list",service.getList(cri));
			model.addAttribute("pageMaker", new PageDTO(cri, service.getTotal(cri))); //keyword가 null이면 그냥 전체갯수가 나옴
		}
		
		//특장 게시물 가져오기 
		@GetMapping({"/get","/modify"})
		public void get(@RequestParam("boardNum") Long boardNum,Criteria cri,Model model) {
			log.info("get...."+boardNum);
			model.addAttribute("board", service.get(boardNum));
			model.addAttribute("cri",cri);
		}
		
		//게시글 작성 클릭
		@GetMapping("/insert")
		public void insert(@ModelAttribute("cri")Criteria cri) {log.info(cri);}
		
		//게시글 작성
		@PostMapping("/insert")
		public String insert(BoardDTO board, RedirectAttributes rttr) {
			log.info("insert.....");
			service.register(board);
			
			rttr.addFlashAttribute("result",board.getBoardNum());
			return "redirect:/board/list";
		}
		
		//게시글 삭제 
		@GetMapping("/remove")
		public String remove(@RequestParam("boardNum")Long boardNum,Criteria cri,RedirectAttributes rttr) {
			log.info("remove....");
			
			if(service.remove(boardNum)) {
				rttr.addFlashAttribute("result","success");
			}
			
			rttr.addAttribute("pageNum",cri.getPageNum());
			rttr.addAttribute("amount",cri.getAmount());
			rttr.addAttribute("keyword", cri.getKeyword());
			rttr.addAttribute("type", cri.getType());
			return "redirect:/board/list";
		}
		
		//게시글 수정 ->수정이 완료되면 리스트로 가는 것이 아니라 get으로 가도록...
		@PostMapping("/modify")
		public String modify(BoardDTO board,Criteria cri,RedirectAttributes rttr) {
			
			if(service.modify(board)) {
				rttr.addAttribute("result","success");
			}
			
			
			rttr.addAttribute("pageNum", cri.getPageNum());
			rttr.addAttribute("amount",cri.getAmount());
			rttr.addAttribute("keyword", cri.getKeyword());
			rttr.addAttribute("type", cri.getType());
			
			return "redirect:/board/get";
		}
		
}
