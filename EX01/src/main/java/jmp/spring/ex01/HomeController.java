package jmp.spring.ex01;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
/* @RequestMapping("/") */
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	//						url매핑 받음(root경로)  이 폼이라는 메서드 실행
	//	http://localhost:8090/home 로 하면 그냥 root경로라서 WEB-INF -> views 안의 home.jsp를 실행
	
	public String home(Locale locale, Model model) {
		//						화면단에 데이터를 담고 싶을때 Model을 씀 
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home"; //페이지 경로를 servlet-context.xml로 보내서 prefix와 suffix로 경로 완성
	}
	
}
