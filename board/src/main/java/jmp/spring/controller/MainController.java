package jmp.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jmp.spring.domain.BoardVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@RequiredArgsConstructor
@Log4j
public class MainController {
	
	private final jmp.spring.service.BoardService service;
	
	@GetMapping("/list2")
	public void getList(Model model) {
		log.info("list.........");
		model.addAttribute("list", service.getList());
	}
	
	@GetMapping("/register")
	public String register() {
		log.info("Get register.....");
		return "/board/register";
	}
	
	/*
	 * @PostMapping("/register") public String
	 * registerProccess(@RequestParam("title") String
	 * title, @RequestParam("content") String content, @RequestParam("writer")
	 * String writer) { log.info("post......"); BoardVO board = new BoardVO();
	 * board.setTitle(title); board.setContent(content); board.setWriter(writer);
	 * service.register(board); return "redirect:/board/list2"; }
	 */
	@PostMapping("/register")
	public String registerProccess(BoardVO board) {
		log.info("post......"+board);
		service.register(board);
		return "redirect:/board/list2";
	}
}
