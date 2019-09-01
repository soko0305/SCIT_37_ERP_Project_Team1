package com.project.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class HomeController {

	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(){
<<<<<<< HEAD
<<<<<<< HEAD
		
		return "signup";
/*		return "inventory/inventoryManagement"; */
		}
=======
		return "inventory/inventoryManagement";
	}
>>>>>>> 1766075fd118d519e1391d75827f039c3fb89363
=======

 
		return "inventory/inventoryMangement";
  
 	}
 
>>>>>>> youngtest1

	@RequestMapping(value="/header", method = RequestMethod.GET)
	public String header(){
		return "menu/header";
	}
	
	@RequestMapping(value="/navbar", method = RequestMethod.GET)
	public String navbar(){
		return "menu/navbar";
	}
	
}
