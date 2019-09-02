package com.project.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class LinkController {

	
	@RequestMapping(value="/buyerList", method = RequestMethod.GET)
	public String Management1(){
		return "sales/buyerList";
	}
	
	@RequestMapping(value="/offerManagement", method = RequestMethod.GET)
	public String Management2(){
		return "sales/offerManagement";
	}

	@RequestMapping(value="/realTimeTracing", method = RequestMethod.GET)
	public String Management3(){
		return "sales/realTimeTracing";
	}

	@RequestMapping(value="/salesHistory", method = RequestMethod.GET)
	public String Management4(){
		return "sales/salesHistory";
	}
	
	@RequestMapping(value="/haraBasicTemplate", method = RequestMethod.GET)
	public String basicTemplate(){
		return "sales/haraBasicTemplate";
	}
	

}
