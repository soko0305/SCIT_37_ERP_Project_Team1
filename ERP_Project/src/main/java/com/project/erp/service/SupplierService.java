package com.project.erp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.erp.dao.SupplierDAO;
import com.project.erp.vo.SupplierVO;

@Service
public class SupplierService {

	@Autowired
	SupplierDAO sDAO;
	
	//공급처 등록
	public int supplierInsert(SupplierVO supplier) {
		String check = "N";
		supplier.setSupplier_delete(check);
		return sDAO.supplierInsert(supplier);
	}
	//공급처 전체 출력
	public ArrayList<SupplierVO> supplierAllSelect() {
		return sDAO.supplierAllSelect();
	}
	//공급처 삭제(삭제여부로 블라인드처리)
	public int supplierDelete(SupplierVO supplier) {
		String check = "Y";
		supplier.setSupplier_delete(check);
		return sDAO.supplierDelete(supplier);
		
	}
	//공급처 수정
	public int supplierUpdate(SupplierVO supplier) {
		return sDAO.supplierUpdate(supplier);
		
	}
	//공급처 한개 가져오기
	public SupplierVO supplierOneSelect(SupplierVO supplier) {
		return sDAO.supplierOneSelect(supplier);
		
	}
	//공급처 대쉬보드 3개만 출력
	public ArrayList<SupplierVO> supplierDashSelect(){
		return sDAO.supplierDashSelect();
		
	}
}
