package com.project.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InventoryLinkController {
	@RequestMapping(value="/goStorage", method = RequestMethod.GET)
	public String goStorageManagement(){
		return "inventory/storage";
	}
	
	@RequestMapping(value="/goInventoryManagement", method = RequestMethod.GET)
	public String goInventoryManagement(){
		return "inventory/inventoryManagement";
	}
	
	@RequestMapping(value="/goResearchInventory", method = RequestMethod.GET)
	public String goResearchInventory(){
		return "inventory/researchInventory";
	}
	
	@RequestMapping(value="/goConfirmInventory", method = RequestMethod.GET)
	public String goConfirmInventory(){
		return "inventory/confirmInventory";
	}
	
	@RequestMapping(value="/goInsertStorage", method = RequestMethod.GET)
	public String goInsertStorage(){
		return "inventory/insertStorageInfo";
	}
	
	@RequestMapping(value="/goUpdateStorage", method = RequestMethod.GET)
	public String goUpdateStorage(){
		return "inventory/updateStorageInfo";
	}
}
