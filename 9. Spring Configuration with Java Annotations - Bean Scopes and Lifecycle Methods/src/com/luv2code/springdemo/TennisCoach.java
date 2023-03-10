package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component
//@Scope("prototype")
public class TennisCoach implements Coach {
	
	//define a field injection
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	//define a default constructor
	 public TennisCoach() {
		 System.out.println(">> TennisCoach: inside defualt constructor"); 
	 }
	
	 //define my init method
	 @PostConstruct
	 public void doMyStartupStuff() {
		 System.out.println(">> TennisCoach: inside of doMyStartupStuff()");
	 }
	 
	 //define my destroy method
	 @PreDestroy
	 public void doMyCleanupStuff() {
		 System.out.println(">> TennisCoach: inside of doMyCleanupStuff()");
	 }
	 
	 //define my destroy method
	 
	//define a setter method (Setter Injection)
	/*
	 * @Autowired public void setFortuneService(FortuneService fortuneService) {
	 * System.out.println(">> TennisCoach: inside setFortuneService method");
	 * this.fortuneService = fortuneService; }
	 */
	
	//define a custom method (Field Injection)
	/*
	 * @Autowired public void doSomeCrazyStuff(FortuneService fortuneService) {
	 * System.out.println(">> TennisCoach: inside doSomeCrazyStuff method");
	 * this.fortuneService = fortuneService; }
	 */
	
	
	/*
	@Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}*/

	@Override
	public String getDailyWorkout() {
		
		return "Practise your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
