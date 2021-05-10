package jmp.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jmp.spring.domain.User;
import jmp.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequiredArgsConstructor
@Log4j
public class UserController {
	
	@Setter(onMethod_= @Autowired)
	UserService service;
	
	@GetMapping("/login")
	public void loginPage() {
		log.info("login......");
	}
	
	@PostMapping("/loginAction")
	public String loginProcess(User user, RedirectAttributes rttr) {
		log.info("login_post.....");
		User users = service.login(user);
		String resMsg = "";
		if(users==null) {
			resMsg = "fail";
		} else {
			resMsg = "success";
		}
		rttr.addFlashAttribute("resMsg", resMsg);
		return "redirect:/login";
	}
}
