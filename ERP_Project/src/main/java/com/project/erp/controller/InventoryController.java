package com.project.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InventoryController {
	@RequestMapping(value="/goInventory", method = RequestMethod.GET)
	public String goInventory(){
		return "inventory/inventoryManagement";
	}

}
