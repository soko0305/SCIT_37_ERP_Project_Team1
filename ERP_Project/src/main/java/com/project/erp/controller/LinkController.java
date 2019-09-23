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
import com.project.erp.vo.SalesDetail;




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
		list1 = service.selectSalesWithoutDone();
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
	public String insertBuyer(){	
		return "sales/insertBuyer";
	}
	
	@RequestMapping(value="/buyerListDetail", method=RequestMethod.GET)
	public String buyerListDetail(Buyer buyer, Model model){
		Buyer buyer1 = null;
		buyer1 = service.selectBuyer(buyer);
		model.addAttribute("buyer", buyer1);
		return "sales/buyerDetails";
	}
	
	@RequestMapping(value="/realTimeOfferDetail", method=RequestMethod.GET)
	public String realTimeOfferDetail(SalesDetail salesDetail, Model model){
		List<SalesDetail> list = service.selectSalesDetailByOrdernum(salesDetail);
		model.addAttribute("salesDetailList", list);
		return "sales/realTimeOfferDetail";
	}
	
	@RequestMapping(value="/salesHistoryDetail", method=RequestMethod.GET)
	public String salesHistoryDetail(Sales sales, Model model){
		String seq = sales.getBuyerseq();
		String num = sales.getSales_ordernum();
		
		Buyer buyer = new Buyer();
		buyer.setBuyerseq(seq);
		
		SalesDetail salesDetail = new SalesDetail();
		salesDetail.setSales_ordernum(num);
		
		List<SalesDetail> list = service.selectSalesDetailByOrdernum(salesDetail);
		Sales sale = service.selectSalesByOrdernum(sales);
		Buyer buyer1 = service.selectBuyer(buyer);
		
		model.addAttribute("sales", sale);
		model.addAttribute("buyer", buyer1);
		model.addAttribute("detailList", list);
		
		return "sales/invoice";
	}
}
