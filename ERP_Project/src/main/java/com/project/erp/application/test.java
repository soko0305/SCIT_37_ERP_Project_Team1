package com.project.erp.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.erp.service.InventoryService;

@Component
public class test {
	
	@Autowired
	InventoryService inventoryService;
	
	
//이후에 이것을 특정 시간때 일어나게 만들기
	//@Scheduled(fixedDelay = 10000) 
	public void scheduleFixedRateTask() {

    }
}
