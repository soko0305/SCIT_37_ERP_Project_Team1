package com.project.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.erp.dao.OrderDAO;
import com.project.erp.dao.RawMaterialDAO;
import com.project.erp.vo.Order_rawMaterialVO;
import com.project.erp.vo.RawMaterialVO;

@Controller
public class OrderController {

	@Autowired
	RawMaterialDAO rDAO;
	@Autowired
	OrderDAO oDAO;
	
	@RequestMapping(value="/autoSelect", method=RequestMethod.GET)
	public @ResponseBody RawMaterialVO autoSelect(String rawm_code) {
		RawMaterialVO result =  rDAO.rawMaterialOneSelect(rawm_code);
		return result;
	}
	
	@RequestMapping(value="/orderInsert", method=RequestMethod.POST)
	public String orderInsert(Order_rawMaterialVO order) {
		int result = oDAO.orderInsert(order);
		
		if(result == 0) {
			return "/rawMaterial/all_view";
		}else {
			return "/rawMaterial/order_view";
		}
	}
}
