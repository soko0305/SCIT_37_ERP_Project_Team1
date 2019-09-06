package com.project.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.erp.dao.InventoryDAO;

@Service
public class InventoryService {
	
	@Autowired
	InventoryDAO inventoryDAO;

}
