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
 
 
<<<<<<< HEAD
 

 


=======
>>>>>>> e3e94a34201d69a02956ad7201bbe09c4be8e42c
	@RequestMapping(value="/header", method = RequestMethod.GET)
	public String header(){
		return "main/header";
	}
	
	@RequestMapping(value="/navbar", method = RequestMethod.GET)
	public String navbar(){
		return "main/navbar";
	}
	
}
