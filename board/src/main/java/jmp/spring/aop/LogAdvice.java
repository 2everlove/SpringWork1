package jmp.spring.aop;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

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
	//* (모든 클래스).*(모든 메서드)(.. -> 파라미터의 갯수)
	//@Around("execution(* jmp.spring.service.*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) {
		Object res = null;
		//타겟 메소드의 실행전 시간과 실행 후 시간을 구하여 메서드의 실행 시간을 계산
		
		//전처리
		long startTime = System.currentTimeMillis();
		
		
		//타겟 객체 실행
		try {
			res = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		//후처리
		long endTime = System.currentTimeMillis();
		System.out.println((endTime-startTime)/1000.0+"s");
		return res;
	}
	
	//@Before("execution(* jmp.spring.service.BoardService*.*(..))")
	public void logBefore() {
		log.info("AOP==============");
		System.out.println("AOP==============");
	}
	
	//@Around("execution(* jmp.spring.service.*.*(..))")
	/*
	 * public Object logTime(ProceedingJoinPoint pjp) { //@Before //method 실행전 시간
	 * Long start = System.currentTimeMillis();
	 * System.out.println("=====pjp====="+pjp.getTarget()); Object res = null; try {
	 * res = pjp.proceed(); } catch (Throwable e) { //@AfterThrowing
	 * e.printStackTrace(); } System.out.println("pjp: "+res); //@After //method 실행
	 * 후 시간 Long end = System.currentTimeMillis();
	 * System.out.println((end-start)/1000.0+"s"); return res; }
	 */
}
