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

import jmp.spring.domain.User;
import jmp.spring.service.UserService;

public class LoginInterceptor 
		extends HandlerInterceptorAdapter{

	@Autowired
	UserService userService;
	
	/**
	 * This implementation always returns {@code true}.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		return true;
	}

	/**
	 * /loginAction 컨트롤러가 실행된 이후에 자동로그인을 위한 쿠키를 저장 합니다.
	 * 만약에 쿠키가 생성되지 않는다면 로직이 실행 되는지 로그를 찍어봅시다
	 * 인터셉터 클래스가 실행 되지 않는다면 설정파일에 등록이 되어 있는지 확인해보세요!!
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		// 로그인이 성공 했다면 = 세션에 user객체가 생성되어져 있다면
		// 세션에 user 객체를 생성 하는 시점 : /loginAction
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
	
		System.out.println("interceptor ==================user "+ user);
		System.out.println("useCookie ==================useCookie"+request.getAttribute("useCookie"));
		// 로그인에 성공 했다면 자동로그인을 위한 쿠키를 생성 합니다.
		// 자동로그인에 체크가 되었을때
		
		//StringUtils.isEmpty(request.getAttribute("useCookie"));
		// request.getparameter 로 파라메터값을 가지고 옶니다
		if(user != null 
				&& request.getParameter("useCookie") != null) {
			
			// Users테이블에 쿠키 정보를 저장 합니다. 
			// session.getId()를 sessionkey 컬럼에 저장합니다 
			// loginCookie = 자동로그인시 생성하는 쿠키 
			// 여기에 저장되는 value 값과 users테이블의 sessionkey에 저장되는 값은 동일 해야 합니다!!! 
			user.setSessionkey(session.getId());
			userService.updateSessionkey(user);
			
			// 자동로그인을 위한 쿠키를 생성 합니다.
			Cookie loginCookie = new Cookie("loginCookie", session.getId());
			// 유효기간과 PAHT를 지정 합니다.
			loginCookie.setMaxAge(60*60*24*7);
			loginCookie.setPath("/");
			
			
			// 자동로그인을 위해 생성한 쿠키를 response 객체에 저장 합니다.
			response.addCookie(loginCookie);
			
		}
		String uri = (String)session.getAttribute("tmpUri");
		System.out.println("loginUri"+uri);
		
		if(!StringUtils.isEmpty(uri)) {
			response.sendRedirect(uri);
		}
	}

}













