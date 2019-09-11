package com.project.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.erp.dao.SalesDAO;
import com.project.erp.vo.Sales;
import com.project.erp.vo.SalesDetail;




@Controller
public class LinkController {

	@Autowired SalesDAO dao;
	
	@RequestMapping(value="/buyerList", method = RequestMethod.GET)
	public String Management1(){
		return "sales/buyerList";
	}
	
	@RequestMapping(value="/realTimeOffer", method = RequestMethod.GET)
	public String Management2(Model model){
		List<Sales> list1 = null;
		list1 = dao.selectAllSales();
		
		model.addAttribute("salesList", list1);
		return "sales/realTimeOffer";
	}

	@RequestMapping(value="/salesHistory", method = RequestMethod.GET)
	public String Management4(Model model){
		
		List<Sales> list1 = null;
		list1 = dao.selectSalesStatusIsDone();
		model.addAttribute("salesList", list1);
		
		return "sales/salesHistory";
	}
}
