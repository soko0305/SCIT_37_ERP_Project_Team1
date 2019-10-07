package com.project.erp.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.erp.service.InventoryService;
import com.project.erp.vo.CheckstockVO;
import com.project.erp.vo.ProductVO;
import com.project.erp.vo.RawMaterialVO;
import com.project.erp.vo.SupplierVO;

@Controller
public class InventoryController {
	
	@Autowired
	InventoryService inventoryService;
	int flag = 0;
	int amount= 0;
	String code = null;
	String warehouse_code = null;
	


	@RequestMapping(value="/selectSupplierBySeq", method = RequestMethod.GET)
	public @ResponseBody SupplierVO selectSupplierBySeq(String supplierseq){
		SupplierVO s = null;
		s = inventoryService.selectSupplierBySeq(supplierseq);
		return s;
	}
	
	@RequestMapping(value="/selectMaterialByCode", method = RequestMethod.GET)
	public @ResponseBody RawMaterialVO selectMaterialByCode(String rawm_code){
		RawMaterialVO m = null;
		m = inventoryService.selectMaterialByCode(rawm_code);
		return m;
	}
	
	
	
	@RequestMapping(value="/selectProductByCode", method = RequestMethod.GET)
	public @ResponseBody ProductVO selectProductByCode(String pd_code){
		ProductVO p = null;
		p = inventoryService.selectProductByCode(pd_code);
		return p;
	}

	@RequestMapping(value="/selectDistinctMaterialSupplier", method = RequestMethod.GET)
	public @ResponseBody ArrayList<SupplierVO> selectDistinctMaterialSupplier(){
		ArrayList<SupplierVO> sList = null;
		sList = inventoryService.selectDistinctMaterialSupplier();
		return sList;
	}
	
	
	@RequestMapping(value="/selectDistinctMaterialSort", method = RequestMethod.GET)
	public @ResponseBody ArrayList<RawMaterialVO> selectDistinctMaterialSort(){
		ArrayList<RawMaterialVO> mList = null;
		mList = inventoryService.selectDistinctMaterialSort();
		return mList;
	}

	
	@RequestMapping(value="/selectDistinctProductSort", method = RequestMethod.GET)
	public @ResponseBody ArrayList<ProductVO> selectDistinctProductSort(){
		ArrayList<ProductVO> pList = null;
		pList = inventoryService.selectDistinctProductSort();
		return pList;
	}
	
	@RequestMapping(value="/setProductMaterialInfo", method = RequestMethod.POST)
	public @ResponseBody void setProductMaterialInfo(ProductVO product){
		code= product.getPd_code();
		amount = product.getAmount();
		warehouse_code = product.getWarehouse_code();
	}
	
	@RequestMapping(value="/setRawMaterialInfo", method = RequestMethod.POST)
	public @ResponseBody void setRawMaterialInfo(RawMaterialVO rawmaterial){
		code= rawmaterial.getRawm_code();
		amount = rawmaterial.getAmount();
		warehouse_code = rawmaterial.getWarehouse_code();
	}
	
	
	@RequestMapping(value="/getCodeANDAmount", method = RequestMethod.POST)
	public @ResponseBody RawMaterialVO getCodeANDAmount(){
		RawMaterialVO rawmaterial = new RawMaterialVO();
		rawmaterial.setRawm_code(code);
		rawmaterial.setAmount(amount);
		rawmaterial.setWarehouse_code(warehouse_code);
		code = null;
		amount =0;
		return rawmaterial;
	}
	
	@RequestMapping(value="/confirmInvenWizNoProbs", method = RequestMethod.POST)
	public @ResponseBody void confirmInvenWizNoProbs(CheckstockVO checkstock, HttpSession session){
		int check =0;
		checkstock.setCheckstock_adminid((String)session.getAttribute("loginid"));
		check = inventoryService.confirmInvenWizNoProbs(checkstock);
	}
	
	@RequestMapping(value="/confirmInvenWizProbs", method = RequestMethod.POST)
	public @ResponseBody void confirmInvenWizProbs(CheckstockVO checkstock, HttpSession session){
		int check =0;
		checkstock.setCheckstock_adminid((String)session.getAttribute("loginid"));
		check = inventoryService.confirmInvenWizProbs(checkstock);
	}
	
}
