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
	
	@RequestMapping(value="/haraManagement2", method = RequestMethod.GET)
	public String Management2(){
		return "sales/offerManagement";
	}


	@RequestMapping(value="/haraManagement3", method = RequestMethod.GET)
	public String Management3(){
		return "sales/management3";
	}


	@RequestMapping(value="/haraManagement4", method = RequestMethod.GET)
	public String Management4(){
		return "sales/management4";
	}
	
	@RequestMapping(value="/haraManagement5", method = RequestMethod.GET)
	public String Management5(){
		return "sales/haraBasicTemplate";
	}
}
