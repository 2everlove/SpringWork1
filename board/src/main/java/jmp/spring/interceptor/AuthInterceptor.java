package jmp.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import jmp.spring.domain.User;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	/**
	 * This implementation always returns {@code true}.
	 */
	@SuppressWarnings("null")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		if(user == null || !(user.hasRole("ROLE_USER"))) {
			response.sendRedirect("/login");
			return false;
		} else {
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
