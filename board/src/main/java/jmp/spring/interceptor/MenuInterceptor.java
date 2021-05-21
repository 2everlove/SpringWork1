package jmp.spring.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import jmp.spring.domain.MenuVO;
import jmp.spring.service.MenuService;
import lombok.extern.log4j.Log4j;
@Log4j
public class MenuInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	private MenuService service;
	
	/**
	 * This implementation always returns {@code true}.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		return true;
	}

	/**
	 * This implementation is empty.
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		
		log.info("menuinter....");
		HttpSession session = request.getSession();
		if(session.getAttribute("menu")==null) {
			List<MenuVO> menuList = service.getMenuList();
			session.setAttribute("menu", menuList);
		}
	}//
	
}//class
