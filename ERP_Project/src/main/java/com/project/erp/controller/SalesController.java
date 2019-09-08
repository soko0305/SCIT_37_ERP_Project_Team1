package com.project.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.project.erp.dao.SalesDAO;
import com.project.erp.vo.Buyer;
import com.project.erp.vo.Sales;

@Controller
public class SalesController {
	
	@Autowired SalesDAO dao;

	@RequestMapping(value="/insertData", method = RequestMethod.POST)
	public @ResponseBody String insertData(@RequestBody String excelJson){
		
		String sales_ordernum = null;
		String company = null;
		int totalPrice = 0;
		
		JsonParser jsonParser = new JsonParser();
		JsonArray jsonArray = (JsonArray) jsonParser.parse(excelJson);
		
		for (int i = 0; i < jsonArray.size(); i++) {
			JsonObject object = (JsonObject) jsonArray.get(i);
			
			try{
			if(object.get("sales_ordernum").getAsString() == null){
				JsonObject object1 = (JsonObject) jsonArray.get(0);
				sales_ordernum = object1.get("sales_ordernum").getAsString();
				company = object1.get("company").getAsString();
			}else{
				sales_ordernum = object.get("sales_ordernum").getAsString();
				company = object.get("company").getAsString();
			}}catch(NullPointerException e){
				System.out.println();
			}
			
			
			String salesdetail_name = object.get("salesdetail_name").getAsString();
			String pd_code = object.get("pd_code").getAsString();
			String salesdetail_amount = object.get("salesdetail_amount").getAsString();
			String salesdetail_price = object.get("salesdetail_price").getAsString();
			
			totalPrice += Integer.parseInt(salesdetail_price);
			
			System.out.println(company);
			System.out.println(sales_ordernum);
			System.out.println(salesdetail_name);
			System.out.println(pd_code);
			System.out.println(salesdetail_price);
			System.out.println(salesdetail_amount);
			
			}
		
		String price = Integer.toString(totalPrice);
		

		Buyer buyer = new Buyer();
		buyer.setBuyer_corp(company);
		Buyer buyer1 = dao.SelectOneBuyer(buyer);
		

		Sales sales = new Sales();
		sales.setBuyerseq(buyer1.getBuyerseq());
		sales.setSales_totalprice(price);
		dao.insertSales(sales);
		
		

		return "ok";
	}
	
}
