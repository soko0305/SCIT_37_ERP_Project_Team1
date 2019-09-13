package com.project.erp.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.ProductVO;
import com.project.erp.vo.RawMaterialVO;
import com.project.erp.vo.SupplierVO;

@Mapper
@Repository
public interface InventoryMapper {
	public SupplierVO selectSupplierBySeq(String supplierseq);
	
	public ProductVO selectProductByCode(String pd_code);

	public ArrayList<SupplierVO> selectDistinctMaterialSupplier();

	public ArrayList<RawMaterialVO> selectDistinctMaterialSort();

	public ArrayList<ProductVO> selectDistinctProductSort();


}
