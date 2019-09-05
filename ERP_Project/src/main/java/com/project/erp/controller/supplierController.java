package com.project.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.erp.dao.SupplierDAO;
import com.project.erp.vo.SupplierVO;

@Controller
public class supplierController {

	@Autowired
	SupplierDAO sDAO;
	
	@RequestMapping(value="/supplierInsert", method=RequestMethod.POST)
	public String supplierInsert(SupplierVO supplier) {
		System.out.println("supplierInsert : " + supplier);
		
		int result = sDAO.supplierInsert(supplier);
		
		if(result == 0) {
			return "/rawMaterial/all_view";
		}else {
			return "/rawMaterial/supplier_view";
		}
	}

	@RequestMapping(value="/supplierDelete", method=RequestMethod.POST)
	public String supplierDelete(SupplierVO supplier) {
		System.out.println("supplierDelete : " + supplier);
		int result = sDAO.supplierDelete(supplier);
		
		if(result == 0) {
			return "/rawMaterial/all_view";
		}else {
			return "/rawMaterial/supplier_view";
		}
	}
	@RequestMapping(value="/supplierUpdate", method=RequestMethod.POST)
	public String supplierUpdate(SupplierVO supplier) {
		System.out.println("supplierUpdate : " + supplier);
		int result = sDAO.supplierUpdate(supplier);
		
		if(result == 0) {
			return "/rawMaterial/all_view";
		}else {
			return "/rawMaterial/supplier_view";
		}
		
	}
}
