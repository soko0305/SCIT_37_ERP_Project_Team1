package com.project.erp.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.InventoryVO;
import com.project.erp.vo.ProductVO;
import com.project.erp.vo.RawMaterialVO;
import com.project.erp.vo.SupplierVO;
import com.project.erp.vo.WarehouseVO;

@Repository
public class InventoryDAO {

	@Autowired
	SqlSessionTemplate sqlSession;


	public SupplierVO selectSupplierBySeq(String supplierseq) {
		SupplierVO s = null;
		try{
		InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
		s= mapper.selectSupplierBySeq(supplierseq);
		}catch(Exception e){
			e.printStackTrace();
		}
		return s;
	}
	
	
	public ProductVO selectProductByCode(String pd_code) {
		ProductVO m = null;
		try{
		InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
		m= mapper.selectProductByCode(pd_code);
		}catch(Exception e){
			e.printStackTrace();
		}
		return m;
	}

	
}
