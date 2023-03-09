package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component
public class TennisCoach implements Coach {
	
	//define a field injection
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	//define a default constructor
	/*
	 * public TennisCoach() {
	 * System.out.println(">> TennisCoach: inside defualt constructor"); }
	 */
	
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
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
