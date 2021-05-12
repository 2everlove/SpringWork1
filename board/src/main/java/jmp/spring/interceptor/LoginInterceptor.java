package jmp.spring.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import jmp.spring.domain.User;
import jmp.spring.service.UserService;
import lombok.Setter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Setter(onMethod_= @Autowired)
	private UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//로그인 성공하면 = 세션에 user 객체가 있으면
		// session 에 user 객체 생성 시점: /loginAction
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		//로그인에 성공했다면 자동로그인을 위한 쿠키를 생성합니다.
		
		StringUtils.isEmpty(request.getParameter("useCookie")); //객체가 있는지 없는지 String에서 체크
		if(user != null && !(StringUtils.isEmpty(request.getParameter("useCookie")))){
			//User테이블에 쿠키 정보를 저장
			user.setSessionkey(session.getId());
			userService.updateSessionkey(user);
			
			//자동로그인을 위한 쿠키 생성 - uuid로 만들면 좀 더 좋음
			Cookie loginCookie = new Cookie("loginCookie",session.getId());
			loginCookie .setMaxAge(60*60*24*7);
			loginCookie .setPath("/");

			//자동로그인을 위해 생성한 쿠키를 response객체에 저장
			response.addCookie(loginCookie );
			
		}	
	}
	
	
}
