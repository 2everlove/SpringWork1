package jmp.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import jmp.spring.domain.User;
import lombok.extern.log4j.Log4j;

@Log4j
public class SampleInterceptor extends HandlerInterceptorAdapter {

	/**
	 * This implementation always returns {@code true}.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("pre============");
		System.out.println(request);
		System.out.println(response);
		System.out.println(handler);
		System.out.println("============");
		
		//로그인 된 사용자만 이용 = session을 가지고 와서 userVO가 있는지 확인
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null) {
			//로그인이 안된 사용자는 로그인페이지로 돌려보내줌
			response.sendRedirect("/login");
			return false;
		} else {
			//로그인이 되어있으면 권한이 있는지 판단
			user.hasRole("ROLE_ADMIN");
		}
		return true;
	}

	/**
	 * This implementation is empty.
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		System.out.println("post============");
		System.out.println(request);
		System.out.println(response);
		System.out.println(handler);
		System.out.println(modelAndView);
		System.out.println("============");
	}
	
}
