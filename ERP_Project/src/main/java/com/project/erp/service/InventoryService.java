package com.project.erp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.erp.dao.InventoryDAO;
import com.project.erp.dao.RawMaterialDAO;
import com.project.erp.vo.CheckstockVO;
import com.project.erp.vo.ProductVO;
import com.project.erp.vo.RawMaterialVO;
import com.project.erp.vo.SupplierVO;

@Service
public class InventoryService {
	
	@Autowired
	InventoryDAO inventoryDAO;
	@Autowired
	RawMaterialDAO rawMaterialDAO;


	public SupplierVO selectSupplierBySeq(String supplierseq) {
		SupplierVO s = null;
		s = inventoryDAO.selectSupplierBySeq(supplierseq);
		return s;
	}

	
	public RawMaterialVO selectMaterialByCode(String rawm_code) {
		RawMaterialVO m = null;
		m = rawMaterialDAO.rawMaterialOneSelect(rawm_code);
		return m;
	}

	public ProductVO selectProductByCode(String pd_code) {
		ProductVO m = null;
		m = inventoryDAO.selectProductByCode(pd_code);
		return m;
	}


	public ArrayList<SupplierVO> selectDistinctMaterialSupplier() {
		ArrayList<SupplierVO> sList = null;
		sList = inventoryDAO.selectDistinctMaterialSupplier();
		return sList;
	}


	public ArrayList<RawMaterialVO> selectDistinctMaterialSort() {
		ArrayList<RawMaterialVO> rList = null;
		rList = inventoryDAO.selectDistinctMaterialSort();
		return rList;
	}


	public ArrayList<ProductVO> selectDistinctProductSort() {
		ArrayList<ProductVO> pList = null;
		pList = inventoryDAO.selectDistinctProductSort();
		return pList;
	}


	public int confirmInvenWizNoProbs(CheckstockVO checkstock) {
		int check =0;
		check = inventoryDAO.confirmInvenWizNoProbs(checkstock);
		return check;
	}


	public int confirmInvenWizProbs(CheckstockVO checkstock) {
		int check =0;
		check = inventoryDAO.confirmInvenWizProbs(checkstock);
		return check;
	}





}
