package com.project.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class HomeController {

	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(){
		return "supplier_view";
	}

	@RequestMapping(value="/header", method = RequestMethod.GET)
	public String header(){
		return "menu/header";
	}
	
	@RequestMapping(value="/navbar", method = RequestMethod.GET)
	public String navbar(){
		return "menu/navbar";
	}
	
}
