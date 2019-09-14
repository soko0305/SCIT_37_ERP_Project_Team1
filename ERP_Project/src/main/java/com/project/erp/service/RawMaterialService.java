package com.project.erp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.erp.dao.RawMaterialDAO;
import com.project.erp.vo.RawMaterialVO;

@Service
public class RawMaterialService {

	@Autowired
	RawMaterialDAO rDAO;
	
	public int rawMaterialInsert(RawMaterialVO rawmaterial) {
		String check = "N";
		rawmaterial.setRawm_delete(check);
		return rDAO.rawMaterialInsert(rawmaterial);
		
	}
	public ArrayList<RawMaterialVO> rawMaterialAllSelect() {
		return rDAO.rawMaterialAllSelect();
		
	}
	
	public RawMaterialVO rawMaterialOneSelect(String rawm_code) {
		return rDAO.rawMaterialOneSelect(rawm_code);
		
	}
	
	public int rawMaterialDelete(RawMaterialVO rawmaterial) {
		String check = "Y";
		rawmaterial.setRawm_delete(check);
		return rDAO.rawMaterialDelete(rawmaterial);
		
	}
	
	public ArrayList<RawMaterialVO> rawMaterialDashSelect() {
		return rDAO.rawMaterialDashSelect();
		
	}
	
	public int rawMaterialUpdate(RawMaterialVO rawmaterial) {
		return rDAO.rawMaterialUpdate(rawmaterial);
		
	}
	
}
