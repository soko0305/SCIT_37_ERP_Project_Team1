package com.project.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class LinkController {

	
	@RequestMapping(value="/buyerList", method = RequestMethod.GET)
	public String Management1(){
<<<<<<< HEAD
		return "haraBasicTemplate2";
=======
		return "sales/buyerList";
>>>>>>> master
	}
	
	@RequestMapping(value="/offerManagement", method = RequestMethod.GET)
	public String Management2(){
		return "sales/offerManagement";
	}

<<<<<<< HEAD
	@RequestMapping(value="/haraManagement3", method = RequestMethod.GET)
=======

	@RequestMapping(value="/realTimeTracing", method = RequestMethod.GET)
>>>>>>> master
	public String Management3(){
		return "sales/realTimeTracing";
	}
<<<<<<< HEAD

=======
>>>>>>> master


	@RequestMapping(value="/salesHistory", method = RequestMethod.GET)
	public String Management4(){
		return "sales/salesHistory";
	}
	
	@RequestMapping(value="/haraBasicTemplate", method = RequestMethod.GET)
	public String basicTemplate(){
		return "sales/haraBasicTemplate";
	}
	

	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String index(){
		return "main/index";
	}
}
