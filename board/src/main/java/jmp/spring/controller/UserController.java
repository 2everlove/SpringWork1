package jmp.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	public String loginProcess(User vo, Model model, HttpServletRequest req) {
		log.info("login_post.....");
		User user = service.login(vo);
		String resMsg = "";
		String page = "";
		if(user==null) {
			resMsg = "fail";
			model.addAttribute("resMsg", resMsg);
			return "/login";
		} else {
			//user객체를 세션에 담음
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			log.info("============"+user);
			resMsg = "success";
			model.addAttribute("resMsg", resMsg);
			model.addAttribute("user", user);
			return "/loginAction";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		return "/login";
	}
}
