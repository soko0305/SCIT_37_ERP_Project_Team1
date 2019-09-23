package com.project.erp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.erp.dao.RawMaterialDAO;
import com.project.erp.service.OrderService;
import com.project.erp.vo.Order_rawMaterialVO;
import com.project.erp.vo.RawMaterialVO;

@Controller
public class OrderController {

	@Autowired
	RawMaterialDAO rDAO;
	@Autowired
	OrderService oService;

	// 공급처 코드를 가져오기
	@RequestMapping(value = "/autoSelect", method = RequestMethod.GET)
	public @ResponseBody RawMaterialVO autoSelect(String rawm_code) {
		RawMaterialVO result = rDAO.rawMaterialOneSelect(rawm_code);
		return result;
	}

	// 발주 요청 한개 가져오기
	@RequestMapping(value = "/requestOneSelect", method = RequestMethod.GET)
	public @ResponseBody Order_rawMaterialVO requestOneSelect(String rmorder_code) {
		Order_rawMaterialVO result = oService.requestOneSelect(rmorder_code);
		return result;
	}

	@RequestMapping(value = "/orderInsert", method = RequestMethod.POST)
	public String orderInsert(Order_rawMaterialVO order) {
		System.out.println("order : " + order);
		int result = oService.orderInsert(order);

		if (result == 0) {
			return "/rawMaterial/all_view";
		} else {
			return "/rawMaterial/order_view";
		}
	}

	@RequestMapping(value = "/orderUpdate", method = RequestMethod.POST)
	public String orderUpdate(Order_rawMaterialVO order, Model model) {
		int result = oService.orderUpdate(order);

		if (result == 0) {
			return "/rawMaterial/all_view";
		} else {
			ArrayList<Order_rawMaterialVO> result1 = oService.orderAllselect();
			model.addAttribute("oList", result1);
			return "/rawMaterial/arrive";
		}
	}

	// 원자재 요청
	@RequestMapping(value = "/rawMaterialRequest", method = RequestMethod.POST)
	public String rawMaterialRequest(Order_rawMaterialVO rawmaterial) {
		System.out.println("request : " + rawmaterial);
		int result = oService.rawMaterialRequest(rawmaterial);

		if (result == 0) {
			return "/rawMaterial/all_view";
		} else {
			return "redirect:/goMaterialsList";
		}
	}
}
