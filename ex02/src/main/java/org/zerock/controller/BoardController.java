package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {

	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		System.out.println("Controller List ȣ��");
		log.info("list");
		log.info("===============pageNum      :" + cri.getPageNum());
		log.info("===============pageKeyword  :" + cri.getKeyword());
		model.addAttribute("list" , service.getList(cri));
		//model.addAttribute("pageMaker", new PageDTO(cri, 23));
		
		int total = service.getTotal(cri);
		
		model.addAttribute("pageMaker" , new PageDTO(cri, total));
	}
	
	
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		service.register(board);
		
		rttr.addFlashAttribute("result" , board.getBno());
		return "redirect:/board/list";
		
	}
	
	
	@GetMapping({"/get" , "/modify"})
	public void get(@RequestParam("bno") Long bno , @ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("board" , service.get(bno));
	}
	  
   
	@PostMapping("/modify")
	public String modify(BoardVO board , @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {

		log.info("==================modify:" + board);
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type",   cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list";
	}  
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno ,  @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {

		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		  
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount",  cri.getAmount());
		rttr.addAttribute("type",    cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		
		return "redirect:/board/list";
	}  
	
}
