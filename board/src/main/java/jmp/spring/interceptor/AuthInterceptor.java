package jmp.spring.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import jmp.spring.domain.User;
import jmp.spring.service.UserService;

public class AuthInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	UserService userService;
	
	/**
	 * This implementation always returns {@code true}.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		// 만약 유저객체가 널이라면 = 로그인 하지 않은 사용자가 접근 했다면
		// 자동로그인 처리 = 세션에 유저 객체를 넣어 줌
		if(user == null) {
			// 자동로그인이 가능 한 사용자인지 판단
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			//자동로그인으로 cookie가 있는 사용자
			if(loginCookie != null) {
				user = userService.loginSessionkey(loginCookie.getValue());
				// 로그인 처리 : 세션에 유저 객체를 생성 합니다.
				if(user != null)
					session.setAttribute("user", user);				
			}
			
		}
		
		// 로그인 확인,  role 권한 확인
		if( user != null) {
			if(user.hasRole("ROLE_USER")) {
				return true;		
			}
			
		}
		
		System.out.println("uri......"+request.getRequestURI());
		System.out.println("query...."+request.getQueryString());
		
		
		String uri = request.getRequestURI(); //기존 요청의 URI
		String query = request.getQueryString(); //기존 요청의 파라미터
		if(!StringUtils.isEmpty(query)) { //query != null
			uri += "?"+query; 
		}
		session.setAttribute("tmpUri", uri);
		System.out.println("uri: "+uri);
		response.sendRedirect("/login");
		return false;
	}


	/**
	 * This implementation is empty.
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
	}
}
