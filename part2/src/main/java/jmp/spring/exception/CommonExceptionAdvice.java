package jmp.spring.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {
	
	@ExceptionHandler(Exception.class)
	public String except(Exception e, Model model) {
		log.error("Exception....."+e.getMessage());
		model.addAttribute("exception", e);
		log.error(model);
		
		return "error_page";
	}
}
