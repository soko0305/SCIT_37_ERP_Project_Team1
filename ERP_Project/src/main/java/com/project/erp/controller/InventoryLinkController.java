package com.project.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.erp.service.InventoryService;
import com.project.erp.vo.WarehouseVO;

@Controller
public class InventoryLinkController {
	@Autowired
	InventoryService inventoryService;
	
	@RequestMapping(value="/goStorage", method = RequestMethod.GET)
	public String goStorageManagement(){
		return "inventory/warehouse";
	}
	
	@RequestMapping(value="/goInventoryManagement", method = RequestMethod.GET)
	public String goInventoryManagement(){
		return "inventory/inventoryManagement";
	}
	
	@RequestMapping(value="/goResearchConfirm", method = RequestMethod.GET)
	public String goResearchInventory(){
		return "inventory/researchConfirm";
	}
	
	@RequestMapping(value="/goConfirmInventory", method = RequestMethod.GET)
	public String goConfirmInventory(){
		return "inventory/confirmInventory";
	}
	
	@RequestMapping(value="/goInsertStorage", method = RequestMethod.GET)
	public String goInsertStorage(){
		return "inventory/insertWarehouseInfo";
	}
	
	@RequestMapping(value="/goUpdateStorage", method = RequestMethod.GET)
	public String goUpdateStorage(String warehouse_code, Model model){
		WarehouseVO w = inventoryService.selectWarehouseByCode(warehouse_code);
		model.addAttribute("warehouse", w);
		return "inventory/updateWarehouseInfo";
	}
	
	@RequestMapping(value="/goResearchInventory", method = RequestMethod.GET)
	public String goResearchInventory(String warehouse_code, Model model){
		WarehouseVO w = inventoryService.selectWarehouseByCode(warehouse_code);
		model.addAttribute("warehouse", w);
		return "inventory/researchInventory";
	}
	
	
}
