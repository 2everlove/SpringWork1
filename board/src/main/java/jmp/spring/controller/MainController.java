package jmp.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
public class MainController {

	@GetMapping("/list")
	public void getList() {
		
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("")
	public String registerProccess() {
		return "redirect:/board/list";
	}
}
