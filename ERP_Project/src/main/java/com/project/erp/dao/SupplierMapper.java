package com.project.erp.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.SupplierVO;

@Mapper
@Repository
public interface SupplierMapper {

	public int supplierInsert(SupplierVO supplier);				//공급처 등록
	
	public ArrayList<SupplierVO> supplierAllSelect();			//공급처 전체 출력
	
	public SupplierVO supplierOneSelect(SupplierVO supplier);	//공급처 선택 출력

	public int supplierDelete(SupplierVO supplier);				//공급처 삭	제
	
	public int supplierUpdate(SupplierVO supplier);				//공급처 수정
	
	public ArrayList<SupplierVO> supplierDashSelect();			//공급처 3개 출력
}
