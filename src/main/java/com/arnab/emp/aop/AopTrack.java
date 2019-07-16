package com.arnab.emp.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect			// Denotes an Aspect, logging, etc.
@Configuration	// Denotes a Configuration class and will be picked up during Spring Component Scanning.
public class AopTrack {
	/**
	 * Below in the @Before annotation, it is the pointcut. It is referring a portion or a method in the classes referred by the 
	 * pointcut. So @Before means it will be executed just before the target methods as expressed by the pointcut expression.
	 */
	@Before(value = "execution(* com.arnab.emp.service.*.*(..))")
	public void beforePointcut() {
		System.out.println("Just before the service.");
	}
	
	/**
	 * Below in the @After annotation, it is the pointcut. It is referring a portion or a method in the classes referred by the 
	 * pointcut. So @After means it will be executed just after the target methods as expressed by the pointcut expression.
	 */
	@After(value = "execution(* com.arnab.emp.service.*.*(..))")
	public void afterPointcut() {
		System.out.println("Just after the service.");
	}
}
