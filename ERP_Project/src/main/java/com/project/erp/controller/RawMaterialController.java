package com.project.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.erp.service.RawMaterialService;
import com.project.erp.vo.RawMaterialVO;

@Controller
public class RawMaterialController {

	@Autowired
	RawMaterialService rService;

	// 원자재 등록
	@RequestMapping(value = "/rawMaterialInsert", method = RequestMethod.POST)
	public String rawMaterialInsert(RawMaterialVO rawmaterial) {

		int result = rService.rawMaterialInsert(rawmaterial);

		if (result == 0) {
			return "/rawMaterial/all_view";
		} else {
			return "redirect:/goMaterialsList";
		}
	}

	// 원자재 삭제
	@RequestMapping(value = "/rawMaterialDelete", method = RequestMethod.POST)
	public String rawMaterialDelete(RawMaterialVO rawmaterial) {
		System.out.println("rdelete : " + rawmaterial);
		int result = rService.rawMaterialDelete(rawmaterial);

		if (result == 0) {
			return "/rawMaterial/all_view";
		} else {
			return "redirect:/goMaterialsList";
		}
	}

	// 원자재 수정
	@ExceptionHandler
	@RequestMapping(value = "/rawMaterialUpdate", method = RequestMethod.POST)
	public String rawMaterialUpdate(RawMaterialVO rawmaterial) {

		int result = rService.rawMaterialUpdate(rawmaterial);

		if (result == 0) {
			return "/rawMaterial/all_view";
		} else {
			return "redirect:/goMaterialsList";
		}
	}
}
