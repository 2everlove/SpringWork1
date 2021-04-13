package jmp.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jmp.spring.domain.BoardVO;
import jmp.spring.service.BoardServiceImpl;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
public class MainController {
	
	private BoardServiceImpl service;
	
	@GetMapping("/list")
	public void getList(Model model) {
		log.info("list.........");
		model.addAttribute("list", service.getList());
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("")
	public String registerProccess() {
		return "redirect:/board/list";
	}
}
