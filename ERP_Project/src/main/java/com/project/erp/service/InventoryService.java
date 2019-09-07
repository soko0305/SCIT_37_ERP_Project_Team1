package com.project.erp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.erp.dao.InventoryDAO;
import com.project.erp.vo.WarehouseVO;

@Service
public class InventoryService {
	
	@Autowired
	InventoryDAO inventoryDAO;

	public ArrayList<WarehouseVO> selectAllInventory() {
		ArrayList<WarehouseVO> wList = null;
		wList = inventoryDAO.selectAllInventory();
		return wList;
	}

	public int insertWarehouse(WarehouseVO warehouse) {
		int check =0;
		check = inventoryDAO.insertWarehouse(warehouse);
		return check;
	}

}
