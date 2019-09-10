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
import com.project.erp.dao.SalesDAO;
import com.project.erp.vo.Buyer;
import com.project.erp.vo.Sales;
import com.project.erp.vo.SalesDetail;

@Controller
public class SalesController {
	
	@Autowired SalesDAO dao;

	//엑셀을 직접 업로드 했을 때, SALES와 SALESDETAIL을 DB에 저장시키는 메소드.
	@RequestMapping(value="/insertData", method = RequestMethod.POST)
	public @ResponseBody String insertData(@RequestBody String excelJson){
		int result1 = 0;
		int result2 = 0;
		
		String sales_ordernum = null;
		String company = null;
		String salesdetail_name = null;
		String pd_code = null;
		String salesdetail_amount = null;
		String salesdetail_price = null;
		
		int totalPrice = 0;
		
		Sales sales = new Sales();
		
		String salestitle = null;
		
		JsonParser jsonParser = new JsonParser();
		JsonArray jsonArray = (JsonArray) jsonParser.parse(excelJson);
		
		for (int i = 0; i < jsonArray.size(); i++) {
			JsonObject object = (JsonObject) jsonArray.get(i);
			
			// ordernumber는 맨 위에 셀에만 정보가 기재되어있기 때문에, 0번째 루프 돌때의 정보만 삽입되어야함.
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
			
			salesdetail_name = object.get("salesdetail_name").getAsString();
			pd_code = object.get("pd_code").getAsString();
			salesdetail_amount = object.get("salesdetail_amount").getAsString();
			salesdetail_price = object.get("salesdetail_price").getAsString();
				
				
			//totalPrice 계산.
			totalPrice += Integer.parseInt(salesdetail_price);
			String price = Integer.toString(totalPrice);
			
			
			if(i==0){
			//회사이름으로 바이어 시퀀스 불러오기.
			Buyer buyer = new Buyer();
			buyer.setBuyer_corp(company);
			Buyer buyer1 = dao.selectOneBuyer(buyer);
			
			//Sales 객체를 DB에 저장하는 메소드.
			
			sales.setSales_ordernum(sales_ordernum);
			sales.setBuyerseq(buyer1.getBuyerseq());
			sales.setBuyer_corp(company);
			sales.setSales_title("0");
			sales.setSales_totalprice("0");
			dao.insertSales(sales);
			}
			
			if(i==jsonArray.size()-1){
			salestitle=salesdetail_name+" 외 "+Integer.toString(jsonArray.size()-1)+" 건";
			sales.setSales_totalprice(price);
			sales.setSales_title(salestitle);
			result1 = dao.setSalesPrice(sales);
			}
			
			//SalesDetail 객체를 DB에 저장하는 메소드.
			SalesDetail salesDetail = new SalesDetail();
			salesDetail.setSalesdetail_name(salesdetail_name);
			salesDetail.setSalesdetail_amount(salesdetail_amount);
			salesDetail.setSalesdetail_price(salesdetail_price);
			salesDetail.setSales_ordernum(sales_ordernum);
			salesDetail.setPd_code(pd_code);
			result2 = dao.insertSalesDetail(salesDetail);
		
			}
			
			if(result1==1 && result2 ==1){return "ok";
			}else{
				return "no";
			}
	}
	
	
	@RequestMapping(value="/selectAllSales", method = RequestMethod.GET)
	public @ResponseBody List<Sales> selectAllSales(){
		List<Sales> list1 = dao.selectAllSales();
		System.out.println(list1);
		return list1;
	}
	
	
}
