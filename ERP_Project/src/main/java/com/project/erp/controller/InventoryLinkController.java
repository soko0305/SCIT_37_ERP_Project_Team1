package com.project.erp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.erp.service.InventoryService;
import com.project.erp.vo.CheckstockVO;

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
	public String goResearchInventory(Model model){
		ArrayList<CheckstockVO> cList = null;
		cList = inventoryService.selectAllCheckstock();
		model.addAttribute("cList", cList);
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
		model.addAttribute("warehouse_code", warehouse_code);
		return "inventory/updateWarehouseInfo";
	}
	
	@RequestMapping(value="/goResearchInventory", method = RequestMethod.GET)
	public String goResearchInventory(String warehouse_code, String p_count, String m_count, Model model){
		model.addAttribute("warehouse_code", warehouse_code);
		model.addAttribute("p_count", p_count);
		model.addAttribute("m_count", m_count);
		return "inventory/researchInventory";
	}
	
	@RequestMapping(value="/goUpdateInventory", method = RequestMethod.GET)
	public String goUpdateInventory(String warehouse_code, String data_code, String button_type, Model model){
		model.addAttribute("warehouse_code", warehouse_code);
		model.addAttribute("data_code", data_code);
		model.addAttribute("button_type", button_type);
		return "inventory/updateInventory";
	}
	
	@RequestMapping(value="/goResearchInventoryHistory", method = RequestMethod.GET)
	public String goResearchInventoryHistory(){
		return "inventory/researchInventoryHistory";
	}
	
	@RequestMapping(value="/checkAmountByPic", method = RequestMethod.POST)
	public @ResponseBody void checkAmountByPic(){
	}
	
	@RequestMapping(value="/goResearchInventoryCode", method = RequestMethod.GET)
	public String goResearchInventoryCode(){
		return "inventory/ResearchInventoryCode";
	}
	
	
	@RequestMapping(value="/goFixInventory", method = RequestMethod.GET)
	public String goFixInventory(CheckstockVO checkstock, Model model){
		model.addAttribute("checkstock", checkstock);
		return "inventory/fixInventory";
	}

	
}
