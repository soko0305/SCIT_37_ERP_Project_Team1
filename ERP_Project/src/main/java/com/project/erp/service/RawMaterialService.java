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
	
	//원자재 등록
	public int rawMaterialInsert(RawMaterialVO rawmaterial) {
		String check = "N";
		rawmaterial.setRawm_delete(check);
		return rDAO.rawMaterialInsert(rawmaterial);
		
	}
	//원자재 전체 출력
	public ArrayList<RawMaterialVO> rawMaterialAllSelect() {
		return rDAO.rawMaterialAllSelect();
		
	}
	//원자재 한개 가져오기
	public RawMaterialVO rawMaterialOneSelect(String rawm_code) {
		return rDAO.rawMaterialOneSelect(rawm_code);
		
	}
	//원자재 삭제(삭제여부로 블라인드처리)
	public int rawMaterialDelete(RawMaterialVO rawmaterial) {
		String check = "Y";
		rawmaterial.setRawm_delete(check);
		return rDAO.rawMaterialDelete(rawmaterial);
		
	}
	//원자재 대쉬보드 3개만 출력
	public ArrayList<RawMaterialVO> rawMaterialDashSelect() {
		return rDAO.rawMaterialDashSelect();
		
	}
	//원자재 수정
	public int rawMaterialUpdate(RawMaterialVO rawmaterial) {
		return rDAO.rawMaterialUpdate(rawmaterial);
		
	}
}
