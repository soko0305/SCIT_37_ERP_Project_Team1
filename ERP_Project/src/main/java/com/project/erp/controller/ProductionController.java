package com.project.erp.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.erp.service.ProductionService;
import com.project.erp.service.RawMaterialService;
import com.project.erp.vo.ManufactureVO;
import com.project.erp.vo.ProductMaterialVO;
import com.project.erp.vo.ProductVO;
import com.project.erp.vo.RawMaterialVO;

@Controller
public class ProductionController {

	@Autowired
	ProductionService pService;
	@Autowired
	RawMaterialService rawMaterialService;
	

	
	//생산조회 리스트 조회
	@RequestMapping(value = "/goproducecheck", method = RequestMethod.GET)
	public String goproducecheck( Model model,HttpSession session) {
		ArrayList<ManufactureVO> plist = pService.produceSelect();
		model.addAttribute("producelist", plist);
		
		return "production/producecheck";
	}
	//생산품 수정
	@RequestMapping(value = "/goproduceupdate", method = RequestMethod.GET)
	public String goproduceupdate(String mfseq, Model model) {
		model.addAttribute("mfseq", mfseq);
		return "production/produceupdate";
	}
	
	//생산품 조회 리스트 조회
 	@RequestMapping(value = "/goproductioncheck", method = RequestMethod.GET)
	public String goproductioncheck(Model model,HttpSession session) {
		ArrayList<ProductVO> plist = pService.productionSelect();
		model.addAttribute("productionlist", plist);
		return "production/productioncheck";
	}
 /*	@RequestMapping(value = "/goproductionupdate", method = RequestMethod.GET)
	public String goproductionupdate(ProductVO product, Model model,HttpSession session) {
		ArrayList<ProductVO> plist = pService.productionSelect(product);
		model.addAttribute("productionlist", plist);
		return "production/productionupdate";
	}*/
 	//생산 1개 가져오기
	@RequestMapping(value = "/produceOneSelect", method = RequestMethod.POST)
	public @ResponseBody ManufactureVO produceOneSelect(String mfseq, Model model) {
		ManufactureVO result = pService.produceOneSelect(mfseq);

		return result;
	}
	//메인화면 이동
	@RequestMapping(value="/main", method = RequestMethod.GET)
	public String home(){
		return "main/index";
		}
	
	//생산 삽입
	@RequestMapping(value="/goproduceinsert", method = RequestMethod.GET)
	public String produceinsert(Model model){
		ArrayList<ProductVO> result= pService.productionSelect();
		model.addAttribute("pList",result);
		
		return "production/produceinsert";
	} 
	
	//생산품 삽입
	@RequestMapping(value="/productioninsert", method = RequestMethod.GET)
	public String productioninsert(Model model){
		ArrayList<RawMaterialVO> mList = null;
		mList = rawMaterialService.rawMaterialAllSelect();
		model.addAttribute("materialList", mList);
		return "production/production_insert2";
	} 
 
 


 	@RequestMapping(value="/confirmproductionrequest", method = RequestMethod.GET)
	public String 	confirmproductionrequest(){
		return "production/	confirmproductionrequest";
	} 	
	
	
	//생산품 등록 이동 Form
	@RequestMapping(value = "/gopRegistration", method = RequestMethod.GET)
	public String gopRegistration() {
		return "production/pRegistration";
	}
	@RequestMapping(value = "/gomRegistration", method = RequestMethod.GET)
	public String gomRegistration() {
		return "production/mRegistration";
	}

	//생산 삭제
	@RequestMapping(value = "/deleteProduce", method = RequestMethod.POST)
	public String deleteProduce(ManufactureVO manufacture) {
		int result = pService.deleteProduce(manufacture);
		if (result == 0) {
			return "redirect:/goproducecheck";
		} else {
			return "redirect:/goproducecheck";
		}
	}
	// 생산 완료 변환
	@RequestMapping(value = "/statusProduce", method = RequestMethod.POST)
	public String statusProduce(ManufactureVO manufacture) {
		int result = pService.statusProduce(manufacture);

		if (result == 0) {
			return "redirect:/goproducecheck";
		} else {
			return "redirect:/goproducecheck";
		}
	}	
	// 생산품 삭제
	@RequestMapping(value = "/deleteProduction", method = RequestMethod.POST)
	public String deleteProduction(ProductVO product) {
		int result = pService.deleteProduction(product);
		
		if (result == 0) {
			return "redirect:/goproductioncheck";
		
		} else {
			return "redirect:/goproductioncheck";
		}
 	}
	
	
	//생산품 등록
	@RequestMapping(value = "/insertProuct", method = RequestMethod.POST)
	public @ResponseBody String insertProuct(ProductVO product) {
			int result =pService.productionInsert(product);
			ProductVO p =null;
			if(result !=0){
				p = pService.selectLatestProduct();
			}
			return p.getPd_code();
	}

	//생산품 삽입
	@RequestMapping(value = "/produceInsert", method = RequestMethod.POST)
	public String produceInsert(ManufactureVO manufacture, HttpSession session) {
		manufacture.setManuf_requserid((String)session.getAttribute("loginid"));
		int result = pService.produceInsert(manufacture);
		if (result == 0) {
			return "redirect:/goproducecheck";
		} else {
			return "redirect:/goproducecheck";
		}
	}

	//pd_code로 원자재 다 들고오기
	@RequestMapping(value = "/amount", method = RequestMethod.GET)
	public String amount(String pd_code, Model model) {
		ArrayList<ProductMaterialVO> result = pService.selectAllProductMaterial(pd_code);
		model.addAttribute("pmList", result);
		return "production/amount";
	}
	
	//pd_code로 원자재 체크
		@RequestMapping(value = "/amountCheck", method = RequestMethod.GET)
		public @ResponseBody ArrayList<ProductMaterialVO> amount(String pd_code) {
			ArrayList<ProductMaterialVO> result = pService.selectAllProductMaterial(pd_code);
			return result;
		}

	//생산품 업데이트
	@RequestMapping(value = "/updateProuct", method = RequestMethod.POST)
	public @ResponseBody int updateProuct(ProductVO product) {
			int result =pService.productionUpdate(product);
			int result2 =pService.deleteProudctMaterial(product.getPd_code());
			if(result!=0&&result2!=0){
				return 1; 
			}else{
			return 0;
			}
	}
	 
	// 생산 수정
	@ExceptionHandler
	@RequestMapping(value = "/produceUpdate", method = RequestMethod.POST)
	public String produceUpdate(ManufactureVO manufacture, HttpSession session) {
		manufacture.setManuf_requserid((String)session.getAttribute("loginid"));
		int result = pService.produceUpdate(manufacture);

		if (result == 0) {
			return "redirect:/goproducecheck";
		} else {
			return "redirect:/goproducecheck";
		}
	}
	//생산품 업데이트로 가기
	@RequestMapping(value = "/goProductionUpdate", method = RequestMethod.GET)
	public String goProductionUpdate(String pd_code, Model model) {
		ProductVO product = pService.selelctProductByCode(pd_code);
		ArrayList<ProductMaterialVO> pmList = pService.selectAllProductMaterial(pd_code);
		ArrayList<RawMaterialVO> mList = null;
		mList = rawMaterialService.rawMaterialAllSelect();
		model.addAttribute("materialList", mList);
		model.addAttribute("product", product);
		model.addAttribute("pmList", pmList);
		return "production/production_update";
	}
	
}
