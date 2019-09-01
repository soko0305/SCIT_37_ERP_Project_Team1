package com.project.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class HomeController {

	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(){
<<<<<<< HEAD
		return "signup";
=======
		return "inventory/inventoryManagement";
>>>>>>> a0ac510d4bcb2e81fe2892c4e50aafafb4e057ae
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
