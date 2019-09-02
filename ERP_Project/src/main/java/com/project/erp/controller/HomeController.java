package com.project.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class HomeController {

	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(){
<<<<<<< HEAD
		return "inventory/confirmInventory";
		}
 
 
=======
		return "all_view";
	}
>>>>>>> 7c8243a65573d86d7c9df2187eb3d2131710f940
	@RequestMapping(value="/header", method = RequestMethod.GET)
	public String header(){
		return "main/header";
	}
	
	@RequestMapping(value="/navbar", method = RequestMethod.GET)
	public String navbar(){
		return "main/navbar";
	}
	
	@RequestMapping(value="/drawerWrapper", method = RequestMethod.GET)
	public String drawerWrapper(){
		return "main/drawerWrapper";
	}
	
	@RequestMapping(value="/wrapperFooter", method = RequestMethod.GET)
	public String wrapperFooter(){
		return "main/wrapperFooter";
	}
	
	@RequestMapping(value="/setting", method = RequestMethod.GET)
	public String setting(){
		return "main/setting";
	}
	
}
