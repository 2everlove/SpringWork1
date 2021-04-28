package jmp.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Component
@Log4j
public class LogAdvice {
	
	@Before("execution(* jmp.spring.service.BoardService*.*(..))")
	public void logBefore() {
		log.info("AOP==============");
		System.out.println("AOP==============");
	}
	
	@Around("execution(* jmp.spring.service*.*(..))")
	public void logTime(ProceedingJoinPoint pjp) {
		System.out.println(""+pjp);
		log.info("ddddddddddd");
	}
}
