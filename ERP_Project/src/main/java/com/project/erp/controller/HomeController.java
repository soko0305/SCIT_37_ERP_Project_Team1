package com.project.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class HomeController {

	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(){
		return "main/index";
		}
 
 
	@RequestMapping(value="/header", method = RequestMethod.GET)
	public String header(){
		return "main/header";
	}
	
	@RequestMapping(value="/navbar", method = RequestMethod.GET)
	public String navbar(){
		return "main/navbar";
	}
	
}
