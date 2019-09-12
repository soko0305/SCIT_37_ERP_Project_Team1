package com.project.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.erp.service.ProductionService;
import com.project.erp.vo.ProductVO;

@Controller
public class ProductionController {

	@Autowired
	ProductionService pService;
	
	//생산풍 등록
	@RequestMapping(value="/productionInsert", method=RequestMethod.POST)
	public String productionInsert(ProductVO product) {
		System.out.println("pInsert : " + product);
		int result =pService.productionInsert(product);
		if(result == 0) {
			return "production/producecheck";
		}else {
			return "production/producecheck";
		}
	}
}
