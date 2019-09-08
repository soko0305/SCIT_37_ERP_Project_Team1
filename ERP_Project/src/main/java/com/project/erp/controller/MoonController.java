package com.project.erp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.erp.dao.RawMaterialDAO;
import com.project.erp.dao.SupplierDAO;
import com.project.erp.vo.RawMaterialVO;
import com.project.erp.vo.SupplierVO;

@Controller
public class MoonController {

	@Autowired
	SupplierDAO sDAO;
	
	@Autowired
	RawMaterialDAO rDAO;

	@RequestMapping(value = "/goAllView", method = RequestMethod.GET)
	public String goAllView(Model model) {
		ArrayList<SupplierVO> result = sDAO.supplierDashSelect();

		if (result != null) {
			model.addAttribute("supplierList", result);
			return "/rawMaterial/All_view";
		} else {
			return "/rawMaterial/All_view";
		}
	}

	@RequestMapping(value = "/goSupplier", method = RequestMethod.GET)
	public String goSupplier(Model model) {
		return "redirect:/goSupplierList";
	}

	@RequestMapping(value = "/goSupplierInsert", method = RequestMethod.GET)
	public String goSupplierInsert() {
		return "rawMaterial/supplier_insert";
	}

	@RequestMapping(value = "/goSupplierUpdate", method = RequestMethod.GET)
	public String goSupplierUpdate(SupplierVO supplier, Model model) {
		
		SupplierVO result = sDAO.supplierOneSelect(supplier);
		if (result == null) {
			return "/rawMaterial/All_view";
		} else {
			model.addAttribute("result", result);
			return "rawMaterial/supplier_update";
		}
	}

	@RequestMapping(value = "/goMaterials", method = RequestMethod.GET)
	public String goMaterials(Model model) {
		ArrayList<RawMaterialVO> result = rDAO.rawMaterialAllSelect();
		
		if(result != null) {
			model.addAttribute("rawMaterialList", result);
			return "rawMaterial/materials_view";
		}else {
			return "/rawMaterial/All_view"; 
		}
		
	}

	@RequestMapping(value = "/goMaterialsInsert", method = RequestMethod.GET)
	public String goMaterialsInsert(Model model) {
		ArrayList<SupplierVO> result = sDAO.supplierAllSelect();

		if (result != null) {
			model.addAttribute("supplierList", result);
			return "rawMaterial/materials_insert";
		} else {
			return "rawMaterial/All_view";
		}
	}

	@RequestMapping(value = "/goMaterialsUpdate", method = RequestMethod.POST)
	public String goMaterialsUpdate(RawMaterialVO rawmaterial,Model model) {
		System.out.println("goMaterialsUpdate result : " + rawmaterial);
		RawMaterialVO result = rDAO.rawMaterialOneSelect(rawmaterial);
		
		if(result != null) {
			model.addAttribute("result", result);
			return "rawMaterial/materials_update";
		}else {
			return "rawMaterial/All_view";
		}
		
	}

	@RequestMapping(value = "/goOrder", method = RequestMethod.GET)
	public String goOrder() {
		return "rawMaterial/order_view";
	}

	@RequestMapping(value = "/goOrderInsert", method = RequestMethod.GET)
	public String goOrderInsert() {
		return "rawMaterial/order_insert";
	}

	@RequestMapping(value = "/goBuy", method = RequestMethod.GET)
	public String goBuy() {
		return "rawMaterial/buy";
	}

	@RequestMapping(value = "/goSupplierList", method = RequestMethod.GET)
	public String goSupplierList(Model model) {
		ArrayList<SupplierVO> result = sDAO.supplierAllSelect();

		if (result != null) {
			model.addAttribute("supplierList", result);
			return "/rawMaterial/supplier_view";
		} else {
			return "/rawMaterial/All_view";
		}
	}

	@RequestMapping(value = "/Moon_test", method = RequestMethod.GET)
	public String Moon_test() {
		return "rawMaterial/Moon_test";
	}

	@RequestMapping(value = "/production_insert", method = RequestMethod.GET)
	public String production_insert() {
		return "production/production_insert";
	}

}
