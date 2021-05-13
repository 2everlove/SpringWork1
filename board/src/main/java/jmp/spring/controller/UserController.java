package jmp.spring.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.util.WebUtils;

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
		if(user==null) {
			resMsg = "fail";
			model.addAttribute("resMsg", resMsg);
			return "/login";
		} else {
			//user객체를 세션에 담음
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			log.info("============"+user);
			resMsg = user.getId()+"님 환영합니다.";
			model.addAttribute("resMsg", resMsg);
			model.addAttribute("user", user);
			return "/loginAction";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		Cookie loginCookie = WebUtils.getCookie(req, "loginCookie");
		if(loginCookie != null) {
			
			log.info(loginCookie);
			loginCookie.setMaxAge(0);
			//동일한 경로에 쿠키가 생기는걸 방지
			loginCookie.setPath("/");
			
			res.addCookie(loginCookie);
		}
		
		session.invalidate();
		return "redirect:/login";
	}
}
