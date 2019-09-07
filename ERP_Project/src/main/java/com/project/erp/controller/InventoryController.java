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
	
	@RequestMapping(value="/insertWarehouse", method = RequestMethod.POST)
	public @ResponseBody void insertWarehouse(WarehouseVO warehouse){
		int check = 0;
		check = inventoryService.insertWarehouse(warehouse);
	}
	
	@RequestMapping(value="/selectLatestWarehouse", method = RequestMethod.GET)
	public @ResponseBody WarehouseVO selectLatestWarehouse(){
		WarehouseVO w = null;
		w = inventoryService.selectLatestWarehouse();
		return w;
	}
	
	@RequestMapping(value="/updateWarehouse", method = RequestMethod.POST)
	public @ResponseBody void updateWarehouse(WarehouseVO warehouse){
		int check = 0;
		System.out.println(warehouse);
		check = inventoryService.updateWarehouse(warehouse);
	}
}
