package com.arnab.emp.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AopTrack {
	
	@Before(value = "execution(* com.arnab.emp.service.*.*(..))")
	public void beforePointcut() {
		System.out.println("Just before the service.");
	}
	
	@After(value = "execution(* com.arnab.emp.service.*.*(..))")
	public void afterPointcut() {
		System.out.println("Just after the service.");
	}
}
