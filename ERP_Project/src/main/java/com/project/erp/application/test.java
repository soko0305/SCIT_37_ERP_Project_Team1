package com.project.erp.application;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class test {
//이후에 이것을 특정 시간때 일어나게 만들기
	@Scheduled(fixedDelay = 10000) 
	public void scheduleFixedRateTask() {
	    System.out.println("good");
	}
}
