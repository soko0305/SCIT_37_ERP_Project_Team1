package com.project.erp.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.erp.vo.CheckstockVO;
import com.project.erp.vo.ProductVO;
import com.project.erp.vo.RawMaterialVO;
import com.project.erp.vo.SupplierVO;

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


	public ArrayList<SupplierVO> selectDistinctMaterialSupplier() {
		ArrayList<SupplierVO> sList = null;
		try{
		InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
		sList= mapper.selectDistinctMaterialSupplier();
		}catch(Exception e){
			e.printStackTrace();
		}
		return sList;
	}


	public ArrayList<RawMaterialVO> selectDistinctMaterialSort() {
		ArrayList<RawMaterialVO> mList = null;
		try{
		InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
		mList= mapper.selectDistinctMaterialSort();
		}catch(Exception e){
			e.printStackTrace();
		}
		return mList;
	}


	public ArrayList<ProductVO> selectDistinctProductSort() {
		ArrayList<ProductVO> pList = null;
		try{
		InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
		pList= mapper.selectDistinctProductSort();
		}catch(Exception e){
			e.printStackTrace();
		}
		return pList;
	}


	public int confirmInvenWizNoProbs(CheckstockVO checkstock) {
		int check = 0;
		try{
		InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
		check= mapper.confirmInvenWizNoProbs(checkstock);
		}catch(Exception e){
			e.printStackTrace();
			check=0;
		}
		return check;
	}


	public int confirmInvenWizProbs(CheckstockVO checkstock) {
		int check = 0;
		try{
		InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
		check= mapper.confirmInvenWizProbs(checkstock);
		}catch(Exception e){
			e.printStackTrace();
			check=0;
		}
		return check;
	}




	
}
