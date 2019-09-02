package com.project.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MoonController {

	@RequestMapping(value="/goSupplier", method = RequestMethod.GET)
	public String goSupplier(){
		return "rawMaterial/supplier_view";
	}
	@RequestMapping(value="/goSupplierInsert", method = RequestMethod.GET)
	public String goSupplierInsert(){
		return "rawMaterial/supplier_insert";
	}
	@RequestMapping(value="/goSupplierUpdate", method = RequestMethod.GET)
	public String goSupplierUpdate(){
		return "rawMaterial/supplier_update";
	}
	@RequestMapping(value="/goMaterials", method = RequestMethod.GET)
	public String goMaterials(){
		return "rawMaterial/materials_view";
	}
	@RequestMapping(value="/goOrder", method = RequestMethod.GET)
	public String goOrder(){
		return "rawMaterial/orderCheck";
	}
	@RequestMapping(value="/goBuy", method = RequestMethod.GET)
	public String goBuy(){
		return "rawMaterial/buy";
	}

}
