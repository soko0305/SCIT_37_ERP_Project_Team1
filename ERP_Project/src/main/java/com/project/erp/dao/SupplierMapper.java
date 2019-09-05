package com.project.erp.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.SupplierVO;

@Mapper
@Repository
public interface SupplierMapper {

	public int supplierInsert(SupplierVO supplier);
	
	public ArrayList<SupplierVO> supplierAllSelect();
	
	public SupplierVO supplierOneSelect(SupplierVO supplier);

	public int supplierDelete(SupplierVO supplier);
	
	public int supplierUpdate(SupplierVO supplier);
}
