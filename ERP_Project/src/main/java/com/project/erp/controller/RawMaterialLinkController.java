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
public class RawMaterialLinkController {

	@Autowired
	SupplierDAO sDAO;

	@Autowired
	RawMaterialDAO rDAO;

	// 대쉬보드 메인 화면 Form
	@RequestMapping(value = "/goAllView", method = RequestMethod.GET)
	public String goAllView(Model model) {
		ArrayList<SupplierVO> result = sDAO.supplierDashSelect();
		model.addAttribute("supplierList", result);
		
		ArrayList<RawMaterialVO> result1 = rDAO.rawMaterialDashSelect();
		model.addAttribute("rawMaterialList", result1);
		
		return "rawMaterial/All_view";
	}

	// 공급처 출력을 위한 redirect(List출력)
	@RequestMapping(value = "/goSupplierList", method = RequestMethod.GET)
	public String goSupplierList(Model model) {
		ArrayList<SupplierVO> result = sDAO.supplierAllSelect();
		model.addAttribute("supplierList", result);
		return "rawMaterial/supplier_view";
	}
	
	// 공급처 전체 출력화면 Form
	@RequestMapping(value = "/goSupplier", method = RequestMethod.GET)
	public String goSupplier(Model model) {
		return "redirect:/goSupplierList";
	}

	// 공급처 등록 Form
	@RequestMapping(value = "/goSupplierInsert", method = RequestMethod.GET)
	public String goSupplierInsert() {
		return "rawMaterial/supplier_insert";
	}

	// 공급처 수정 Form
	@RequestMapping(value = "/goSupplierUpdate", method = RequestMethod.GET)
	public String goSupplierUpdate(SupplierVO supplier, Model model) {
		SupplierVO result = sDAO.supplierOneSelect(supplier);
		model.addAttribute("result", result);
		return "rawMaterial/supplier_update";
	}
	//
	//
	// 원자재 출력을 위한 redirect(List출력)
	@RequestMapping(value = "/goMaterialsList", method = RequestMethod.GET)
	public String goMaterialsList(Model model) {
		ArrayList<RawMaterialVO> result = rDAO.rawMaterialAllSelect();
		model.addAttribute("rawMaterialList", result);
		return "rawMaterial/materials_view";
	}
	// 원자재 전체 출력화면 Form
	@RequestMapping(value = "/goMaterials", method = RequestMethod.GET)
	public String goMaterials(Model model) {
		return "redirect:/goMaterialsList";
	}
	
	// 원자재 등록 Form
	@RequestMapping(value = "/goMaterialsInsert", method = RequestMethod.GET)
	public String goMaterialsInsert(Model model) {
		ArrayList<SupplierVO> result = sDAO.supplierAllSelect();
		model.addAttribute("supplierList", result);
		return "rawMaterial/materials_insert";
	}

	// 원자재 수정 Form
	@RequestMapping(value = "/goMaterialsUpdate", method = RequestMethod.POST)
	public String goMaterialsUpdate(RawMaterialVO rawmaterial, Model model) {
		System.out.println("goMaterialsUpdate result : " + rawmaterial);
		RawMaterialVO result = rDAO.rawMaterialOneSelect(rawmaterial);
		model.addAttribute("result", result);
		return "rawMaterial/materials_update";
	}

	// 발주 전체 출력 Form
	@RequestMapping(value = "/goOrder", method = RequestMethod.GET)
	public String goOrder() {
		return "rawMaterial/order_view";
	}

	// 발주 등록 Form
	@RequestMapping(value = "/goOrderInsert", method = RequestMethod.GET)
	public String goOrderInsert() {
		return "rawMaterial/order_insert";
	}

	@RequestMapping(value = "/goBuy", method = RequestMethod.GET)
	public String goBuy() {
		return "rawMaterial/buy";
	}


	@RequestMapping(value = "/production_insert", method = RequestMethod.GET)
	public String production_insert() {
		return "production/production_insert";
	}

	@RequestMapping(value = "/goMoonTest", method = RequestMethod.GET)
	public String goMoonTest() {
		return "rawMaterial/MoonTes";
	}

}