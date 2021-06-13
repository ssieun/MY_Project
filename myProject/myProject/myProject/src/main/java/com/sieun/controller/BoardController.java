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
	
		//��ü �Խù� �������� 
		@GetMapping("/list")
		public void list(Criteria cri,Model model) {
			log.info("getlist......");
			model.addAttribute("list",service.getList(cri));
			model.addAttribute("pageMaker", new PageDTO(cri, service.getTotal(cri))); //keyword�� null�̸� �׳� ��ü������ ����
		}
		
		//Ư�� �Խù� �������� 
		@GetMapping({"/get","/modify"})
		public void get(@RequestParam("boardNum") Long boardNum,Criteria cri,Model model) {
			log.info("get...."+boardNum);
			model.addAttribute("board", service.get(boardNum));
			model.addAttribute("cri",cri);
		}
		
		//�Խñ� �ۼ� Ŭ��
		@GetMapping("/insert")
		public void insert(@ModelAttribute("cri")Criteria cri) {log.info(cri);}
		
		//�Խñ� �ۼ�
		@PostMapping("/insert")
		public String insert(BoardDTO board, RedirectAttributes rttr) {
			log.info("insert.....");
			service.register(board);
			
			rttr.addFlashAttribute("result",board.getBoardNum());
			return "redirect:/board/list";
		}
		
		//�Խñ� ���� 
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
		
		//�Խñ� ���� ->������ �Ϸ�Ǹ� ����Ʈ�� ���� ���� �ƴ϶� get���� ������...
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
