package com.project.erp.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.erp.service.ProductionService;
import com.project.erp.vo.BoardVO;
import com.project.erp.vo.ManufactureVO;
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
	
	@RequestMapping(value = "/goproducecheck", method = RequestMethod.GET)
	public String goproducecheck(ManufactureVO manufacture, Model model,HttpSession session) {
		ArrayList<ManufactureVO> result = pService.produceSelect(manufacture);
		model.addAttribute("producelist", result);
		return "production/producecheck";
	}
	
}
