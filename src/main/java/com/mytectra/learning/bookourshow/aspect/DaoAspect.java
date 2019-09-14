package com.mytectra.learning.bookourshow.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DaoAspect {

	
	@Around("timmer()")
	public Object recordTime(ProceedingJoinPoint jp) throws Throwable {
		long before  = System.currentTimeMillis();
		Object result = jp.proceed();
		long after  = System.currentTimeMillis();
		long timeTaken = after - before;
		System.out.println("Time taken by "+ jp.toLongString() + " ---- " + timeTaken);
		return result;
	}
	
	@Before("timmer()")
	public void after() throws Throwable {
		System.out.println("before");
		
	}
	
	@After("timmer()")
	public void before() throws Throwable {
		System.out.println("after");
	}
	
	
	@Pointcut("@annotation(Timmer)")
	void timmer() {
		
	}
	
}