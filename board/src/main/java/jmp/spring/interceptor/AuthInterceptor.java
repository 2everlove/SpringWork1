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
		System.out.println("user:"+user);
		
		// 로그인 하지 않은 사용자가 접근 했다면 (만약 유저객체가 널이라면)
		// 자동 로그인이 가능 한 사용 자라면
		// 로그인 처리 = 세션에 유저 객체를 넣어 준다
		if(user == null) {
			// 자동로그인이 가능 한 사용자인지 판단
			Cookie loginCookie = 
					WebUtils.getCookie(request, "loginCookie");
			
			if(loginCookie != null) {  // 자동로그인 사용자 이다
				user = userService.loginSessionkey(loginCookie.getValue());
				
				if(user != null) {
					// 로그인 처리 : 세션에 유저 객체를 생성 합니다.
					session.setAttribute("user", user);
					
				}
			}
			
		}
		
		// 1. 로그인 확인
		// 2. 권한 확인 
		if( user != null) {
			// ROLE_USER 권한 체크
			if(user.hasRole("ROLE_USER")) {
				String resMsg = (String)session.getAttribute("resMsg");
				if("fail".equals(resMsg)) {
					session.removeAttribute("resMsg");
					return true;
				}
				
				// 로그인이 되어 있고 권한이 충분한 자만이 /board/list에 접근 할수 있다
				return true;		
			}
			return true;
		}
		
		// 만약 로그인을 안했거나 권한이 없다면 로그인 페이지로 이동 합니다.
		// 원래 요청했던 페이지와 파라메터를 세션에 저장 합니다.  ->> 세션 삭제해야 해요
		System.out.println("uri============"+request.getRequestURI());
		System.out.println("query=========="+request.getQueryString());
		String uri = request.getRequestURI(); 	// 기존 요청의 URI정보
		String query = request.getQueryString();// 기존 요청의 파라메터
		
		if(query != null) {
			uri += "?" + query; 
		}
		
		session.setAttribute("tmpUri", uri);

		// 로그인 안했니
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
