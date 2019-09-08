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
	
	//공급처 등록
	@RequestMapping(value = "/rawMaterialInsert", method = RequestMethod.POST)
	public String rawMaterialInsert(RawMaterialVO rawmaterial) {
		
		int result = rDAO.rawMaterialInsert(rawmaterial);

		if (result == 0) {
			return "/rawMaterial/all_view";
		} else {
			
			return "/rawMaterial/materials_insert";
		}
	}
}
