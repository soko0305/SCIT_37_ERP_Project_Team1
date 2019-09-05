package com.project.erp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.erp.dao.SupplierDAO;
import com.project.erp.vo.SupplierVO;

@Controller
public class MoonController {

	@Autowired
	SupplierDAO sDAO;
	
	@RequestMapping(value="/goAllView", method = RequestMethod.GET)
	public String goAllView(){
		return "rawMaterial/all_view";
	}
	@RequestMapping(value="/goSupplier", method = RequestMethod.GET)
	public String goSupplier(Model model){
		ArrayList<SupplierVO> result = sDAO.supplierAllSelect();
		
		if(result != null) {
			model.addAttribute("supplierList", result);
			return "/rawMaterial/supplier_view";
		}else {
			return "/rawMaterial/All_view";
		}
		/*return "rawMaterial/supplier_view";*/
	}
	@RequestMapping(value="/goSupplierInsert", method = RequestMethod.GET)
	public String goSupplierInsert(){
		return "rawMaterial/supplier_insert";
	}
	@RequestMapping(value="/goSupplierUpdate", method = RequestMethod.GET)
	public String goSupplierUpdate(SupplierVO supplier, Model model){
		System.out.println("goSupplierUpdateForm : " + supplier);
		SupplierVO result = sDAO.supplierOneSelect(supplier);
		if(result == null) {
			return "/rawMaterial/All_view";
		}else {
			model.addAttribute("result", result);
			return "rawMaterial/supplier_update";
		}
	}
	@RequestMapping(value="/goMaterials", method = RequestMethod.GET)
	public String goMaterials() {
			return "rawMaterial/materials_view";
		}
	@RequestMapping(value="/goMaterialsInsert", method = RequestMethod.GET)
	public String goMaterialsInsert(){
		return "rawMaterial/materials_insert";
	}
	@RequestMapping(value="/goMaterialsUpdate", method = RequestMethod.GET)
	public String goMaterialsUpdate(){
		return "rawMaterial/materials_update";
	}
	@RequestMapping(value="/goOrder", method = RequestMethod.GET)
	public String goOrder(){
		return "rawMaterial/order_view";
	}
	@RequestMapping(value="/goOrderInsert", method = RequestMethod.GET)
	public String goOrderInsert(){
		return "rawMaterial/order_insert";
	}
	@RequestMapping(value="/goBuy", method = RequestMethod.GET)
	public String goBuy(){
		return "rawMaterial/buy";
	}
	
	
	@RequestMapping(value="/production_insert", method = RequestMethod.GET)
	public String production_insert(){
		return "production/production_insert";
	}

}
