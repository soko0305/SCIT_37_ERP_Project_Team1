package com.project.erp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.erp.dao.OrderDAO;
import com.project.erp.dao.RawMaterialDAO;
import com.project.erp.dao.SupplierDAO;
import com.project.erp.service.RawMaterialService;
import com.project.erp.service.SupplierService;
import com.project.erp.vo.Order_rawMaterialVO;
import com.project.erp.vo.RawMaterialVO;
import com.project.erp.vo.SupplierVO;

@Controller
public class RawMaterialLinkController {

	@Autowired
	SupplierService sService;

	@Autowired
	RawMaterialService rService;
	
	@Autowired
	OrderDAO oDAO;

	// 대쉬보드 메인 화면 Form
	@RequestMapping(value = "/goAllView", method = RequestMethod.GET)
	public String goAllView(Model model) {
		ArrayList<SupplierVO> result = sService.supplierDashSelect();
		model.addAttribute("supplierList", result);

		ArrayList<RawMaterialVO> result1 = rService.rawMaterialDashSelect();
		model.addAttribute("rawMaterialList", result1);
		
		ArrayList<Order_rawMaterialVO> result2 =  oDAO.orderDashSelect();
		model.addAttribute("orderList", result2);
		
		return "rawMaterial/All_view";
	}

	// 공급처 출력을 위한 redirect(List출력)
	@RequestMapping(value = "/goSupplierList", method = RequestMethod.GET)
	public String goSupplierList(Model model) {
		ArrayList<SupplierVO> result = sService.supplierAllSelect();
		model.addAttribute("supplierList", result);
		return "rawMaterial/supplier_view";
	}

	// 공급처 전체 출력화면 Form
	@RequestMapping(value = "/goSupplier", method = RequestMethod.GET)
	public String goSupplier() {
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
		SupplierVO result = sService.supplierOneSelect(supplier);
		model.addAttribute("result", result);
		return "rawMaterial/supplier_update";
	}

	//
	//
	// 원자재 출력을 위한 redirect(List출력)
	@RequestMapping(value = "/goMaterialsList", method = RequestMethod.GET)
	public String goMaterialsList(Model model) {
		ArrayList<RawMaterialVO> result = rService.rawMaterialAllSelect();
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
		ArrayList<SupplierVO> result = sService.supplierAllSelect();
		model.addAttribute("supplierList", result);
		return "rawMaterial/materials_insert";
	}

	// 원자재 수정 Form
	@RequestMapping(value = "/goMaterialsUpdate", method = RequestMethod.GET)
	public String goMaterialsUpdate(String rawm_code, Model model) {
		/*RawMaterialVO result = rService.rawMaterialOneSelect(rawm_code);
		model.addAttribute("result", result);*/
		ArrayList<SupplierVO> result1 = sService.supplierAllSelect();
		model.addAttribute("supplierList", result1);
		
		model.addAttribute("rawm_code", rawm_code);
		return "rawMaterial/materials_update";
	}
	// 원자재 하나 가져오기
	@RequestMapping(value = "/rawMaterialOneSelect", method = RequestMethod.POST)
	public @ResponseBody RawMaterialVO rawMaterialOneSelect(String rawm_code, Model model) {
		RawMaterialVO result = rService.rawMaterialOneSelect(rawm_code);
		return result;
	}
	//
	//
	// 발주 전체 출력 Form
	@RequestMapping(value = "/goOrder", method = RequestMethod.GET)
	public String goOrder() {
		return "rawMaterial/order_view";
	}

	// 발주 등록 Form
	@RequestMapping(value = "/goOrderInsert", method = RequestMethod.GET)
	public String goOrderInsert(Model model) {
		ArrayList<RawMaterialVO> result = rService.rawMaterialAllSelect();
		model.addAttribute("rList", result);
		return "rawMaterial/order_insert";
	}
	//
	//
	// 구매 관리 전체 출력 Form
	@RequestMapping(value = "/goArrive", method = RequestMethod.GET)
	public String goArrive(Model model) {
		ArrayList<Order_rawMaterialVO> result = oDAO.orderAllselect();
		model.addAttribute("oList", result);
		return "rawMaterial/arrive";
	}

	@RequestMapping(value = "/production_insert", method = RequestMethod.GET)
	public String production_insert() {
		return "production/production_insert";
	}

}
