package com.project.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.erp.service.SalesService;
import com.project.erp.vo.Buyer;
import com.project.erp.vo.Sales;




@Controller
public class LinkController {

	@Autowired SalesService service;
	
	@RequestMapping(value="/buyerList", method = RequestMethod.GET)
	public String Management1(Model model){
		List<Buyer> list1 = null;
		list1 = service.selectAllBuyer();
		model.addAttribute("buyerList", list1);
		return "sales/buyerList";
	}
	
	@RequestMapping(value="/realTimeOffer", method = RequestMethod.GET)
	public String Management2(Model model){
		List<Sales> list1 = null;
		list1 = service.selectAllSales();
		model.addAttribute("salesList", list1);
		return "sales/realTimeOffer";
	}

	@RequestMapping(value="/salesHistory", method = RequestMethod.GET)
	public String Management4(Model model){
		List<Sales> list1 = null;
		list1 = service.selectSalesStatusIsDone();
		model.addAttribute("salesList", list1);
		return "sales/salesHistory";
	}
	@RequestMapping(value="/insertBuyer", method = RequestMethod.GET)
	public String inserBuyer(Model model){
		
		return "sales/insertBuyer";
	}
}
