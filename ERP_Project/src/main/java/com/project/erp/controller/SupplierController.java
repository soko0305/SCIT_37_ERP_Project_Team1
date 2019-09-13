package com.project.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.erp.service.SupplierService;
import com.project.erp.vo.SupplierVO;

@Controller
public class SupplierController {

	@Autowired
	SupplierService sService;
	
	@RequestMapping(value="/supplierInsert", method=RequestMethod.POST)
	public String supplierInsert(SupplierVO supplier) {
		System.out.println("supplierInsert : " + supplier);
		
		int result = sService.supplierInsert(supplier);
		
		if(result == 0) {
			return "/rawMaterial/all_view";
		}else {
			return "redirect:/goSupplierList";
		}
	}

	@RequestMapping(value="/supplierDelete", method=RequestMethod.POST)
	public String supplierDelete(SupplierVO supplier) {
		int result = sService.supplierDelete(supplier);
		
		if(result == 0) {
			return "/rawMaterial/all_view";
		}else {
			return "redirect:/goSupplierList";
		}
	}
	@RequestMapping(value="/supplierUpdate", method=RequestMethod.POST)
	public String supplierUpdate(SupplierVO supplier) {
		int result = sService.supplierUpdate(supplier);
		
		if(result == 0) {
			return "/rawMaterial/all_view";
		}else {
			return "redirect:/goSupplierList";
		}
		
	}
}
