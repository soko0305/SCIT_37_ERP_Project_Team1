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
	
	public int supplierInsert(SupplierVO supplier) {
		String check = "N";
		supplier.setSupplier_delete(check);
		return sDAO.supplierInsert(supplier);
	}
	
	public ArrayList<SupplierVO> supplierAllSelect() {
		return sDAO.supplierAllSelect();
	}
	
	public int supplierDelete(SupplierVO supplier) {
		String check = "Y";
		supplier.setSupplier_delete(check);
		return sDAO.supplierDelete(supplier);
		
	}
	
	public int supplierUpdate(SupplierVO supplier) {
		return sDAO.supplierUpdate(supplier);
		
	}
	
	public SupplierVO supplierOneSelect(SupplierVO supplier) {
		return sDAO.supplierOneSelect(supplier);
		
	}
	
	public ArrayList<SupplierVO> supplierDashSelect(){
		return sDAO.supplierDashSelect();
		
	}
}
