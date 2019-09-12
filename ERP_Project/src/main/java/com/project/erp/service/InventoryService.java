package com.project.erp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.erp.dao.InventoryDAO;
import com.project.erp.dao.RawMaterialDAO;
import com.project.erp.vo.InventoryVO;
import com.project.erp.vo.ProductVO;
import com.project.erp.vo.RawMaterialVO;
import com.project.erp.vo.SupplierVO;
import com.project.erp.vo.WarehouseVO;

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
		RawMaterialVO m = new RawMaterialVO();
		m.setRawm_code(rawm_code);
		m = rawMaterialDAO.rawMaterialOneSelect(m);
		return m;
	}

	public ProductVO selectProductByCode(String pd_code) {
		ProductVO m = null;
		m = inventoryDAO.selectProductByCode(pd_code);
		return m;
	}





}
