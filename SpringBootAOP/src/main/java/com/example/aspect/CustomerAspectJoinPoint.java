package com.example.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomerAspectJoinPoint {

	@Before("execution(* com.example.service.CustomerAdvanceService.*(..)) && args(firstName, id)")
	public void logStringArguments(String firstName, long id) {
		System.out.println("Passed Arguments: [" + "firstName = " + firstName + "; id = " + id + "]");
	}

	@Before("execution(* com.example.service.CustomerAdvanceService.setCustomerFirstName(..))")
	public void logAdvice(JoinPoint joinPoint) {
		System.out.println("Before running Advice on " + joinPoint.toString());
		System.out.println("Display Passed Arguments: " + Arrays.toString(joinPoint.getArgs()));
	}

	/**
	 * Around Advice: can run both before and after the method executes, and to specify when, how and what the method actually gets to execute.
	 * @param joinPoint
	 * @return
	 */
	@Around("execution(* com.example.service.CustomerAdvanceService.findAllCustomers())")
	public Object logAround(ProceedingJoinPoint joinPoint){
		System.out.println("This is LogAdvice BEFORE excuting Method");
		
		Object returnObj = null;
		
		try {
			returnObj = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.out.println("This is LogAdvice AFTER excuting Method");
		
		return returnObj;
	}
}
