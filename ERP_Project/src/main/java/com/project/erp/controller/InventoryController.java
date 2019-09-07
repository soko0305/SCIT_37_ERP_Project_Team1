package com.project.erp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.erp.service.InventoryService;
import com.project.erp.vo.WarehouseVO;

@Controller
public class InventoryController {
	
	@Autowired
	InventoryService inventoryService;
	
	@RequestMapping(value="/selectAllInventory", method = RequestMethod.GET)
	public @ResponseBody ArrayList<WarehouseVO> selectAllInventory(){
		ArrayList<WarehouseVO> wList = null;
		wList = inventoryService.selectAllInventory();
		return wList;
	}

}
