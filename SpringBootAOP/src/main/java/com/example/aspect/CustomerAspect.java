package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Aspect with simiple expression
 * @author praveen
 *
 */
@Aspect
@Component
public class CustomerAspect {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	/**
	 * Before Advice: runs before the execution of join point methods. 
	 */
	
	@Before("execution(* com.example.service.CustomerService.getCustomerById(..))")
	public void getCustomerByIdAdvice() {
		//System.out.println("Execute advice on getCustomerByIdAdvice()");
		log.info("Execute advice on getCustomerByIdAdvice()");
	}
	
	/**
	 * After Advice: runs after the join point method finishes executing.
	 */
	
	@After("execution(* com.example.service.CustomerService.getCustomerById(..))")
	public void getCustomerByIdAfterAdvice() {
		System.out.println("Execute ***after*** advice on getCustomerByIdAdvice()");
	}

	@Before("execution(* com.example.service.CustomerService.set*(..))")
	public void getAllSetAdvices(JoinPoint joinPoint) {
		System.out.println("Excute advice on Service set Method: " + joinPoint.getSignature().getName());
	}
}
