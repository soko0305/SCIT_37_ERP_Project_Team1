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
 }
