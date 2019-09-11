package com.project.erp.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.RawMaterialVO;

@Mapper
@Repository
public interface RawMaterialMapper {

	public int rawMaterialInsert(RawMaterialVO rawmaterial);				//원자재 등록
	
	public ArrayList<RawMaterialVO> rawMaterialAllSelect();					//원자재 전체 출력
	
	public RawMaterialVO rawMaterialOneSelect(String rawm_code);	//원자재 선택 출력
	
	public int rawMaterialDelete(RawMaterialVO rawmaterial);				//원자재 삭제
	
	public ArrayList<RawMaterialVO> rawMaterialDashSelect();				//원자재 3개 출력
	
	public int rawMaterialUpdate(RawMaterialVO rawmaterial);		//원자재 수정
}
