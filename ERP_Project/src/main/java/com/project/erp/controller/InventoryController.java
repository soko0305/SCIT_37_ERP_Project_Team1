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
	int flag = 0;
	
	@RequestMapping(value="/selectAllInventory", method = RequestMethod.GET)
	public @ResponseBody ArrayList<WarehouseVO> selectAllInventory(){
		ArrayList<WarehouseVO> wList = null;
		wList = inventoryService.selectAllInventory();
		return wList;
	}
	
	@RequestMapping(value="/insertWarehouse", method = RequestMethod.POST)
	public @ResponseBody void insertWarehouse(WarehouseVO warehouse){
		flag=0;
		flag = inventoryService.insertWarehouse(warehouse);
	}
	
	@RequestMapping(value="/checkSuccess", method = RequestMethod.GET)
	public @ResponseBody int checkSuccess(){
		return flag;
	}
	
	@RequestMapping(value="/selectLatestWarehouse", method = RequestMethod.GET)
	public @ResponseBody WarehouseVO selectLatestWarehouse(){
		WarehouseVO w = null;
		w = inventoryService.selectLatestWarehouse();
		return w;
	}
	
	@RequestMapping(value="/updateWarehouse", method = RequestMethod.POST)
	public @ResponseBody void updateWarehouse(WarehouseVO warehouse){
		flag=0;
		flag = inventoryService.updateWarehouse(warehouse);
	}
	
	@RequestMapping(value="/deleteWarehouse", method = RequestMethod.GET)
	public @ResponseBody int deleteWarehouse(String warehouse_code){
		int check =0;
		check = inventoryService.deleteWarehouse(warehouse_code);
		return check;
	}
	
	@RequestMapping(value="/selectWarehouseByCode", method = RequestMethod.GET)
	public @ResponseBody WarehouseVO selectWarehouseByCode(String warehouse_code){
		WarehouseVO w = null;
		w = inventoryService.selectWarehouseByCode(warehouse_code);
		return w;
	}
}
