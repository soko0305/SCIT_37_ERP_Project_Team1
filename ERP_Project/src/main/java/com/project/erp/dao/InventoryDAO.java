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

	public ArrayList<WarehouseVO> selectAllInventory() {
		ArrayList<WarehouseVO> wList = null;
		try{
		InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
		wList= mapper.selectAllInventory();
		}catch(Exception e){
			e.printStackTrace();
		}
		return wList;
	}

	public int insertWarehouse(WarehouseVO warehouse) {
		int check =0;
		try{
		InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
		check= mapper.insertWarehouse(warehouse);
		}catch(Exception e){
			e.printStackTrace();
			check = 0;
		}
		return check;
	}

	public WarehouseVO selectLatestWarehouse() {
		WarehouseVO w = null;
		try{
		InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
		w= mapper.selectLatestWarehouse();
		}catch(Exception e){
			e.printStackTrace();
		}
		return w;
	}

	public WarehouseVO selectWarehouseByCode(String warehouse_code) {
		WarehouseVO w = null;
		try{
		InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
		w= mapper.selectWarehouseByCode(warehouse_code);
		}catch(Exception e){
			e.printStackTrace();
		}
		return w;
	}

	public int updateWarehouse(WarehouseVO warehouse) {
		int check =0;
		try{
		InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
		check= mapper.updateWarehouse(warehouse);
		}catch(Exception e){
			e.printStackTrace();
			check = 0;
		}
		return check;
	}

	public int deleteWarehouse(String warehouse_code) {
		int check =0;
		try{
		InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
		check= mapper.deleteWarehouse(warehouse_code);
		}catch(Exception e){
			e.printStackTrace();
			check = 0;
		}
		return check;
	}

	
	public ArrayList<RawMaterialVO> selectMaterialINWarehouse(String warehouse_code) {
		ArrayList<RawMaterialVO> mList = null;
		try{
		InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
		mList= mapper.selectMaterialINWarehouse(warehouse_code);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mList;
	}

	public ArrayList<ProductVO> selectProductINWarehouse(String warehouse_code) {
		ArrayList<ProductVO> pList = null;
		try{
		InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
		pList= mapper.selectProductINWarehouse(warehouse_code);
		}catch(Exception e){
			e.printStackTrace();
		}
		return pList;
	}


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

	public ArrayList<RawMaterialVO> selectDistinctMaterialINWarehouse(String warehouse_code) {
		ArrayList<RawMaterialVO> sList = null;
		try{
		InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
		sList= mapper.selectDistinctMaterialINWarehouse(warehouse_code);
		}catch(Exception e){
			e.printStackTrace();
		}
		return sList;
	}

	public ArrayList<RawMaterialVO> selectDistinctMaterialSortINWarehouse(String warehouse_code) {
		ArrayList<RawMaterialVO> mList = null;
		try{
		InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
		mList= mapper.selectDistinctMaterialSortINWarehouse(warehouse_code);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mList;
	}

	public ArrayList<ProductVO> selectDistinctProductSortINWarehouse(String warehouse_code) {
		ArrayList<ProductVO> pList = null;
		try{
		InventoryMapper mapper = sqlSession.getMapper(InventoryMapper.class);
		pList= mapper.selectDistinctProductSortINWarehouse(warehouse_code);
		}catch(Exception e){
			e.printStackTrace();
		}
		return pList;
	}
	
}
