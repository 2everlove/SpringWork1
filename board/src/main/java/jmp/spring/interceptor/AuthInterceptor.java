package jmp.spring.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import jdk.nashorn.internal.objects.annotations.Setter;
import jmp.spring.domain.User;
import jmp.spring.service.UserService;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	@lombok.Setter(onMethod_= @Autowired)
	private UserService userService;
	
	/**
	 * This implementation always returns {@code true}.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		//만약 유저객체가 null이라면
		if(user==null) {
			//자동로그인이 가능한 사용자인지 판단
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			user = userService.loginSessionkey(loginCookie.getValue());
			session.setAttribute("user", user);
		}
		
		if(user == null || !(user.hasRole("ROLE_USER"))) {
			response.sendRedirect("/login");
			return false;
		} else {
			String tmpUri = request.getRequestURI();
			String query = request.getQueryString();
			return true;
		}
	}
	
	/**
	 * This implementation is empty.
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
	}
}
