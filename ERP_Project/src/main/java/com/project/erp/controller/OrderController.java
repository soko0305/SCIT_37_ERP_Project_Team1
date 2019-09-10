package com.project.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.erp.dao.RawMaterialDAO;
import com.project.erp.vo.RawMaterialVO;

@Controller
public class OrderController {

	@Autowired
	RawMaterialDAO rDAO;
	
	@RequestMapping(value="/autoSelect", method=RequestMethod.GET)
	public @ResponseBody RawMaterialVO autoSelect(String rawm_code) {
		RawMaterialVO result =  rDAO.rawMaterialOneSelect(rawm_code);
		return result;
	}
}
