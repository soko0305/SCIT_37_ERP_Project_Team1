package com.project.erp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.erp.dao.InventoryDAO;
import com.project.erp.vo.InventoryVO;
import com.project.erp.vo.ProductVO;
import com.project.erp.vo.RawMaterialVO;
import com.project.erp.vo.SupplierVO;
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

	public WarehouseVO selectLatestWarehouse() {
		WarehouseVO w = null;
		w = inventoryDAO.selectLatestWarehouse();
		return w;
	}

	public WarehouseVO selectWarehouseByCode(String warehouse_code) {
		WarehouseVO w = null;
		w = inventoryDAO.selectWarehouseByCode(warehouse_code);
		return w;
	}

	public int updateWarehouse(WarehouseVO warehouse) {
		int check =0;
		check = inventoryDAO.updateWarehouse(warehouse);
		return check;
	}

	public int deleteWarehouse(String warehouse_code) {
		int check =0;
		check = inventoryDAO.deleteWarehouse(warehouse_code);
		return check;
	}
	
	public ArrayList<RawMaterialVO> selectMaterialINWarehouse(String warehouse_code) {
		ArrayList<RawMaterialVO> mList = null;
		mList = inventoryDAO.selectMaterialINWarehouse(warehouse_code);
		return mList;
	}

	public ArrayList<ProductVO> selectProductINWarehouse(String warehouse_code) {
		ArrayList<ProductVO> pList = null;
		pList = inventoryDAO.selectProductINWarehouse(warehouse_code);
		return pList;
	}

	public SupplierVO selectSupplierBySeq(String supplierseq) {
		SupplierVO s = null;
		s = inventoryDAO.selectSupplierBySeq(supplierseq);
		return s;
	}

	public ArrayList<RawMaterialVO> selectDistinctMaterialINWarehouse(String warehouse_code) {
		ArrayList<RawMaterialVO> sList = null;
		sList = inventoryDAO.selectDistinctMaterialINWarehouse(warehouse_code);
		return sList;
	}

	public ArrayList<RawMaterialVO> selectDistinctMaterialSortINWarehouse(String warehouse_code) {
		ArrayList<RawMaterialVO> mList = null;
		mList = inventoryDAO.selectDistinctMaterialSortINWarehouse(warehouse_code);
		return mList;
	}

	public ArrayList<ProductVO> selectDistinctProductSortINWarehouse(String warehouse_code) {
		ArrayList<ProductVO> pList = null;
		pList = inventoryDAO.selectDistinctProductSortINWarehouse(warehouse_code);
		return pList;
	}

	public ArrayList<RawMaterialVO> selectMaterialINWarehouseWizCondition(RawMaterialVO material) {
		ArrayList<RawMaterialVO> mList = null;
		mList = inventoryDAO.selectMaterialINWarehouseWizCondition(material);
		return mList;
	}

	public ArrayList<ProductVO> selectProductINWarehouseWizCondition(ProductVO product) {
		ArrayList<ProductVO> pList = null;
		pList = inventoryDAO.selectProductINWarehouseWizCondition(product);
		return pList;
	}




}
