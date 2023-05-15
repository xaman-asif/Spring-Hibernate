package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	// this is where we add all of our related advice for logging
	
	// let's start with an @Before advice
	
//	Specifying the path
//	@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
//	}
	
//	Based on wildcard expression
//	@Before("execution(public void add*())")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
//	}
	
	//Based on the return type
//	@Before("execution(public String add*())")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
//	}
	
	// Super Modularity
	@Before("execution(* add*())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
	}
}
