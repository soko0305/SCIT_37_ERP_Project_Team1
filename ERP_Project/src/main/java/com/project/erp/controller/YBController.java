package com.project.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class YBController {

	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public String signup(){
		return "member/signup";
	}
	@RequestMapping(value="/signup2", method = RequestMethod.GET)
	public String signup2(){
		return "member/signup2";
	}
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(){
		return "member/login";
	}
	
	@RequestMapping(value="/inventoryManagement123", method = RequestMethod.GET)
	public String inventoryManagement123(){
		return "inventory/inventoryManagement123";
	} 
	@RequestMapping(value="/inventoryManagement", method = RequestMethod.GET)
	public String inventoryManagement(){
		return "inventory/inventoryManagement";
	} 
	@RequestMapping(value="/freeboard", method = RequestMethod.GET)
	public String freeboard(){
		return "member/freeboard";
	} 
	@RequestMapping(value="/notice", method = RequestMethod.GET)
	public String notice(){
		return "member/notice";
	} 
	@RequestMapping(value="/board", method = RequestMethod.GET)
	public String board(){
		return "member/board";
	} 
	@RequestMapping(value="/producecheck", method = RequestMethod.GET)
	public String producecheck(){
		return "production/producecheck";
	} 
	@RequestMapping(value="/main", method = RequestMethod.GET)
	public String home(){
		return "main/index";
		}
	@RequestMapping(value="/produceinsert", method = RequestMethod.GET)
	public String produceinsert(){
		return "production/produceinsert";
	} 
	@RequestMapping(value="/productioninsert", method = RequestMethod.GET)
	public String productioninsert(){
		return "production/productioninsert";
	} 
	@RequestMapping(value="/productioncheck", method = RequestMethod.GET)
	public String productioncheck(){
		return "production/productioncheck";
	} 
	@RequestMapping(value="/sample", method = RequestMethod.GET)
	public String sample(){
		return "production/sample";
	} 	

	 
	@RequestMapping(value="/rawmaterialrequest", method = RequestMethod.GET)
	public String rawmaterialrequest(){
		return "production/rawmaterialrequest";
	} 	
	
	 
	@RequestMapping(value="/confirmproductionrequest", method = RequestMethod.GET)
	public String confirmproductionrequest(){
		return "production/confirmproductionrequest";
	} 	

}


