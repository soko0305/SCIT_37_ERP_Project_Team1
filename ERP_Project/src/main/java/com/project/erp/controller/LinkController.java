package com.project.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class LinkController {

	
	@RequestMapping(value="/haraManagement", method = RequestMethod.GET)
	public String Management1(){
		return "management1";
	}
	
	@RequestMapping(value="/haraManagement2", method = RequestMethod.GET)
	public String Management2(){
		return "management2";
	}

 

}