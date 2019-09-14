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
	
	//생산조회 리스트 조회
	@RequestMapping(value = "/goproducecheck", method = RequestMethod.GET)
	public String goproducecheck(ManufactureVO manufacture, Model model,HttpSession session) {
		ArrayList<ManufactureVO> plist = pService.produceSelect(manufacture);
		model.addAttribute("producelist", plist);
		return "production/producecheck";
	}
	//생산품 조회 리스트 조회
 	@RequestMapping(value = "/goproductioncheck", method = RequestMethod.GET)
	public String goproductioncheck(ProductVO product, Model model,HttpSession session) {
		ArrayList<ProductVO> plist = pService.productionSelect(product);
		model.addAttribute("productionlist", plist);
		return "production/productioncheck";
	}
	//생산조회
	@RequestMapping(value="/producecheck", method = RequestMethod.GET)
	public String producecheck(){
		return "production/producecheck";
	} 
	
	//메인화면 이동
	@RequestMapping(value="/main", method = RequestMethod.GET)
	public String home(){
		return "main/index";
		}
	
	//생산 삽입
	@RequestMapping(value="/produceinsert", method = RequestMethod.GET)
	public String produceinsert(){
		return "production/produceinsert";
	} 
	
	//생산품 삽입
	@RequestMapping(value="/productioninsert", method = RequestMethod.GET)
	public String productioninsert(){
		return "production/production_insert2";
	} 
 
 
	//생산품 조회
	@RequestMapping(value="/productioncheck", method = RequestMethod.GET)
	public String productioncheck(){
		return "production/productioncheck";
	} 
	@RequestMapping(value="/sample", method = RequestMethod.GET)
	public String sample(){
		return "production/sample";
	} 	

 	@RequestMapping(value="/confirmproductionrequest", method = RequestMethod.GET)
	public String 	confirmproductionrequest(){
		return "production/	confirmproductionrequest";
	} 	
	
	//
	//생산품 등록 이동 Form
	@RequestMapping(value = "/gopRegistration", method = RequestMethod.GET)
	public String gopRegistration() {
		return "production/pRegistration";
	}
	@RequestMapping(value = "/gomRegistration", method = RequestMethod.GET)
	public String gomRegistration() {
		return "production/mRegistration";
	}
	// 생산품 삭제
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
	public String deleteProduct(ProductVO product) {
		
		int result = pService.deleteProduct(product);

		if (result == 0) {
			return "redirect:/goproductioncheck";
		} else {
			return "redirect:/goproductioncheck";
		}
	}
}
