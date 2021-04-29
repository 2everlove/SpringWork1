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
	
	//@Before("execution(* jmp.spring.service.BoardService*.*(..))")
	public void logBefore() {
		log.info("AOP==============");
		System.out.println("AOP==============");
	}
	
	//@Around("execution(* jmp.spring.service.*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) {
		//@Before
		//method 실행전 시간
		Long start = System.currentTimeMillis();
		System.out.println("=====pjp====="+pjp.getTarget());
		Object res = null;
		try {
			res = pjp.proceed();
		} catch (Throwable e) {
			//@AfterThrowing
			e.printStackTrace();
		}
		System.out.println("pjp: "+res);
		//@After
		//method 실행 후 시간
		Long end = System.currentTimeMillis();
		System.out.println((end-start)/1000.0+"s");
		return res;
	}
}
