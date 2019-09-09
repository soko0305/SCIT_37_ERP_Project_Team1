package com.project.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.erp.dao.RawMaterialDAO;
import com.project.erp.vo.RawMaterialVO;

@Controller
public class RawMaterialController {

	@Autowired
	RawMaterialDAO rDAO;

	// 원자재 등록
	@RequestMapping(value = "/rawMaterialInsert", method = RequestMethod.POST)
	public String rawMaterialInsert(RawMaterialVO rawmaterial) {

		int result = rDAO.rawMaterialInsert(rawmaterial);

		if (result == 0) {
			return "/rawMaterial/all_view";
		} else {
			return "redirect:/goMaterialsList";
		}
	}

	// 원자재 삭제
	@RequestMapping(value = "/rawMaterialDelete", method = RequestMethod.POST)
	public String rawMaterialDelete(RawMaterialVO rawmaterial) {

		int result = rDAO.rawMaterialDelete(rawmaterial);

		if (result == 0) {
			return "/rawMaterial/all_view";
		} else {
			return "redirect:/goMaterialsList";
		}
	}
	
	// 원자재 수정
		@RequestMapping(value = "/rawMaterialUpdate", method = RequestMethod.POST)
		public String rawMaterialUpdate(RawMaterialVO rawmaterial) {
			System.out.println("rMUpdate : " + rawmaterial);
			int result = rDAO.rawMaterialUpdate(rawmaterial);
			
			
			if (result == 0) {
				return "/rawMaterial/all_view";
			} else {
				return "redirect:/goMaterialsList";
			}
		}
}
