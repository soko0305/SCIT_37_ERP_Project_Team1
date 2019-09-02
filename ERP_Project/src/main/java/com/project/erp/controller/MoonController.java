package com.project.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MoonController {

	@RequestMapping(value="/goSupplier", method = RequestMethod.GET)
	public String goSupplier(){
		return "supplier_view";
	}
	@RequestMapping(value="/goMaterials", method = RequestMethod.GET)
	public String goMaterials(){
		return "materials_view";
	}
	@RequestMapping(value="/goOrder", method = RequestMethod.GET)
	public String goOrder(){
		return "orderCheck";
	}
	@RequestMapping(value="/goBuy", method = RequestMethod.GET)
	public String goBuy(){
		return "buy";
	}
}
