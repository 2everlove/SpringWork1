package jmp.spring.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String loginAction(User vo, Model model, HttpServletRequest req) {
		log.info("loginAction.........");
		User user = service.login(vo);
		
		if (user == null || user.getEmail() == null) {
			log.info("action1....");
			model.addAttribute("resMsg","fail");
			return "/login";
		} else {
			// user 객체를 세션에 담아줍니다. - 로그인 처리
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			log.info("===================="+user);
			model.addAttribute("resMsg",user.getId()+"님 환영합니다.");
			//model.addAttribute("user", user);
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
	
	
	@GetMapping("/member")
	public void member() {
		log.info("member.........");
	}
	
	@PostMapping("/registerMember")
	public String registerMember(HttpServletRequest request, User user) {
		try {
			int res = service.insertUser(user);
			if(res > 0) {
				return "forward:/loginAction";
			} else {
				return "/error";
			}
		} catch (Exception e) {
			return "/error";
		}
	}
	
	@GetMapping({"/getId", "/getPwd"})
	public String getId() {
		return "/getInfo";
	}
	
	@PostMapping("/checkInfo")
	public String checkInfo(User user, Model model) {
		String path = "/login";
		if(user != null) {
			String name = user.getName();
			String resMsg = "";
			User findUser = new User();
			if(name != null) { //아이디 찾기
				findUser = service.checkId(user.getName(), user.getEmail());
				if(findUser == null) {
					resMsg = "notFound";
					path = "/error";
					return path;
				} else {
					resMsg = "고객님의 ID는 "+findUser.getId()+"입니다.";
				}
			
			} else {
				findUser = service.checkPwd(user.getId(), user.getEmail());
				if(findUser == null) {
					resMsg = "notFound";
					path = "/error";
					return path;
				} else {
					resMsg = user.getEmail()+"로 메일을 전송하였습니다.";
				}
			}
			model.addAttribute("resMsg", resMsg);
			return path;
		} else {
			path = "/error";
			return path;
		}
	}
	
	@GetMapping("/myPage")
	public void myPage() {
		log.info("myPage.......");
	}
	
	@PostMapping("/updateMember")
	public String updateMember(User user, String newPwd, Model model) {
		int res = service.updateUser(user, newPwd);
		if(res>0) {
			model.addAttribute("resMsg", "modify");
			return "redirect:/board/list";
		}else {
			return "/error";
		}
	}
	
}
