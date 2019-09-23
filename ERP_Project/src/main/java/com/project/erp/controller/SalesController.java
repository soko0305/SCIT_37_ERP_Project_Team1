package com.project.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.project.erp.service.SalesService;
import com.project.erp.vo.Buyer;
import com.project.erp.vo.Sales;
import com.project.erp.vo.SalesDetail;

@Controller
public class SalesController {
	
	@Autowired
	SalesService service;
	
	
	//엑셀을 직접 업로드 했을 때, SALES와 SALESDETAIL을 DB에 저장시키는 메소드.
	@RequestMapping(value="/insertData", method = RequestMethod.POST)
	public @ResponseBody String insertData(@RequestBody String excelJson){
		String result = service.insertData(excelJson);
		return result;
	}
	
	//모든 리스트 뿌려줄 때 호출할 메소드.
	@RequestMapping(value="/selectSalesWithoutDone", method = RequestMethod.GET)
	public @ResponseBody List<Sales> selectSalesWithoutDone(){
		List<Sales> list = service.selectSalesWithoutDone();
		return list;
	}
	
	@RequestMapping(value="/getDetails", method = RequestMethod.GET)
	public @ResponseBody List<SalesDetail> getDetails(SalesDetail salesDetail){
		List<SalesDetail> list = service.selectSalesDetailByOrdernum(salesDetail);
		return list;
	}
	
	@RequestMapping(value="/insertBuyerToDb", method=RequestMethod.POST)
	public int insertBuyer(Buyer buyer){
		int result = service.insertBuyer(buyer);
		return result;
	}
	
	@RequestMapping(value="/deleteBuyer", method=RequestMethod.POST)
	public String deleteBuyer(Buyer buyer){
		service.deleteBuyer(buyer);
		return "redirect:/buyerList";
	}
	
	@RequestMapping(value="/updateBuyer", method=RequestMethod.POST)
	public String updateBuyer(Buyer buyer){
		service.updateBuyer(buyer);
		return "redirect:/buyerList";
	}
	
	
}
